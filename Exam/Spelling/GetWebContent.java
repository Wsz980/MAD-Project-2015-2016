/**
 * version 1.00 1999-08-27
 * author Cay Horstmann
 */

package spelling;

import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import util.WebConnectionUtil;

public class GetWebContent {

	public GetWebContent() {

	}

	public static String getMp3URLString(String urlStr) {
		List<String> mp3UrlList = getMp3URLList(urlStr);
		
		String mp3URLString = null;
		if(mp3UrlList != null || mp3UrlList.size() != 0 ) mp3UrlList.get(0);
		return mp3URLString;
	}
	
	public static List<String> getMp3URLList(String urlStr) {
		
		List<String> mp3UrlList = new ArrayList<String>();
		
		String webContentStr = getWebContent(urlStr, null, null);
		List<String> listStr = new ArrayList<String>();
		// String[] sArr = webContentStr.split("\n\\s+");
		String[] sArr = webContentStr.split("\n");

		String mp3Str = "audio";
		for (int ii = 0; ii < sArr.length; ii++) {
			if (sArr[ii].length() > 100) {
				String subString = sArr[ii].substring(0, 6);
				if (subString.equals(mp3Str))
					System.out.println("000" + sArr[ii]);

				char[] cccArr = sArr[ii].toCharArray();

				for (int ic = 0; ic < cccArr.length; ic++) {
					if (cccArr[ic] == 'a' && cccArr[ic + 1] == 'u' && cccArr[ic + 2] == 'd'
							&& cccArr[ic + 3] == 'i' && cccArr[ic + 4] == 'o'
							&& cccArr[ic + 5] == '=') {
						
						String[] s02Arr = sArr[ii].split("\\s");
						
						for (int jj = 0; jj < s02Arr.length; jj++) {
							if (s02Arr[jj].length() > 20) {
								char[] c02Arr = s02Arr[jj].toCharArray();
								//for (int ic02 = 0; ic02 < c02Arr.length; ic02++) {
								int ic02 = 0;
									if (c02Arr[ic02] == 'a' && c02Arr[ic02 + 1] == 'u'
											&& c02Arr[ic02 + 2] == 'd' && c02Arr[ic02 + 3] == 'i'
											&& c02Arr[ic02 + 4] == 'o' && c02Arr[ic02 + 5] == '=') {
										//System.out.println("!!!!!!!!!!" + s02Arr[jj]);
										mp3Str = s02Arr[jj].substring(7, s02Arr[jj].length()-1);
										System.out.println("mp3 URL: " + mp3Str);
										mp3UrlList.add(mp3Str);
									}
								//}
							}
						}
						
					}
				}
			}
		}

		return mp3UrlList;
	}

	private static String getWebContent(String urlStr, String username, String password) {

		WebConnectionUtil webConnectionUtil = new WebConnectionUtil();
		URLConnection connection = webConnectionUtil.getConnect(urlStr, username, password);

		// String headerStr = webConnectionUtil.getWebHeader(connection);
		String webContentStr = webConnectionUtil.getContent(connection);

		// String outputStr = headerStr + webContentStr;

		// String webSiteStr = webConnectionUtil.getWebSiteStr();

		// System.out.println(webContentStr);

		return webContentStr;
	}

}
