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

import org.apache.commons.lang.StringUtils;

/**
 * Utility class for Structure plug-in.
 * 
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 0.1
 */
public class Util {

	private static final String TRUE = "true";
	private static final String FALSE = "false";
	private static final String TRUE_VALUE = "1";
	private static final String FALSE_VALUE = "0";

	private static final String SPACE = " ";
	private static final String NEWLINE = System.getProperty("line.separator");
	
	// Hide as tis' an utility class
	private Util() {}
	
	public static void addOption(StringBuilder sb, String key, String value) {
		if(StringUtils.isNotBlank(value)) {
			sb.append("#define" + SPACE + key + SPACE + value + NEWLINE);
		}
	}
	
	public static void addBooleanOption(StringBuilder sb, String key, String value) {
		if(StringUtils.isNotBlank(value)) {
			final String booleanValue = getBooleanValue(value);
			if(StringUtils.isNotBlank(booleanValue)) {
				sb.append("#define" + SPACE + key + SPACE + booleanValue + NEWLINE);
			}
		}
	}
	
	public static String getBooleanValue(String value) {
		if(StringUtils.isNotBlank(value)) {
			if(value.equals(TRUE)) {
				return TRUE_VALUE;
			} else if(value.equals(FALSE)) {
				return FALSE_VALUE;
			}
		}
		return null;
	}
	
}
