/**
 * 
 */
package com.iam_vip.jsoup_all.torrent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.iam_vip.jsoup_all._Jsoup;

/**
 * @author Colin
 */
public class AVTorrent extends _Jsoup {

	public interface OnFinishFetch {
		void fetch(Map<String, String> maps);
	}

	OnFinishFetch ofch = null;

	/**
	 * 
	 */
	public AVTorrent() {
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		AVTorrent instance = new AVTorrent();

		String url = "http://javtorrent.xyz/page/1/";
		instance.toHtml(url);

	}

	private Map<String, String> maps;

	public void toHtml(final String url) throws IOException {
		this.toHtml(url, null);
	}

	public void toHtml(final String url, OnFinishFetch ofch) throws IOException {

		if (url == null || "".equals(url) || !url.startsWith("http://")) {
			return;
		}

		this.ofch = ofch;

		Document doc = super.doc(url);
		Elements posts = doc.getElementsByClass("posts-default").get(0).children();

		maps = new HashMap<String, String>(posts.size() + 1);

		posts.forEach(ele -> {

			if (!ele.tagName().equals("li")) {
				return;
			}

			String to = ele.child(0).child(0).attr("src");
			String dl = ele.child(1).child(0).attr("href");

			maps.put(to.replace("_s.", "."), dl);
		});

		for (Map.Entry<String, String> item : maps.entrySet()) {
			final String k = item.getKey(), v = item.getValue();
			new Thread() {
				public void run() {
					try {
						getDL(k, v);
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();
		}

	}

	public void getDL(String key, String url) throws IOException {

		Document doc = super.doc(url);
		StringBuffer buf = new StringBuffer();

		doc.getElementsByClass("j-link").forEach(ele -> {
			if (ele.tagName().equals("a")) {
				buf.append(ele.attr("href"));
				return;
			}
		});



		String link = buf.toString();
		buf.setLength(0);

		if (link == null || "".equals(link))
			return;




		doc = super.doc(link);
		doc.getElementsByClass("j-link").forEach(ele -> {
			if (ele.tagName().equals("a")) {
				buf.append(ele.attr("href"));
				return;
			}
		});

		link = buf.toString();
		maps.put(key, link);
		calc();
	}

	private int finish = 0;

	private void calc() {
		finish++;

		if (finish == maps.size()) {
			if (this.ofch != null) {
				this.ofch.fetch(maps);
			}
			for (Map.Entry<String, String> item : maps.entrySet()) {
				String/* k = item.getKey(), */ v = item.getValue();
				System.out.println(/* k + " --- " + */v);
			}
		}
	}

}
