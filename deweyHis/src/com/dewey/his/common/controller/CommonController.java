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
	 * 下载文件用
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
		// 获得文件名
		String fileName = request.getParameter("fileName");
		try {
			output = response.getOutputStream();
			if (fileName == null || fileName.length() == 0)
				fileName = (String) request.getAttribute("fileName");
			consoleLogger.debug("导出文件fileName=" + fileName);
			fileLogger.info("导出文件fileName=" + fileName);
			
			if (fileName == null || fileName.length() == 0) {
				fileName = "data.cvs.html.xls";
			}
			InputStream inStream = (InputStream) request.getAttribute("contentStream");
			String sFileExp = "";
			// 设置输出的格式
			response.reset();
			int iIndex = fileName.lastIndexOf(".");
			if (iIndex != -1) {
				sFileExp = fileName.substring(iIndex + 1);
			}
			 // 设置扩展名
			response.addHeader("Extension", sFileExp);
			consoleLogger.info("导出文件Extension = " + sFileExp);
			// 直接打开
			// response.addHeader("Content-Disposition","inline; filename=\"" +filename + "\""); 
			// 弹出保存对话框
			response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes(), "ISO-8859-1") + "\"");
			response.setHeader("Accept-ranges", "bytes");
			response.setContentType("application/x-filler");
			// 循环取出流中的数据
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
			out.print("下载文件失败。	");
			out.close();
		} finally {
			output.close();
		}
	}
}
