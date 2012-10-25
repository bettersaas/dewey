<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="roomTypeList" value="${roomTypeList}" scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
</HEAD>
<BODY>
<br>
<form name="form1" method="get" action="#" target="mainFrame">
<table align="center" class="result" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0" style="border-collapse:collapse;">
  <tbody>
  <tr class="hcititle"> 
    <td align=left colSpan=12>�������б�</td>
  </tr>
  <tr class="reshead"> 
    <td>���</td>
	<td>����</td>
	<td>����</td>
	<td>��ע</td>
	<td>���Ƽ�</td>
	<td>ȫ�շ���ʱ��</td>
	<td>���շ��۸�</td>
	<td>���շ���ʱ��</td>
	<td>�ӵ㷿��ʼ��λ</td>
	<td>�ӵ㷿��ʼ�۸�</td>
	<td>�ӵ㷿��ʱ��</td>
	<td>����</td>
  </tr>
<c:choose>
	<c:when test="${empty roomTypeList}">
		<tr>
			<td colspan="12" align="center">�޷�����Ϣ�������</td>
		</tr>
	</c:when>
	<c:otherwise>
		<c:forEach var="rs" items="${roomTypeList}" varStatus="vStatus">
		  <tr  <c:choose><c:when test="${vStatus.index%2==0}">class="rescontent"</c:when><c:otherwise>class="rescontent_"</c:otherwise></c:choose>  > 
				<td style="border-bottom:1px solid #e1e1e1;height:28px;padding-left:6px;"><input type="checkbox" name="ids" value="<c:out value="${rs.id}"/>"><c:out value="${vStatus.index+1}"/></td>
				<input type="hidden" name="name" value='${rs.name}'>
				<td><c:out value="${rs.name}"/></td>
				<td><c:out value="${rs.roomTypeDesc}"/></td>
				<td><c:out value="${rs.comment}"/></td>
				<td><c:out value="${rs.alldayPrice}"/></td>
				<td><c:out value="${rs.alldayPerHourPrice}"/></td>
				<td><c:out value="${rs.halfdayPrice}"/></td>
				<td><c:out value="${rs.halfdayPerHourPrice}"/></td>
				<td><c:out value="${rs.hourMeasure}"/></td>
				<td><c:out value="${rs.hourPrice}"/></td>
				<td><c:out value="${rs.hourPerHourPrice}"/></td>
				<td align="center" ><a href="<c:url value="/roomType/edit/"/><c:out value="${rs.id}"/>">�༭</a>&nbsp;&nbsp;&nbsp;<a href="<c:url value="/roomType/delete/"/><c:out value="${rs.id}"/>">ɾ��</a></td>
		  </tr>
	  </c:forEach>
	</c:otherwise>
</c:choose>
  <tr>
    <td colspan="12"> 
      <table class="resBottom">
        <tr> 
          <td width="38%">
            <input  type="button" name="save"     onclick="javascript:form1.action='<c:url value="/roomType/new"/>';form1.submit();"  value="����" border=0/>
            <input  type="button" name="delete"  onclick="javascript:deleteBatch();"  value="ɾ��" border=0/>
          </td>
          <td width="26%"> 
            <div align="right"> </div>
          </td>
          <td width="36%">
		    <div align="right"> </div>
          </td>
        </tr>
      </table>
    </td>
  </tr>
  </tbody> 
</table>
</form>
<SCRIPT language="javascript">
	function deleteBatch() {
		var vflag=getCheckBoxLength("ids");
   		if(vflag==0) {
   			alert("��ѡ��Ҫɾ���ķ��ͣ�");
   		} else {
	   		   	var ids = document.getElementsByName("ids");
	   		   	var name = document.getElementsByName("name");
	   		   	var nameStr = "";
				for (i=0;i < ids.length;i++ )
				{
					if (ids[i].checked)  nameStr = nameStr +  name[i].value + "\n";
				}
			   if(confirm("��ɾ���ķ����б�\n" +nameStr + "ȷ��Ҫɾ����")){
	      	       form1.action='<c:url value="/roomType/batchDelete"/>';
				   form1.submit();
      	       }
           }
	}
</SCRIPT>
</BODY>
</HTML>