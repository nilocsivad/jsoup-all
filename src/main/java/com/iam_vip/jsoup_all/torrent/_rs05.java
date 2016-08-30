/**
 * 
 */
package com.iam_vip.jsoup_all.torrent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author Colin
 */
public class _rs05 extends __BT {

	/**
	 * 
	 */
	public _rs05() {
	}

	/*
	 * (non-Javadoc)
	 * @see com.iam_vip.jsoup_all.torrent.__BT#getBTLinks(java.lang.String)
	 */
	@Override
	public void getBTLinks(String url) throws IOException {

		Document doc = super.doc(url);
		Elements lis = doc.getElementsByClass("resourceslist").get(0).getElementsByTag("li");

		List<String> list = new ArrayList<>(8);
		lis.forEach(ele -> {
			if (!ele.children().isEmpty()) {
				//System.out.println(ele.getElementsByClass("fr").get(0).child(1).attr("href"));
				list.add(ele.getElementsByClass("fr").get(0).child(1).attr("href"));
			}
			else {
				//System.out.println(ele.html());
				list.add(ele.html());
			}
		});

		Collections.reverse(list);
		for (String href : list) {
			System.out.println(href);
		}

		
		
		
		System.out.format("\r\n\r\n\r\n\r\n");
		
		
		
		
		
		list.removeAll(list);
		list.clear();
		lis.forEach(ele -> {
			if (!ele.children().isEmpty()) {
				//System.out.println(ele.getElementsByClass("fr").get(0).child(0).attr("href"));
				list.add(ele.getElementsByClass("fr").get(0).child(0).attr("href"));
			}
			else {
				//System.out.println(ele.html());
				list.add(ele.html());
			}
		});

		Collections.reverse(list);
		for (String href : list) {
			System.out.println(href);
		}


	}

}
