/**
 * 
 */
package com.iam_vip.jsoup_all.link;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import com.iam_vip.jsoup_all._Jsoup;


/**
 * @author Colin
 */
public class _meijutt extends _Jsoup {
	
	/**
	 * 
	 */
	public _meijutt() {}
	
	@Test
	public void run() throws Exception {
		
		String url = "";
		
		getBTLinks( url );
		
	}
	
	protected List< String > getBTLinks( String url ) throws IOException {
		
		List< String > links = new ArrayList< >( 8 );
		
		Document doc = super.doc( url );
		Element el = doc.getElementsByClass( "downurl" ).get( 0 );
		Element sc = el.getElementsByTag( "script" ).get( 1 );
		
		String html = sc.html();
		String[] $s = html.split( "\\$" );
		for ( String str : $s ) {
			if ( str.startsWith( "thunder" ) || str.startsWith( "ed2k" ) ) System.out.println( str );
		}
		
		return links;
	}
	
}
