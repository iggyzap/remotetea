/*
 * $Header: /home/harald/repos/remotetea.sf.net/remotetea/src/org/acplt/oncrpc/apps/jrpcgen/JrpcgenStruct.java,v 1.1 2003/08/13 12:03:47 haraldalbrecht Exp $
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

package org.acplt.oncrpc.apps.jrpcgen;

import java.util.Vector;

/**
 * The <code>JrpcgenStruct</code> class represents a single structure defined
 * in an rpcgen "x"-file.
 *
 * @version $Revision: 1.1 $ $Date: 2003/08/13 12:03:47 $ $State: Exp $ $Locker:  $
 * @author Harald Albrecht
 */
public class JrpcgenStruct {

    /**
     * Global next available id for an unnamed inner structure.
     */
    private static long NEXT_UNNAMED_STRUCT_ID = 1;
    
    /**
     * Structure identifier.
     */
    public String identifier;

    /**
     * Contains elements of structure. The elements are of class
     * {@link JrpcgenDeclaration}.
     */
    public Vector elements;

    /**
     * Returns just the identifier.
     */
    public String toString() {
        return identifier;
    }

    /**
     * Constructs a <code>JrpcgenStruct</code> and sets the identifier and all
     * its attribute elements.
     *
     * @param identifier Identifier to be declared.
     * @param elements Vector of attribute elements of class
     *   {@link JrpcgenDeclaration}.
     */
    public JrpcgenStruct(String identifier, Vector elements)
    {
        /*
         * Is the passed identifer 'null', identifying an unnamed structure
         * definition?
         */
        if ( identifier != null )
        {
            /*
             * No:
             * Simply take over the passed identifier.
             */
            this.identifier = identifier;
        }
        else
        {
            /*
             * Yes:
             * In this case an identifier for the unnamed struct is generated.
             */
            this.identifier = "unnamed_struct_" + NEXT_UNNAMED_STRUCT_ID;
            
            /*
             * Increment the next unnamed struct id.
             */
            ++NEXT_UNNAMED_STRUCT_ID;
        }

        this.elements = elements;
    }

    /**
     * Dumps the structure together with its attribute elements to
     * <code>System.out</code>.
     */
    public void dump() {
        System.out.println("STRUCT " + identifier + ":");

        int size = elements.size();
        for ( int idx = 0; idx < size; ++idx ) {
            JrpcgenDeclaration d = (JrpcgenDeclaration) elements.elementAt(idx);
            System.out.print("  ");
            d.dump();
        }
        System.out.println();
    }

}

// End of JrpcgenStruct.java