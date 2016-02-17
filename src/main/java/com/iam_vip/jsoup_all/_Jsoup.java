/**
 * 
 */
package com.iam_vip.jsoup_all;

import java.io.IOException;
import java.util.Random;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author Colin
 */
public class _Jsoup implements IBrowserUserAgent {
	
	protected static final int TIMEOUT = 1000 * 60 * 1 * 1; // 1 minute
	
	
	/**
	 * 
	 */
	public _Jsoup() {}
	
	protected String getUserAgent() {
		
		int index = new Random().nextInt( ArrUserAgent.length );
		return ArrUserAgent[ index ];
	}
	
	protected Document doc( String url ) throws IOException {
		
		Connection connection = Jsoup.connect( url ).timeout( TIMEOUT ).header( "User-Agent", getUserAgent() );
		if ( connection.execute().statusCode() != 200 ) return null;
		return connection.get();
	}
	
}
