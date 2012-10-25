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

			// ������ס�Ǽ���Ϣ
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
<div align="center">�Ǽǳɹ�</div>
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
			      <TD colSpan="8">��������ס�Ǽ���ϸ��</TD>
			    </TR>
		     <THEAD> 
		    <TBODY> 
				<tr>
					<td colspan="8"><p>�Ǽ��ÿ���Ϣ:	</p>	</td>
				</tr>
				<tr>
					<td class="hcihead"   width="8%">����</td>
					<td class=hcicontent  width="17%"><c:out value="${checkIn.custName}"/></td>
					<td class="hcihead"   width="8%">�Ա�</td>
					<td class=hcicontent  width="17%"><c:out value="${checkIn.sex}"/></td>
					<td class="hcihead"   width="8%">��ϵ�绰</td>
					<td class=hcicontent  width="17%"><c:out value="${checkIn.phone}"/></td>
					<td class="hcihead"   width="8%">��ַ</td>
					<td class=hcicontent  width="17%"  title="<c:out value="${checkIn.address}"/>"><script language="javascript">writeSubString('<c:out value="${checkIn.address}"/>',15)</script></td>
				</tr>
				<tr>
					<td class="hcihead">֤������</td>
					<td class=hcicontent><c:out value="${checkIn.idType}"/></td>
					<td class="hcihead">֤������</td>
					<td class=hcicontent ><c:out value="${checkIn.idNo}"/></td>
					<td class="hcihead">����</td>
					<td class=hcicontent ><c:out value="${checkIn.peopleNum}"/></td>
					<td class="hcihead">���ȯ</td>
					<td class=hcicontent ><c:out value="${checkIn.breakfastTicket}"/></td>
				</tr>
				<tr>
					<td class="hcihead">��ס����</td>
					<td class=hcicontent ><fmt:formatDate   value="${checkIn.arrivalDate}" pattern="yyyy-MM-dd HH:mm" /></td>
					<td class="hcihead">Ԥ���������</td>
					<td class=hcicontent ><fmt:formatDate   value="${checkIn.planDepartureDate}" pattern="yyyy-MM-dd HH:mm" /></td>
					<td class="hcihead">��ס����</td>
					<td class=hcicontent ><c:out value="${checkIn.stayDays}"/></td>
					<td class="hcihead">��ס����</td>
					<td class=hcicontent><c:out value="${checkIn.stayType}"/></td>
				</tr>
				<tr>
					<td class="hcihead">���ʽ</td>
					<td class=hcicontent><c:out value="${checkIn.settleMode}"/></td>
					<td class="hcihead">Ԥ��Ѻ��</td>
					<td class=hcicontent ><fmt:formatNumber value="${checkIn.deposit}" type="currency" pattern="#####0.00"/></td>
					<td class="hcihead">�ÿ����</td>
					<td class=hcicontent ><c:out value="${checkIn.custType}"/></td>
					<td class="hcihead">ǩ�����˵�λ</td>
					<td class=hcicontent   title="<c:out value="${checkIn.contractualUnitName}"/>" ><script language="javascript">writeSubString('<c:out value="${checkIn.contractualUnitName}"/>',15)</script></td>
				</tr>
				<tr>
					<td class="hcihead">��ע</td>
					<td class=hcicontent  colspan="7">
						<pre><c:out value="${checkIn.remark}"/></pre>
					</td>
				</tr>
				
					<tr>
					<td colspan="8"><p>��ס�����б���Ϣ:</p></td>
				</tr>
				<tr>
					<td colspan="8">
						<table  id="custCheckInRoomList"  width="100%"  style="border-collapse:collapse;"  border="1" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td height="25" width="3%" align="center">No.</td>
								<td height="25" width="5%" align="center">����</td>
								<td height="25" width="5%" align="center">����</td>
								<td height="25" width="5%" align="center">����</td>
								<td height="25" width="5%" align="center">�ۿ�(��)</td>
								<td height="25" width="5%" align="center">�ۿۼ�</td>
								<td height="25" width="*" align="center">��ע</td>
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
				      	<input  type="button" name="update"  onclick="javascript:checkInEdit(<c:out value="${checkIn.id}"/>);"  value="�޸��ÿ���Ϣ" />&nbsp;&nbsp;
				      	<input  type="button" name="new"   onclick="javascript:newCheckIn();"  value="  ��  ��  �� " />&nbsp;&nbsp;
				      	<input  type="button" name="new"   onclick="javascript:guestListQuery();"  value="  �ÿ��б� " />
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
		jQuery�༭table�е�Ԫ���ֵ
		************************/
		var editHTML;
		var editText;
		function setEditHTML(value){
			editHTML='<input size="75" maxlength="50" type="text" value="'+value+'" />&nbsp;<input type="button" onclick="ok(this)" value=" �޸� " />&nbsp;<input type="button" onclick="cancel(this)" value=" ȡ�� " />';
		}
		
		//���¼�
		$(".editbox").each(function(){ //ȡ������classΪeditbox�Ķ���
			$(this).bind("dblclick",function(){ //�����˫���¼�
				editText = $(this).html(); //ȡ�ñ��Ԫ����ı�
				setEditHTML(editText); //��ʼ���ؼ�
				$(this).data("oldtxt",editText) //����Ԫ��ԭ�ı��������仺���У����޸�ʧ�ܻ�ȡ��ʱ��
				.html(editHTML) //�ı䵥Ԫ������Ϊ�༭״̬
				.unbind("dblclick"); //ɾ����Ԫ��˫���¼���������˫��
			});
		});
		
		//ȡ��
		function cancel(cbtn){
			var $obj = $(cbtn).parent(); //'ȡ��'��ť����һ��������Ԫ��td
			$obj.html($obj.data("oldtxt")); //����Ԫ��������Ϊԭʼ���ݣ�ȡ���޸�
			$obj.bind("dblclick",function(){ //���°󶨵�Ԫ��˫���¼�
				editText = $(this).html();
				setEditHTML(editText);
				$(this).data("oldtxt",editText)
				.html(editHTML).unbind("dblclick");
			});
		}
		
		//�޸�
		function ok(obtn){
			var $obj = $(obtn).parent(); //'�޸�'��ť����һ��������Ԫ��td
			var id = $obj.parent().attr("id").replace("tr_",""); //ȡ�ø������ݵ�ID������ID����tr��
			var value = $obj.find("input:text")[0].value; //ȡ���ı����ֵ����������
			
			if (value.length>50) {
				alert('�������ܳ���50���ַ����������ַ�����');
				$obj.find("input:text")[0].select();
				return false;
			}
			form1.custCheckInRoomId.value = id;
			form1.custCheckInRoomRemark.value = value;
		
			//AJAX �޸�����
			htmlobj=$.ajax({
				url:"<c:url value="/custCheckInRoom/updateRemarkAjax"/>?&randValue=" + getRandom(),
			    data: encodeURI(encodeURI("checkInId="+form1.checkInId.value+"&custCheckInRoomId="+id+"&custCheckInRoomRemark="+ value)),   //����Ҫ�Ĳ���,���ε���encodeURI ,���Ǳ�������
				type: "POST",
				async:false,  // ͬ������
				processData: true,
				dataType: "html",
				success: function(data) {},
				error:function(e){}
			});
			//�ɹ�
			if(htmlobj.responseText == "true"){
				$obj.data("oldtxt",value); //���ô˵�Ԫ�񻺴�Ϊ������
				cancel(obtn); //����'ȡ��'�������ڴ�Ӧ��'ȡ��'��ť��ȥ������'ȡ��'�¼���û����'ȡ��'��ť�������,�õ�ֻ��������һ������td,���ڴ�ֱ����'�޸�'��ť���
			} 
			//ʧ��
			else{
				alert("error");
				cancel(obtn);
			}
		}
		</script>
 </BODY>
 </HTML>