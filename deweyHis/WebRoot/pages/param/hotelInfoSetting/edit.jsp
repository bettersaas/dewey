<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="hotelInfoSetting" value="${hotelInfoSetting}" scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
<script language="JavaScript" type="text/JavaScript">
function formSubmit()
{
	if(isEmpty(form1.title))    {
		window.alert("�����뱨�����!") ;
		form1.title.focus();
		return;
	}
	if(form1.title.length > 100)    {
		window.alert("�����������������100���ڣ�!") ;
		form1.title.select();
		return;
	}
	if(isEmpty(form1.settleAcountTail))    {
		window.alert("��������˵�β!") ; 
		form1.settleAcountTail.focus(); 
		return;
	}
	if(form1.settleAcountTail.length > 500)    {
		window.alert("�����������������500���ڣ�!") ;
		form1.settleAcountTail.select();
		return;
	}
	if(isEmpty(form1.foregiftTail))    {
		window.alert("������Ѻ��β!") ;
		form1.foregiftTail.focus();
		return;
	}
	if(form1.foregiftTail.length > 500)    {
		window.alert("�����������������500���ڣ�!") ;
		form1.foregiftTail.select();
		return;
	}
	form1.target="_self";
	form1.submit();
}
</script>
</HEAD>
<BODY>
  <form name="form1" method=post action="<c:url value="/hotelInfoSetting/update"/>" target="_self">
        <input type="hidden" name="mer.id" value="<c:out value="${hotelInfoSetting.mer.id}"/>">
        <input type="hidden" name="id"        value="<c:out value="${hotelInfoSetting.id}"/>">
        <br>
		<div align="center">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY> 
		    <TR class="hcititle"> 
		      <TD colSpan="4">���Ƶ���Ϣ���á�</TD>
		    </TR>
				<tr>
					<td class="hcihead" width="12%">�������</td>
					<td class=hcicontent colspan="3"><textarea name="title"  cols="50"   rows="3"><c:out value="${hotelInfoSetting.title}"/></textarea></td>
				</tr>
				<tr>
					<td class="hcihead">���˵�β</td>
					<td class=hcicontent colspan="3"><textarea name="settleAcountTail"  cols="80"   rows="4"><c:out value="${hotelInfoSetting.settleAcountTail}"/></textarea></td>
				</tr>
				<tr>
					<td class="hcihead">Ѻ��β</td>
					<td class=hcicontent colspan="3"><textarea name="foregiftTail"  cols="80"   rows="4"><c:out value="${hotelInfoSetting.foregiftTail}"/></textarea></td>
				</tr>
			    <TR> 
			      <TD class=hcihead colspan="4">
			        <input  type="button" name="save"      onclick="javascript:formSubmit();"  value="����" />
			      </TD>
			    </TR>
		    </TBODY> 
		  </TABLE>
		</div>
  </form>
 </body>
</html>