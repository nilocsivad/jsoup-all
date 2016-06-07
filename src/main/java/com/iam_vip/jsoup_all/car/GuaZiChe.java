/**
 * 
 */
package com.iam_vip.jsoup_all.car;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.iam_vip.jsoup_all._Jsoup;

/**
 * @author Colin
 *
 */
public class GuaZiChe extends _Jsoup {

	/**
	 * 
	 */
	public GuaZiChe() {
	}

	@Test
	public void run() throws Exception {

		// 搜索条件的URL
		Document doc = super.doc("http://www.guazi.com/zz/byd/p3n1i2j2v3/");
		Elements elements = doc.getElementsByClass("o-b-list").get(0).getElementsByTag("a");

		elements.forEach(element -> {
			try {
				String url = "http://www.guazi.com" + element.attr("href");
				System.out.println(url);
				Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe " + url);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		});

	}

}
