/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ballad.mibbrowser;

/**
 *
 * @author bkin
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MibBrowser {
	private String fileName;
    public MibBrowser (String f){
        fileName = f;
    }
    public void loadMib(){
    	try{
    		FileReader fr = new FileReader(new File("f"));
    		BufferedReader br = new BufferedReader(fr);
    		String str = br.readLine();
    		while (str != null) {
    			str.trim();
    			if (str.length()==0)
    				continue;
    			if (str.indexOf("--")==0)
    				continue;
    			if (str.indexOf("--")>0)
    				str = str.substring(0,str.length()-str.indexOf("--")-1);
    			str.trim();
    			
    			if (str.contains("DEFINITIONS ::=")){
    				String rootName = str.substring(0,str.indexOf("DEFINITIONS ::="));
    				
    			}
    			
    			
    			
    			
    			str = br.readLine();
    		};
    		
    		br.close();
    		fr.close(); 

    	}catch(Exception e){
    		
    	}
    }
    	

}
