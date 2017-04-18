/**
 * 
 */
package com.iam_vip.jsoup_all.torrent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author Colin
 */
public class _qitete extends __BT {

	/**
	 * 
	 */
	public _qitete() {
	}

	@Override
	public void getBTLinks(String url) throws IOException {

		Document doc = super.doc(url);
		Elements tbs = doc.getElementsByClass("down_list").get(0).getElementsByTag("li");

		List<String> list = new ArrayList<>();

		tbs.forEach(ele -> {
			String value = ele.getElementsByClass("down_url").get(0).attr("value").replace("I0JleW9uZCMj", "");
			String txt = ele.getElementsByClass("down_part_name").get(0).text();
			System.out.println(txt + "  " + value);
			list.add(value);
		});

		for (String href : list) {
			System.out.println(href);
		}

	}

}
