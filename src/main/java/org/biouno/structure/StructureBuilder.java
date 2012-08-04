package org.biouno.structure;
import hudson.AbortException;
import hudson.Extension;
import hudson.Launcher;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;
import hudson.tasks.Builder;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.biouno.structure.parser.MainParamsParser;
import org.biouno.structure.parser.ParserException;
import org.biouno.structure.util.Messages;

/**
 * Structure builder.
 * 
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 0.1
 */
public class StructureBuilder extends Builder {
	
	@Extension
	public static final StructureBuilderDescriptor DESCRIPTOR = new StructureBuilderDescriptor();
	
	private final MainParamsParser parser;
	
	/**
	 * Structure installation.
	 */
	private final String structureInstallationName;
	/**
	 * Number of populations assumed (MAXPOPS).
	 */
	private final Integer maxPops;
	/**
	 * Number of loci in data file (NUMLOCI).
	 */
	private final Integer numLoci;
	/**
	 * Number of diploid individuals in data file (NUMINDS).
	 */
	private final Integer numInds;
	/**
	 * Length of burn-in period (BURNIN).
	 */
	private final Long burnIn;
	/**
	 * Number of MCMC steps after burn-in (NUMREPS).
	 */
	private final Long numReps;
	/**
	 * Name of input data file.
	 */
	private final String inFile;
	/**
	 * Name of output data file.
	 */
	private final String outFile;
	/**
	 * Main parameters.
	 */
	private final String mainParams;
	/**
	 * Extra parameters.
	 */
	private final String extraParams;
	/**
	 * Slave label;
	 */
	private final String label;
	

    /**
     * Constructor with args, called from Jelly populating the object properties 
     * from the form.
	 * @param structureInstallationName
	 * @param maxPops
	 * @param numLoci
	 * @param numInds
	 * @param burnIn
	 * @param numReps
	 * @param inFile
	 * @param outFile
	 * @param mainParams
	 * @param extraParams
	 * @param label
	 */
	public StructureBuilder(String structureInstallationName, Integer maxPops,
			Integer numLoci, Integer numInds, Long burnIn, Long numReps,
			String inFile, String outFile, String mainParams, String extraParams, 
			String label) {
		super();
		this.structureInstallationName = structureInstallationName;
		this.maxPops = maxPops;
		this.numLoci = numLoci;
		this.numInds = numInds;
		this.burnIn = burnIn;
		this.numReps = numReps;
		this.inFile = inFile;
		this.outFile = outFile;
		this.mainParams = mainParams;
		this.extraParams = extraParams;
		this.label = label;
		parser = new MainParamsParser(numLoci, numInds, burnIn, numReps, inFile, outFile);
	}

	/**
	 * @return the structureInstallationName
	 */
	public String getStructureInstallationName() {
		return structureInstallationName;
	}
	
    /**
	 * @return the maxPops
	 */
	public Integer getMaxPops() {
		return maxPops;
	}

	/**
	 * @return the numLoci
	 */
	public Integer getNumLoci() {
		return numLoci;
	}

	/**
	 * @return the numInds
	 */
	public Integer getNumInds() {
		return numInds;
	}

	/**
	 * @return the burnIn
	 */
	public Long getBurnIn() {
		return burnIn;
	}

	/**
	 * @return the numReps
	 */
	public Long getNumReps() {
		return numReps;
	}

	/**
	 * @return the inFile
	 */
	public String getInFile() {
		return inFile;
	}

	/**
	 * @return the outFile
	 */
	public String getOutFile() {
		return outFile;
	}

	/**
	 * @return the mainParams
	 */
	public String getMainParams() {
		return mainParams;
	}

	/**
	 * @return the extraParams
	 */
	public String getExtraParams() {
		return extraParams;
	}
	
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	@Override
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, final BuildListener listener) 
    		throws AbortException, InterruptedException, IOException {
    	listener.getLogger().println(Messages.StructureBuilder_InvokingStructure());
        
        StructureInstallation structureInstallation = DESCRIPTOR.getInstallationByName(this.structureInstallationName);
        if(structureInstallation == null) {
        	throw new AbortException(Messages.StructureBuilder_InvalidStructureInstallation());
        }
        
        // Replace variables with the values provided by the user in the job configuration
        // Create one mainparam file for each K value
        for(int i = 1; 1 <= this.maxPops ; ++i) {
        	try {
				String mainParamContent = parser.parse(this.mainParams, i);
				FileUtils.writeStringToFile(new File("mainparams.param_set.k"+i), mainParamContent);
				
				// TODO: Spawn one job for each K/mainparam
		        
		        // TODO: Gather all the results
		        
		        // TODO: Reporting
				
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
//        // create command to be executed
//        listener.getLogger().println("Launching Structure...");
//        
//        final String command = structureInstallation.getPathToExecutable();
//        final ArgumentListBuilder args = new ArgumentListBuilder();
//        args.add(command);
//        
//        final String mainParamsLocation = fileNames.get("mainparams");
//        final String extraParamsLocation = fileNames.get("extraparams");
//        
//        if(StringUtils.isNotBlank(mainParamsLocation)) {
//        	args.add("-m");
//        	args.add(mainParamsLocation);
//        }
//        
//        if(StringUtils.isNotBlank(extraParamsLocation)) {
//        	args.add("-e");
//        	args.add(extraParamsLocation);
//        }
//        
//        Map<String, String> env = build.getEnvironment(listener);
//        
//        final Integer exitCode = launcher.launch().cmds(args).envs(env).stdout(listener).pwd(build.getModuleRoot()).join();
//        
//        if(exitCode != 0) {
//        	listener.getLogger().println("Error executing Structure. Exit code : " + exitCode);
//        	return Boolean.FALSE;
//        } else {
//        	listener.getLogger().println("Successfully executed Structure.");
//        	return Boolean.TRUE;
//        }
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

