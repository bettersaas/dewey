<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="SexList"               value="${SexList}"              scope="page"/>
<c:set var="IdTypeList"          value="${IdTypeList}"         scope="page"/>
<c:set var="StayTypeList"     value="${StayTypeList}"     scope="page"/>
<c:set var="SettleModeList" value="${SettleModeList}" scope="page"/>
<c:set var="CustTypeList"     value="${CustTypeList}"    scope="page"/>
<c:set var="StatusList"          value="${StatusList}"         scope="page"/>
<c:set var="roomTypeList"            value="${roomTypeList}"          scope="page"/>
<c:set var="contractualUnitList"   value="${contractualUnitList}"  scope="page"/>
<c:set var="checkIn"   value="${checkIn}"  scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
<style>
#traveller{
	float:left;
	width: 30%;
	border-right: 1px solid #cccccc;
	border-bottom: 1px solid #cccccc;
	padding-right: 10px;
}
#content{
  float: right;
  width: 69%;
  margin: 0px;
	padding: 0px;
	background-color: #eeeeee;
	border-left: 1px solid #cccccc;
	border-bottom: 1px solid #cccccc;
}
#siteInfo{
	clear: both;
	border: 1px solid #cccccc;
	font-size: 75%;
	color: #cccccc;
	padding: 10px 10px 10px 10px;
}
.inputTextNoBorder{
   BORDER-RIGHT: medium none;
   BORDER-TOP: medium none;
   BORDER-LEFT: medium none;
   BORDER-BOTTOM:medium none;
   FONT-SIZE:9pt;
   WIDTH: 110; 
   TEXT-DECORATION: none ;
  }
.inputTextBorder{
   BORDER-RIGHT: 1px solid ;
   BORDER-TOP: 1px solid ;
   BORDER-LEFT: 1px solid ;
   BORDER-BOTTOM:1px solid;
   FONT-SIZE:9pt;
   WIDTH: 110;
   TEXT-DECORATION: none;
  }
.mouseHover{
	color: blue;
  }
</style>
<script src="<c:url value="/scripts/calendar.js"/>" type="text/javascript"></script>
<script language="JavaScript" type="text/JavaScript">
//+---------------------------------------------------
//| ���Ͳ�ѯ�վ�����
//+---------------------------------------------------
function searchByRroomTypeId()
{
		var searchRroomTypeId = document.getElementById("searchRroomTypeId");
		// ��ס���Ͳ���Ϊ��
		var stayType = form1.stayType.value;
		if(stayType=="") {
			window.alert("��ס���Ͳ���Ϊ��!") ;
			form1.stayType.focus();
			searchRroomTypeId.selectedIndex=0;
			return;
		}
		// ���͵�ѡ��
		if(searchRroomTypeId.value == "") {
			searchRroomTypeId.focus();
			return;
		}
		searchEmptyCleanRoom("",searchRroomTypeId.value);
}
//+---------------------------------------------------
//| ���Ų�ѯ�վ�����
//+---------------------------------------------------
function searchByRoomNo()
{
	// ��ס���Ͳ���Ϊ��
	var stayType = form1.stayType.value;
	if(stayType=="") {
		window.alert("��ס���Ͳ���Ϊ��!") ;
		form1.stayType.focus();
		return;
	}
	var roomSearchNum = $.trim($("#roomSearchNum").val());
	// �������Ϊ�ղ�ѯ
	if(roomSearchNum == ""  || roomSearchNum == "�����뷿��") {
		// ���͵Ĳ�ѯ
		var searchRroomTypeId = document.getElementById("searchRroomTypeId");
		if(searchRroomTypeId.value == "") {
			alert("�����뷿�Ų��һ���ѡ���Ͳ��ң�");
			$("#roomSearchNum").val("�����뷿��");
			$("#roomSearchNum").select();
			roomSearchNum = "";
		} else {
			// ���Ͳ�ѯ
			searchEmptyCleanRoom("",searchRroomTypeId.value);
		}
		return;
	}
	searchEmptyCleanRoom(roomSearchNum,"");
}
//+---------------------------------------------------
//| ͨ��ajax��ȡ�վ�����Ϣ
//+---------------------------------------------------
function searchEmptyCleanRoom(roomSearchNum,searchRroomTypeId)
{
	var merId = document.getElementById("mer.id").value;
	var contractualUnitId = document.getElementById("contractualUnitId").value;
	htmlobj=$.ajax({
	    url: encodeURI("<c:url value="/checkIn/searchRoom"/>?randValue=" + getRandom()),
	    data: "roomSearchNum="+roomSearchNum+"&searchRroomTypeId="+searchRroomTypeId+"&mer.id="+ merId +"&contractualUnitId="+contractualUnitId,
		type: "POST",
		dataType : "json",
		async:false,  // ͬ������
		timeout: 1000,
		error:function(xhr,error,exception) {
		    //����JSON�쳣ʱ����ajax����
			alert(exception.toString());
		},
		success:function(data, status, xhr){
			var roomTrStr='';
			// ɾ��tobody�е�������
			$("#tbd tr").remove();
			// ��������Ϣ
			if(data.message != "") {
				// ҳ����ʾ���޿վ�������ʾ��Ϣ  ������ʾ��Ϣalert(data.message);
				$("#tbd").append('<tr class="rescontent"><td colspan="9" align="center">' + data.message + '<br></td></tr>');
			} else {
				// ��ȡjson�еĿͷ���Ϣ
				var jsonData = data.merRooms;
				var roomTrStr = "";
				// ����ÿ��������Ϣ������ÿ�пͷ���¼html�ַ����������뵽�վ��ͷ���β��
				for(var i=0;i<jsonData.length;i++){
					roomTrStr = '<tr>';
					roomTrStr += '<td align="center" style="border-bottom:1px solid #e1e1e1;height:28px;padding-left:6px;"><input type="checkbox" name="ids" onclick="selectCheckInRoom(this,' + i + ')" value="'+ i + ';' + jsonData[i]["roomId"] + ';' + jsonData[i]["roomNo"] + ';' + jsonData[i]["bedId"] + ';' + jsonData[i]["bedNo"] + '">' + (i+1)  + '</td>';
					roomTrStr += '<input type="hidden" name="hireFlag' + i + '"  id="hireFlag' + i + '"  value="' + jsonData[i]["hireFlag"] + '">';
					roomTrStr += '<td align="center">' + jsonData[i]["roomTypeName"] + '</td>';
					roomTrStr += '<td align="center">' + jsonData[i]["roomNo"] + '</td>';
					roomTrStr += '<td align="center">' + jsonData[i]["bedNo"] + '</td>';
					roomTrStr += '<td align="center">' + jsonData[i]["alldayPrice"] + '</td>';
					roomTrStr += '<td align="center">' + jsonData[i]["halfdayPrice"] + '</td>';
					roomTrStr += '<td align="center">' + jsonData[i]["hourPrice"] + '/'+ jsonData[i]["hourMeasure"]  + 'Сʱ</td>';
					roomTrStr += '<td align="center">' + jsonData[i]["roomDesc"] + '</td>';
					roomTrStr += '<td align="center"><input type="text" disabled name="discount' + i + '" id="discount' + i + '" onblur="discountInput(' + i + ');"  size="8" maxlength="5" class="inputTextNoBorder"></td>';
					roomTrStr += '<td align="center"><input type="text" disabled name="amount' + i + '"  id="amount' + i + '"  onblur="amountInput(' + i + ');" " size="8" maxlength="7" class="inputTextNoBorder"></td>';
					roomTrStr += '</tr>';
					$("#tbd").append(roomTrStr);
					// ��ѯ��������ס����
					document.getElementsByName("roomType.id")[0].value=jsonData[i]["roomTypeId"];
					// ������ס�������Ӧ�ķ���۸�
					selectCheckInType();
				}
				// ��ż�в�ͬ��ɫ
				$("#emptyRoom tbody tr:odd").addClass("rescontent_");  // ��������
				$("#emptyRoom tbody tr:even").addClass("rescontent");
				// ����ƶ��б�ɫ
				$("#emptyRoom tbody tr").hover(function(){
				    $(this).addClass("mouseHover");
				},function(){
				    $(this).removeClass("mouseHover");
				});
			}
		}
	});
}
//+---------------------------------------------------
//| ѡ����ס����
//| obj.checked      id:roomId
//+---------------------------------------------------
function selectCheckInRoom(obj,index)
{
	// ѡ��ķ���
	if(obj.checked) {
		$("#discount" + index).removeClass();
		$("#amount" + index).removeClass();
		$("#discount" + index).addClass("inputTextBorder");
		$("#amount" + index).addClass("inputTextBorder");
		$("#discount" + index).val("").removeAttr("disabled");
		$("#amount" + index).val("").removeAttr("disabled");
	} else {
		$("#discount" + index).removeClass();
		$("#amount" + index).removeClass();
		$("#discount" + index).addClass("inputTextNoBorder");
		$("#amount" + index).addClass("inputTextNoBorder");
		$("#discount" + index).val("").attr("disabled","disabled");
		$("#amount" + index).val("").attr("disabled","disabled");
	}
}
//+---------------------------------------------------
//| ��ס���͵�ѡ��
//+---------------------------------------------------
function selectCheckInType()
{
	var stayTypeValue = document.getElementsByName("stayType")[0].value;
	// ���ݲ�ͬ��ѡ��ֻ��ʾ��ǰѡ�����ס���ͼ۸�
	switch(stayTypeValue){
		// ���췿
		case "1" :
			$("#emptyRoom tr").each(function(){$("td:eq(4)",this).hide()});   // ȫ�շ�
			$("#emptyRoom tr").each(function(){$("th:eq(4)",this).hide()});   // ȫ�շ�
			$("#emptyRoom tr").each(function(){$("td:eq(5)",this).show()}); // ���շ�
			$("#emptyRoom tr").each(function(){$("th:eq(5)",this).show()});  // ���շ�
			$("#emptyRoom tr").each(function(){$("td:eq(6)",this).hide()});   // �ӵ㷿
			$("#emptyRoom tr").each(function(){$("th:eq(6)",this).hide()});   // �ӵ㷿
			break;
		// ȫ�շ�
		case '2':
			$("#emptyRoom tr").each(function(){$("td:eq(4)",this).show()});  // ȫ�շ�
			$("#emptyRoom tr").each(function(){$("th:eq(4)",this).show()});  // ȫ�շ�
			$("#emptyRoom tr").each(function(){$("td:eq(5)",this).hide()});   // ���շ�
			$("#emptyRoom tr").each(function(){$("th:eq(5)",this).hide()});   // ���շ�
			$("#emptyRoom tr").each(function(){$("td:eq(6)",this).hide()});   // �ӵ㷿
			$("#emptyRoom tr").each(function(){$("th:eq(6)",this).hide()});   // �ӵ㷿
			break;
		// �ӵ㷿
		case '3':
			$("#emptyRoom tr").each(function(){$("td:eq(4)",this).hide()});   // ȫ�շ�
			$("#emptyRoom tr").each(function(){$("th:eq(4)",this).hide()});    // ȫ�շ�
			$("#emptyRoom tr").each(function(){$("td:eq(5)",this).hide()});    // ���շ�
			$("#emptyRoom tr").each(function(){$("th:eq(5)",this).hide()});    // ���շ�
			$("#emptyRoom tr").each(function(){$("td:eq(6)",this).show()});  // �ӵ㷿
			$("#emptyRoom tr").each(function(){$("th:eq(6)",this).show()});   // �ӵ㷿
			break;
		// ������
		case '4':
			$("#emptyRoom tr").each(function(){$("td:eq(4)",this).show()});  // ȫ�շ�
			$("#emptyRoom tr").each(function(){$("th:eq(4)",this).show()});  // ȫ�շ�
			$("#emptyRoom tr").each(function(){$("td:eq(5)",this).hide()});   // ���շ�
			$("#emptyRoom tr").each(function(){$("th:eq(5)",this).hide()});   // ���շ�
			$("#emptyRoom tr").each(function(){$("td:eq(6)",this).hide()});   // �ӵ㷿
			$("#emptyRoom tr").each(function(){$("th:eq(6)",this).hide()});   // �ӵ㷿
			break;
		// Ĭ��Ϊ��
		default : 
			$("#emptyRoom tr").each(function(){$("td:eq(4)",this).hide()});  // ȫ�շ�
			$("#emptyRoom tr").each(function(){$("th:eq(4)",this).hide()});  // ȫ�շ�
			$("#emptyRoom tr").each(function(){$("td:eq(5)",this).hide()});  // ���շ�
			$("#emptyRoom tr").each(function(){$("th:eq(5)",this).hide()});  // ���շ�
			$("#emptyRoom tr").each(function(){$("td:eq(6)",this).hide()});  // �ӵ㷿
			$("#emptyRoom tr").each(function(){$("th:eq(6)",this).hide()});  // �ӵ㷿
	}
	// �����ǰ���ۿ��ʺ��ۿۼ�
	$("#emptyRoom tbody tr").each(function(index){
		$("#discount" + index).val("");
		$("#amount" + index).val("");
	});
}
//+---------------------------------------------------
//| �ۿ۵���������ۿۼ�
//+---------------------------------------------------
function discountInput(index)
{
	$("#discount" + index).val($.trim($("#discount" + index).val()));
	var discount = $("#discount" + index).val();
	if (discount == "") {
		return;
	}
	if (!isDecimal(discount)) {
		alert("��������ȷ���ۿ��ʡ�");
		$("#discount" + index).select();
		return;
	}
	if (parseFloat(discount)>10 || parseFloat(discount)<0) {
		alert("��������ȷ���ۿ��ʡ��ۿ�����0��10֮�䡣");
		$("#discount" + index).select();
		return;
	}
	var stayTypeValue = document.getElementsByName("stayType")[0].value;
	var basePrice = "";
	// ���ݲ�ͬ��ѡ��ѡ����Ҫ���ۿ۵ļ۸�
	switch(stayTypeValue){
		// ���췿
		case "1" :
			basePrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(5)").text();
			break;
		// ȫ�շ�
		case '2':
			basePrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(4)").text();
			break;
		// �ӵ㷿
		case '3':
			basePrice = ($("#emptyRoom tbody tr:eq(" + index + ") td:eq(6)").text().split("/"))[0];
			break;
		// ������
		case '4':
			basePrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(4)").text();
			break;
		// Ĭ��Ϊ��
		default : 
			return;
	}
	$("#amount" + index).val(getRoundNumber(eval(basePrice + "*" + discount + "/10"),2));
}
//+---------------------------------------------------
//| ���ۿۼ۸������Ӧ���ۿ��ʽ��л���
//+---------------------------------------------------
function amountInput(index)
{
	$("#amount" + index).val($.trim($("#amount" + index).val()));
	var amount = $("#amount" + index).val();
	if (amount == "") {
		return;
	}
	if (!isDecimal(amount)) {
		alert("��������ȷ���ۿۼۡ�");
		$("#amount" + index).select();
		return;
	}
	var stayTypeValue = document.getElementsByName("stayType")[0].value;
	var basePrice = "";
	// ���ݲ�ͬ��ѡ��ѡ����Ҫ���ۿ۵ļ۸�
	switch(stayTypeValue){
		// ���췿
		case "1" :
			basePrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(5)").text();
			break;
		// ȫ�շ�
		case '2':
			basePrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(4)").text();
			break;
		// �ӵ㷿
		case '3':
			basePrice = ($("#emptyRoom tbody tr:eq(" + index + ") td:eq(6)").text().split("/"))[0];
			break;
		// ������
		case '4':
			basePrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(4)").text();
			break;
		// Ĭ��Ϊ��
		default : 
			return;
	}
	$("#discount" + index).val(getRoundNumber(eval(amount + "*10/" + basePrice),2));
}
</script>
</HEAD>
<BODY>
        <div style="height:3px;"></div>
		<div align="center" id="traveller">
		<form name="form1" method=post action="<c:url value="/checkIn/create"/>" target="_self">
		<input type="hidden" name="mer.id" value="<c:out value="${checkIn.mer.id}"/>">
		 <input type="hidden" name="roomType.id" >
		 <input type="hidden" name="contractualUnitName" >
		 <div id="selectCheckInRooms" style="display:none;"></div>
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY> 
		    <TR class="hcititle"> 
		      <TD colSpan="2">���ÿ�Ԥ���Ǽ���Ϣ��</TD>
		    </TR>
				<tr>
					<td class="hcihead">��ס����</td>
					<td class=hcicontent>
					    <select name="stayType" onchange="selectCheckInType();">
					    	<option value="">--��ѡ��--</option>
					    	<c:forEach var="rs" items="${StayTypeList}" varStatus="vStatus">
					    		<option value="<c:out value="${rs.value}"/>" ><c:out value="${rs.name}"/></option>
					    	</c:forEach>
					    </select><font color="red">*</font>
					</td>
				</tr>
		
				<tr>
					<td class="hcihead">����</td>
					<td class=hcicontent ><input type="text" name="custName"></td>
				</tr>
				<tr>
					<td class="hcihead">�Ա�</td>
					<td class=hcicontent >
						<c:forEach var="rs" items="${SexList}" varStatus="vStatus">
							<input type="radio" name="sex"  value="<c:out value="${rs.value}"/>"><c:out value="${rs.name}"/>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td class="hcihead">��ϵ�绰</td>
					<td class=hcicontent ><input type="text" name="phone"></td>
				</tr>
				<tr>
					<td class="hcihead">֤������</td>
					<td class=hcicontent >
					    <select name="idType">
					    	<option value="">--��ѡ��--</option>
					    	<c:forEach var="rs" items="${IdTypeList}" varStatus="vStatus">
					    		<option value="<c:out value="${rs.value}"/>" ><c:out value="${rs.name}"/></option>
					    	</c:forEach>
					    </select>
					</td>
				</tr>
				<tr>
					<td class="hcihead">֤������</td>
					<td class=hcicontent ><input type="text" name="idNo"></td>
				</tr>
				<tr>
					<td class="hcihead">��ַ</td>
					<td class=hcicontent ><input type="text" name="address"></td>
				</tr>
				<tr>
					<td class="hcihead">����</td>
					<td class=hcicontent > <input type="text" name="peopleNum"></td>
				</tr>
				<tr>
					<td class="hcihead">Ԥ����ס����</td>
					<td class=hcicontent >
					<input type="text" name="arrivalDate" id="arrivalDate" size="20" maxlength="19" readonly="readonly">
					<img  src='images/calen_pic.gif'  width="17" height="18" align="absmiddle" onclick="new Calendar(2000, 2050, 0).show(form1.arrivalDate,null,'yyyy-MM-dd hh:mm',true);" />
					</td>
				</tr>
				<tr>
					<td class="hcihead">Ԥ���������</td>
					<td class=hcicontent >
					<input type="text" name="planDepartureDate" id="planDepartureDate" size="20" maxlength="19" readonly="readonly">
					<img  src='images/calen_pic.gif'  width="17" height="18" align="absmiddle" onclick="new Calendar(2000, 2050, 0).show(form1.planDepartureDate,null,'yyyy-MM-dd hh:mm',true);" />
					</td>
				</tr>
				<tr>
					<td class="hcihead">Ԥ����ס����</td>
					<td class=hcicontent ><input type="text" name="stayDays" size="6" maxlength="3" readOnly class="inputTextNoBorder"></td>
				</tr>
				<tr>
					<td class="hcihead">���ʽ</td>
					<td class=hcicontent>
					    <select name="settleMode">
					    	<option value="">--��ѡ��--</option>
					    	<c:forEach var="rs" items="${SettleModeList}" varStatus="vStatus">
					    		<option value="<c:out value="${rs.value}"/>" ><c:out value="${rs.name}"/></option>
					    	</c:forEach>
					    </select>
					</td>
				</tr>
						<tr>
					<td class="hcihead">ǩ�����˵�λ</td>
					<td class=hcicontent >
					    <select name="contractualUnitId" id="contractualUnitId">
					    	<option value="">--��ѡ��--</option>
					    	<c:forEach var="rs" items="${contractualUnitList}" varStatus="vStatus">
					    		<option value="<c:out value="${rs.id}"/>" ><c:out value="${rs.company}"/></option>
					    	</c:forEach>
					    </select>
					</td>
				</tr>
				<tr>
					<td class="hcihead">Ԥ��Ѻ��</td>
					<td class=hcicontent ><input type="text" name="deposit"></td>
				</tr>
				<tr>
					<td class="hcihead">�ÿ����</td>
					<td class=hcicontent >
					    <select name="custType">
					    	<option value="">--��ѡ��--</option>
					    	<c:forEach var="rs" items="${CustTypeList}" varStatus="vStatus">
					    		<option value="<c:out value="${rs.value}"/>" ><c:out value="${rs.name}"/></option>
					    	</c:forEach>
					    </select>
					</td>
				</tr>
				<tr>
					<td class="hcihead">���ȯ</td>
					<td class=hcicontent ><input type="text" name="breakfastTicket" size="5"  maxlength="3" style="ime-mode:disabled" onkeyup="value=value.replace(/[^\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">&nbsp;��</td>
				</tr>
				<tr>
					<td class="hcihead">��ע</td>
					<td class=hcicontent ><textarea  rows="2" cols="30" name="remark"></textarea></td>
				</tr>
		    </TBODY>
		  </TABLE>
		</div>
		<div id="content" >
		    <div id="sectionLinks" style="width:100%;height:430px; overflow:scroll; border:1px solid;">
		    <div id="search">
		      ���վ�����
		       &nbsp;&nbsp;
		      ����:<select name="searchRroomTypeId" id="searchRroomTypeId" onchange="searchByRroomTypeId();">
		    	<option value="">--��ѡ��--</option>
		    	<c:forEach var="rs" items="${roomTypeList}" varStatus="vStatus">
		    		<option value="<c:out value="${rs.id}"/>" ><c:out value="${rs.name}"/></option>
		    	</c:forEach>
		     </select>
		     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		     ����:<input name="roomSearchNum" type="text" size="10" id="roomSearchNum"   value="�����뷿�� " onFocus="if (value =='�����뷿�� '){value =''}" onBlur="if (value ==''){value='�����뷿�� '}"/>
		      <input name="goButton" type="button"  onclick="javascript:searchByRoomNo();"  value="����" />
		    </div>
		    </form>
		    <form name="form2" method=post action="#" target="_self">
		    <table  id="emptyRoom" width="100%" border="1" cellspacing="0" cellpadding="0" summary="���� " style="border-collapse:collapse;">
		   		<thead>
			    <tr class="reshead" id="merRoomTitle">
				    <th scope="col">���</th>
				    <th scope="col">����</th>
				    <th scope="col">����</th>
				    <th scope="col">����</th>
				    <th scope="col">ȫ�շ���</th>
				    <th scope="col">���շ���</th>
				    <th scope="col">�ӵ㷿��</th>
				    <th scope="col" width="30%">����˵��</th>
				    <th scope="col">�ۿ۱���(/��)</th>
				    <th scope="col">�ۿۼ۸�</th>
			    </tr>
			    </thead>
			    <tbody id="tbd">
						<tr  class="rescontent">
							<td colspan="10" align="center">���ѯ��Ӧ��ס���͵Ŀվ����䡣<br></td>
						</tr>
				</tbody>
		    </table>
		    </form>
		   </div>
		   <!-- end �վ��� -->
		</div>
		<div id="siteInfo" align="center"> 
			<input  type="button" name="save"  onclick="javascript:readIdentity();"  value="������֤" />&nbsp;&nbsp;
			<input  type="button" name="save"  onclick="javascript:readMemberCard();"  value="��Ա����" />&nbsp;&nbsp;
			<input  type="button" name="save"  onclick="javascript:operatorDiscount();"  value="����Ա�ۿ�" />&nbsp;&nbsp;
			<input  type="button" name="save"  onclick="javascript:formSubmit();"  value="�ύԤ��" />&nbsp;&nbsp;
		</div>
		<br />
 </BODY>
 <script language="JavaScript" type="text/JavaScript">
//+---------------------------------------------------
//| �����ƿ�
//+---------------------------------------------------
function formSubmit()
{
	// Э�鵥λ��ֵ
	var contractualUnitId = form1.contractualUnitId.value;
	if(contractualUnitId!="") {
		var obj=document.getElementById("contractualUnitId");
		for(i=0; obj.length; i++){
			if(obj[i].selected==true){
				form1.contractualUnitName.value = obj[i].innerText;
				break;
			}
		}
	}
	
	// ���ȯ��Ϊ��ʱ�ж����Ƿ�������
	if(!isEmpty(form1.breakfastTicket))    {
		cntBft = parseInt(form1.breakfastTicket.value,10);
		if(isNaN(cntBft)) {
			window.alert("���ȯ����������������!") ;
			form1.breakfastTicket.select();
			return;
		}
	}
	
	var arrivalDate =  form1.arrivalDate.value;
	// ��ס���ڲ���Ϊ��
	if(isEmpty(form1.arrivalDate)) {
		window.alert("��ס���ڲ���Ϊ��!") ;
		form1.arrivalDate.select();
		return;
	}
	// �����ס���ڲ���С�ڵ�ǰʱ��
	//var now = new Date();
	//var truncMinuteNowDate = new Date(now.getFullYear(), now.getMonth(), now.getDate(), now.getHours(), now.getMinutes());
	//var time1 = truncMinuteNowDate.getTime();       // ��ǰ����
	var arrivalDateSplit = arrivalDate.split(/[- :]/);
	var time2 = new Date(arrivalDateSplit[0], arrivalDateSplit[1]-1, arrivalDateSplit[2], arrivalDateSplit[3], arrivalDateSplit[4]).getTime();
	//if(time1 > time2) {   // ��סʱ��ȵ�ǰʱ����
	//	window.alert("��סʱ��ȵ�ǰʱ�仹�磬���趨��ǰ�Ժ��ʱ��!") ;
	//	form1.arrivalDate.select();
	//	return;
	//}
	var planDepartureDate =  form1.planDepartureDate.value;
	// Ԥ���������
	if(isEmpty(form1.planDepartureDate)) {
		window.alert("Ԥ��������ڲ���Ϊ��!") ;
		form1.planDepartureDate.select();
		return;
	}
	// �����ס���ڱ����Ԥ�����������
	var planDepartureDateSplit = planDepartureDate.split(/[- :]/);
	var time3 = new Date(planDepartureDateSplit[0], planDepartureDateSplit[1]-1, planDepartureDateSplit[2], planDepartureDateSplit[3], planDepartureDateSplit[4]).getTime();
	if(time2 >= time3) {   // ��סʱ������Ԥ�����������
		window.alert("��סʱ������Ԥ����������磬���޸�!") ;
		form1.planDepartureDate.select();
		return;
	}
	// �趨��ס����
	var cha=(time3-time2)/(1000*60*60*24);
	form1.stayDays.value=getRoundNumber(Math.abs(cha),2);
	
	// ��ס���Ͳ���Ϊ��
	var stayType = form1.stayType.value;
	if(stayType=="") {
		window.alert("��ס���Ͳ���Ϊ��!") ;
		form1.stayType.focus();
		return;
	}

	// �����ѡ�ͷ���Ϣ
	$('#selectCheckInRooms').html("");
	// ��ѡ��Ľ���˳����
	var selectInt = -1;
    $("input[name='ids']").each(function(){
    	// ѡ��
    	if (this.checked) {
    		selectInt += 1;
    		var arr = this.value.split(";");
    		var index = arr[0];        // tr�е�����
    		var roomId = arr[1];     // ����ID
    		var roomNo = arr[2];   // ����
    		var bedId = arr[3];       // ��λID
    		var bedNo = arr[4];     // ����
    		var discount = $("#discount" + index).val();          // �ۿ۱���
    		var amount =   $("#amount" + index).val();            // �ۿۼ۸�
    		var checkInType = $("#hireFlag" + index).val();    // �ⷿ��ʽ
			// ԭ�۸�
   			var amountPrice;
   			switch(stayType) {
				// ���췿
				case "1" :
					amountPrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(5)").text();
					break;
				// ȫ�շ�
				case '2':
					amountPrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(4)").text();
					break;
				// �ӵ㷿
				case '3':
					amountPrice = ($("#emptyRoom tbody tr:eq(" + index + ") td:eq(6)").text().split("/"))[0];
					break;
				// ������
				case '4':
					amountPrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(4)").text();
					break;
   			}
   			// û���ۿ�ʱ��Ĭ��10��ȫ��
    		if (amount == "") {
    			discount = 10;
    			amount = amountPrice;
    		}
    		$('#selectCheckInRooms').append(
    		"<input type='hidden' name='custCheckInRooms[" + selectInt  + "].roomId' value='" +roomId + "' >" + 
    		"<input type='hidden' name='custCheckInRooms[" + selectInt  + "].roomNo' value='" + roomNo + "' >" +  
    		"<input type='hidden' name='custCheckInRooms[" + selectInt  + "].bedId' value='" +bedId + "' >" + 
    		"<input type='hidden' name='custCheckInRooms[" + selectInt  + "].bedNo' value='" + bedNo + "' >" +  
    		"<input type='hidden' name='custCheckInRooms[" + selectInt  + "].discount' value='" + discount + "' >" +  
    		"<input type='hidden' name='custCheckInRooms[" + selectInt  + "].amount' value='" + amount + "' >" +  
    		"<input type='hidden' name='custCheckInRooms[" + selectInt  + "].checkInType' value='" + checkInType + "' >" +  
    		"<input type='hidden' name='custCheckInRooms[" + selectInt  + "].merId' value='<c:out value="${checkIn.mer.id}"/>' >" +
    		"<input type='hidden' name='custCheckInRooms[" + selectInt  + "].registPrice' value='" + amountPrice + "' >");    //alert($('#selectCheckInRooms').html());
    	}
	});
	if(selectInt == -1) {
		alert("û��ѡ����ס�ͷ���");
		return;
	}
	form1.action="${pageContext.request.contextPath}/checkIn/create";
	form1.target="_self";
	form1.submit();
}

//+---------------------------------------------------
//| ѡ����ס����/Ԥ��������ں��Զ�������ס����
//+---------------------------------------------------
// propertychange��IE7���첽��Ӧ
function setStayDays() {
	var arrivalDate =  form1.arrivalDate.value;
	// ��ס���ڲ���Ϊ��
	if(isEmpty(form1.arrivalDate)) {
		return;
	}
	// �����ס���ڲ���С�ڵ�ǰʱ��
	var now = new Date();
	//var truncMinuteNowDate = new Date(now.getFullYear(), now.getMonth(), now.getDate(), now.getHours(), now.getMinutes());
	//var time1 = truncMinuteNowDate.getTime();       // ��ǰ����
	var arrivalDateSplit = arrivalDate.split(/[- :]/);
	var time2 = new Date(arrivalDateSplit[0], arrivalDateSplit[1]-1, arrivalDateSplit[2], arrivalDateSplit[3], arrivalDateSplit[4]).getTime();
	//if(time1 > time2) {   // ��סʱ��ȵ�ǰʱ�仹��
	//	window.alert("��סʱ��ȵ�ǰʱ�仹�磬���趨��ǰ�Ժ��ʱ��!") ;
	//	form1.arrivalDate.select();
	//	return;
	//}
	var planDepartureDate =  form1.planDepartureDate.value;
	// Ԥ���������Ϊ��
	if(isEmpty(form1.planDepartureDate)) {
		return;
	}
	// �����ס���ڱ����Ԥ�����������
	var planDepartureDateSplit = planDepartureDate.split(/[- :]/);
	var time3 = new Date(planDepartureDateSplit[0], planDepartureDateSplit[1]-1, planDepartureDateSplit[2], planDepartureDateSplit[3], planDepartureDateSplit[4]).getTime();
	if(time2 >= time3) {   // ��סʱ������Ԥ�����������
		window.alert("��סʱ������Ԥ����������磬���޸�!") ;
		form1.planDepartureDate.select();
		return;
	}
	// �趨��ס����
	var cha=(time3-time2)/(1000*60*60*24);
	form1.stayDays.value=getRoundNumber(Math.abs(cha),2);
}

/********************************************************
 js�����ı����ֵ�󲻴���onChange�¼����� 
********************************************************/
//IE  $.browser.msie   navigator.userAgent.indexOf("MSIE")>0
if($.browser.msie){
	// .unbind("propertychange")
	// document.getElementById('arrivalDate').attachEvent("onpropertychange",setStayDays);
	$('#arrivalDate').bind('propertychange', function(event) {
	        if($.syncProcessSign) return ;
	        $.syncProcessSign = true;
	        setStayDays();
	        $.syncProcessSign = false;
	});
    // document.getElementById('planDepartureDate').attachEvent("onpropertychange",setStayDays);
    $('#planDepartureDate').bind('propertychange', function(event) {
	        if($.syncProcessSign1) return ;
	        $.syncProcessSign1 = true;
	        setStayDays();
	        $.syncProcessSign1 = false;
	});
//FF
}else if(navigator.userAgent.indexOf("Firefox")>0){
    document.getElementById('arrivalDate').addEventListener("input",setStayDays,false);
    document.getElementById('planDepartureDate').addEventListener("input",setStayDays,false);
}
 </script>
</HTML>