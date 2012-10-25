<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="checkIn"   value="${checkIn}"    scope="page"/>
<c:set var="custCheckInRoom"   value="${custCheckInRoom}"    scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
<style>
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
</style>
<script language="JavaScript" type="text/JavaScript">
// form�ύ
function formSubmit()
{
	//<tr>
	//	<td height="30px" class=hcicontent colspan="6"><input type="radio" name="changeType"  value="0">�����󷿼�ִ��ԭ����&nbsp;&nbsp;<input type="radio" name="changeType"  value="1">�����󷿼۲�һ��</td>
	//</tr>
	//if(! (getRadioValue("changeType")[0]) ) {
	//	alert("��ѡ�񻻷���ļ۸�ȡ��") ;
	//	return false;
	//}
	
	var stayType = form1.stayType.value;
	
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
    		"<input type='hidden' name='roomId' value='" +roomId + "' >" + 
    		"<input type='hidden' name='roomNo' value='" + roomNo + "' >" +  
    		"<input type='hidden' name='bedId' value='" +bedId + "' >" + 
    		"<input type='hidden' name='bedNo' value='" + bedNo + "' >" +  
    		"<input type='hidden' name='discount' value='" + discount + "' >" +  
    		"<input type='hidden' name='amount' value='" + amount + "' >" +  
    		"<input type='hidden' name='roomNoPrice' value='" + amount + "' >" +  
    		"<input type='hidden' name='checkInType' value='" + checkInType + "' >" +  
    		"<input type='hidden' name='merId' value='<c:out value="${checkIn.mer.id}"/>' >" +
    		"<input type='hidden' name='registPrice' value='" + amountPrice + "' >");
    	}
	});
	form1.action="${pageContext.request.contextPath}/exchangeRoom/create";
	form1.target="_parent"; //   _self
	form1.submit();
}
</script>
</HEAD>
<BODY>
  <form name="form1" method=post action="<c:url value="/exchangeRoom/create"/>" target="_self">
        <input type="hidden" name="checkInId"                         value="<c:out value="${checkIn.id}"/>">
        <input type="hidden" name="custCheckInRoomId"      value="<c:out value="${custCheckInRoom.id}"/>">
        <input type="hidden" name="checkIn.id"      value="<c:out value="${checkIn.id}"/>">
        <input type="hidden" name="mer.id"      value="<c:out value="${checkIn.mer.id}"/>">
        <input type="hidden" name="stayType"      value="<c:out value="${checkIn.stayType}"/>">
        <input type="hidden" name="contractualUnitId"      value="<c:out value="${checkIn.contractualUnitId}"/>">
        <div id="selectCheckInRooms" style="display:none;"></div>
        <br>
		<div align="center">
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		    <TBODY>
			<TR class="hcititle"> 
			      <TD colSpan="6">��������</TD>
			</TR>
			<tr>
				<td class="hcihead">ԭ�ͷ�</td>
				<td class=hcicontent colspan="5"><input type="text" name="oldRoomNo" readOnly value="<c:out value="${custCheckInRoom.roomNo}"/>" class="inputTextNoBorder"></td>
			</tr>
			<tr>
				<td class="hcihead" width="12%">��������</td>
				<td class=hcicontent width="21%"><input type="text" name="travler" readOnly value="<c:out value="${checkIn.custName}"/>" class="inputTextNoBorder"></td>
				<td class="hcihead" width="12%">���</td>
				<td class=hcicontent width="21%"><input type="text" name="oldRoomNoPrice" readOnly value="<c:out value="${custCheckInRoom.amount}"/>" class="inputTextNoBorder"></td>
				<td class="hcihead" width="12%">�Ƽ�</td>
				<td class=hcicontent width="21%"><input type="text" name="oldRoomNoRegPrice" readOnly value="<c:out value="${custCheckInRoom.registPrice}"/>" class="inputTextNoBorder"></td>
			</tr>
			<tr>
				<td height="30px" class=hcicontent colspan="6">
				����:<input name="roomSearchNum" type="text" size="10" id="roomSearchNum" />&nbsp;<input name="goButton" type="button"  onclick="javascript:searchByRoomNo();"  value="����" />
				</td>
			</tr>
			<tr>
				<td height="30px" class=hcicontent colspan="6">
				    <table  id="emptyRoom" width="100%" border="1" cellspacing="0" cellpadding="0" summary="���� " style="border-collapse:collapse;">
				   		<thead>
					    <tr class="reshead" id="merRoomTitle">
						    <th scope="col">No.</th>
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
				</td>
			</tr>
			<TR>
			      <TD class=hcihead colspan="6" style="text-align:center">
			        <input type="button" value=" �� �� " onclick="javascript:formSubmit();">
			        <input type="button" value=" ȡ �� " onclick="javascript:cancle();">
			      </TD>
			</TR>
		    </TBODY> 
		  </TABLE>
		</div>
  </form>
 <br>
 <br>
 <br>
<script type="text/javascript">
function cancle()
{
	window.location.href="<c:url value="/commons/newBlank.jsp"/>";
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
	if(roomSearchNum == "" ) {
		alert("�����뷿��");
		form1.roomSearchNum.select();
		return;
	}
	searchEmptyCleanRoom(roomSearchNum);
}
//+---------------------------------------------------
//| ͨ��ajax��ȡ�վ�����Ϣ
//+---------------------------------------------------
function searchEmptyCleanRoom(roomSearchNum)
{
	var merId = document.getElementById("mer.id").value;
	var contractualUnitId = document.getElementById("contractualUnitId").value;
	htmlobj=$.ajax({
	    url: encodeURI("<c:url value="/checkIn/searchRoom"/>?randValue=" + getRandom()),
	    data: "roomSearchNum="+roomSearchNum+"&mer.id="+ merId +"&contractualUnitId="+contractualUnitId,
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
					roomTrStr += '<td align="center" style="border-bottom:1px solid #e1e1e1;height:28px;padding-left:6px;"><input type="radio" name="ids" onclick="selectCheckInRoom(this,' + i + ')" value="'+ i + ';' + jsonData[i]["roomId"] + ';' + jsonData[i]["roomNo"] + ';' + jsonData[i]["bedId"] + ';' + jsonData[i]["bedNo"] + '">' + (i+1)  + '</td>';
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
 </body>
</html>