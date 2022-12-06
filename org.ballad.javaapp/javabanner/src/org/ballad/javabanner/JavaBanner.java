/*
 * @(#)JavaBanner.java	1.0 2012/05/06
 *
 * Copyright 2012 BalladDev. All rights reserved.
 */

package org.ballad.javabanner;

/**
 * Java Banner.
 * 
 * <P>
 * Using the command "banner" is funny when I use the UNIX system, also I can
 * get banner installed in Linux.
 * </P>
 * 
 * <p>
 * Now, let it running in Java.
 * </p>
 * 
 * <p>
 * Thanks to Kenneth J. Pronovici <pronovic@ieee.org>, I copied some codes from
 * his ANSI C source code, and do some changes for Java Language.
 * </p>
 * 
 * @author ballad <ballad.dev@gmail.com>
 * @version 2012/05/16 1.0 initial
 */
public class JavaBanner {

	/**
	 * You can call this function to print the banner String, it uses the java
	 * default function <code>System.out.println()</code>¡£
	 * 
	 * @param str
	 */
	public static void banner(String str) {
		String[] banner = processBanner(str);
		for (int i = 0; i < banner.length; i++) {
			System.out.println(banner[i]);
		}
	}

	/**
	 * You can call this function to get the banner String array.
	 * 
	 * @param str
	 */
	public static String[] getBannerArray(String str) {
		return processBanner(str);
	}

	/**
	 * The main process of <code>JavaBanner</code>.
	 * 
	 * @param str
	 */
	private static String[] processBanner(String str) {
		String[] banner = { "", "", "", "", "", "", "" };
		String[] bannerLetter = null;
		char[] sarray = str.toUpperCase().toCharArray();
		for (int i = 0; i < sarray.length; i++) {
			bannerLetter = getLetterFromChar(sarray[i]);
			if (bannerLetter != null) {
				for (int j = 0; j < banner.length; j++) {
					banner[j] += (" " + bannerLetter[j]);
				}
			}
		}
		return banner;
	}

	/**
	 * Get the String array if the character is supported by
	 * <code>JavaBanner</code>.
	 * 
	 * @see Letter
	 * @param c
	 * @return String array if the character is supported.
	 */
	private static String[] getLetterFromChar(char c) {
		String[] retString = null;
		switch (c) {
		case 'A':
			retString = Letter.char_a;
			break;
		case 'B':
			retString = Letter.char_b;
			break;
		case 'C':
			retString = Letter.char_c;
			break;
		case 'D':
			retString = Letter.char_d;
			break;
		case 'E':
			retString = Letter.char_e;
			break;
		case 'F':
			retString = Letter.char_f;
			break;
		case 'G':
			retString = Letter.char_g;
			break;
		case 'H':
			retString = Letter.char_h;
			break;
		case 'I':
			retString = Letter.char_i;
			break;
		case 'J':
			retString = Letter.char_j;
			break;
		case 'K':
			retString = Letter.char_k;
			break;
		case 'L':
			retString = Letter.char_l;
			break;
		case 'M':
			retString = Letter.char_m;
			break;
		case 'N':
			retString = Letter.char_n;
			break;
		case 'O':
			retString = Letter.char_o;
			break;
		case 'P':
			retString = Letter.char_p;
			break;
		case 'Q':
			retString = Letter.char_q;
			break;
		case 'R':
			retString = Letter.char_r;
			break;
		case 'S':
			retString = Letter.char_s;
			break;
		case 'T':
			retString = Letter.char_t;
			break;
		case 'U':
			retString = Letter.char_u;
			break;
		case 'V':
			retString = Letter.char_v;
			break;
		case 'W':
			retString = Letter.char_w;
			break;
		case 'X':
			retString = Letter.char_x;
			break;
		case 'Y':
			retString = Letter.char_y;
			break;
		case 'Z':
			retString = Letter.char_z;
			break;
		case '0':
			retString = Letter.char_0;
			break;
		case '1':
			retString = Letter.char_1;
			break;
		case '2':
			retString = Letter.char_2;
			break;
		case '3':
			retString = Letter.char_3;
			break;
		case '4':
			retString = Letter.char_4;
			break;
		case '5':
			retString = Letter.char_5;
			break;
		case '6':
			retString = Letter.char_6;
			break;
		case '7':
			retString = Letter.char_7;
			break;
		case '8':
			retString = Letter.char_8;
			break;
		case '9':
			retString = Letter.char_9;
			break;
		case '#':
			retString = Letter.char_hash;
			break;
		case '~':
			retString = Letter.char_tild;
			break;
		case '!':
			retString = Letter.char_excl;
			break;
		case '@':
			retString = Letter.char_atsg;
			break;
		case '$':
			retString = Letter.char_dolr;
			break;
		case '%':
			retString = Letter.char_prct;
			break;
		case '^':
			retString = Letter.char_crrt;
			break;
		case '&':
			retString = Letter.char_ampr;
			break;
		case '*':
			retString = Letter.char_star;
			break;
		case ')':
			retString = Letter.char_rpar;
			break;
		case '(':
			retString = Letter.char_lpar;
			break;
		case '_':
			retString = Letter.char_undr;
			break;
		case '+':
			retString = Letter.char_plus;
			break;
		case '=':
			retString = Letter.char_equl;
			break;
		case '}':
			retString = Letter.char_rbrc;
			break;
		case '{':
			retString = Letter.char_lbrc;
			break;
		case ']':
			retString = Letter.char_rbrk;
			break;
		case '[':
			retString = Letter.char_lbrk;
			break;
		case '|':
			retString = Letter.char_pipe;
			break;
		case '\\':
			retString = Letter.char_lsls;
			break;
		case ':':
			retString = Letter.char_coln;
			break;
		case ';':
			retString = Letter.char_scln;
			break;
		case '\"':
			retString = Letter.char_quot;
			break;
		case '\'':
			retString = Letter.char_squt;
			break;
		case '`':
			retString = Letter.char_btck;
			break;
		case '>':
			retString = Letter.char_rarw;
			break;
		case '<':
			retString = Letter.char_larw;
			break;
		case '.':
			retString = Letter.char_perd;
			break;
		case ',':
			retString = Letter.char_coma;
			break;
		case '?':
			retString = Letter.char_ques;
			break;
		case '/':
			retString = Letter.char_rsls;
			break;
		case '-':
			retString = Letter.char_dash;
			break;
		case ' ':
			retString = Letter.char_spac;
			break;
		default:
			;
		}
		return retString;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JavaBanner.banner("Hello Banner!");
	}
}
