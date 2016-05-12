/**
 * 
 */
package com.iam_vip.jsoup_all.link;

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

		String url = "";

		getBTLinks(url);

	}

	protected void getBTLinks(String url) throws IOException {

		Document doc = super.doc(url);
		Element el = doc.getElementsByClass("down_list").get(0);
		el.getElementsByTag("input").forEach(e -> {
			System.out.println(e.attr("value"));
		});
	}

}
