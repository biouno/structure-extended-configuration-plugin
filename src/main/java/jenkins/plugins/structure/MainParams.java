/*
 * The MIT License
 *
 * Copyright (c) <2012> <Bruno P. Kinoshita>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package jenkins.plugins.structure;

import java.io.Serializable;

import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Structure main params.
 * 
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 0.1
 */
public class MainParams implements Serializable {

	private static final long serialVersionUID = -4370670728575641946L;
	
	private static final String NOTAMBIGUOUS = "NOTAMBIGUOUS";
	private static final String MARKOVPHASE = "MARKOVPHASE";
	private static final String PHASEINFO = "PHASEINFO";
	private static final String PHASED = "PHASED";
	private static final String MAPDISTANCES = "MAPDISTANCES";
	private static final String RECESSIVEALLELES = "RECESSIVEALLELES";
	private static final String MARKERNAMES = "MARKERNAMES";
	private static final String EXTRACOLS = "EXTRACOLS";
	private static final String PHENOTYPE = "PHENOTYPE";
	private static final String LOCDATA = "LOCDATA";
	private static final String POPFLAG = "POPFLAG";
	private static final String POPDATA = "POPDATA";
	private static final String LABEL = "LABEL";
	private static final String ONEROWPERIND = "ONEROWPERIND";
	private static final String MISSING = "MISSING";
	private static final String PLOIDY = "PLOIDY";
	private static final String NUMLOCI = "NUMLOCI";
	private static final String NUMINDS = "NUMINDS";
	private static final String OUTFILE = "OUTFILE";
	private static final String INFILE = "INFILE";
	private static final String NUMREPS = "NUMREPS";
	private static final String BURNIN = "BURNIN";
	private static final String MAXPOPS = "MAXPOPS";

	// Basic Program Parameters
	private final Long maxPops; // (int) number of populations assumed
	private final Long burnIn; // (int) length of burnin period
	private final Long numReps; // (int) number of MCMC reps after burnin

	// Input/Output files
	private final String inFile; // (str) name of input data file
	private final String outFile; //(str) name of output data file

	// Data file format
	private final Long numInds; // (int) number of diploid individuals in data file
	private final Long numLoci; // (int) number of loci in data file
	private final Integer ploidy; // (int) ploidy of data
	private final Integer missing; // (int) value given to missing genotype data
	private final Boolean oneRowPerInd; // (B) store data for individuals in a single line
	private final Boolean label; // (B) Input file contains individual labels
	private final Boolean popData; // (B) Input file contains a population identifier
	private final Boolean popFlag; // (B) Input file contains a flag which says whether to use popinfo when USEPOPINFO==1
	private final Boolean locData; // (B) Input file contains a location identifier
	private final Boolean phenotype; // (B) Input file contains phenotype information
	private final Integer extraCols; // (int) Number of additional columns of data before the genotype data start.
	private final Boolean markerNames; // (B) data file contains row of marker names
	private final Boolean recessiveAlleles; // (B) data file contains dominant markers (eg AFLPs) and a row to indicate which alleles are recessive
	private final Boolean mapDistances; // (B) data file contains row of map distances between loci

	// Advanced data file options
	private final Boolean phased; // (B) Data are in correct phase (relevant for linkage model only)
	private final Boolean phaseInfo; // (B) the data for each individual contains a line indicating phase (linkage model)
	private final Boolean markovPhase; // (B) the phase info follows a Markov model.
	private final Integer notAmbiguous; // (int) for use in some analyses of polyploid data

	/**
	 * @param maxPops
	 * @param burnIn
	 * @param numReps
	 * @param inFile
	 * @param outFile
	 * @param numInds
	 * @param numLoci
	 * @param ploidy
	 * @param missing
	 * @param oneRowPerInd
	 * @param label
	 * @param popData
	 * @param popFlag
	 * @param locData
	 * @param phenotype
	 * @param extraCols
	 * @param markerNames
	 * @param recessiveAlleles
	 * @param mapDistances
	 * @param phased
	 * @param phaseInfo
	 * @param markovPhase
	 * @param notAmbiguous
	 */
	@DataBoundConstructor
	public MainParams(Long maxPops, 
			Long burnIn,
			Long numReps, 
			String inFile,
			String outFile, 
			Long numInds, 
			Long numLoci, 
			Integer ploidy,
			Integer missing, 
			Boolean oneRowPerInd, 
			Boolean label,
			Boolean popData, 
			Boolean popFlag, 
			Boolean locData,
			Boolean phenotype, 
			Integer extraCols, 
			Boolean markerNames,
			Boolean recessiveAlleles, 
			Boolean mapDistances, 
			Boolean phased,
			Boolean phaseInfo, 
			Boolean markovPhase, 
			Integer notAmbiguous) {
		super();
		this.maxPops = maxPops;
		this.burnIn = burnIn;
		this.numReps = numReps;
		this.inFile = inFile;
		this.outFile = outFile;
		this.numInds = numInds;
		this.numLoci = numLoci;
		this.ploidy = ploidy;
		this.missing = missing;
		this.oneRowPerInd = oneRowPerInd;
		this.label = label;
		this.popData = popData;
		this.popFlag = popFlag;
		this.locData = locData;
		this.phenotype = phenotype;
		this.extraCols = extraCols;
		this.markerNames = markerNames;
		this.recessiveAlleles = recessiveAlleles;
		this.mapDistances = mapDistances;
		this.phased = phased;
		this.phaseInfo = phaseInfo;
		this.markovPhase = markovPhase;
		this.notAmbiguous = notAmbiguous;
	}

	/**
	 * @return the maxPops
	 */
	public Long getMaxPops() {
		return maxPops;
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
	 * @return the numInds
	 */
	public Long getNumInds() {
		return numInds;
	}

	/**
	 * @return the numLoci
	 */
	public Long getNumLoci() {
		return numLoci;
	}

	/**
	 * @return the ploidy
	 */
	public Integer getPloidy() {
		return ploidy;
	}

	/**
	 * @return the missing
	 */
	public Integer getMissing() {
		return missing;
	}

	/**
	 * @return the oneRowPerInd
	 */
	public Boolean getOneRowPerInd() {
		return oneRowPerInd;
	}

	/**
	 * @return the label
	 */
	public Boolean getLabel() {
		return label;
	}

	/**
	 * @return the popData
	 */
	public Boolean getPopData() {
		return popData;
	}

	/**
	 * @return the popFlag
	 */
	public Boolean getPopFlag() {
		return popFlag;
	}

	/**
	 * @return the locData
	 */
	public Boolean getLocData() {
		return locData;
	}

	/**
	 * @return the phenotype
	 */
	public Boolean getPhenotype() {
		return phenotype;
	}

	/**
	 * @return the extraCols
	 */
	public Integer getExtraCols() {
		return extraCols;
	}

	/**
	 * @return the markerNames
	 */
	public Boolean getMarkerNames() {
		return markerNames;
	}

	/**
	 * @return the recessiveAlleles
	 */
	public Boolean getRecessiveAlleles() {
		return recessiveAlleles;
	}

	/**
	 * @return the mapDistances
	 */
	public Boolean getMapDistances() {
		return mapDistances;
	}

	/**
	 * @return the phased
	 */
	public Boolean getPhased() {
		return phased;
	}

	/**
	 * @return the phaseInfo
	 */
	public Boolean getPhaseInfo() {
		return phaseInfo;
	}

	/**
	 * @return the markovPhase
	 */
	public Boolean getMarkovPhase() {
		return markovPhase;
	}

	/**
	 * @return the notAmbiguous
	 */
	public Integer getNotAmbiguous() {
		return notAmbiguous;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Util.addOption(sb, MAXPOPS, this.getMaxPops());
		Util.addOption(sb, BURNIN, this.getBurnIn());
		Util.addOption(sb, NUMREPS, this.getNumReps());
		Util.addOption(sb, INFILE, this.getInFile());
		Util.addOption(sb, OUTFILE, this.getOutFile());
		Util.addOption(sb, NUMINDS, this.getNumInds());
		Util.addOption(sb, NUMLOCI, this.getNumLoci());
		Util.addOption(sb, PLOIDY, this.getPloidy());
		Util.addOption(sb, MISSING, this.getMissing());
		Util.addOption(sb, ONEROWPERIND, this.getOneRowPerInd());
		Util.addOption(sb, LABEL, this.getLabel());
		Util.addOption(sb, POPDATA, this.getPopData());
		Util.addOption(sb, POPFLAG, this.getPopFlag());
		Util.addOption(sb, LOCDATA, this.getLocData());
		Util.addOption(sb, PHENOTYPE, this.getPhenotype());
		Util.addOption(sb, EXTRACOLS, this.getExtraCols());
		Util.addOption(sb, MARKERNAMES, this.getMarkerNames());
		Util.addOption(sb, RECESSIVEALLELES, this.getRecessiveAlleles());
		Util.addOption(sb, MAPDISTANCES, this.getMapDistances());
		Util.addOption(sb, PHASED, this.getPhased());
		Util.addOption(sb, PHASEINFO, this.getPhaseInfo());
		Util.addOption(sb, MARKOVPHASE, this.getMarkovPhase());
		Util.addOption(sb, NOTAMBIGUOUS, this.getNotAmbiguous());
		return sb.toString();
	}

}
