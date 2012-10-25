package common.util.zip;

import javax.servlet.http.HttpServletRequest;

public class GzipUtility {
	
	public static boolean isGzipEnabled(HttpServletRequest request) {
		String flag = request.getParameter("enabledGzip");
		return (flag != null) && (flag.equalsIgnoreCase("true"));
	}

//	public static PrintWriter getGzipWriter(HttpServletResponse response) throws IOException {
//		return new PrintWriter(new GZIPOutputStream(response.getOutputStream()));
//	}
	
	public static  boolean isGzipSupported(HttpServletRequest request) {
		String encodings = request.getHeader("Accept-Encoding");
		return (encodings != null) && (encodings.indexOf("gzip") != -1);
	}
}