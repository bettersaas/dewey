package common.servlet.wrapper;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * 可重用响应封装包
 * @author Administrator
 *
 */
public class CharArrayWrapper extends HttpServletResponseWrapper {
	
	private CharArrayWriter charWriter;
	
	public CharArrayWrapper(HttpServletResponse response) {
		super(response);
		charWriter = new CharArrayWriter();
	}
	
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return super.getOutputStream();
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		//return super.getWriter();
		return new PrintWriter(charWriter);
	}
	
	public char[] toCharArray() {
		return(charWriter.toCharArray());
	}
	
	public String toString() {
		return charWriter.toString();
	}

}
