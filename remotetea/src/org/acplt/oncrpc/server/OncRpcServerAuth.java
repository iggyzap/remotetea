/*
 * $Header: /home/harald/repos/remotetea.sf.net/remotetea/src/org/acplt/oncrpc/server/OncRpcServerAuth.java,v 1.1 2003/08/13 12:03:51 haraldalbrecht Exp $
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
 * License along with this program (see the file COPYING.LIB for more
 * details); if not, write to the Free Software Foundation, Inc.,
 * 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package org.acplt.oncrpc.server;

import java.io.IOException;

import org.acplt.oncrpc.OncRpcAuthType;
import org.acplt.oncrpc.OncRpcException;
import org.acplt.oncrpc.XdrDecodingStream;
import org.acplt.oncrpc.XdrEncodingStream;

/**
 * This interface connects incoming ONC/RPC - calls to an ONC/RPC server
 * with authentication handling allowing or refusing a call.
 * 
 * <p>Therefore, implementations of this interface can be seen as authentication handlers coming
 * with specific authentication schemes. They are invoked before dispatching a call to the implementation
 * of the ONC/RPC server stub. In detail, if an authentication handler refuses credentials or verifiers,
 * an ONC/RPC server will not dispatch the call, but reply an appropriate authentication error to
 * the client.</p>
 * 
 * <p>Authentication handlers are responsible for decoding the authentication part of an
 * ONC/RPC call message. The decoded authentication information shall be verified and shall
 * lead to an appropriate authentication error, if verification of the authentication information
 * fails.</p>
 * 
 * <p>If authentication succeeded and the call has been dispatched and processed by the ONC/RPC server
 * stub implementation, an authentication handler will be asked to encode an verifier. It depends on the
 * authentication scheme, whether an verifier will be provided or the verifier just gets auth-none as
 * type with no further data.</p>
 *
 * @author Harald Albrecht
 */
public interface OncRpcServerAuth {

    /**
     * Returns the authentication type (flavor) identifying the
     * authentication scheme this handler belongs to.
     * 
     * <p>This may either be one of the standard types as defined in {@link OncRpcAuthType}
     * or the number of a custom authentication scheme.</p>
     *
     * @return Authentication type implemented by this authentication handler.
     */
    int getAuthenticationType();

    /**
     * Restores (deserializes) an authentication object from an XDR stream.
     *
     * @param xdr XDR stream from which the authentication object is
     *   restored.
     * @param recycle old authtentication object which is intended to be
     *   reused in case it is of the same authentication type as the new
     *   one just arriving from the XDR stream.
     *
     * @return Authentication information encapsulated in an object, whose class
     *   is derived from <code>OncRpcServerAuth</code>.
     *
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
//    public static final OncRpcServerAuth xdrNew(XdrDecodingStream xdr,
//                                                OncRpcServerAuth recycle)
//           throws OncRpcException, IOException {
//        OncRpcServerAuth auth;
//        //
//        // In case we got an old authentication object and we are just about
//        // to receive an authentication with the same type, we reuse the old
//        // object.
//        //
//        int authType = xdr.xdrDecodeInt();
//        if ( (recycle != null)
//             && (recycle.getAuthenticationType() == authType) ) {
//            //
//            // Simply recycle authentication object and pull its new state
//            // of the XDR stream.
//            //
//            auth = recycle;
//            auth.xdrDecodeCredVerf(xdr);
//        } else {
//            //
//            // Create a new authentication object and pull its state off
//            // the XDR stream.
//            //
//            switch ( authType ) {
//            case OncRpcAuthType.ONCRPC_AUTH_NONE:
//                auth = OncRpcServerAuthNone.AUTH_NONE;
//                auth.xdrDecodeCredVerf(xdr);
//                break;
//            case OncRpcAuthType.ONCRPC_AUTH_SHORT:
//                auth = new OncRpcServerAuthShort(xdr);
//                break;
//            case OncRpcAuthType.ONCRPC_AUTH_UNIX:
//                auth = new OncRpcServerAuthUnix(xdr);
//                break;
//            default:
//                //
//                // In case of an unknown or unsupported type, throw an exception.
//                // Note: using AUTH_REJECTEDCRED is in sync with the way Sun's
//                // ONC/RPC implementation does it. But don't ask me why they do
//                // it this way...!
//                //
//                throw(new OncRpcAuthenticationException(
//                              OncRpcAuthStatus.ONCRPC_AUTH_REJECTEDCRED));
//            }
//        }
//        return auth;
//    }

    /**
     * Decodes -- that is: deserializes -- an ONC/RPC authentication object
     * (credential & verifier) on the server side.
     *
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    void xdrDecodeCredVerf(XdrDecodingStream xdr)
           throws OncRpcException, IOException;

    /**
     * Encodes -- that is: serializes -- an ONC/RPC authentication object
     * (its verifier) on the server side.
     *
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    void xdrEncodeVerf(XdrEncodingStream xdr)
           throws OncRpcException, IOException;

}

// End of OncRpcServerAuth.java
