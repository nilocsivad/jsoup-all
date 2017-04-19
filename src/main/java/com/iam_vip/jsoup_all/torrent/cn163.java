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
		el.getElementsByTag("a").forEach(e -> {
			String link = e.attr("href");
			if (link.startsWith("ed2k") || link.startsWith("thunder"))
				System.out.println(link);
		});

		System.out.println();
		System.out.println();
		System.out.println();

	}

}
