/**
 * 
 */
package com.iam_vip.jsoup_all.torrent;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
		Elements eles = el.getElementsByTag("input");
		
		for (int i = eles.size() - 1; i >= 0; --i) {
			System.out.println(eles.get(i).attr("value"));
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();

	}

}
