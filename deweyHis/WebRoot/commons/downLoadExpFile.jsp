<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.io.*,org.apache.log4j.Logger" %>
<%@ page import="java.io.FileInputStream"%>
<%
	
	try{
		String filename = request.getParameter("fileName");
		if(filename==null||filename.length()==0)
			filename =(String)request.getAttribute("fileName");
		System.out.println("filename="+filename);
		if(filename==null||filename.length()==0){
			filename="data.cvs.html.xls";
		} 
		InputStream inStream=(InputStream)request.getAttribute("contentStream");
		System.out.println("InputStream >>>" + inStream.toString());
		String sFileExp = "" ;
		//��������ĸ�ʽ
	  	response.reset();
		int iIndex = filename.lastIndexOf(".") ;
		if( iIndex != -1 ){
			sFileExp = filename.substring(iIndex+1) ;
		}
		response.addHeader("Extension",sFileExp);  //������չ��
		System.out.println("Extension = " + sFileExp);
	  	//response.addHeader("Content-Disposition","inline; filename=\"" + filename + "\"");   //ֱ�Ӵ�
	  	//��������Ի���
	  	response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(filename.getBytes(),"ISO-8859-1") + "\""); 
		response.setHeader("Accept-ranges", "bytes");
		response.setContentType("application/x-filler");
	 	//ѭ��ȡ�����е�����
	  	byte[] b = new byte[1024];
	  	int len;
	  	while((len=inStream.read(b)) !=-1) {
	  		response.getOutputStream().write(b,0,len);
	  	}
	  	inStream.close();
	 }catch(Exception e){
	  	response.setContentType("text/html;charset=GBK");
	  	%>
		�����ļ�ʧ�ܡ�	
	  	<%
	  	out.close();
  	 }
%>