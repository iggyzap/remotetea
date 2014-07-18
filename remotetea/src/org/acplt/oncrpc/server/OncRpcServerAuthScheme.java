package org.acplt.oncrpc.server;

/**
 * Implementing this interface enables the definition of a custom authentication scheme,
 * which is intended to be provided by an ONC/RPC server.
 * 
 * <p>Defining an authentication scheme requires both, providing the authentication type
 * (flavor) identified numerically and providing appropriate handler instances implementing the
 * interface {@link OncRpcServerAuth}.</p>
 * 
 * @author hwirths
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
