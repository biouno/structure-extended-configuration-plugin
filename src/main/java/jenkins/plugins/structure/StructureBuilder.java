package jenkins.plugins.structure;
import hudson.AbortException;
import hudson.CopyOnWrite;
import hudson.Extension;
import hudson.FilePath;
import hudson.FilePath.FileCallable;
import hudson.Launcher;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;
import hudson.remoting.VirtualChannel;
import hudson.tasks.Builder;
import hudson.util.ArgumentListBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jenkins.plugins.structure.util.Messages;

import org.apache.commons.lang.StringUtils;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Structure builder.
 * 
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 0.1
 */
public class StructureBuilder extends Builder {
	
	@Extension
	public static final StructureBuilderDescriptor DESCRIPTOR = new StructureBuilderDescriptor();

	private String structureInstallationName;
	
	@CopyOnWrite
	private final MainParams mainParams;
	@CopyOnWrite
	private final ExtraParams extraParams;
	
    @DataBoundConstructor
    public StructureBuilder(
    		String structureInstallationName, 
    		String inputFile, 
    		MainParams mainParams, 
    		ExtraParams extraParams) {
    	this.structureInstallationName = structureInstallationName;
        this.mainParams = mainParams;
        this.extraParams = extraParams;
    }

    /**
	 * @return the mainParams
	 */
	public MainParams getMainParams() {
		return mainParams;
	}
	
	/**
	 * @return the extraParams
	 */
	public ExtraParams getExtraParams() {
		return extraParams;
	}
	
	/**
	 * @return the structureInstallationName
	 */
	public String getStructureInstallationName() {
		return structureInstallationName;
	}
	
    @Override
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, final BuildListener listener) 
    		throws AbortException, InterruptedException, IOException {
    	listener.getLogger().println(Messages.StructureBuilder_InvokingStructure());
        
        StructureInstallation structureInstallation = DESCRIPTOR.getInstallationByName(this.structureInstallationName);
        if(structureInstallation == null) {
        	throw new AbortException(Messages.StructureBuilder_InvalidStructureInstallation());
        }
        
        if(StringUtils.isBlank(this.getMainParams().getInFile())) {
        	throw new AbortException(Messages.StructureBuilder_InvalidStructureInstallation());
        }
        
        final FilePath workspace = build.getWorkspace();
        
        listener.getLogger().println("Creating parameter files...");
        
        final String mainParamsText = StructureBuilder.this.getMainParams().toString();
        final String extraParamsText = StructureBuilder.this.getExtraParams().toString();
        
        final Map<String, String> fileNames = new HashMap<String, String>();
        
        try {
	        workspace.act(new FileCallable<Void>() {
	
				private static final long serialVersionUID = 1L;
	
				public Void invoke(File f, VirtualChannel channel) throws IOException, InterruptedException {
					
					// create mainparams
					File mainParamsFile = null;
					FileWriter mainParamsWriter = null;
					
					try {
						mainParamsFile = new File(f, "mainparams");
						mainParamsWriter = new FileWriter(mainParamsFile);
						mainParamsWriter.append(mainParamsText);
						mainParamsWriter.flush();
						fileNames.put("mainparams", mainParamsFile.getAbsolutePath());
					} finally {
						try{
							mainParamsWriter.close();
						} catch ( IOException ioe ) {
							ioe.printStackTrace(listener.getLogger());
						}
					}
					
					// create extraparams
					File extraParamsFile = null;
					FileWriter extraParamsWriter = null;
					
					try {
						extraParamsFile = new File(f, "extraparams");
						extraParamsWriter = new FileWriter(extraParamsFile);
						extraParamsWriter.append(extraParamsText);
						extraParamsWriter.flush();
						fileNames.put("extraparams", extraParamsFile.getAbsolutePath());
					} finally {
						try{
							extraParamsWriter.close();
						} catch ( IOException ioe ) {
							ioe.printStackTrace(listener.getLogger());
						}
					}
					
					return null;
				}
			});
        } catch ( IOException ioe ) {
        	listener.getLogger().println("Error creating parameter files: " + ioe.getMessage());
        	ioe.printStackTrace(listener.getLogger());
        }
        
        // create command to be executed
        listener.getLogger().println("Launching Structure...");
        
        final String command = structureInstallation.getPathToExecutable();
        final ArgumentListBuilder args = new ArgumentListBuilder();
        args.add(command);
        
        final String mainParamsLocation = fileNames.get("mainparams");
        final String extraParamsLocation = fileNames.get("extraparams");
        
        if(StringUtils.isNotBlank(mainParamsLocation)) {
        	args.add("-m");
        	args.add(mainParamsLocation);
        }
        
        if(StringUtils.isNotBlank(extraParamsLocation)) {
        	args.add("-e");
        	args.add(extraParamsLocation);
        }
        
        Map<String, String> env = build.getEnvironment(listener);
        
        final Integer exitCode = launcher.launch().cmds(args).envs(env).stdout(listener).pwd(build.getModuleRoot()).join();
        
        if(exitCode != 0) {
        	listener.getLogger().println("Error executing Structure. Exit code : " + exitCode);
        	return Boolean.FALSE;
        } else {
        	listener.getLogger().println("Successfully executed Structure.");
        	return Boolean.TRUE;
        }
    }

    // Overridden for better type safety.
    // If your plugin doesn't really define any property on Descriptor,
    // you don't have to do this.
    @Override
    public StructureBuilderDescriptor getDescriptor() {
        return (StructureBuilderDescriptor)super.getDescriptor();
    }

}

