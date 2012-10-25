<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ include file="/commons/taglibs.jsp" %>
<c:set var="checkIn"   value="${checkIn}"  scope="page"/>
<HTML>
<HEAD>
<%@ include file="/commons/meta.jsp" %>
		<style type=text/css>
			.sec1{
						background-color:#FFFFFF;
						cursor:hand;
						color:#000000;
						border-left:1px solid #FFFFFF;
						border-top:1px solid #FFFFFF;
						border-right:1px solid gray;
						border-bottom:1px solid #FFFFFF
					 }
			.sec2{
						background-color:#799ae1;
						cursor:hand;
						color:#000000;
						border-left:1px solid #FFFFFF;
						border-top:1px solid #FFFFFF;
						border-right:1px solid gray;
						border-weight:bold;
					 }
			html { 
				scrollbar-face-color: #d2e4f7;
				scrollbar-highlight-color: #f0f0f0;
				scrollbar-shadow-color: #d2e4f7;
				scrollbar-3dlight-color: #99bbe8;
				scrollbar-arrow-color: #15428b;
				scrollbar-track-color: #f0f0f0;
				scrollbar-darkshadow-color: #d2e4f7
			} 
			
			#foot{position:absolute; margin:0;bottom:0;left:2%;display:block;width:95%;height:70px;z-index:5;overflow:auto;}
			.footlefthead{width:48%;height:20px;float:left;border:0px;overflow:no;}
			.footrighthead{width:50%;height:20px;float:right;border:0px;overflow:no;}
			.footleft{width:48%;height:150px;float:left;border:1px #c0c0c0 solid;overflow:auto;}
			.footright{width:50%;height:150px;float:right;border:1px #c0c0c0 solid;overflow:auto;}
		</style>
		<script language="JavaScript" type="text/JavaScript">
            <!--
			function writeSubString(str,len){
		    	if (str.length > len) {
		    		document.writeln(str.substring(0,len)+'...');
		    	} else {
		    		document.writeln(str);
		        }
		    }
            function initTable() {
            	var tableIndex;
            		if(form1.custCheckInRoomIndex.value == null || form1.custCheckInRoomIndex.value == "") {
            			tableIndex = 0;
            		} else {
            			tableIndex = form1.custCheckInRoomIndex.value;
            		}
            	secBoard(tableIndex);
            }
			function secBoard(n){
				var nadd1 = parseInt(n)+1;
				var custCheckInRoomListObj = document.all("custCheckInRoomList");
				for(i=1;i<custCheckInRoomListObj.rows.length;i++){
					if (i==nadd1) {
						custCheckInRoomListObj.rows[i].className="sec2";
					} else {
						custCheckInRoomListObj.rows[i].className="sec1";
					}
				}
				var custCheckInRoomObj = document.all("custCheckInRoom");
				for(i=0;i<custCheckInRoomObj.tBodies.length;i++){
					custCheckInRoomObj.tBodies[i].style.display="none";
				}
				custCheckInRoomObj.tBodies[n].style.display="block";
				var custCheckInRoomObj1 = document.all("custCheckInRoom1");
				for(i=0;i<custCheckInRoomObj1.tBodies.length;i++){
					custCheckInRoomObj1.tBodies[i].style.display="none";
				}
				custCheckInRoomObj1.tBodies[n].style.display="block";
			}
			function window.onload(){
				initTable();
			}

			// 更新入住登记信息
			function checkInEdit(checkInId) {
				form1.action='<c:url value="/checkIn/edit/"/>' + checkInId;
				form2.target="_self";
				form1.submit();
			}
	
			//-->
		</script>
</HEAD>
<BODY>
<br>
<div align="center">登记成功</div>
          <br>
		  <div align="center">
		  <form name="form1" method=post action="<c:url value="/checkIn/create"/>" target="_self">
		  <input type="hidden" name="mer.id" value="<c:out value="${checkIn.mer.id}"/>">
		  <input type="hidden" name="custCheckInRoomIndex"    value="<c:out value="${param.custCheckInRoomIndex}"/>">
		  <input type="hidden" name="roomType.id" >
		  <input type="hidden" name="custCheckInRoomId">
		  <input type="hidden" name="custCheckInRoomRemark">
		  <input type="hidden" name="checkInId" value="<c:out value="${checkIn.id}"/>">
		  
		  <TABLE class="hci" border="1" bordercolordark="#ffffff" bordercolorlight="#eeeeee" cellpadding="3" cellspacing="0">
		   <THEAD> 
			    <TR class="hcititle"> 
			      <TD colSpan="8">【客人入住登记明细】</TD>
			    </TR>
		     <THEAD> 
		    <TBODY> 
				<tr>
					<td colspan="8"><p>登记旅客信息:	</p>	</td>
				</tr>
				<tr>
					<td class="hcihead"   width="8%">姓名</td>
					<td class=hcicontent  width="17%"><c:out value="${checkIn.custName}"/></td>
					<td class="hcihead"   width="8%">性别</td>
					<td class=hcicontent  width="17%"><c:out value="${checkIn.sex}"/></td>
					<td class="hcihead"   width="8%">联系电话</td>
					<td class=hcicontent  width="17%"><c:out value="${checkIn.phone}"/></td>
					<td class="hcihead"   width="8%">地址</td>
					<td class=hcicontent  width="17%"  title="<c:out value="${checkIn.address}"/>"><script language="javascript">writeSubString('<c:out value="${checkIn.address}"/>',15)</script></td>
				</tr>
				<tr>
					<td class="hcihead">证件类型</td>
					<td class=hcicontent><c:out value="${checkIn.idType}"/></td>
					<td class="hcihead">证件号码</td>
					<td class=hcicontent ><c:out value="${checkIn.idNo}"/></td>
					<td class="hcihead">人数</td>
					<td class=hcicontent ><c:out value="${checkIn.peopleNum}"/></td>
					<td class="hcihead">早餐券</td>
					<td class=hcicontent ><c:out value="${checkIn.breakfastTicket}"/></td>
				</tr>
				<tr>
					<td class="hcihead">入住日期</td>
					<td class=hcicontent ><fmt:formatDate   value="${checkIn.arrivalDate}" pattern="yyyy-MM-dd HH:mm" /></td>
					<td class="hcihead">预计离店日期</td>
					<td class=hcicontent ><fmt:formatDate   value="${checkIn.planDepartureDate}" pattern="yyyy-MM-dd HH:mm" /></td>
					<td class="hcihead">入住天数</td>
					<td class=hcicontent ><c:out value="${checkIn.stayDays}"/></td>
					<td class="hcihead">入住类型</td>
					<td class=hcicontent><c:out value="${checkIn.stayType}"/></td>
				</tr>
				<tr>
					<td class="hcihead">付款方式</td>
					<td class=hcicontent><c:out value="${checkIn.settleMode}"/></td>
					<td class="hcihead">预付押金</td>
					<td class=hcicontent ><fmt:formatNumber value="${checkIn.deposit}" type="currency" pattern="#####0.00"/></td>
					<td class="hcihead">旅客类别</td>
					<td class=hcicontent ><c:out value="${checkIn.custType}"/></td>
					<td class="hcihead">签单挂账单位</td>
					<td class=hcicontent   title="<c:out value="${checkIn.contractualUnitName}"/>" ><script language="javascript">writeSubString('<c:out value="${checkIn.contractualUnitName}"/>',15)</script></td>
				</tr>
				<tr>
					<td class="hcihead">备注</td>
					<td class=hcicontent  colspan="7">
						<pre><c:out value="${checkIn.remark}"/></pre>
					</td>
				</tr>
				
					<tr>
					<td colspan="8"><p>入住房间列表信息:</p></td>
				</tr>
				<tr>
					<td colspan="8">
						<table  id="custCheckInRoomList"  width="100%"  style="border-collapse:collapse;"  border="1" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td height="25" width="3%" align="center">No.</td>
								<td height="25" width="5%" align="center">房号</td>
								<td height="25" width="5%" align="center">床号</td>
								<td height="25" width="5%" align="center">房价</td>
								<td height="25" width="5%" align="center">折扣(折)</td>
								<td height="25" width="5%" align="center">折扣价</td>
								<td height="25" width="*" align="center">备注</td>
				    		</tr>
							<c:forEach var="rs" items="${checkIn.custCheckInRooms}" varStatus="vStatus">
								<tr onclick="secBoard(<c:out value="${vStatus.index}"/>)" id="tr_<c:out value="${rs.id}"/>">
									<td height="24" align="center" valign="middle" nowrap><c:out value="${vStatus.index+1}"/></td>
									<td height="24" align="center" valign="middle" nowrap><c:out value="${rs.roomNo}"/></td>
									<td height="24" align="center" valign="middle" nowrap><c:out value="${rs.bedNo}"/></td>
									<td height="24" align="center" valign="middle" nowrap><c:out value="${rs.registPrice}"/></td>
									<td height="24" align="center" valign="middle" nowrap><c:out value="${rs.discount}"/></td>
									<td height="24" align="center" valign="middle" nowrap><c:out value="${rs.amount}"/></td>
									<td height="24" align="left" valign="middle" class="editbox"><c:out value="${rs.remark}"/></td>
					    		</tr>
					    	</c:forEach>
						</table>
					</td>
				</tr>
				<tr>
				      <td height="28" class=hcihead colspan="8" style="text-align:center">
				      	<input  type="button" name="update"  onclick="javascript:checkInEdit(<c:out value="${checkIn.id}"/>);"  value="修改旅客信息" />&nbsp;&nbsp;
				      	<input  type="button" name="new"   onclick="javascript:newCheckIn();"  value="  新  登  记 " />&nbsp;&nbsp;
				      	<input  type="button" name="new"   onclick="javascript:guestListQuery();"  value="  旅客列表 " />
				      </td>
				</tr>
		    </TBODY>
		  </TABLE>
		  </form>
		</div>
		<script type="text/javascript">
			function newCheckIn()
			{
				window.location.href="<c:url value="/checkIn/new"/>";
			}
				function guestListQuery()
			{
				window.location.href="<c:url value="/guestList/query"/>";
			}
		</script>
		<script type="text/javascript">
		/************************
		jQuery编辑table中单元格的值
		************************/
		var editHTML;
		var editText;
		function setEditHTML(value){
			editHTML='<input size="75" maxlength="50" type="text" value="'+value+'" />&nbsp;<input type="button" onclick="ok(this)" value=" 修改 " />&nbsp;<input type="button" onclick="cancel(this)" value=" 取消 " />';
		}
		
		//绑定事件
		$(".editbox").each(function(){ //取得所有class为editbox的对像
			$(this).bind("dblclick",function(){ //给其绑定双击事件
				editText = $(this).html(); //取得表格单元格的文本
				setEditHTML(editText); //初始化控件
				$(this).data("oldtxt",editText) //将单元格原文本保存在其缓存中，便修改失败或取消时用
				.html(editHTML) //改变单元格内容为编辑状态
				.unbind("dblclick"); //删除单元格双击事件，避免多次双击
			});
		});
		
		//取消
		function cancel(cbtn){
			var $obj = $(cbtn).parent(); //'取消'按钮的上一级，即单元格td
			$obj.html($obj.data("oldtxt")); //将单元格内容设为原始数据，取消修改
			$obj.bind("dblclick",function(){ //重新绑定单元格双击事件
				editText = $(this).html();
				setEditHTML(editText);
				$(this).data("oldtxt",editText)
				.html(editHTML).unbind("dblclick");
			});
		}
		
		//修改
		function ok(obtn){
			var $obj = $(obtn).parent(); //'修改'按钮的上一级，即单元格td
			var id = $obj.parent().attr("id").replace("tr_",""); //取得该行数据的ID，此例ID绑定在tr中
			var value = $obj.find("input:text")[0].value; //取得文本框的值，即新数据
			
			if (value.length>50) {
				alert('字数不能超过50个字符，请缩减字符数！');
				$obj.find("input:text")[0].select();
				return false;
			}
			form1.custCheckInRoomId.value = id;
			form1.custCheckInRoomRemark.value = value;
		
			//AJAX 修改数据
			htmlobj=$.ajax({
				url:"<c:url value="/custCheckInRoom/updateRemarkAjax"/>?&randValue=" + getRandom(),
			    data: encodeURI(encodeURI("checkInId="+form1.checkInId.value+"&custCheckInRoomId="+id+"&custCheckInRoomRemark="+ value)),   //最重要的部分,两次调用encodeURI ,就是编码两次
				type: "POST",
				async:false,  // 同步请求
				processData: true,
				dataType: "html",
				success: function(data) {},
				error:function(e){}
			});
			//成功
			if(htmlobj.responseText == "true"){
				$obj.data("oldtxt",value); //设置此单元格缓存为新数据
				cancel(obtn); //调用'取消'方法，在此应传'取消'按钮过去，但在'取消'事件中没有用'取消'按钮这个对象,用的只是它的上一级，即td,固在此直接用'修改'按钮替代
			} 
			//失败
			else{
				alert("error");
				cancel(obtn);
			}
		}
		</script>
 </BODY>
 </HTML>