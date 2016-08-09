/**
 * 
 */
package com.iam_vip.jsoup_all.torrent;

import java.io.IOException;

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
	public _meijutt() {
	}

	@Test
	public void run() throws Exception {

		String[] arr = { 
				"-----", 
				"-----" };

		for (String url : arr) {
			getBTLinks(url);
		}

	}

	protected void getBTLinks(String url) throws IOException {

		if (url == null || "".equals(url) || !url.startsWith("http://")) {
			return;
		}
		
		Document doc = super.doc(url);
		Element el = doc.getElementsByClass("down_list").get(0);
		el.getElementsByTag("input").forEach(e -> {
			System.out.println(e.attr("value"));
		});
		System.out.println();
		System.out.println();
		System.out.println();

	}

}
