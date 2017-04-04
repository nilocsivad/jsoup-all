/**
 * 
 */
package com.iam_vip.jsoup_all.torrent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Colin
 */
public class BTFactory {

	private static final Map<String, Class<?>> MAP = new HashMap<String, Class<?>>(8);

	static {
		MAP.put("http://www.meijutt.com", _meijutt.class);
		MAP.put("http://www.ttmeiju.com", _ttmeiju.class);
		MAP.put("http://tv.rs05.com", _rs05.class);
		MAP.put("http://www.yyste.com", _yyste.class);
		MAP.put("http://www.xunleicang.com", _xunleicang.class);
		MAP.put("http://cn163.net", cn163.class);
	}

	/**
	 * 
	 */
	public BTFactory() {
	}

	public static String prefix;

	private static Class<?> getInstance(String url) {

		for (Map.Entry<String, Class<?>> itm : MAP.entrySet()) {
			if (url.startsWith(itm.getKey())) {
				prefix = itm.getKey();
				return itm.getValue();
			}
		}

		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		String[] array = {
				"",
				"",
				"",
				"",
				"",
				"",
				"" };

		// String url = "";
		for (String url : array) {

			if (url.equals(""))
				continue;

			Class<?> cls = getInstance(url);
			if (cls != null) {

				__BT instance = (__BT) cls.newInstance();
				instance.getBTLinks(url);

			}
			else {
				System.err.format("Can not find implements to '%s' \r\n", url);
			}

		}

	}

}
