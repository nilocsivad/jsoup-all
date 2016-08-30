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
public class _yyste extends __BT {

	/**
	 * 
	 */
	public _yyste() {
	}

	/*
	 * (non-Javadoc)
	 * @see com.iam_vip.jsoup_all.torrent.__BT#getBTLinks(java.lang.String)
	 */
	@Override
	public void getBTLinks(String url) throws IOException {

		Document doc = super.doc(url);
		Elements tbs = doc.getElementsByClass("table");

		List<String> list = new ArrayList<>(8);
		tbs.forEach(ele -> {
			ele.getElementsByClass("span3").forEach(e -> {
				list.add(e.getElementsByTag("a").get(1).attr("href"));
			});
		});

		Collections.reverse(list);
		for (String href : list) {
			System.out.println(href);
		}

	}

}
