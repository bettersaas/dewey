package common.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.servlet.wrapper.CharArrayWrapper;
import common.util.zip.GzipUtility;

/**
 * 压缩
 * 
 * @author Administrator
 * 
 */
public class CompressionFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		// 浏览器支持压缩且制定压缩
		if (GzipUtility.isGzipSupported(request) && (GzipUtility.isGzipEnabled(request))) {
			// 支持压缩
			// 告知客户端浏览器，需要解压后显示
			response.setHeader("Content-Encoding", "gzip");
			// 包装响应
			CharArrayWrapper responseWrapper = new CharArrayWrapper(response);
			arg2.doFilter(request, responseWrapper);
			char[]  responseChars = responseWrapper.toCharArray();
			double zipBeforeLength = responseChars.length;
			System.out.println("压缩开始... 压缩前字节数:" + zipBeforeLength);
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			GZIPOutputStream zipOut = new GZIPOutputStream(byteStream);
			OutputStreamWriter tempOut =  new OutputStreamWriter(zipOut);
			tempOut.write(responseChars);
			tempOut.close();
			int zipAfterLength = byteStream.size();
			response.setContentLength(zipAfterLength);
			OutputStream realOut = response.getOutputStream();
			byteStream.writeTo(realOut);
			System.out.println("压缩结束...压缩后字节数:" + zipAfterLength + "    压缩率：" + zipAfterLength/zipBeforeLength);
		} else {
			System.out.println("浏览器不支持压缩或者没有制定压缩");
			arg2.doFilter(request, response);
		}
	}
	
	public void destroy() {
		
	}
}