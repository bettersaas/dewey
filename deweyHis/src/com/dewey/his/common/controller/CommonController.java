package com.dewey.his.common.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.base.controller.BaseController;

@Controller
public class CommonController extends BaseController<Object, Long>{

	/**
	 * �����ļ���
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/downloadExpFile")
	public void downloadExpFile(HttpServletRequest request, HttpServletResponse response) throws IOException{
		OutputStream output = null;
		// ����ļ���
		String fileName = request.getParameter("fileName");
		try {
			output = response.getOutputStream();
			if (fileName == null || fileName.length() == 0)
				fileName = (String) request.getAttribute("fileName");
			consoleLogger.debug("�����ļ�fileName=" + fileName);
			fileLogger.info("�����ļ�fileName=" + fileName);
			
			if (fileName == null || fileName.length() == 0) {
				fileName = "data.cvs.html.xls";
			}
			InputStream inStream = (InputStream) request.getAttribute("contentStream");
			String sFileExp = "";
			// ��������ĸ�ʽ
			response.reset();
			int iIndex = fileName.lastIndexOf(".");
			if (iIndex != -1) {
				sFileExp = fileName.substring(iIndex + 1);
			}
			 // ������չ��
			response.addHeader("Extension", sFileExp);
			consoleLogger.info("�����ļ�Extension = " + sFileExp);
			// ֱ�Ӵ�
			// response.addHeader("Content-Disposition","inline; filename=\"" +filename + "\""); 
			// ��������Ի���
			response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes(), "ISO-8859-1") + "\"");
			response.setHeader("Accept-ranges", "bytes");
			response.setContentType("application/x-filler");
			// ѭ��ȡ�����е�����
			byte[] b = new byte[1024];
			int len;
			while ((len = inStream.read(b)) != -1) {
				output.write(b, 0, len);
			}
			inStream.close();
			output.flush();
		} catch (Exception e) {
			response.setContentType("text/html;charset=GBK");
			PrintWriter out = response.getWriter();
			out.print("�����ļ�ʧ�ܡ�	");
			out.close();
		} finally {
			output.close();
		}
	}
}
