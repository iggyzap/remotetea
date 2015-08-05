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

import java.io.File;
import java.io.IOException;

import org.acplt.oncrpc.apps.jrpcgen.jrpcgen;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Parameter;


public abstract class JRpcGeneratorBase extends AbstractMojo
{
    
    @Parameter( required=true )
    protected java.io.File xFile;
    
    @Parameter( required=true )
    protected java.io.File destDir;
    
    @Parameter( required=true )
    protected String packageName;

    @Parameter( defaultValue="false" )
    protected boolean debug     = false;
    
    @Parameter( defaultValue="false" )
    protected boolean verbose   = false;
    
    @Parameter( defaultValue="false" )
    protected boolean backup    = false;
    
    @Parameter( defaultValue="false" )
    protected boolean createDir = false;
    
    @Parameter( defaultValue="false" )
    protected boolean serverTcpOnly = false;
    
    @Parameter( defaultValue="false" )
    protected boolean serverUdpOnly = false;
    
    protected JRpcGeneratorBase()
    {
        jrpcgen.reset();
    }
    
    protected void generateSources() throws MojoExecutionException
    {                
        this.checkAttributes();

        try
        {
            this.logInfo("Compiling %s", this.xFile.getCanonicalPath());
        }
        catch (IOException ex) {
        }

        if(packageName != null) {
            jrpcgen.packageName = packageName;

            try {
                // Add the package name to destination dir
                destDir = new File(
                    destDir.getCanonicalPath() +
                    File.separator +
                    packageName.replace('.', File.separatorChar));
            }
            catch (IOException ex) {
                throw new MojoExecutionException("",ex); // should never occur
            }
        }

        if (createDir) {
            // Create the destination dir if it does not exist
            try {
                if (!destDir.exists()) {
                    boolean dirsCreated = destDir.mkdirs();
                    if (!dirsCreated) {
                        throw new MojoExecutionException("Could not create destination dir" );
                    }
                }
            }
            catch (SecurityException ex) {
                throw new MojoExecutionException("",ex);
            }
        }

        if (debug)
            dumpState();

        jrpcgen.debug          = debug;
        jrpcgen.verbose        = verbose;
        jrpcgen.noBackups      = (!backup);
        jrpcgen.destinationDir = destDir;
        jrpcgen.xFile          = xFile;
        jrpcgen.serverTcpOnly  = serverTcpOnly;
        jrpcgen.serverUdpOnly  = serverUdpOnly;

        try {
            jrpcgen.doParse();
        }
        catch (Throwable t) {
            throw new MojoExecutionException("",t);
        }
    }
    
    protected void checkAttributes() throws MojoExecutionException {
        if(xFile == null)
            throw new MojoExecutionException("srcfile has not been set");

        if(destDir == null)
            throw new MojoExecutionException("destdir has not been set");

        try {
            if(!xFile.isFile())
                throw new MojoExecutionException(String.format("%s : problem reading srcdir", xFile.getCanonicalPath()));

            if(!destDir.isDirectory())
            {
                if ( ! this.createDir )
                {
                    this.logError("Zielverzeichnis '%s' existiert nicht.", this.destDir.getCanonicalPath());
                    throw new MojoExecutionException("problem accessing srcdir");
                }
                else
                {
                    this.logInfo("Zielverzeichnis '%s' muss angelegt werden.", this.destDir.getCanonicalPath());
                }
            }
                
        }
        catch(IOException ex) {
            throw new MojoExecutionException("",ex);
        }
        catch(SecurityException ex) {
            throw new MojoExecutionException("",ex);
        }
    }

    protected void dumpState() throws MojoExecutionException {
        try
        {
            this.logDebug("Quelldatei: %s", this.xFile.getCanonicalPath());
            this.logDebug("Zielverzeichnis: %s", this.destDir.getCanonicalPath());
            this.logDebug("Paketname: %s", this.packageName);
            this.logDebug("Backup: %s", (this.backup ? "Ja" : "Nein"));
            this.logDebug("Verbosse: %s", (this.verbose ? "Ja" : "Nein"));
            this.logDebug("Zielverzeichnis wird erzeugt: %s", (this.createDir ? "Ja" : "Nein"));
        }
        catch(IOException ioException)
        {
            /*
             * Garnicht gut...
             */
            this.logError("Der Status kann nicht ausgegeben werden (%s).", ioException.getMessage());
            throw new MojoExecutionException("Fehler beim Ausgeben des Status", ioException);
        }
    }
    
    protected void logDebug(String format, Object... arguments)
    {
        if ( this.getLog().isDebugEnabled() )
        {
            String message = String.format(format, arguments);
            
            this.getLog().debug(message.subSequence(0, message.length()));
        }
    }
    
    protected void logInfo(String format, Object... arguments)
    {
        if (this.getLog().isInfoEnabled())
        {
            String message = String.format(format, arguments);
            
            this.getLog().info(message.subSequence(0, message.length()));
        }
    }

    protected void logWarn(String format, Object... arguments)
    {
        if ( this.getLog().isWarnEnabled() )
        {
            String message = String.format(format, arguments);
            
            this.getLog().warn(message.subSequence(0,  message.length()));
        }
    }
    
    protected void logError(String format, Object... arguments)
    {
        if ( this.getLog().isErrorEnabled() )
        {
            String message = String.format(format, arguments);
            
            this.getLog().error(message.subSequence(0, message.length()));
        }
    }

}
