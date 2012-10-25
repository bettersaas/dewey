<%@ page contentType="text/html;charset=GB18030"   isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="message" value="${message}" scope="page"/>
<html>
<head>
	<title>Error Page</title>
	<script src="<c:url value="/scripts/prototype.js"/>" type="text/javascript"></script>
	<meta http-equiv="content-type" content="text/html;charset=gb2312">
	<script language="javascript">
		function showDetail() {
			var detailErrorMsg = document.getElementById('detail_error_msg');
			if (detailErrorMsg.style.display == "none") {
				detailErrorMsg.style.display = "";
			} else {
				detailErrorMsg.style.display = "none";
			}
		}
	</script>
</head>
<body>
<br/>
<br/>
<div id="content">
	<h3><c:out value="${message}<br>"  escapeXml="false"/></h3>
	<br>
	<h5><%=exception.getMessage() %></h5>
	<button onclick="history.back();">返回</button>
	<br>
	<p><a  href="#" onclick="showDetail();">Administrator click here to get the detail.</a></p>
	<div id="detail_error_msg" style="display:none">
		<pre><%  exception.printStackTrace(new java.io.PrintWriter(out));  %></pre>
	</div>
</div>
<p/>
<input type="button" name="goback" value="返回"  onClick="javascript:history.go(-1);">
</body>
</html>