package com.iam_vip.jsoup_all;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.junit.Test;

/**
 * Hello world!
 */
public class JsoupShowUrlHtml {
	
	/**
	 * 
	 */
	public JsoupShowUrlHtml() {}
	
	@Test
	public void run() throws Exception {
		
		System.out.println( "Hello World! -------------------------" );
		
		this.getUrlHtml( "" );
	}
	
	public String getUrlHtml( String url ) throws IOException {
		
		String htm = Jsoup.connect( url ).timeout( 1000 * 60 * 3 ).get().html();
		System.out.println( htm );
		return htm;
	}
	
}
