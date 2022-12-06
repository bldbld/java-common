package org.ballad.javacommon.designpattern.flyweight.cdsample;

import java.util.Hashtable;
import java.util.Map;

/**
 * FlyWeight<br>
 * The Artist Info is stored in ArtistFactory.
 * 
 * @author Ballad
 * @date 2011-12-02
 */
public class ArtistFactory {
	private final Map<String, Artist> artistPool = new Hashtable<String, Artist>();

	public Artist getArtist(String key) {
		Artist result;
		result = artistPool.get(key);
		return result;
	}
}
