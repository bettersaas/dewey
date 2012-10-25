<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ page import="java.util.Enumeration" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
//			<c:import url="/commons/pager1.jsp" charEncoding="GBK">
//				<c:param name="submitAction" 	value="action.do"/>
//				<c:param name="pageCount"    	value="12"/>
//			</c:import>
//			使用说明：
//				submitAction		必须参数	页面提交action值
//				countAll             必须参数	  记录总数
//				pageCount 		必须参数  记录总页数，查询得出
//				checkboxName	可选参数	全选\全不选\反选按钮的操作对象名（即复选框名）
%>
<style type="text/css">
<!--
.style1 {font-size: 14px}
-->
</style>
<form name="pagerForm1" method="post" action="">
	<%
		Enumeration enum1=request.getParameterNames();
		while(enum1.hasMoreElements())
		{
			String parameterName=(String)enum1.nextElement();
			if(!parameterName.equals("pageNo2") && !parameterName.equals("pageCount"))
				out.println("<input type=\"hidden\" name=\""+parameterName+"\" id=\""+parameterName+"\" value=\""+request.getParameter(parameterName)+"\">");
		}
	%>
	<input type="hidden" name="pageCount" value="${param.pageCount}">
<table id="pagerTable" align="center" width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tbody>
	<tr height="35px">
		<td id="td1" align="center" valign="middle">
			<% 
				String checkboxName		=	request.getParameter("checkboxName");
			%>
			<script language="javascript">checkboxName="<%=checkboxName %>" ;</script>
			<%
					if(checkboxName!=null && !"".equals(checkboxName.trim()) )
					{
			 %>
			<script language="javascript">
				var ids = eval("document.getElementsByName('"+checkboxName+"')");
				if(ids!=undefined)
				{
					document.write("『<a href='javascript:setChecked()'>全选</a>』『<a href='javascript:setUnChecked()'>全不选</a>』『<a href='javascript:setReverse()'>反选</a>』&nbsp;&nbsp;&nbsp;&nbsp;");
				}
				function setChecked()
				{ 
					var targetLength=ids.length;
					if(isNaN(parseInt(targetLength)))
						{
							if(eval("document.getElementsByName('"+checkboxName+"').disabled == false"))
							{
								eval("document.getElementsByName('"+checkboxName+"').checked=true;");
							}
						}
					else
						{
							for(var i=0;i<targetLength;i++)
							{
								if(eval("document.getElementsByName('"+checkboxName+"')[i].disabled == false"))
								{
								   eval("document.getElementsByName('"+checkboxName+"')[i].checked=true;");
								}
						    }
						}
					
				}
				function setUnChecked()
				{
					var targetLength=ids.length;
					if(isNaN(parseInt(targetLength)))
					{
							eval("document.getElementsByName('"+checkboxName+"').checked=false;");
					}
					else
					{
						for(var i=0;i<targetLength;i++)
							eval("document.getElementsByName('"+checkboxName+"')[i].checked=false;");
					}
				}
				function setReverse()
				{
						var targetLength=ids.length;
						if(isNaN(parseInt(targetLength)))
						{
							var temp=eval("document.getElementsByName('"+checkboxName+"').checked");
							if(temp==true)
								eval("document.getElementsByName('"+checkboxName+"').checked=false;");
							else
								eval("document.getElementsByName('"+checkboxName+"').checked=true;");
						}
						else
						{
							for (var i=0;i<targetLength;i++)
							{
							 	var temp=eval("document.getElementsByName('"+checkboxName+"')[i].checked");
							 	if(temp==true)
									eval("document.getElementsByName('"+checkboxName+"')[i].checked=false;");
								else 
									eval("document.getElementsByName('"+checkboxName+"')[i].checked=true;");
							}
						}
				}
			</script>
			<% } %>
			<script language="javascript">document.write("合计 " + pagerForm1.countAll.value + " 条 ");</script>
			<script language="javascript">document.write("共 " + pagerForm1.pageCount.value + " 页 ");</script>
			<script language="javascript">document.write("第 " + pagerForm1.pageNo.value + " 页 ");</script>
			<script language="javascript">document.write(pagerForm1.pageSize.value + "/页 ");</script>
			<input type=button name="prevPage" value="上一页" onclick="prevSub()" class="button3">
			<input type=button name="nextPage" value="下一页" onclick="NextSub()" class="button3">
			<input type=button name="jump" value="跳至" onclick="jumpTo()" class="button3">
			<span>&nbsp;第<input name="pageNo2" id="pageNo2" style="text-align:center" value="<%=request.getParameter("pageNo")%>" size="2" onKeyPress="javascript:isEnterPress();"></span>&nbsp;页
		</td>
	</tr>
  </tbody>
</table>
</form>
<script language="javascript">
	if(parseInt(document.pagerForm1.pageNo.value)-1<1)
	{
		document.pagerForm1.prevPage.disabled=true;
	}
	if((document.pagerForm1.pageNo2.value) >= parseInt(pagerForm1.pageCount.value) || pagerForm1.pageCount.value=="" || pagerForm1.pageCount.value=="0")
	{
		document.pagerForm1.nextPage.disabled=true;
	}
	if(document.pagerForm1.prevPage.disabled==true&&document.pagerForm1.nextPage.disabled==true)
	{
		document.pagerForm1.jump.disabled=true;
	}
	if(document.pagerForm1.jump.disabled==true)
	{
		document.pagerForm1.pageNo2.disabled=true;
	}
	function prevSub()
	{
	   if(parseInt(document.pagerForm1.pageNo.value)>1)
	   {
		 document.pagerForm1.pageNo.value=parseInt(document.pagerForm1.pageNo.value)-1;
		 pagerForm1.action=pagerForm1.submitAction.value;
		 pagerForm1.submit();
	   } 
	}
	function NextSub()
	{ 
		 if(parseInt(document.pagerForm1.pageNo.value) < parseInt(pagerForm1.pageCount.value))
		 {
		 	document.pagerForm1.pageNo.value=parseInt(document.pagerForm1.pageNo.value)+1;
		 	pagerForm1.action=pagerForm1.submitAction.value;
		 	pagerForm1.submit();
		 }
	}
	function jumpTo()
	{
		var pageNo=document.pagerForm1.pageNo2.value;
		if(pageNo.match(/^[1-9]\d*$/)==null)
		{
			alert("您输入的页数不存在！");
			return false;
		}
		if(parseInt(document.pagerForm1.pageNo2.value) > parseInt(pagerForm1.pageCount.value))
		{
			alert("您输入的页数不存在！");
			return false;
		}
		document.pagerForm1.pageNo.value=document.pagerForm1.pageNo2.value;
		 pagerForm1.action=pagerForm1.submitAction.value;
		 pagerForm1.submit();
	}
	function isEnterPress()
	{
		if(event.keyCode == 13)
			jumpTo();
	}

	document.onkeydown=function splitPage(){if(event.keyCode==33){prevSub();}if(event.keyCode==34){NextSub();}}
</script>