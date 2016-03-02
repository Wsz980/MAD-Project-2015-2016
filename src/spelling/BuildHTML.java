package spelling;

import java.util.List;

public class BuildHTML {

	public static String getHtml(List<WordBean> wordBeanList) {
		String htmlStr = getHTMLHead();
		htmlStr = htmlStr + getScript_Checkall(wordBeanList);
		htmlStr = htmlStr + getScript(wordBeanList);
		htmlStr = htmlStr + getContent_Checkall();
		htmlStr = htmlStr + getContent(wordBeanList);
		// htmlStr = htmlStr + getcontent2(wordBeanList);
		htmlStr = htmlStr + getHTMLEnd();
		return htmlStr;
	}

	public static String getHTMLHead() {
		String htmlHeadStr = "<html><head>\n";

		// htmlHeadStr = htmlHeadStr +
		// "<script type=\"text/javascript\" src=\"js/jquery-1.4.2.js\"></script>";
		// htmlHeadStr = htmlHeadStr +
		// "<script type=\"text/javascript\">" +
		// "$(document).ready(function(){" +
		// "if( $(\"#show_word\").is(\":visible\")){" +
		// "$(\"#show_word\").click(function(){" +
		// "$(\"#show_wordAAA\").slideToggle(\"slow\");" +
		// "});" +
		// "}" +
		// "});" +
		// "</script>";
		
		htmlHeadStr = htmlHeadStr + "<style> \n";
		htmlHeadStr = htmlHeadStr + "body {\n" +
		      "background-color:lightblue; \n" +
		      "background-image:url('img/pencil.gif'); \n" +
		      "background-repeat:no-repeat; \n " +
		      "background-attachment:fixed; \n " +
		      "background-position:center; \n " +
		     "}" +
		"h1   {font-size:36pt;}" +
		"h2   {color:blue;}" +
		"p    {margin-left:50px;}" +
		"</style>";
		
		
		htmlHeadStr = htmlHeadStr + "</head><body bgcolor=\"#OOFFCC\"> <h6>2.6</h6> <center> <h1><i>Spelling<i></h1> <br> <i><h6>Wensen Zhang</h6></i> \n";

		
		return htmlHeadStr;
	}

	public static String getContent(List<WordBean> wordBeanList) {
		String s = new String();

		s = s + "<br><ol>\n";

		int ii = 1;

		for (WordBean wb : wordBeanList) {

			String mp3Url = "Non";
			if (wb.getMp3List().size() != 0 && wb.getMp3List() != null) {
				mp3Url = getHtmlEmbed(wb.getMp3List().get(0));
			}
		

			// htmlContent = htmlContent +
			// " <div id=\"show_word\">Show Word</div>";
			// htmlContent = htmlContent +
			// " <div id=\"show_wordAAA\"><a href=\"" + wb.getWordURL() +
			// "\" target=\"new\">" + wb.getWord() + "</a></div>\n";
			// htmlContent = htmlContent + "<p></p>\n";

			s = s
					+ "<FORM NAME=\"form" + ii + "\"> \n"
					+ "<li>" + mp3Url + "&nbsp;&nbsp;&nbsp;"
					+ " <a href=\"" + wb.getWordURL() + "\">Definition</a> <br>\n"
					+ "<INPUT type=\"text\" value=\"\" name=\"Answer\" size=25> \n"
					+ "<INPUT type=\"hidden\" value=\""
					+ wb.getWord()
					+ "\"  name=\"Word\" size=5> \n"
					+ "<input type=\"button\" value=\"Check\" name=\"Submit\" onClick=\"check"
					+ ii
					+ "()\"> <br> \n"
					+ "<INPUT type=\"text\" value=\"Input Word Then Click Submit Button \" name=\"Result\" size=35>  \n"
					+ " <br> \n"
					+ "<INPUT type=\"text\" value=\" \" name=\"ShowAnswer\" size=25>  \n"
					+ " <input type=\"button\" value=\"Show Answer\" name=\"Show\" onClick=\"show" + ii + "()\"> \n"
					+ "</FORM>";

			s = s + "\n";
			ii++;
		}

		s = s + "</ol> \n";

		return s;
	}

	public static String getContent_Checkall() {
		String s = "<FORM NAME=\"formall\"> \n"
				+ "<input type=\"button\" value=\"Check Test\" name=\"Check All\" onClick=\"checkall()\">  \n"
				+ " <input type=\"button\" value=\"See Answers\" name=\"Show\" onClick=\"showall()\"> \n"
				+ " <input type=\"button\" value=\"Restart\" name=\"Reset All\" onClick=\"resetall()\"> \n"
				+ "</FORM>";
		return s;
	}

	public static String getScript_Checkall(List<WordBean> wordBeanList) {

		int nword = wordBeanList.size();

		String s = "<script type=\"text/javascript\">\n";

		s = s + "function checkall(){\n";
		for (int ii = 0; ii < nword; ii++) {
			int ip = ii + 1;
			s = s + "check" + ip + "(); \n";
		}
		s = s + "} \n";

		s = s + "function showall(){\n";
		for (int ii = 0; ii < nword; ii++) {
			int ip = ii + 1;
			s = s + "show" + ip + "(); \n";
		}
		s = s + "} \n";

		s = s + "function resetall(){\n";
		for (int ii = 0; ii < nword; ii++) {
			int ip = ii + 1;
			s = s + "document.form" + ip + ".Answer.value = \"\"; \n";
			s = s + "document.form" + ip + ".Result.value = \"Input Word Then Click Submit Button \"; \n";
			s = s + "document.form" + ip + ".ShowAnswer.value = \"\"; \n";
		}
		s = s + "} \n";
		
		s = s + "</script>\n";

		return s;
	}

	public static String getScript(List<WordBean> wordBeanList) {
		String s = "<script type=\"text/javascript\">\n";

		int ii = 1;
		for (WordBean wb : wordBeanList) {

			s = s + "function check" + ii + "(){\n";

			s = s + "if (document.form" + ii + ".Word.value == document.form" + ii
					+ ".Answer.value){\n" + "document.form" + ii + ".Result.value = document.form"
        			+ ii + ".Word.value + \" is Correct!\"; \n" + "}else{ \n" + " document.form"
					+ ii + ".Result.value = document.form" + ii
					+ ".Answer.value + \" is Incorrect!\"; \n" + "} \n" + "} \n" +

					" function show" + ii + "(){ \n" + "document.form" + ii
					+ ".ShowAnswer.value = document.form" + ii
					+ ".Word.value; \n" + "} \n";

			ii++;

		}
		s = s + "</script>\n";
		return s;
	}

	public static String getcontent2(List<WordBean> wordBeanList) {
		String htmlContent = new String();
		htmlContent = htmlContent + "<br>\n";
		htmlContent = htmlContent + "<hr>\n";
		htmlContent = htmlContent + "<p></p>\n";
		for (int i = 0; i < 20; i++) {
			htmlContent = htmlContent + ".<br>\n";
		}
		int ii = 0;

		htmlContent = htmlContent + "<ul><ol>\n";

		for (WordBean wb : wordBeanList) {

			String mp3Url = "Non";
			if (wb.getMp3List().size() != 0 && wb.getMp3List() != null) {
				mp3Url = getHtmlEmbed(wb.getMp3List().get(0));
			}
			htmlContent = htmlContent + "<li>" + mp3Url;
			htmlContent = htmlContent + " <a href=\"" + wb.getWordURL() + "\" target=\"new\">"
					+ wb.getWord() + "</a>\n";
			// htmlContent = htmlContent + "<p></p>\n";
			ii++;
		}

		htmlContent = htmlContent + "</ol></ul>\n";

		return htmlContent;
	}

	public static String getHtmlEmbed(String mp3Url) {
		String htmlEmbed = "<span><embed type=\"application/x-shockwave-flash\" src=\"http://static.sfdict.com/dictstatic/d/g/speaker.swf\" id=\"speaker\" quality=\"high\" loop=\"false\" menu=\"false\" salign=\"t\" allowscriptaccess=\"sameDomain\" wmode=\"transparent\" flashvars=\"soundUrl="
				+ mp3Url + "\"" + " align=\"texttop\" height=\"15\" width=\"17\"></span>";
		// <embed type="application/x-shockwave-flash"
		// src="http://static.sfdict.com/dictstatic/d/g/speaker.swf"
		// id="speaker" quality="high" loop="false" menu="false" salign="t"
		// allowscriptaccess="sameDomain" wmode="transparent"
		// flashvars="soundUrl=http://static.sfdict.com/dictstatic/dictionary/audio/luna/E03/E0398500.mp3"
		// align="texttop" height="15" width="17"></span>
		return htmlEmbed;
	}

	public static String getHTMLEnd() {
		String htmlEndStr = " </center> </body>\n";
		htmlEndStr = htmlEndStr + "</html>\n";
		return htmlEndStr;
	}
}
