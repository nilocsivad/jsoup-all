/**
 * 
 */
package com.iam_vip.jsoup_all.torrent;

import java.io.IOException;

import com.iam_vip.jsoup_all._Jsoup;

/**
 * @author Colin
 */
public abstract class __BT extends _Jsoup {

	/**
	 * 
	 */
	public __BT() {
	}

	public abstract void getBTLinks(String url) throws IOException;

}
