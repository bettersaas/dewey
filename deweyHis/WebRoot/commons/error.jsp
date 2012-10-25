<%@ page contentType="text/html;charset=GBK"   isErrorPage="true" %>
<%@ page import="org.apache.commons.logging.LogFactory" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Error Page</title>
	<script src="<c:url value="/scripts/prototype.js"/>" type="text/javascript"></script>
	<meta http-equiv="content-type" content="text/html;charset=gb2312">
	<script language="javascript">
		function showDetail()
		{
			document.getElementById('detail_error_msg').style.display = "";
		}
	</script>
</head>

<body>

<% 
try {
    //  异常页面从request.getAttribute("Exception")取得Exception对象
	// The Servlet spec guarantees this attribute will be available  
	Throwable exception1 = (Throwable) request.getAttribute("javax.servlet.error.exception"); 

	if (exception1 != null) {
		if (exception1 instanceof ServletException) {
			// It's a ServletException: we should extract the root cause
			ServletException sex = (ServletException) exception1;
			Throwable rootCause = sex.getRootCause();
			if (rootCause == null)
				rootCause = sex;
			out.println("** Root cause is: "+ rootCause.getMessage());
			rootCause.printStackTrace(new java.io.PrintWriter(out)); 
		}
		else {
			// It's not a ServletException, so we'll just show it
			exception1.printStackTrace(new java.io.PrintWriter(out)); 
		}
	} 
	else  {
    	out.println("No error information available");
	} 

	// Display cookies
	out.println("\nCookies:\n");
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
    	for (int i = 0; i < cookies.length; i++) {
      		out.println(cookies[i].getName() + "=[" + cookies[i].getValue() + "]");
		}
	}
	    
} catch (Exception ex) { 
	ex.printStackTrace(new java.io.PrintWriter(out));
}
%>

<p/>
<br/>
<br/>

<div id="content">
	<%
		// Exception from JSP didn't log yet ,should log it here.
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		LogFactory.getLog(requestUri).error(exception.getMessage(), exception);
	%>

	<h3>System Runtime Error: <br><%=exception.getMessage()%>
	</h3>
	<br>

	<button onclick="history.back();">Back</button>
	<br>

	<p><a href="#" onclick="showDetail();">Administrator click here to get the detail.</a></p>

	<div id="detail_error_msg" style="display:none">
		<pre><%exception.printStackTrace(new java.io.PrintWriter(out)); %></pre>
	</div>
</div>

<h2/>Internal error</h2>
<p/>
<input type="button" name="goback" value="返回"  onClick="javascript:history.go(-1);">

</body>
</html>