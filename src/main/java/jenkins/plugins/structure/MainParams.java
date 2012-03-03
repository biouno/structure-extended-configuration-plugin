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

	// Basic Program Parameters
	private final Long maxPops;
	private final Long burnIn;
	private final Long numReps;

	// Input/Output files
	private final String inFile;
	private final String outFile;

	// Data file format
	private final Long numInds;
	private final Long numLoci;
	private final Integer ploidy;
	private final Integer missing;
	private final Boolean oneRowPerInd;
	private final Boolean label;
	private final Boolean popData;
	private final Boolean popFlag;
	private final Boolean locData;
	private final Boolean phenotype;
	private final Integer extraCols;
	private final Boolean markerNames;
	private final Boolean recessiveAlleles;
	private final Boolean mapDistances;

	// Advanced data file options
	private final Boolean phased;
	private final Boolean phaseInfo;
	private final Boolean markkovPhase;
	private final Integer notAmbiguous;

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
	 * @param markkovPhase
	 * @param notAmbiguous
	 */
	@DataBoundConstructor
	public MainParams(Long maxPops, Long burnIn, Long numReps, String inFile,
			String outFile, Long numInds, Long numLoci, Integer ploidy,
			Integer missing, Boolean oneRowPerInd, Boolean label,
			Boolean popData, Boolean popFlag, Boolean locData,
			Boolean phenotype, Integer extraCols, Boolean markerNames,
			Boolean recessiveAlleles, Boolean mapDistances, Boolean phased,
			Boolean phaseInfo, Boolean markkovPhase, Integer notAmbiguous) {
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
		this.markkovPhase = markkovPhase;
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
	 * @return the markkovPhase
	 */
	public Boolean getMarkkovPhase() {
		return markkovPhase;
	}

	/**
	 * @return the notAmbiguous
	 */
	public Integer getNotAmbiguous() {
		return notAmbiguous;
	}

}
