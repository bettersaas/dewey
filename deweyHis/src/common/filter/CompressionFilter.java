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
 * ѹ��
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
		
		// �����֧��ѹ�����ƶ�ѹ��
		if (GzipUtility.isGzipSupported(request) && (GzipUtility.isGzipEnabled(request))) {
			// ֧��ѹ��
			// ��֪�ͻ������������Ҫ��ѹ����ʾ
			response.setHeader("Content-Encoding", "gzip");
			// ��װ��Ӧ
			CharArrayWrapper responseWrapper = new CharArrayWrapper(response);
			arg2.doFilter(request, responseWrapper);
			char[]  responseChars = responseWrapper.toCharArray();
			double zipBeforeLength = responseChars.length;
			System.out.println("ѹ����ʼ... ѹ��ǰ�ֽ���:" + zipBeforeLength);
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			GZIPOutputStream zipOut = new GZIPOutputStream(byteStream);
			OutputStreamWriter tempOut =  new OutputStreamWriter(zipOut);
			tempOut.write(responseChars);
			tempOut.close();
			int zipAfterLength = byteStream.size();
			response.setContentLength(zipAfterLength);
			OutputStream realOut = response.getOutputStream();
			byteStream.writeTo(realOut);
			System.out.println("ѹ������...ѹ�����ֽ���:" + zipAfterLength + "    ѹ���ʣ�" + zipAfterLength/zipBeforeLength);
		} else {
			System.out.println("�������֧��ѹ������û���ƶ�ѹ��");
			arg2.doFilter(request, response);
		}
	}
	
	public void destroy() {
		
	}
}