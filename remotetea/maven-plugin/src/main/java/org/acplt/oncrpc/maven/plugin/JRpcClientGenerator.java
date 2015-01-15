package org.acplt.oncrpc.maven.plugin;

import org.acplt.oncrpc.apps.jrpcgen.jrpcgen;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * Goal which generates client sources.
 *
 * @goal client
 * 
 * @phase generate-sources
 */
public class JRpcClientGenerator extends JRpcGeneratorBase
{

    public void execute()
            throws MojoExecutionException
        {
            jrpcgen.noServer = true;
            this.generateSources();
        }
    
}
