/**
 * 
 */
package com.iam_vip.jsoup_all.torrent;

import java.io.IOException;

import org.jsoup.nodes.Document;

/**
 * @author Colin
 */
public class _meijutt extends __BT {

	/**
	 * 
	 */
	public _meijutt() {
	}

	public void getBTLinks(String url) throws IOException {

		if (url == null || "".equals(url) || !url.startsWith("http://")) {
			return;
		}

		Document doc = super.doc(url);
		doc.getElementsByClass("down_list").forEach(el -> {

			el.getElementsByTag("input").forEach(e -> {
				System.out.println(e.attr("value"));
			});

			System.out.println();
			System.out.println();
			System.out.println();

		});

	}

}
