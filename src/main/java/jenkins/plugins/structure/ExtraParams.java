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
	private final Boolean noAdmix; // (B) Use no admixture model (0=admixture model, 1=no-admix)
	private final Boolean linkage; // (B) Use the linkage model model 
	private final Boolean usePopInfo; // (B) Use prior population information to pre-assign individuals to clusters
	private final Boolean locPrior; //(B)  Use location information to improve weak data
	private final Boolean freqsCorr; // (B) allele frequencies are correlated among pops
	private final Boolean oneFst; // (B) assume same value of Fst for all subpopulations.
	private final Boolean inferAlpha; // (B) Infer ALPHA (the admixture parameter)
	private final Boolean popAlphas; // (B) Individual alpha for each population
	private final Double alpha; // (d) Dirichlet parameter for degree of admixture (this is the initial value if INFERALPHA==1).
	private final Boolean inferLambda; // (B) Infer LAMBDA (the allele frequencies parameter)
	private final Boolean popSpecificLambda; //(B) infer a separate lambda for each pop (only if INFERLAMBDA=1).
	private final Double lambda; // (d) Dirichlet parameter for allele frequencies 

	// PRIORS
	private final Double fPriorMean; // (d) Prior mean and SD of Fst for pops.
	private final Double fPriorSd; // (d) The prior is a Gamma distribution with these parameters
	private final Boolean unifPriorAlpha; // (B) use a uniform prior for alpha; otherwise gamma prior
	private final Double alphaMax; // (d) max value of alpha if uniform prior
	private final Double alphaPriorA; // (only if UNIFPRIORALPHA==0): alpha has a gamma prior with mean A*B, and 
	private final Double alphaPriorB; // variance A*B^2. 
	private final Double log10RMin; //(d) Log10 of minimum allowed value of r under linkage model
	private final Double log10RMax; //(d) Log10 of maximum allowed value of r
	private final Double log10RPropSD; //(d) standard deviation of log r in update
	private final Double log10RStart; //(d) initial value of log10 r

	// USING PRIOR POPULATION INFO (USEPOPINFO)
	private final Long gensBank; //(int) For use when inferring whether an individual is an immigrant, or has an immigrant ancestor in the past GENSBACK generations.  eg, if GENSBACK==2, it tests for immigrant ancestry back to grandparents. 
	private final Double migrPrior; //(d) prior prob that an individual is a migrant (used only when USEPOPINFO==1).  This should be small, eg 0.01 or 0.1.
	private final Boolean pFromPopFlagOnly; // (B) only use individuals with POPFLAG=1 to update P. This is to enable use of a reference set of individuals for clustering additional "test" individuals.
	
	// LOCPRIOR MODEL FOR USING LOCATION INFORMATION
	private final Boolean locisPop; //(B) use POPDATA for location information 
	private final Double locPriorInit; //(d) initial value for r, the location prior
	private final Double maxLocPrior; //(d) max allowed value for r

	// OUTPUT OPTIONS
	private final Boolean printNet; // (B) Print the "net nucleotide distance" to screen during the run
	private final Boolean printLambda; // (B) Print current value(s) of lambda to screen
	private final Boolean printQSum; // (B) Print summary of current population membership to screen
	private final Boolean siteByte; // (B) whether or not to print site by site results. (Linkage model only) This is a large file!
	private final Boolean printQHat; // (B) Q-hat printed to a separate file.  Turn this on before using STRAT.
	private final Long updateFreq; // (int) frequency of printing update on the screen. Set automatically if this is 0.
	private final Boolean printLikes; // (B) print current likelihood to screen every rep
	private final Long intermedSave; // (int) number of saves to file during run
	private final Boolean echoData; // (B) Print some of data file to screen to check that the data entry is correct.
	
	// (NEXT 3 ARE FOR COLLECTING DISTRIBUTION OF Q:)
	private final Boolean ancestDist; // (B) collect data about the distribution of ancestry coefficients (Q) for each individual
	private final Long numBoxes; // (int) the distribution of Q values is stored as a histogram with this number of boxes. 
	private final Double ancestPint; // (d) the size of the displayed probability interval on Q (values between 0.0--1.0)

	// MISCELLANEOUS
	private final Boolean computerProb; // (B) Estimate the probability of the Data under the model.  This is used when choosing the best number of subpopulations.
	private final Long admBurnIn; // (int) [only relevant for linkage model]: Initial period of burnin with admixture model (see Readme)
	private final Double alphaPropSd; // (d) SD of proposal for updating alpha
	private final Boolean startAtPopInfo; // Use given populations as the initial condition for population origins. (Need POPDATA==1). It is assumed that the PopData in the input file are between 1 and k where k<=MAXPOPS.
	private final Boolean randomize; // (B) use new random seed for each run 
	private final Long seed; // (int) seed value for random number generator (must set RANDOMIZE=0) 
	private final Long metroFreq; // (int) Frequency of using Metropolis step to update Q under admixture model (ie use the metr. move every i steps).  If this is set to 0, it is never used. (Proposal for each q^(i) sampled from prior.  The goal is to improve mixing for small alpha.)
	private final Boolean reportHitRate; // (B) report hit rate if using METROFREQ

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
	public ExtraParams(Boolean noAdmix, 
			Boolean linkage, 
			Boolean usePopInfo,
			Boolean locPrior, 
			Boolean freqsCorr, 
			Boolean oneFst,
			Boolean inferAlpha, 
			Boolean popAlphas, 
			Double alpha,
			Boolean inferLambda, 
			Boolean popSpecificLambda, 
			Double lambda,
			Double fPriorMean, 
			Double fPriorSd, 
			Boolean unifPriorAlpha,
			Double alphaMax, 
			Double alphaPriorA, 
			Double alphaPriorB,
			Double log10rMin, 
			Double log10rMax, 
			Double log10rPropSD,
			Double log10rStart, 
			Long gensBank, 
			Double migrPrior,
			Boolean pFromPopFlagOnly, 
			Boolean locisPop, 
			Double locPriorInit,
			Double maxLocPrior, 
			Boolean printNet, 
			Boolean printLambda,
			Boolean printQSum, 
			Boolean siteByte, 
			Boolean printQHat,
			Long updateFreq, 
			Boolean printLikes, 
			Long intermedSave,
			Boolean echoData, 
			Boolean ancestDist, 
			Long numBoxes,
			Double ancestPint, 
			Boolean computerProb, 
			Long admBurnIn,
			Double alphaPropSd, 
			Boolean startAtPopInfo, 
			Boolean randomize,
			Long seed, 
			Long metroFreq, 
			Boolean reportHitRate) {
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
	public Double getLocPriorInit() {
		return locPriorInit;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Util.addOption(sb, NOADMIX, this.getNoAdmix());
		Util.addOption(sb, LINKAGE, this.getLinkage());
		Util.addOption(sb, USEPOPINFO, this.getUsePopInfo());
		Util.addOption(sb, LOCPRIOR, this.getLocPrior());
		Util.addOption(sb, FREQSCORR, this.getFreqsCorr());
		Util.addOption(sb, ONEFST, this.getOneFst());
		Util.addOption(sb, INFERALPHA, this.getInferAlpha());
		Util.addOption(sb, POPALPHAS, this.getPopAlphas());
		Util.addOption(sb, ALPHA, this.getAlpha());
		Util.addOption(sb, INFERLAMBDA, this.getInferLambda());
		Util.addOption(sb, POPSPECIFICLAMBDA, this.getPopSpecificLambda());
		Util.addOption(sb, LAMBDA, this.getLambda());
		Util.addOption(sb, FPRIORMEAN, this.getfPriorMean());
		Util.addOption(sb, FPRIORSD, this.getfPriorSd());
		Util.addOption(sb, UNIFPRIORALPHA, this.getUnifPriorAlpha());
		Util.addOption(sb, ALPHAMAX, this.getAlphaMax());
		Util.addOption(sb, ALPHAPRIORA, this.getAlphaPriorA());
		Util.addOption(sb, ALPHAPRIORB, this.getAlphaPriorB());
		Util.addOption(sb, LOG10RMIN, this.getLog10RMin());
		Util.addOption(sb, LOG10RMAX, this.getLog10RMax());
		Util.addOption(sb, LOG10RPROPSD, this.getLog10RPropSD());
		Util.addOption(sb, LOG10RSTART, this.getLog10RStart());
		Util.addOption(sb, GENSBACK, this.getGensBank());
		Util.addOption(sb, MIGRPRIOR, this.getMigrPrior());
		Util.addOption(sb, PFROMPOPFLAGONLY, this.getpFromPopFlagOnly());
		Util.addOption(sb, LOCISPOP, this.getLocisPop());
		Util.addOption(sb, LOCPRIORINIT, this.getLocPriorInit());
		Util.addOption(sb, MAXLOCPRIOR, this.getMaxLocPrior());
		Util.addOption(sb, PRINTNET, this.getPrintNet());
		Util.addOption(sb, PRINTLAMBDA, this.getPrintLambda());
		Util.addOption(sb, PRINTQSUM, this.getPrintQSum());
		Util.addOption(sb, SITEBYSITE, this.getSiteByte());
		Util.addOption(sb, PRINTQHAT, this.getPrintQHat());
		Util.addOption(sb, UPDATEFREQ, this.getUpdateFreq());
		Util.addOption(sb, PRINTLIKES, this.getPrintLikes());
		Util.addOption(sb, INTERMEDSAVE, this.getIntermedSave());
		Util.addOption(sb, ECHODATA, this.getEchoData());
		Util.addOption(sb, ANCESTDIST, this.getAncestDist());
		Util.addOption(sb, NUMBOXES, this.getNumBoxes());
		Util.addOption(sb, ANCESTPINT, this.getAncestPint());
		Util.addOption(sb, COMPUTEPROB, this.getComputerProb());
		Util.addOption(sb, ADMBURNIN, this.getAdmBurnIn());
		Util.addOption(sb, ALPHAPROPSD, this.getAlphaPropSd());
		Util.addOption(sb, STARTATPOPINFO, this.getStartAtPopInfo());
		Util.addOption(sb, RANDOMIZE, this.getRandomize());
		Util.addOption(sb, SEED, this.getSeed());
		Util.addOption(sb, METROFREQ, this.getMetroFreq());
		Util.addOption(sb, REPORTHITRATE, this.getReportHitRate());
		
		return sb.toString();
	}

}
