package jenkins.plugins.structure;
import hudson.AbortException;
import hudson.CopyOnWrite;
import hudson.Extension;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;
import hudson.tasks.Builder;

import java.io.IOException;

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
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) 
    		throws AbortException, InterruptedException, IOException {
    	listener.getLogger().println(Messages.StructureBuilder_InvokingStructure());
        
        StructureInstallation structureInstallation = DESCRIPTOR.getInstallationByName(this.structureInstallationName);
        if(structureInstallation == null) {
        	throw new AbortException(Messages.StructureBuilder_InvalidStructureInstallation());
        }
        
        if(StringUtils.isBlank(this.getMainParams().getInFile())) {
        	throw new AbortException(Messages.StructureBuilder_InvalidStructureInstallation());
        }
        
        // create mainparams
        
        // create extraparams
        
        // create command to be executed
        
        // execute command
        
        final FilePath workspace = build.getWorkspace();
        
        return true;
    }

    // Overridden for better type safety.
    // If your plugin doesn't really define any property on Descriptor,
    // you don't have to do this.
    @Override
    public StructureBuilderDescriptor getDescriptor() {
        return (StructureBuilderDescriptor)super.getDescriptor();
    }

}

