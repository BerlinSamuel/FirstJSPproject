package com.chainsys.jspproject.commonutil;
public class ExceptionManager {
	public static String handleException(Exception err,String source,String message) {
		LogManager.logException(err,source,message);
		message +="Message: "+err.getMessage();
		String errorPage=HTMLHelper.getHTMLTemplate("Error", message);
		return errorPage;
	}
}