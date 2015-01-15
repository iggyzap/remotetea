package org.acplt.oncrpc.maven.plugin;

import org.acplt.oncrpc.apps.jrpcgen.jrpcgen;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * Goal which generates client sources.
 *
 * @goal server
 * 
 * @phase generate-sources
 */
public class JRpcServerGenerator extends JRpcGeneratorBase
{
    
    public void execute()
            throws MojoExecutionException
        {
            jrpcgen.noClient = true;
            this.generateSources();
        }

}
