/*
 * Copyright (c) 2014, 2015
 * NDE Netzdesign und -entwicklung AG, Hamburg, Germany
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

/**
 * Implementing this interface enables the definition of a custom authentication scheme,
 * which is intended to be provided by an ONC/RPC server.
 * 
 * <p>Defining an authentication scheme requires both, providing the authentication type
 * (flavor) identified numerically and providing appropriate handler instances implementing the
 * interface {@link OncRpcServerAuth}.</p>
 * 
 * @author Harald Wirths {@literal <hwirths@nde.ag>}
 */
public interface OncRpcServerAuthScheme {

	/**
	 * Delivers the authentication type (flavor) provided by this authentication scheme.
	 * 
	 * @return The authentication type identified by its number.
	 */
	int getAuthenticationType();
	
	/**
	 * Delivers a new authentication handler with respect to the provided authentication scheme.
	 * 
	 * <p>The returned authentication handler is an implementation of the interface {@link OncRpcServerAuth}.</p>
	 * 
	 * @return A new instance of the authentication handler provided by this authentication scheme.
	 */
	OncRpcServerAuth getNewHandler();
	
}
