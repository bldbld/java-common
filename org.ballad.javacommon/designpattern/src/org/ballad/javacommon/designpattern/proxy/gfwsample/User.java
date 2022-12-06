package org.ballad.javacommon.designpattern.proxy.gfwsample;

public class User {
	public static void main (String [] args){
		GFW gfw = new GFW (1,new WebSite ());
		gfw.shwoPage("twitter");
		
		GFW gfw2 = new GFW (0,new WebSite ());
		gfw2.shwoPage("twitter");
	}
}
