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

	private static final long serialVersionUID = 7972402475597064450L;
	
	private static final String NOADMIX = "NOADMIX";
	private static final String LINKAGE = "LINKAGE";
	private static final String USEPOPINFO = "USEPOPINFO";
	private static final String LOCPRIOR = "LOCPRIOR";
	private static final String FREQSCORR = "FREQSCORR";
	private static final String ONEFST = "ONEFST";
	private static final String INFERALPHA = "INFERALPHA";
	private static final String POPALPHAS = "POPALPHAS";
	private static final String ALPHA = "ALPHA";
	private static final String INFERLAMBDA = "INFERLAMBDA";
	private static final String POPSPECIFICLAMBDA = "POPSPECIFICLAMBDA";
	private static final String LAMBDA = "LAMBDA";
	private static final String FPRIORMEAN = "FPRIORMEAN";
	private static final String FPRIORSD = "FPRIORSD";
	private static final String UNIFPRIORALPHA = "UNIFPRIORALPHA";
	private static final String ALPHAMAX = "ALPHAMAX";
	private static final String ALPHAPRIORA = "ALPHAPRIORA";
	private static final String ALPHAPRIORB = "ALPHAPRIORB";
	private static final String LOG10RMIN = "LOG10RMIN";
	private static final String LOG10RMAX = "LOG10RMAX";
	private static final String LOG10RPROPSD = "LOG10RPROPSD";
	private static final String LOG10RSTART = "LOG10RSTART";
	private static final String GENSBACK = "GENSBACK";
	private static final String MIGRPRIOR = "MIGRPRIOR";
	private static final String PFROMPOPFLAGONLY = "PFROMPOPFLAGONLY";
	private static final String LOCISPOP = "LOCISPOP";
	private static final String LOCPRIORINIT = "LOCPRIORINIT";
	private static final String MAXLOCPRIOR = "MAXLOCPRIOR";
	private static final String PRINTNET = "PRINTNET";
	private static final String PRINTLAMBDA = "PRINTLAMBDA";
	private static final String PRINTQSUM = "PRINTQSUM";
	private static final String SITEBYSITE = "SITEBYSITE";
	private static final String PRINTQHAT = "PRINTQHAT";
	private static final String UPDATEFREQ = "UPDATEFREQ";
	private static final String PRINTLIKES = "PRINTLIKES";
	private static final String INTERMEDSAVE = "INTERMEDSAVE";
	private static final String ECHODATA = "ECHODATA";
	private static final String ANCESTDIST = "ANCESTDIST";
	private static final String NUMBOXES = "NUMBOXES";
	private static final String ANCESTPINT = "ANCESTPINT";
	private static final String COMPUTEPROB = "COMPUTEPROB";
	private static final String ADMBURNIN = "ADMBURNIN";
	private static final String ALPHAPROPSD = "ALPHAPROPSD";
	private static final String STARTATPOPINFO = "STARTATPOPINFO";
	private static final String RANDOMIZE = "RANDOMIZE";
	private static final String SEED = "SEED";
	private static final String METROFREQ = "METROFREQ";
	private static final String REPORTHITRATE = "REPORTHITRATE";

	// PROGRAM OPTIONS
	private final String noAdmix; // (B) Use no admixture model (0=admixture model, 1=no-admix)
	private final String linkage; // (B) Use the linkage model model 
	private final String usePopInfo; // (B) Use prior population information to pre-assign individuals to clusters
	private final String locPrior; //(B)  Use location information to improve weak data
	private final String freqsCorr; // (B) allele frequencies are correlated among pops
	private final String oneFst; // (B) assume same value of Fst for all subpopulations.
	private final String inferAlpha; // (B) Infer ALPHA (the admixture parameter)
	private final String popAlphas; // (B) Individual alpha for each population
	private final String alpha; // (d) Dirichlet parameter for degree of admixture (this is the initial value if INFERALPHA==1).
	private final String inferLambda; // (B) Infer LAMBDA (the allele frequencies parameter)
	private final String popSpecificLambda; //(B) infer a separate lambda for each pop (only if INFERLAMBDA=1).
	private final String lambda; // (d) Dirichlet parameter for allele frequencies 

	// PRIORS
	private final String fPriorMean; // (d) Prior mean and SD of Fst for pops.
	private final String fPriorSd; // (d) The prior is a Gamma distribution with these parameters
	private final String unifPriorAlpha; // (B) use a uniform prior for alpha; otherwise gamma prior
	private final String alphaMax; // (d) max value of alpha if uniform prior
	private final String alphaPriorA; // (only if UNIFPRIORALPHA==0): alpha has a gamma prior with mean A*B, and 
	private final String alphaPriorB; // variance A*B^2. 
	private final String log10RMin; //(d) Log10 of minimum allowed value of r under linkage model
	private final String log10RMax; //(d) Log10 of maximum allowed value of r
	private final String log10RPropSD; //(d) standard deviation of log r in update
	private final String log10RStart; //(d) initial value of log10 r

	// USING PRIOR POPULATION INFO (USEPOPINFO)
	private final String gensBank; //(int) For use when inferring whether an individual is an immigrant, or has an immigrant ancestor in the past GENSBACK generations.  eg, if GENSBACK==2, it tests for immigrant ancestry back to grandparents. 
	private final String migrPrior; //(d) prior prob that an individual is a migrant (used only when USEPOPINFO==1).  This should be small, eg 0.01 or 0.1.
	private final String pFromPopFlagOnly; // (B) only use individuals with POPFLAG=1 to update P. This is to enable use of a reference set of individuals for clustering additional "test" individuals.
	
	// LOCPRIOR MODEL FOR USING LOCATION INFORMATION
	private final String locisPop; //(B) use POPDATA for location information 
	private final String locPriorInit; //(d) initial value for r, the location prior
	private final String maxLocPrior; //(d) max allowed value for r

	// OUTPUT OPTIONS
	private final String printNet; // (B) Print the "net nucleotide distance" to screen during the run
	private final String printLambda; // (B) Print current value(s) of lambda to screen
	private final String printQSum; // (B) Print summary of current population membership to screen
	private final String siteByte; // (B) whether or not to print site by site results. (Linkage model only) This is a large file!
	private final String printQHat; // (B) Q-hat printed to a separate file.  Turn this on before using STRAT.
	private final String updateFreq; // (int) frequency of printing update on the screen. Set automatically if this is 0.
	private final String printLikes; // (B) print current likelihood to screen every rep
	private final String intermedSave; // (int) number of saves to file during run
	private final String echoData; // (B) Print some of data file to screen to check that the data entry is correct.
	
	// (NEXT 3 ARE FOR COLLECTING DISTRIBUTION OF Q:)
	private final String ancestDist; // (B) collect data about the distribution of ancestry coefficients (Q) for each individual
	private final String numBoxes; // (int) the distribution of Q values is stored as a histogram with this number of boxes. 
	private final String ancestPint; // (d) the size of the displayed probability interval on Q (values between 0.0--1.0)

	// MISCELLANEOUS
	private final String computerProb; // (B) Estimate the probability of the Data under the model.  This is used when choosing the best number of subpopulations.
	private final String admBurnIn; // (int) [only relevant for linkage model]: Initial period of burnin with admixture model (see Readme)
	private final String alphaPropSd; // (d) SD of proposal for updating alpha
	private final String startAtPopInfo; // Use given populations as the initial condition for population origins. (Need POPDATA==1). It is assumed that the PopData in the input file are between 1 and k where k<=MAXPOPS.
	private final String randomize; // (B) use new random seed for each run 
	private final String seed; // (int) seed value for random number generator (must set RANDOMIZE=0) 
	private final String metroFreq; // (int) Frequency of using Metropolis step to update Q under admixture model (ie use the metr. move every i steps).  If this is set to 0, it is never used. (Proposal for each q^(i) sampled from prior.  The goal is to improve mixing for small alpha.)
	private final String reportHitRate; // (B) report hit rate if using METROFREQ

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
	 * @param locPriorInit
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
	public ExtraParams(String noAdmix, 
			String linkage, 
			String usePopInfo,
			String locPrior, 
			String freqsCorr, 
			String oneFst,
			String inferAlpha, 
			String popAlphas, 
			String alpha,
			String inferLambda, 
			String popSpecificLambda, 
			String lambda,
			String fPriorMean, 
			String fPriorSd, 
			String unifPriorAlpha,
			String alphaMax, 
			String alphaPriorA, 
			String alphaPriorB,
			String log10rMin, 
			String log10rMax, 
			String log10rPropSD,
			String log10rStart, 
			String gensBank, 
			String migrPrior,
			String pFromPopFlagOnly, 
			String locisPop, 
			String locPriorInit,
			String maxLocPrior, 
			String printNet, 
			String printLambda,
			String printQSum, 
			String siteByte, 
			String printQHat,
			String updateFreq, 
			String printLikes, 
			String intermedSave,
			String echoData, 
			String ancestDist, 
			String numBoxes,
			String ancestPint, 
			String computerProb, 
			String admBurnIn,
			String alphaPropSd, 
			String startAtPopInfo, 
			String randomize,
			String seed, 
			String metroFreq, 
			String reportHitRate) {
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
		this.locPriorInit = locPriorInit;
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
	public String getNoAdmix() {
		return noAdmix;
	}

	/**
	 * @return the linkage
	 */
	public String getLinkage() {
		return linkage;
	}

	/**
	 * @return the usePopInfo
	 */
	public String getUsePopInfo() {
		return usePopInfo;
	}

	/**
	 * @return the locPrior
	 */
	public String getLocPrior() {
		return locPrior;
	}

	/**
	 * @return the freqsCorr
	 */
	public String getFreqsCorr() {
		return freqsCorr;
	}

	/**
	 * @return the oneFst
	 */
	public String getOneFst() {
		return oneFst;
	}

	/**
	 * @return the inferAlpha
	 */
	public String getInferAlpha() {
		return inferAlpha;
	}

	/**
	 * @return the popAlphas
	 */
	public String getPopAlphas() {
		return popAlphas;
	}

	/**
	 * @return the alpha
	 */
	public String getAlpha() {
		return alpha;
	}

	/**
	 * @return the inferLambda
	 */
	public String getInferLambda() {
		return inferLambda;
	}

	/**
	 * @return the popSpecificLambda
	 */
	public String getPopSpecificLambda() {
		return popSpecificLambda;
	}

	/**
	 * @return the lambda
	 */
	public String getLambda() {
		return lambda;
	}

	/**
	 * @return the fPriorMean
	 */
	public String getfPriorMean() {
		return fPriorMean;
	}

	/**
	 * @return the fPriorSd
	 */
	public String getfPriorSd() {
		return fPriorSd;
	}

	/**
	 * @return the unifPriorAlpha
	 */
	public String getUnifPriorAlpha() {
		return unifPriorAlpha;
	}

	/**
	 * @return the alphaMax
	 */
	public String getAlphaMax() {
		return alphaMax;
	}

	/**
	 * @return the alphaPriorA
	 */
	public String getAlphaPriorA() {
		return alphaPriorA;
	}

	/**
	 * @return the alphaPriorB
	 */
	public String getAlphaPriorB() {
		return alphaPriorB;
	}

	/**
	 * @return the log10RMin
	 */
	public String getLog10RMin() {
		return log10RMin;
	}

	/**
	 * @return the log10RMax
	 */
	public String getLog10RMax() {
		return log10RMax;
	}

	/**
	 * @return the log10RPropSD
	 */
	public String getLog10RPropSD() {
		return log10RPropSD;
	}

	/**
	 * @return the log10RStart
	 */
	public String getLog10RStart() {
		return log10RStart;
	}

	/**
	 * @return the gensBank
	 */
	public String getGensBank() {
		return gensBank;
	}

	/**
	 * @return the migrPrior
	 */
	public String getMigrPrior() {
		return migrPrior;
	}

	/**
	 * @return the pFromPopFlagOnly
	 */
	public String getpFromPopFlagOnly() {
		return pFromPopFlagOnly;
	}

	/**
	 * @return the locisPop
	 */
	public String getLocisPop() {
		return locisPop;
	}

	/**
	 * @return the locPriorInt
	 */
	public String getLocPriorInit() {
		return locPriorInit;
	}

	/**
	 * @return the maxLocPrior
	 */
	public String getMaxLocPrior() {
		return maxLocPrior;
	}

	/**
	 * @return the printNet
	 */
	public String getPrintNet() {
		return printNet;
	}

	/**
	 * @return the printLambda
	 */
	public String getPrintLambda() {
		return printLambda;
	}

	/**
	 * @return the printQSum
	 */
	public String getPrintQSum() {
		return printQSum;
	}

	/**
	 * @return the siteByte
	 */
	public String getSiteByte() {
		return siteByte;
	}

	/**
	 * @return the printQHat
	 */
	public String getPrintQHat() {
		return printQHat;
	}

	/**
	 * @return the updateFreq
	 */
	public String getUpdateFreq() {
		return updateFreq;
	}

	/**
	 * @return the printLikes
	 */
	public String getPrintLikes() {
		return printLikes;
	}

	/**
	 * @return the intermedSave
	 */
	public String getIntermedSave() {
		return intermedSave;
	}

	/**
	 * @return the echoData
	 */
	public String getEchoData() {
		return echoData;
	}

	/**
	 * @return the ancestDist
	 */
	public String getAncestDist() {
		return ancestDist;
	}

	/**
	 * @return the numBoxes
	 */
	public String getNumBoxes() {
		return numBoxes;
	}

	/**
	 * @return the ancestPint
	 */
	public String getAncestPint() {
		return ancestPint;
	}

	/**
	 * @return the computerProb
	 */
	public String getComputerProb() {
		return computerProb;
	}

	/**
	 * @return the admBurnIn
	 */
	public String getAdmBurnIn() {
		return admBurnIn;
	}

	/**
	 * @return the alphaPropSd
	 */
	public String getAlphaPropSd() {
		return alphaPropSd;
	}

	/**
	 * @return the startAtPopInfo
	 */
	public String getStartAtPopInfo() {
		return startAtPopInfo;
	}

	/**
	 * @return the randomize
	 */
	public String getRandomize() {
		return randomize;
	}

	/**
	 * @return the seed
	 */
	public String getSeed() {
		return seed;
	}

	/**
	 * @return the metroFreq
	 */
	public String getMetroFreq() {
		return metroFreq;
	}

	/**
	 * @return the reportHitRate
	 */
	public String getReportHitRate() {
		return reportHitRate;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Util.addBooleanOption(sb, NOADMIX, this.getNoAdmix());
		Util.addBooleanOption(sb, LINKAGE, this.getLinkage());
		Util.addBooleanOption(sb, USEPOPINFO, this.getUsePopInfo());
		Util.addBooleanOption(sb, LOCPRIOR, this.getLocPrior());
		Util.addBooleanOption(sb, FREQSCORR, this.getFreqsCorr());
		Util.addBooleanOption(sb, ONEFST, this.getOneFst());
		Util.addBooleanOption(sb, INFERALPHA, this.getInferAlpha());
		Util.addBooleanOption(sb, POPALPHAS, this.getPopAlphas());
		Util.addOption(sb, ALPHA, this.getAlpha());
		Util.addBooleanOption(sb, INFERLAMBDA, this.getInferLambda());
		Util.addBooleanOption(sb, POPSPECIFICLAMBDA, this.getPopSpecificLambda());
		Util.addOption(sb, LAMBDA, this.getLambda());
		Util.addOption(sb, FPRIORMEAN, this.getfPriorMean());
		Util.addOption(sb, FPRIORSD, this.getfPriorSd());
		Util.addBooleanOption(sb, UNIFPRIORALPHA, this.getUnifPriorAlpha());
		Util.addOption(sb, ALPHAMAX, this.getAlphaMax());
		Util.addOption(sb, ALPHAPRIORA, this.getAlphaPriorA());
		Util.addOption(sb, ALPHAPRIORB, this.getAlphaPriorB());
		Util.addOption(sb, LOG10RMIN, this.getLog10RMin());
		Util.addOption(sb, LOG10RMAX, this.getLog10RMax());
		Util.addOption(sb, LOG10RPROPSD, this.getLog10RPropSD());
		Util.addOption(sb, LOG10RSTART, this.getLog10RStart());
		Util.addOption(sb, GENSBACK, this.getGensBank());
		Util.addOption(sb, MIGRPRIOR, this.getMigrPrior());
		Util.addBooleanOption(sb, PFROMPOPFLAGONLY, this.getpFromPopFlagOnly());
		Util.addBooleanOption(sb, LOCISPOP, this.getLocisPop());
		Util.addOption(sb, LOCPRIORINIT, this.getLocPriorInit());
		Util.addOption(sb, MAXLOCPRIOR, this.getMaxLocPrior());
		Util.addBooleanOption(sb, PRINTNET, this.getPrintNet());
		Util.addBooleanOption(sb, PRINTLAMBDA, this.getPrintLambda());
		Util.addBooleanOption(sb, PRINTQSUM, this.getPrintQSum());
		Util.addBooleanOption(sb, SITEBYSITE, this.getSiteByte());
		Util.addBooleanOption(sb, PRINTQHAT, this.getPrintQHat());
		Util.addOption(sb, UPDATEFREQ, this.getUpdateFreq());
		Util.addBooleanOption(sb, PRINTLIKES, this.getPrintLikes());
		Util.addOption(sb, INTERMEDSAVE, this.getIntermedSave());
		Util.addBooleanOption(sb, ECHODATA, this.getEchoData());
		Util.addBooleanOption(sb, ANCESTDIST, this.getAncestDist());
		Util.addOption(sb, NUMBOXES, this.getNumBoxes());
		Util.addOption(sb, ANCESTPINT, this.getAncestPint());
		Util.addBooleanOption(sb, COMPUTEPROB, this.getComputerProb());
		Util.addOption(sb, ADMBURNIN, this.getAdmBurnIn());
		Util.addOption(sb, ALPHAPROPSD, this.getAlphaPropSd());
		Util.addBooleanOption(sb, STARTATPOPINFO, this.getStartAtPopInfo());
		Util.addBooleanOption(sb, RANDOMIZE, this.getRandomize());
		Util.addOption(sb, SEED, this.getSeed());
		Util.addOption(sb, METROFREQ, this.getMetroFreq());
		Util.addBooleanOption(sb, REPORTHITRATE, this.getReportHitRate());
		
		return sb.toString();
	}

}
