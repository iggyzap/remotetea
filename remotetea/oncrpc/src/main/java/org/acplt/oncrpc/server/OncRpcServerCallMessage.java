/*
 * $Header: /home/harald/repos/remotetea.sf.net/remotetea/src/org/acplt/oncrpc/server/OncRpcServerCallMessage.java,v 1.1 2003/08/13 12:03:51 haraldalbrecht Exp $
 *
 * Copyright (c) 1999, 2000
 * Lehrstuhl fuer Prozessleittechnik (PLT), RWTH Aachen
 * D-52064 Aachen, Germany.
 * All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Library General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this program (see the file LICENSE.txt for more
 * details); if not, write to the Free Software Foundation, Inc.,
 * 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package org.acplt.oncrpc.server;

import org.acplt.oncrpc.*;

import java.io.IOException;

/**
 * The <code>OncRpcServerCallMessage</code> class represents an ONC/RPC
 * call message on the server side. For this reasons it just handles
 * decoding of call messages but can not do any encoding. This class is
 * also responsible for pulling off authentication information from the
 * wire and converting it into appropriate authentication protocol handling
 * objects. As with all good management, this class therefor delegates this
 * somehow unpleasant work to the server-side authentication protocol handling
 * classes.
 *
 * @see OncRpcServerAuth
 *
 * @version $Revision: 1.1 $ $Date: 2003/08/13 12:03:51 $ $State: Exp $ $Locker:  $
 * @author Harald Albrecht
 */
public class OncRpcServerCallMessage extends OncRpcCallMessage {

	public OncRpcServerCallMessage(OncRpcServerAuthSchemes authenticationSchemes)
	{
		/*
		 * If for any reason the passed authentication scheme repository is null,
		 * we use the default repository. Otherwise we take over the passed one.
		 * This ensures the presence of at least the standard authentication schemes
		 * implemented by this package.
		 */
		this.authenticationSchemes = (authenticationSchemes == null ? OncRpcServerAuthSchemes.getDefaultRepository() : authenticationSchemes);
	}
	
    /**
     * Decodes -- that is: deserializes -- a ONC/RPC message header object
     * from a XDR stream according to RFC 1831.
     *
     * @param xdr A decoding XDR stream from which to receive all the mess.
      *
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
    */
    public void xdrDecode(XdrDecodingStream xdr)
           throws OncRpcException, IOException {
    	int authenticationType = -1;
    	
        messageId = xdr.xdrDecodeInt();
        //
        // Make sure that we are really decoding an ONC/RPC message call
        // header. Otherwise, throw the appropriate OncRpcException exception.
        //
        messageType = xdr.xdrDecodeInt();
        if ( messageType != OncRpcMessageType.ONCRPC_CALL ) {
            throw(new OncRpcException(OncRpcException.RPC_WRONGMESSAGE));
        }
        //
        // Make sure that the other side is talking the right slang --
        // we will only understand version 2 slang of ONC/RPC.
        //
        oncRpcVersion = xdr.xdrDecodeInt();
        if ( oncRpcVersion != ONCRPC_VERSION ) {
            throw(new OncRpcException(OncRpcException.RPC_VERSMISMATCH));
        }
        //
        // Now decode the remaining fields of the call header.
        //
        program = xdr.xdrDecodeInt();
        version = xdr.xdrDecodeInt();
        procedure = xdr.xdrDecodeInt();
        
        /*
         * Last comes the authentication data.
         * First the requested authentication type is decoded.
         * If we already have an authentication handler and the authentication
         * handler matches the requested authentication type, we reuse it.
         * Otherwise we ask the authentication scheme repository for a new matching
         * authentication handler.
         */
        authenticationType = xdr.xdrDecodeInt();
        
        if ( (this.auth == null)
        		|| (this.auth.getAuthenticationType() != authenticationType) )
        {
        	this.auth = this.authenticationSchemes.getNewHandler(authenticationType);
        }
        
        /*
         * If we have an authentication handler at this point, we let it
         * process the xdr stream and the provided authentication.
         * Otherwise we raise an exception. 
         */
        if ( this.auth != null )
        {
        	this.auth.xdrDecodeCredVerf(xdr);
        }
        else
        {
            //
            // In case of an unknown or unsupported type, throw an exception.
            // Note: using AUTH_REJECTEDCRED is in sync with the way Sun's
            // ONC/RPC implementation does it. But don't ask me why they do
            // it this way...!
            //
            throw(new OncRpcAuthenticationException(
                          OncRpcAuthStatus.ONCRPC_AUTH_REJECTEDCRED));
        }
    }

    /**
     * Contains the authentication protocol handling object retrieved together
     * with the call message itself.
     */
    public OncRpcServerAuth auth = null;
    
    private OncRpcServerAuthSchemes authenticationSchemes = null;

}

// End of OncRpcServerCallMessage.java

