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
// form提交
function formSubmit()
{
	//<tr>
	//	<td height="30px" class=hcicontent colspan="6"><input type="radio" name="changeType"  value="0">换房后房价执行原房价&nbsp;&nbsp;<input type="radio" name="changeType"  value="1">换房后房价不一致</td>
	//</tr>
	//if(! (getRadioValue("changeType")[0]) ) {
	//	alert("请选择换房后的价格取向。") ;
	//	return false;
	//}
	
	var stayType = form1.stayType.value;
	
	// 清空已选客房信息
	$('#selectCheckInRooms').html("");
	// 已选择的进行顺序编号
	var selectInt = -1;
    $("input[name='ids']").each(function(){
    	// 选择
    	if (this.checked) {
    		selectInt += 1;
    		var arr = this.value.split(";");
    		var index = arr[0];        // tr中的索引
    		var roomId = arr[1];     // 房间ID
    		var roomNo = arr[2];   // 房号
    		var bedId = arr[3];       // 床位ID
    		var bedNo = arr[4];     // 床号
    		var discount = $("#discount" + index).val();          // 折扣比例
    		var amount =   $("#amount" + index).val();            // 折扣价格
    		var checkInType = $("#hireFlag" + index).val();    // 租房方式
			// 原价格
   			var amountPrice;
   			switch(stayType) {
				// 半天房
				case "1" :
					amountPrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(5)").text();
					break;
				// 全日房
				case '2':
					amountPrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(4)").text();
					break;
				// 钟点房
				case '3':
					amountPrice = ($("#emptyRoom tbody tr:eq(" + index + ") td:eq(6)").text().split("/"))[0];
					break;
				// 长包房
				case '4':
					amountPrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(4)").text();
					break;
   			}
   			// 没有折扣时，默认10折全价
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
			      <TD colSpan="6">【换房】</TD>
			</TR>
			<tr>
				<td class="hcihead">原客房</td>
				<td class=hcicontent colspan="5"><input type="text" name="oldRoomNo" readOnly value="<c:out value="${custCheckInRoom.roomNo}"/>" class="inputTextNoBorder"></td>
			</tr>
			<tr>
				<td class="hcihead" width="12%">客人姓名</td>
				<td class=hcicontent width="21%"><input type="text" name="travler" readOnly value="<c:out value="${checkIn.custName}"/>" class="inputTextNoBorder"></td>
				<td class="hcihead" width="12%">金额</td>
				<td class=hcicontent width="21%"><input type="text" name="oldRoomNoPrice" readOnly value="<c:out value="${custCheckInRoom.amount}"/>" class="inputTextNoBorder"></td>
				<td class="hcihead" width="12%">牌价</td>
				<td class=hcicontent width="21%"><input type="text" name="oldRoomNoRegPrice" readOnly value="<c:out value="${custCheckInRoom.registPrice}"/>" class="inputTextNoBorder"></td>
			</tr>
			<tr>
				<td height="30px" class=hcicontent colspan="6">
				房号:<input name="roomSearchNum" type="text" size="10" id="roomSearchNum" />&nbsp;<input name="goButton" type="button"  onclick="javascript:searchByRoomNo();"  value="搜索" />
				</td>
			</tr>
			<tr>
				<td height="30px" class=hcicontent colspan="6">
				    <table  id="emptyRoom" width="100%" border="1" cellspacing="0" cellpadding="0" summary="方法 " style="border-collapse:collapse;">
				   		<thead>
					    <tr class="reshead" id="merRoomTitle">
						    <th scope="col">No.</th>
						    <th scope="col">房型</th>
						    <th scope="col">房号</th>
						    <th scope="col">床号</th>
						    <th scope="col">全日房价</th>
						    <th scope="col">半日房价</th>
						    <th scope="col">钟点房价</th>
						    <th scope="col" width="30%">房间说明</th>
						    <th scope="col">折扣比例(/折)</th>
						    <th scope="col">折扣价格</th>
					    </tr>
					    </thead>
					    <tbody id="tbd">
								<tr  class="rescontent">
									<td colspan="10" align="center">请查询相应入住房型的空净房间。<br></td>
								</tr>
						</tbody>
				    </table>
				</td>
			</tr>
			<TR>
			      <TD class=hcihead colspan="6" style="text-align:center">
			        <input type="button" value=" 保 存 " onclick="javascript:formSubmit();">
			        <input type="button" value=" 取 消 " onclick="javascript:cancle();">
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
//| 选择入住房间
//| obj.checked      id:roomId
//+---------------------------------------------------
function selectCheckInRoom(obj,index)
{
	// 选择的房间
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
//| 房号查询空静房间
//+---------------------------------------------------
function searchByRoomNo()
{
	// 入住类型不能为空
	var stayType = form1.stayType.value;
	if(stayType=="") {
		window.alert("入住类型不能为空!") ;
		form1.stayType.focus();
		return;
	}
	var roomSearchNum = $.trim($("#roomSearchNum").val());
	if(roomSearchNum == "" ) {
		alert("请输入房号");
		form1.roomSearchNum.select();
		return;
	}
	searchEmptyCleanRoom(roomSearchNum);
}
//+---------------------------------------------------
//| 通过ajax获取空净房信息
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
		async:false,  // 同步请求
		timeout: 1000,
		error:function(xhr,error,exception) {
		    //解析JSON异常时或者ajax出错
			alert(exception.toString());
		},
		success:function(data, status, xhr){
			var roomTrStr='';
			// 删除tobody中的所有行
			$("#tbd tr").remove();
			// 报错误信息
			if(data.message != "") {
				// 页面显示查无空净房的提示信息  弹出提示信息alert(data.message);
				$("#tbd").append('<tr class="rescontent"><td colspan="9" align="center">' + data.message + '<br></td></tr>');
			} else {
				// 获取json中的客房信息
				var jsonData = data.merRooms;
				var roomTrStr = "";
				// 遍历每个房间信息，生成每行客房记录html字符串，并加入到空净客房的尾部
				for(var i=0;i<jsonData.length;i++){
					roomTrStr = '<tr>';
					roomTrStr += '<td align="center" style="border-bottom:1px solid #e1e1e1;height:28px;padding-left:6px;"><input type="radio" name="ids" onclick="selectCheckInRoom(this,' + i + ')" value="'+ i + ';' + jsonData[i]["roomId"] + ';' + jsonData[i]["roomNo"] + ';' + jsonData[i]["bedId"] + ';' + jsonData[i]["bedNo"] + '">' + (i+1)  + '</td>';
					roomTrStr += '<input type="hidden" name="hireFlag' + i + '"  id="hireFlag' + i + '"  value="' + jsonData[i]["hireFlag"] + '">';
					roomTrStr += '<td align="center">' + jsonData[i]["roomTypeName"] + '</td>';
					roomTrStr += '<td align="center">' + jsonData[i]["roomNo"] + '</td>';
					roomTrStr += '<td align="center">' + jsonData[i]["bedNo"] + '</td>';
					roomTrStr += '<td align="center">' + jsonData[i]["alldayPrice"] + '</td>';
					roomTrStr += '<td align="center">' + jsonData[i]["halfdayPrice"] + '</td>';
					roomTrStr += '<td align="center">' + jsonData[i]["hourPrice"] + '/'+ jsonData[i]["hourMeasure"]  + '小时</td>';
					roomTrStr += '<td align="center">' + jsonData[i]["roomDesc"] + '</td>';
					roomTrStr += '<td align="center"><input type="text" disabled name="discount' + i + '" id="discount' + i + '" onblur="discountInput(' + i + ');"  size="8" maxlength="5" class="inputTextNoBorder"></td>';
					roomTrStr += '<td align="center"><input type="text" disabled name="amount' + i + '"  id="amount' + i + '"  onblur="amountInput(' + i + ');" " size="8" maxlength="7" class="inputTextNoBorder"></td>';
					roomTrStr += '</tr>';
					$("#tbd").append(roomTrStr);
					// 设置入住类型相对应的房间价格
					selectCheckInType();
				}
				// 奇偶行不同颜色
				$("#emptyRoom tbody tr:odd").addClass("rescontent_");  // 索引奇数
				$("#emptyRoom tbody tr:even").addClass("rescontent");
				// 鼠标移动行变色
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
//| 入住类型的选择
//+---------------------------------------------------
function selectCheckInType()
{
	var stayTypeValue = document.getElementsByName("stayType")[0].value;
	// 根据不同的选择，只显示当前选择的入住类型价格
	switch(stayTypeValue){
		// 半天房
		case "1" :
			$("#emptyRoom tr").each(function(){$("td:eq(4)",this).hide()});   // 全日房
			$("#emptyRoom tr").each(function(){$("th:eq(4)",this).hide()});   // 全日房
			$("#emptyRoom tr").each(function(){$("td:eq(5)",this).show()}); // 半日房
			$("#emptyRoom tr").each(function(){$("th:eq(5)",this).show()});  // 半日房
			$("#emptyRoom tr").each(function(){$("td:eq(6)",this).hide()});   // 钟点房
			$("#emptyRoom tr").each(function(){$("th:eq(6)",this).hide()});   // 钟点房
			break;
		// 全日房
		case '2':
			$("#emptyRoom tr").each(function(){$("td:eq(4)",this).show()});  // 全日房
			$("#emptyRoom tr").each(function(){$("th:eq(4)",this).show()});  // 全日房
			$("#emptyRoom tr").each(function(){$("td:eq(5)",this).hide()});   // 半日房
			$("#emptyRoom tr").each(function(){$("th:eq(5)",this).hide()});   // 半日房
			$("#emptyRoom tr").each(function(){$("td:eq(6)",this).hide()});   // 钟点房
			$("#emptyRoom tr").each(function(){$("th:eq(6)",this).hide()});   // 钟点房
			break;
		// 钟点房
		case '3':
			$("#emptyRoom tr").each(function(){$("td:eq(4)",this).hide()});   // 全日房
			$("#emptyRoom tr").each(function(){$("th:eq(4)",this).hide()});    // 全日房
			$("#emptyRoom tr").each(function(){$("td:eq(5)",this).hide()});    // 半日房
			$("#emptyRoom tr").each(function(){$("th:eq(5)",this).hide()});    // 半日房
			$("#emptyRoom tr").each(function(){$("td:eq(6)",this).show()});  // 钟点房
			$("#emptyRoom tr").each(function(){$("th:eq(6)",this).show()});   // 钟点房
			break;
		// 长包房
		case '4':
			$("#emptyRoom tr").each(function(){$("td:eq(4)",this).show()});  // 全日房
			$("#emptyRoom tr").each(function(){$("th:eq(4)",this).show()});  // 全日房
			$("#emptyRoom tr").each(function(){$("td:eq(5)",this).hide()});   // 半日房
			$("#emptyRoom tr").each(function(){$("th:eq(5)",this).hide()});   // 半日房
			$("#emptyRoom tr").each(function(){$("td:eq(6)",this).hide()});   // 钟点房
			$("#emptyRoom tr").each(function(){$("th:eq(6)",this).hide()});   // 钟点房
			break;
		// 默认为空
		default : 
			$("#emptyRoom tr").each(function(){$("td:eq(4)",this).hide()});  // 全日房
			$("#emptyRoom tr").each(function(){$("th:eq(4)",this).hide()});  // 全日房
			$("#emptyRoom tr").each(function(){$("td:eq(5)",this).hide()});  // 半日房
			$("#emptyRoom tr").each(function(){$("th:eq(5)",this).hide()});  // 半日房
			$("#emptyRoom tr").each(function(){$("td:eq(6)",this).hide()});  // 钟点房
			$("#emptyRoom tr").each(function(){$("th:eq(6)",this).hide()});  // 钟点房
	}
	// 清空先前的折扣率和折扣价
	$("#emptyRoom tbody tr").each(function(index){
		$("#discount" + index).val("");
		$("#amount" + index).val("");
	});
}
//+---------------------------------------------------
//| 折扣的输入计算折扣价
//+---------------------------------------------------
function discountInput(index)
{
	$("#discount" + index).val($.trim($("#discount" + index).val()));
	var discount = $("#discount" + index).val();
	if (discount == "") {
		return;
	}
	if (!isDecimal(discount)) {
		alert("请输入正确的折扣率。");
		$("#discount" + index).select();
		return;
	}
	if (parseFloat(discount)>10 || parseFloat(discount)<0) {
		alert("请输入正确的折扣率。折扣率在0到10之间。");
		$("#discount" + index).select();
		return;
	}
	var stayTypeValue = document.getElementsByName("stayType")[0].value;
	var basePrice = "";
	// 根据不同的选择，选择需要打折扣的价格
	switch(stayTypeValue){
		// 半天房
		case "1" :
			basePrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(5)").text();
			break;
		// 全日房
		case '2':
			basePrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(4)").text();
			break;
		// 钟点房
		case '3':
			basePrice = ($("#emptyRoom tbody tr:eq(" + index + ") td:eq(6)").text().split("/"))[0];
			break;
		// 长包房
		case '4':
			basePrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(4)").text();
			break;
		// 默认为空
		default : 
			return;
	}
	$("#amount" + index).val(getRoundNumber(eval(basePrice + "*" + discount + "/10"),2));
}
//+---------------------------------------------------
//| 由折扣价格计算相应的折扣率进行回显
//+---------------------------------------------------
function amountInput(index)
{
	$("#amount" + index).val($.trim($("#amount" + index).val()));
	var amount = $("#amount" + index).val();
	if (amount == "") {
		return;
	}
	if (!isDecimal(amount)) {
		alert("请输入正确的折扣价。");
		$("#amount" + index).select();
		return;
	}
	var stayTypeValue = document.getElementsByName("stayType")[0].value;
	var basePrice = "";
	// 根据不同的选择，选择需要打折扣的价格
	switch(stayTypeValue){
		// 半天房
		case "1" :
			basePrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(5)").text();
			break;
		// 全日房
		case '2':
			basePrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(4)").text();
			break;
		// 钟点房
		case '3':
			basePrice = ($("#emptyRoom tbody tr:eq(" + index + ") td:eq(6)").text().split("/"))[0];
			break;
		// 长包房
		case '4':
			basePrice = $("#emptyRoom tbody tr:eq(" + index + ") td:eq(4)").text();
			break;
		// 默认为空
		default : 
			return;
	}
	$("#discount" + index).val(getRoundNumber(eval(amount + "*10/" + basePrice),2));
}
</script>
 </body>
</html>