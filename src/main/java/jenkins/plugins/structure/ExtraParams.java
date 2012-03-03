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
 * Structure extra params.
 * 
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 0.1
 */
public class ExtraParams implements Serializable {

	private static final long serialVersionUID = -552861951501625811L;

	// PROGRAM OPTIONS
	private final Boolean noAdmix;
	private final Boolean linkage;
	private final Boolean usePopInfo;
	private final Boolean locPrior;
	private final Boolean freqsCorr;
	private final Boolean oneFst;
	private final Boolean inferAlpha;
	private final Boolean popAlphas;
	private final Double alpha;
	private final Boolean inferLambda;
	private final Boolean popSpecificLambda;
	private final Double lambda;

	// PRIORS
	private final Double fPriorMean;
	private final Double fPriorSd;
	private final Boolean unifPriorAlpha;
	private final Double alphaMax;
	private final Double alphaPriorA;
	private final Double alphaPriorB;
	private final Double log10RMin;
	private final Double log10RMax;
	private final Double log10RPropSD;
	private final Double log10RStart;

	// USING PRIOR POPULATION INFO (USEPOPINFO)
	private final Long gensBank;
	private final Double migrPrior;
	private final Boolean pFromPopFlagOnly;
	private final Boolean locisPop;
	private final Double locPriorInt;
	private final Double maxLocPrior;

	// OUTPUT OPTIONS
	private final Boolean printNet;
	private final Boolean printLambda;
	private final Boolean printQSum;
	private final Boolean siteByte;
	private final Boolean printQHat;
	private final Long updateFreq;
	private final Boolean printLikes;
	private final Long intermedSave;
	private final Boolean echoData;
	private final Boolean ancestDist;
	private final Long numBoxes;
	private final Double ancestPint;

	// MISCELLANEOUS
	private final Boolean computerProb;
	private final Long admBurnIn;
	private final Double alphaPropSd;
	private final Boolean startAtPopInfo;
	private final Boolean randomize;
	private final Long seed;
	private final Long metroFreq;
	private final Boolean reportHitRate;

	/**
	 * @param noAdmix
	 * @param linkage
	 * @param usePopInfo
	 * @param locPrior
	 * @param freqsCorr
	 * @param oneFst
	 * @param inferAlpha
	 * @param popAlphas
	 * @param alpha
	 * @param inferLambda
	 * @param popSpecificLambda
	 * @param lambda
	 * @param fPriorMean
	 * @param fPriorSd
	 * @param unifPriorAlpha
	 * @param alphaMax
	 * @param alphaPriorA
	 * @param alphaPriorB
	 * @param log10rMin
	 * @param log10rMax
	 * @param log10rPropSD
	 * @param log10rStart
	 * @param gensBank
	 * @param migrPrior
	 * @param pFromPopFlagOnly
	 * @param locisPop
	 * @param locPriorInt
	 * @param maxLocPrior
	 * @param printNet
	 * @param printLambda
	 * @param printQSum
	 * @param siteByte
	 * @param printQHat
	 * @param updateFreq
	 * @param printLikes
	 * @param intermedSave
	 * @param echoData
	 * @param ancestDist
	 * @param numBoxes
	 * @param ancestPint
	 * @param computerProb
	 * @param admBurnIn
	 * @param alphaPropSd
	 * @param startAtPopInfo
	 * @param randomize
	 * @param seed
	 * @param metroFreq
	 * @param reportHitRate
	 */
	@DataBoundConstructor
	public ExtraParams(Boolean noAdmix, Boolean linkage, Boolean usePopInfo,
			Boolean locPrior, Boolean freqsCorr, Boolean oneFst,
			Boolean inferAlpha, Boolean popAlphas, Double alpha,
			Boolean inferLambda, Boolean popSpecificLambda, Double lambda,
			Double fPriorMean, Double fPriorSd, Boolean unifPriorAlpha,
			Double alphaMax, Double alphaPriorA, Double alphaPriorB,
			Double log10rMin, Double log10rMax, Double log10rPropSD,
			Double log10rStart, Long gensBank, Double migrPrior,
			Boolean pFromPopFlagOnly, Boolean locisPop, Double locPriorInt,
			Double maxLocPrior, Boolean printNet, Boolean printLambda,
			Boolean printQSum, Boolean siteByte, Boolean printQHat,
			Long updateFreq, Boolean printLikes, Long intermedSave,
			Boolean echoData, Boolean ancestDist, Long numBoxes,
			Double ancestPint, Boolean computerProb, Long admBurnIn,
			Double alphaPropSd, Boolean startAtPopInfo, Boolean randomize,
			Long seed, Long metroFreq, Boolean reportHitRate) {
		super();
		this.noAdmix = noAdmix;
		this.linkage = linkage;
		this.usePopInfo = usePopInfo;
		this.locPrior = locPrior;
		this.freqsCorr = freqsCorr;
		this.oneFst = oneFst;
		this.inferAlpha = inferAlpha;
		this.popAlphas = popAlphas;
		this.alpha = alpha;
		this.inferLambda = inferLambda;
		this.popSpecificLambda = popSpecificLambda;
		this.lambda = lambda;
		this.fPriorMean = fPriorMean;
		this.fPriorSd = fPriorSd;
		this.unifPriorAlpha = unifPriorAlpha;
		this.alphaMax = alphaMax;
		this.alphaPriorA = alphaPriorA;
		this.alphaPriorB = alphaPriorB;
		log10RMin = log10rMin;
		log10RMax = log10rMax;
		log10RPropSD = log10rPropSD;
		log10RStart = log10rStart;
		this.gensBank = gensBank;
		this.migrPrior = migrPrior;
		this.pFromPopFlagOnly = pFromPopFlagOnly;
		this.locisPop = locisPop;
		this.locPriorInt = locPriorInt;
		this.maxLocPrior = maxLocPrior;
		this.printNet = printNet;
		this.printLambda = printLambda;
		this.printQSum = printQSum;
		this.siteByte = siteByte;
		this.printQHat = printQHat;
		this.updateFreq = updateFreq;
		this.printLikes = printLikes;
		this.intermedSave = intermedSave;
		this.echoData = echoData;
		this.ancestDist = ancestDist;
		this.numBoxes = numBoxes;
		this.ancestPint = ancestPint;
		this.computerProb = computerProb;
		this.admBurnIn = admBurnIn;
		this.alphaPropSd = alphaPropSd;
		this.startAtPopInfo = startAtPopInfo;
		this.randomize = randomize;
		this.seed = seed;
		this.metroFreq = metroFreq;
		this.reportHitRate = reportHitRate;
	}

	/**
	 * @return the noAdmix
	 */
	public Boolean getNoAdmix() {
		return noAdmix;
	}

	/**
	 * @return the linkage
	 */
	public Boolean getLinkage() {
		return linkage;
	}

	/**
	 * @return the usePopInfo
	 */
	public Boolean getUsePopInfo() {
		return usePopInfo;
	}

	/**
	 * @return the locPrior
	 */
	public Boolean getLocPrior() {
		return locPrior;
	}

	/**
	 * @return the freqsCorr
	 */
	public Boolean getFreqsCorr() {
		return freqsCorr;
	}

	/**
	 * @return the oneFst
	 */
	public Boolean getOneFst() {
		return oneFst;
	}

	/**
	 * @return the inferAlpha
	 */
	public Boolean getInferAlpha() {
		return inferAlpha;
	}

	/**
	 * @return the popAlphas
	 */
	public Boolean getPopAlphas() {
		return popAlphas;
	}

	/**
	 * @return the alpha
	 */
	public Double getAlpha() {
		return alpha;
	}

	/**
	 * @return the inferLambda
	 */
	public Boolean getInferLambda() {
		return inferLambda;
	}

	/**
	 * @return the popSpecificLambda
	 */
	public Boolean getPopSpecificLambda() {
		return popSpecificLambda;
	}

	/**
	 * @return the lambda
	 */
	public Double getLambda() {
		return lambda;
	}

	/**
	 * @return the fPriorMean
	 */
	public Double getfPriorMean() {
		return fPriorMean;
	}

	/**
	 * @return the fPriorSd
	 */
	public Double getfPriorSd() {
		return fPriorSd;
	}

	/**
	 * @return the unifPriorAlpha
	 */
	public Boolean getUnifPriorAlpha() {
		return unifPriorAlpha;
	}

	/**
	 * @return the alphaMax
	 */
	public Double getAlphaMax() {
		return alphaMax;
	}

	/**
	 * @return the alphaPriorA
	 */
	public Double getAlphaPriorA() {
		return alphaPriorA;
	}

	/**
	 * @return the alphaPriorB
	 */
	public Double getAlphaPriorB() {
		return alphaPriorB;
	}

	/**
	 * @return the log10RMin
	 */
	public Double getLog10RMin() {
		return log10RMin;
	}

	/**
	 * @return the log10RMax
	 */
	public Double getLog10RMax() {
		return log10RMax;
	}

	/**
	 * @return the log10RPropSD
	 */
	public Double getLog10RPropSD() {
		return log10RPropSD;
	}

	/**
	 * @return the log10RStart
	 */
	public Double getLog10RStart() {
		return log10RStart;
	}

	/**
	 * @return the gensBank
	 */
	public Long getGensBank() {
		return gensBank;
	}

	/**
	 * @return the migrPrior
	 */
	public Double getMigrPrior() {
		return migrPrior;
	}

	/**
	 * @return the pFromPopFlagOnly
	 */
	public Boolean getpFromPopFlagOnly() {
		return pFromPopFlagOnly;
	}

	/**
	 * @return the locisPop
	 */
	public Boolean getLocisPop() {
		return locisPop;
	}

	/**
	 * @return the locPriorInt
	 */
	public Double getLocPriorInt() {
		return locPriorInt;
	}

	/**
	 * @return the maxLocPrior
	 */
	public Double getMaxLocPrior() {
		return maxLocPrior;
	}

	/**
	 * @return the printNet
	 */
	public Boolean getPrintNet() {
		return printNet;
	}

	/**
	 * @return the printLambda
	 */
	public Boolean getPrintLambda() {
		return printLambda;
	}

	/**
	 * @return the printQSum
	 */
	public Boolean getPrintQSum() {
		return printQSum;
	}

	/**
	 * @return the siteByte
	 */
	public Boolean getSiteByte() {
		return siteByte;
	}

	/**
	 * @return the printQHat
	 */
	public Boolean getPrintQHat() {
		return printQHat;
	}

	/**
	 * @return the updateFreq
	 */
	public Long getUpdateFreq() {
		return updateFreq;
	}

	/**
	 * @return the printLikes
	 */
	public Boolean getPrintLikes() {
		return printLikes;
	}

	/**
	 * @return the intermedSave
	 */
	public Long getIntermedSave() {
		return intermedSave;
	}

	/**
	 * @return the echoData
	 */
	public Boolean getEchoData() {
		return echoData;
	}

	/**
	 * @return the ancestDist
	 */
	public Boolean getAncestDist() {
		return ancestDist;
	}

	/**
	 * @return the numBoxes
	 */
	public Long getNumBoxes() {
		return numBoxes;
	}

	/**
	 * @return the ancestPint
	 */
	public Double getAncestPint() {
		return ancestPint;
	}

	/**
	 * @return the computerProb
	 */
	public Boolean getComputerProb() {
		return computerProb;
	}

	/**
	 * @return the admBurnIn
	 */
	public Long getAdmBurnIn() {
		return admBurnIn;
	}

	/**
	 * @return the alphaPropSd
	 */
	public Double getAlphaPropSd() {
		return alphaPropSd;
	}

	/**
	 * @return the startAtPopInfo
	 */
	public Boolean getStartAtPopInfo() {
		return startAtPopInfo;
	}

	/**
	 * @return the randomize
	 */
	public Boolean getRandomize() {
		return randomize;
	}

	/**
	 * @return the seed
	 */
	public Long getSeed() {
		return seed;
	}

	/**
	 * @return the metroFreq
	 */
	public Long getMetroFreq() {
		return metroFreq;
	}

	/**
	 * @return the reportHitRate
	 */
	public Boolean getReportHitRate() {
		return reportHitRate;
	}

}
