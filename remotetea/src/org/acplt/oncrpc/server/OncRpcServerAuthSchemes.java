package org.acplt.oncrpc.server;

import org.acplt.oncrpc.OncRpcAuthType;

/**
 * Repository auf supported authentication schemes, which are intended to
 * be provided by an ONC/RPC server.
 * 
 * <p>By default the authentication schemes<em>none</em>, <em>short</em>
 * and <em>unix (system)</em> are supported by ONC/RPC servers.</p> 
 * 
 * <p>This class is designed to be used internally by this package. Registration of custom
 * authentication schemes will be available through a concrete instance of an implementation
 * of an ONC/RPC server stub. Concrete authentication handler instances will be requested on demand
 * with respect to the desired authentication type.</p>
 * 
 * @author hwirths
 *
 */
final class OncRpcServerAuthSchemes {

	/**
	 * Registers a custom authentication scheme to this authentication scheme repository.
	 *  
	 * @param authenticationScheme A custom authentication scheme.
	 * @return <em>true</em>, if the passed authentication scheme has been added
	 *         to the list of custom authentication schemes, <em>false</em>, if either
	 *         <em>null</em>has been passed or there is already an authentication scheme
	 *         registered for the authentication type of the passed one.
	 */
	boolean registerScheme(OncRpcServerAuthScheme authenticationScheme)
	{
		boolean registered = false;
		
		/*
		 * We cancel the call, if the authentication type indicates either one of
		 * the standard schemes or one of the already registered custom schemes.
		 * But let's ensure, that the caller has passed a valid object.
		 */
		if ( authenticationScheme != null )
		{
			switch(authenticationScheme.getAuthenticationType())
			{
			case OncRpcAuthType.ONCRPC_AUTH_NONE:
			case OncRpcAuthType.ONCRPC_AUTH_SHORT:
			case OncRpcAuthType.ONCRPC_AUTH_UNIX:
				/*
				 * A request to override a standard scheme is skipped.
				 */
				break;
				
			default:
				/*
				 * Now we look at the list of already registered schemes.
				 * If the list is still empty, the new authentication scheme
				 * is inserted as the first entry.
				 * If there is already a scheme with the same authentication type
				 * as the passed one, we skip the request.
				 * Otherwise we insert the new scheme with respect to the ordering.
				 */
				if ( this.head == null )
				{
					/*
					 * The passed authentication scheme gets the first custom authentication scheme.
					 */
					this.head = new Node(authenticationScheme);
				}
				else
				{
					Node actualNode = this.head;
					Node predecessorNode = null;
					
					/*
					 * Do we find an authentication scheme in the list
					 * with same authentication type?
					 */
					while ( actualNode != null )
					{
						if ( actualNode.scheme.getAuthenticationType() == authenticationScheme.getAuthenticationType() )
						{
							/*
							 * We are done.
							 */
							actualNode = null;
						}
						else if ( actualNode.scheme.getAuthenticationType() < authenticationScheme.getAuthenticationType() )
						{
							/*
							 * Let's continue with the next node.
							 * We remind the actual node, as it possibly
							 * will be the new predecessor node of the passed authentication scheme.
							 */
							predecessorNode = actualNode;
							actualNode = actualNode.next;
						}
						else
						{
							/*
							 * The number of the authentication type of the actual node is greater than the
							 * one of the passed authentication scheme. With respect to the ordering of the list
							 * we found the successor node of the new authentication scheme. The reminded
							 * predecessor node will be the predecessor node of the passed authentication scheme,
							 * except the actual node is the head. Then the passed authentication scheme
							 * will be inserted at the head of the list.
							 */
							if ( actualNode == this.head )
							{
								predecessorNode = new Node(authenticationScheme);
								predecessorNode.next = this.head;
								this.head = predecessorNode;
							}
							else
							{
								predecessorNode.next = new Node(authenticationScheme);
								predecessorNode.next.next = actualNode;
							}
							
							/*
							 * At this point the passed authentication scheme has been registered.
							 */
							registered = true;
						}
					}
				}
			}
		}

		return registered;
	}
	
	/**
	 * Delivers a new authentication handler with respect to the passed authentication type.
	 * 
	 * @param desiredAuthenticationType The desired authentication type, the new authentication handler
	 *        shall provide.
	 * @return <em>null</em>, if there either is no authentication scheme registered for the passed authentication type
	 *         or the corresponding authentication scheme does not deliver a new authentication handler instance.
	 *         Otherwise an authentication handler created by the corresponding authentication scheme is returned.          
	 */
	OncRpcServerAuth getNewHandler(int desiredAuthenticationType)
	{
        OncRpcServerAuth authenticationHandler = null;
        
        /*
         * Let's see, whether we are able to provide an authentication handler
         * to the passed authentication type.
         * 
         * First we check the passed authentication type for the standard authentication
         * schemes. If neither of them match, the list of custom authentication schemes
         * is searched for the requested authentication type.
         */
        switch ( desiredAuthenticationType ) {
        case OncRpcAuthType.ONCRPC_AUTH_NONE:
            authenticationHandler = OncRpcServerAuthNone.AUTH_NONE;
            break;
            
        case OncRpcAuthType.ONCRPC_AUTH_SHORT:
            authenticationHandler = new OncRpcServerAuthShort();
            break;
            
        case OncRpcAuthType.ONCRPC_AUTH_UNIX:
            authenticationHandler = new OncRpcServerAuthUnix();
            break;
            
        default:
        	/*
        	 * ok, let's see, whether an appropriate authentication scheme is
        	 * registered.
        	 */
        	Node actualNode = this.head;
        	
        	while ( (authenticationHandler == null)
        			&& (actualNode != null) )
        	{
        		if ( actualNode.scheme.getAuthenticationType() == desiredAuthenticationType )
        		{
        			/*
        			 * The scheme is provided!
        			 * Then ask for a new handler.
        			 * This will end the search.
        			 */
        			authenticationHandler = actualNode.scheme.getNewHandler();
        		}
        		else if ( actualNode.scheme.getAuthenticationType() > desiredAuthenticationType )
        		{
        			/*
        			 * The number of the desired authentication type is smaller than
        			 * the number of the authenitcation type of the actual node.
        			 * As the list is ordered by the number of the authentication type,
        			 * there can't be another authentication scheme in the list, that
        			 * may match the desired one. Therefore the search ends up at this point.
        			 */
        			actualNode = null;
        		}
        		else
        		{
        			/*
        			 * Maybe we have luck with the next node...
        			 */
        			actualNode = actualNode.next;
        		}
        	}
        }
        
        return authenticationHandler;
	}
	
	/**
	 * Simple node used by the repository to build and parse the custom authentication 
	 * scheme list.
	 * 
	 * @author hwirths
	 *
	 */
	private class Node {
		
		/**
		 * The provided authentication scheme.
		 */
		OncRpcServerAuthScheme scheme = null;
		
		/**
		 * The successor node, containing the next supported
		 * authentication scheme.
		 */
		Node next = null;
		
		/**
		 * Constructs a new node taking over the passed authentication scheme.
		 * 
		 * @param authenticationScheme An instance of an implementation oof {@link OncRpcServerAuthScheme}.
		 */
		Node(OncRpcServerAuthScheme authenticationScheme)
		{
			this.scheme = authenticationScheme;
		}
		
	}

	/**
	 * The head of the custom authentication scheme list.
	 */
	private Node head = null;
}
