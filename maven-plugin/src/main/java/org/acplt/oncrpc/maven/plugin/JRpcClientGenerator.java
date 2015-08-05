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

package org.acplt.oncrpc.maven.plugin;

import org.acplt.oncrpc.apps.jrpcgen.jrpcgen;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Goal which generates client sources.
 */
@Mojo( name="client", defaultPhase=LifecyclePhase.GENERATE_SOURCES )
public class JRpcClientGenerator extends JRpcGeneratorBase
{

    public void execute()
            throws MojoExecutionException
        {
            jrpcgen.noServer = true;
            this.generateSources();
        }
    
}
