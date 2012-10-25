<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="roomTypeList" value="${roomTypeList}" scope="page"/>
<c:set var="merRoomList" value="${merRoomList}" scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
</HEAD>
<BODY>
<br>
<form name="form1" method="get" action="#">
<input type="hidden" name="state">
<table align="center" class="result" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0" style="border-collapse:collapse;">
  <tbody>
  <tr class="hcititle">
    <td align=left colSpan=17>������ά����</td>
  </tr>
  <tr class="hcititle">
    <td align=left colSpan=17>&nbsp;���ͣ�&nbsp;&nbsp;
    <select name="roomType.id">
    	<option value="">--��ѡ��--</option>
    	<c:forEach var="rs" items="${roomTypeList}" varStatus="vStatus">
    		<option value="<c:out value="${rs.id}"/>"  <c:if test="${param['roomType.id'] == rs.id}">selected</c:if>  ><c:out value="${rs.name}"/></option>
    	</c:forEach>
    </select>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="javascript:query();" target="mainFrame"><img src="<c:url value="/images/button/query.gif"/>" border="0"></a>
    </td>
  </tr>
  <c:if test="${merRoomList != null}" >
		  <tr class="reshead">
		    <td>���</td>
		    <td>����</td>
			<td>����</td>
			<td>¥��</td>
			<td>¥��</td>
			<td>�绰�ֻ�</td>
			<td>�绰����</td>
			<td>�ſ�</td>
			<td>����״̬</td>
			<td>��λ��</td>
			<td>���Ƽ�</td>
			<td>���ռ�</td>
			<td>�ӵ㷿��λ</td>
			<td>�ӵ㷿�۸�</td>
			<td>����</td>
			<td>����״̬</td>
			<td>����</td>
		  </tr>
		<c:choose>
			<c:when test="${empty merRoomList}">
				<tr>
					<td colspan="17" align="center">�޿ͷ���Ϣ�������</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="rs" items="${merRoomList}" varStatus="vStatus">
				  <tr  <c:choose><c:when test="${vStatus.index%2==0}">class="rescontent"</c:when><c:otherwise>class="rescontent_"</c:otherwise></c:choose>  > 
						<td style="border-bottom:1px solid #e1e1e1;height:28px;padding-left:6px;"><input type="checkbox" name="ids" value="<c:out value="${rs.id}"/>"><c:out value="${vStatus.index+1}"/></td>
						<input type="hidden" name="roomNo" value='${rs.roomNo}'>
						<input type="hidden" name="roomState" value='${rs.state}'>
						<td><c:out value="${rs.roomNo}"/></td>
						<td><c:out value="${rs.roomType.name}"/></td>
						<td><c:out value="${rs.building}"/></td>
						<td><c:out value="${rs.floor}"/></td>
						<td><c:out value="${rs.telExtension}"/></td>
						<td><c:out value="${rs.telExteriorLine}"/></td>
						<td><c:out value="${rs.doorCard}"/></td>
						<td><c:choose><c:when test="${rs.hireFlag==1}">��λ����</c:when><c:otherwise>�������</c:otherwise></c:choose></td>
						<td><c:out value="${rs.currBed}"/></td>
						<td><c:out value="${rs.alldayPrice}"/></td>
						<td><c:out value="${rs.halfdayPrice}"/></td>
						<!-- td><c:choose><c:when test="${rs.hourFlag==1}">��</c:when><c:otherwise>��</c:otherwise></c:choose></td -->
						<td><c:if test="${rs.hourFlag==1}"><c:out value="${rs.hourMeasure}"/></c:if></td>
						<td><c:if test="${rs.hourFlag==1}"><c:out value="${rs.hourPrice}"/></c:if></td>
						<td><c:out value="${rs.roomDesc}"/></td>
						<td><c:out value="${rs.stateDesc}"/></td>
						<td align="center" ><a href="<c:url value="/merRoom/edit/"/><c:out value="${rs.id}"/>">�༭</a>&nbsp;&nbsp;<a href='javascript:deleteRoom(<c:out value="${rs.id}"/>);'>ɾ��</a></td>
				  </tr>
			  </c:forEach>
			</c:otherwise>
		</c:choose>
</c:if>
  <tr>
    <td colspan="17"> 
      <table class="resBottom">
        <tr> 
          <td width="38%">
            <input  type="button" name="save"  onclick="javascript:newRoom();"  value="����" border=0/>
            <input  type="button" name="emptyClean"  onclick="javascript:batchUpdateState('5');"  value="����Ϊ�վ���" border=0/>
            <input  type="button" name="maintain"        onclick="javascript:batchUpdateState('4');"  value="ͣ��Ϊά�޷�" border=0/>
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
	function  deleteRoom(id) {
		form1.action='<c:url value="/merRoom/delete/"/>' + id;
		form1.submit();
	}
	function  query() {
		form1.action='<c:url value="/merRoom/list"/>';
		form1.submit();
	}
	function  newRoom() {
		form1.action='<c:url value="/merRoom/new"/>';
		form1.submit();
	}
	// �����޸ķ���״̬Ϊ���û���ͣ��
	function batchUpdateState(state) {
		var ids=getCheckBoxLength("ids");
   		if(ids==0) {
   			alert("��ѡ��ͷ���");
   			return;
   		}
   		// ����״̬������ס����Ԥ����ʱ�����޸�״̬
		for (var i=0;i<ids.length;i++) {
			if ((document.getElementsByName("ids"))[i].checked) {
				//   ����״̬    1��Ԥ����  2����ס��
				if((document.getElementsByName("roomState"))[i].value=='1'){
					alert("ѡ��Ŀͷ�����Ԥ�����������޸�״̬��");
					return;
				}
				if((document.getElementsByName("roomState"))[i].value=='2'){
					alert("ѡ��Ŀͷ�������ס���������޸�״̬��");
					return;
				}
			}
		}
		form1.state.value=state;
		form1.action='<c:url value="/merRoom/batchUpdateState"/>';
		form1.submit();
	}
</SCRIPT>
</BODY>
</HTML>