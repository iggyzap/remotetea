package org.acplt.oncrpc.maven.plugin;

import java.io.File;
import java.io.IOException;

import org.acplt.oncrpc.apps.jrpcgen.jrpcgen;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

public abstract class JRpcGeneratorBase extends AbstractMojo
{
    
    /**
     * @parameter expression=${jrpcgen.xFile}
     */
    protected java.io.File xFile;
    
    /**
     * @parameter expression=${jrpcgen.destDir}
     */
    protected java.io.File destDir;
    
    /**
     * @parameter expression=${jrpcgen.packageName}
     */
    protected String packageName;

    /**
     * @parameter expression=${jrpcgen.debug}
     *              default-value=false
     */
    protected boolean debug     = false;
    
    /**
     * @parameter expression=${jrpcgen.verbose}
     *              default-value=false
     */
    protected boolean verbose   = false;
    
    /**
     * @parameter expression=${jrpcgen.backup}
     *              default-value=false
     */
    protected boolean backup    = false;
    
    /**
     * @parameter expression=${jrpcgen.createDestDir}
     *              default-value=false
     */
    protected boolean createDir = false;
    
    /**
     * @parameter expression=${jrpcgen.serverTcpOnly}
     *              default-value=false
     */
    protected boolean serverTcpOnly = false;
    
    /**
     * @parameter expression=${jrpcgen.serverUdpOnly}
     *              default-value=false
     */
    protected boolean serverUdpOnly = false;
    
    protected JRpcGeneratorBase()
    {
        // jrpcgen.reset();
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
