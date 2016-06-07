/**
 * 
 */
package com.iam_vip.jsoup_all.torrent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.iam_vip.jsoup_all._Jsoup;

/**
 * @author Colin
 */
public class _ttmeiju extends _Jsoup {
	
	/**
	 * 
	 */
	public _ttmeiju() {}
	
	@Test
	public void run() throws Exception {
		
		String url = "";
		
		List< String > pages = getPageLinks( url );
		// for ( String page : pages )
		// System.out.println( page );
		
		this.getBTLinks( pages );
		
	}
	
	protected List< List< String > > getBTLinks( List< String > pages ) throws IOException {
		
		List< List< String > > r = new ArrayList< >( 8 );
		
		for ( String url : pages ) {
			
			List< String > links = new ArrayList< >( 8 );
			System.out.println( url );
			System.out.println( "-----------------------------------------" );
			
			Document doc = super.doc( url );
			Elements eles = doc.getElementsByClass( "Scontent" );
			
			for ( Element ele : eles ) {
				
				Elements doms = ele.child( 2 ).getElementsByTag( "a" );
				if ( doms.size() > 0 ) {
					
					for ( Element et : doms ) {
						
						String href = et.attr( "href" );
						if ( href.startsWith( "magnet:" ) ) {
							links.add( et.attr( "href" ) );
							break;
						}
					}
				}
			}
			
			for ( String list : links ) {
				System.out.println( list );
			}
			
			System.out.println( "-----------------------------------------" );
			r.add( links );
		}
		
		return r;
	}
	
	/**
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	protected List< String > getPageLinks( String url ) throws IOException {
		
		List< String > pages = new ArrayList< >( 12 );
		pages.add( url );
		
		Document doc = super.doc( url );
		Elements links = doc.getElementsByClass( "pages" ).get( 0 ).child( 0 ).getElementsByTag( "a" );
		
		String base = url.split( "\\?" )[ 0 ];
		
		for ( Element ele : links ) {
			if ( ele.hasClass( "next" ) || ele.hasClass( "prev" ) ) continue;
			pages.add( base + ele.attr( "href" ) );
		}
		
		return pages;
	}
	
}
