/**
 * 
 */
package com.iam_vip.jsoup_all.torrent;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @author Colin
 */
public class cn163 extends __BT {

	/**
	 * 
	 */
	public cn163() {
	}

	public void getBTLinks(String url) throws IOException {

		if (url == null || "".equals(url) || !url.startsWith("http://")) {
			return;
		}

		Document doc = super.doc(url);
		Element el = doc.getElementById("entry");
		el.getElementsByTag("ol").get(0).getElementsByTag("a").forEach(e -> {
			System.out.println(e.attr("href"));
		});

		System.out.println();
		System.out.println();
		System.out.println();

	}

}
