package org.acplt.oncrpc.maven.plugin;

import org.acplt.oncrpc.apps.jrpcgen.jrpcgen;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Goal which generates client sources.
 */
@Mojo( name="server", defaultPhase=LifecyclePhase.GENERATE_SOURCES )
public class JRpcServerGenerator extends JRpcGeneratorBase
{
    
    public void execute()
            throws MojoExecutionException
        {
            jrpcgen.noClient = true;
            this.generateSources();
        }

}
