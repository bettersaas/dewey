package com.dewey.his.reservation.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dewey.his.common.model.Mer;
import com.dewey.his.reception.model.CheckIn;
import com.dewey.his.reception.model.CustCheckInRoom;
import com.dewey.his.reception.service.CheckInManager;
import common.base.constant.VOConstantList;
import common.base.controller.BaseController;
import common.base.model.vo.PagerVO;
import common.poi.PoiExcelServletUtil;

@Controller
@RequestMapping("/reserveList")
public class ReserveListController extends BaseController<CheckIn, Long> {
	
	private CheckInManager checkInManager;

	public void setCheckInManager(CheckInManager checkInManager) {
		this.checkInManager = checkInManager;
	}
	
	/**
	 * PAGE视图
	 */
	private final String LIST_PAGE_VIEW          = "/reservation/list";           // 列表页面
	
	private final String CHECK_IN_OBJ_MODEL = "checkIn";
	
	/**
	 * 进入旅客查询页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/query")
	public ModelAndView query(HttpServletRequest request) {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		ModelAndView model = new ModelAndView();
		CheckIn checkIn  = new CheckIn();
		checkIn.setMer(mer);
		model.addObject(CHECK_IN_OBJ_MODEL, checkIn);
		model.addAllObjects(VOConstantList.getCheckInStatusListModelMap());
		model.setViewName(LIST_PAGE_VIEW);
		return model;
	}
	
	/**
	 * 旅客查询结果显示页面
	 * @param request
	 * @param roomTypeId
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView index(HttpServletRequest request,
			@RequestParam(value="custName",required=false) String custName,
			@RequestParam(value="idNo",required=false) String idNo,
			@RequestParam(value="lcdStart",required=false) String lcdStartStr,
			@RequestParam(value="lcdEnd",required=false) String lcdEndStr,
			@RequestParam(value="status",required=false) String status,
			@RequestParam(value="roomNoSearch",required=false) String roomNo,
			@RequestParam(value="contractualUnitName",required=false) String contractualUnitName,
			@RequestParam(value="planDepartureDateStart",required=false) String planDepartureDateStartStr,
			@RequestParam(value="planDepartureDateEnd",required=false) String planDepartureDateEndStr,
			@RequestParam(value="pageSize") String pageSize,
			@RequestParam(value="pageNo") String pageNo
			) {
		// 分页信息处理
		Integer pageNoInt;
		Integer pageSizeInt;
		if (pageSize == null || "".equals(pageSize.trim())) {
			pageSizeInt = 10;
		} else {
			pageSizeInt = Integer.parseInt(pageSize);
		}
		if (pageNo == null || "".equals(pageNo.trim())) {
			pageNoInt = 1;
		} else {
			pageNoInt = Integer.parseInt(pageNo);
		}
		PagerVO pager = new PagerVO(pageNoInt, pageSizeInt);
		
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		
		// 登记时间的解析
		Date lcdStart = formatDate(lcdStartStr);
		Date lcdEnd = formatDate(lcdEndStr);
		
		// 预计离店时间
		Date planDepartureDateStart = formatDate(planDepartureDateStartStr);
		Date planDepartureDateEnd = formatDate(planDepartureDateEndStr);
		
		List<CustCheckInRoom> list = checkInManager.findCustCheckInRoomPagerListBySearch(pager, mer.getId(), custName, idNo, lcdStart, lcdEnd, status, roomNo, contractualUnitName, planDepartureDateStart, planDepartureDateEnd);
		ModelAndView model = new ModelAndView();
		
		// 转码，因为checkIn的对象可能前后同一个，前面转码后面再转码就置为空
		long preLongId = 0L;
		for (CustCheckInRoom room  : list) {
			CheckIn checkIn = room.getCheckIn();
			// 排除同一个类进行多次转码
			if (preLongId != checkIn.getId()) {
				Map<String, String> sex = VOConstantList.getCheckInSexMap();
				checkIn.setSex(sex.get(checkIn.getSex()));
				Map<String, String> idType = VOConstantList.getCheckInIdTypeMap();
				checkIn.setIdType(idType.get(checkIn.getIdType()));
				Map<String, String> stayType = VOConstantList.getCheckInStayTypeMap();
				checkIn.setStayType(stayType.get(checkIn.getStayType()));
				Map<String, String> settleModel = VOConstantList.getCheckInSettleModeMap();
				checkIn.setSettleMode(settleModel.get(checkIn.getSettleMode()));
				Map<String, String> custType = VOConstantList.getCheckInCustTypeMap();
				checkIn.setCustType(custType.get(checkIn.getCustType()));
				Map<String, String> checkInStatus = VOConstantList.getCheckInStatusMap();
				checkIn.setStatus(checkInStatus.get(checkIn.getStatus()));
				preLongId = checkIn.getId();
			}
		}
		model.addObject("pageList", list);  // 旅客入住列表分页信息
		model.addObject("pager", pager);
		model.addAllObjects(VOConstantList.getCheckInStatusListModelMap());
		model.setViewName(LIST_PAGE_VIEW);
		return model;
	}
	
	/**
	 * 旅客查询结果显示页面
	 * @param request
	 * @param roomTypeId
	 * @return
	 */
	@RequestMapping(value = "/list1")
	public ModelAndView index1(HttpServletRequest request,
			@RequestParam(value="custName",required=false) String custName,
			@RequestParam(value="idNo",required=false) String idNo,
			@RequestParam(value="lcdStart",required=false) String lcdStartStr,
			@RequestParam(value="lcdEnd",required=false) String lcdEndStr,
			@RequestParam(value="status",required=false) String status,
			@RequestParam(value="roomNoSearch",required=false) String roomNo,
			@RequestParam(value="contractualUnitName",required=false) String contractualUnitName,
			@RequestParam(value="planDepartureDateStart",required=false) String planDepartureDateStartStr,
			@RequestParam(value="planDepartureDateEnd",required=false) String planDepartureDateEndStr,
			@RequestParam(value="pageSize") String pageSize,
			@RequestParam(value="pageNo") String pageNo
			) {
		// 分页信息处理
		Integer pageNoInt;
		Integer pageSizeInt;
		if (pageSize == null || "".equals(pageSize.trim())) {
			pageSizeInt = 10;
		} else {
			pageSizeInt = Integer.parseInt(pageSize);
		}
		if (pageNo == null || "".equals(pageNo.trim())) {
			pageNoInt = 1;
		} else {
			pageNoInt = Integer.parseInt(pageNo);
		}
		PagerVO pager = new PagerVO(pageNoInt, pageSizeInt);
		
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		
		// 登记时间的解析
		Date lcdStart = formatDate(lcdStartStr);
		Date lcdEnd = formatDate(lcdEndStr);
		
		// 预计离店时间
		Date planDepartureDateStart = formatDate(planDepartureDateStartStr);
		Date planDepartureDateEnd = formatDate(planDepartureDateEndStr);
		
		List<CheckIn> list = checkInManager.findCheckInPagerListBySearch(pager, mer.getId(), custName, idNo, lcdStart, lcdEnd, status, roomNo, contractualUnitName, planDepartureDateStart, planDepartureDateEnd);
		ModelAndView model = new ModelAndView();
		
		// 转码，因为checkIn的对象可能前后同一个，前面转码后面再转码就置为空
		long preLongId = 0L;
		for (CheckIn checkIn : list) {
			// 排除同一个类进行多次转码
			if (preLongId != checkIn.getId()) {
				Map<String, String> sex = VOConstantList.getCheckInSexMap();
				checkIn.setSex(sex.get(checkIn.getSex()));
				Map<String, String> idType = VOConstantList.getCheckInIdTypeMap();
				checkIn.setIdType(idType.get(checkIn.getIdType()));
				Map<String, String> stayType = VOConstantList.getCheckInStayTypeMap();
				checkIn.setStayType(stayType.get(checkIn.getStayType()));
				Map<String, String> settleModel = VOConstantList.getCheckInSettleModeMap();
				checkIn.setSettleMode(settleModel.get(checkIn.getSettleMode()));
				Map<String, String> custType = VOConstantList.getCheckInCustTypeMap();
				checkIn.setCustType(custType.get(checkIn.getCustType()));
				Map<String, String> checkInStatus = VOConstantList.getCheckInStatusMap();
				checkIn.setStatus(checkInStatus.get(checkIn.getStatus()));
				preLongId = checkIn.getId();
			}
		}
		model.addObject("pageList", list);  // 旅客入住列表分页信息
		model.addObject("pager", pager);
		model.addAllObjects(VOConstantList.getCheckInStatusListModelMap());
		//model.setViewName("/reception/guestList/list1");
		model.setViewName(LIST_PAGE_VIEW);
		return model;
	}
	
	/** 
	 * 旅客列表查询导出 
	 * @throws Exception 
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/listExp")
	public String listExp(HttpServletRequest request, HttpServletResponse response,
		@RequestParam(value="custName",required=false) String custName,
		@RequestParam(value="idNo",required=false) String idNo,
		@RequestParam(value="lcdStart",required=false) String lcdStartStr,
		@RequestParam(value="lcdEnd",required=false) String lcdEndStr,
		@RequestParam(value="status",required=false) String status,
		@RequestParam(value="roomNoSearch",required=false) String roomNo,
		@RequestParam(value="contractualUnitName",required=false) String contractualUnitName,
		@RequestParam(value="planDepartureDateStart",required=false) String planDepartureDateStartStr,
		@RequestParam(value="planDepartureDateEnd",required=false) String planDepartureDateEndStr) throws Exception {
		
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		
		// 登记时间的解析
		Date lcdStart = formatDate(lcdStartStr);
		Date lcdEnd = formatDate(lcdEndStr);
		
		// 预计离店时间
		Date planDepartureDateStart = formatDate(planDepartureDateStartStr);
		Date planDepartureDateEnd = formatDate(planDepartureDateEndStr);
		
		List<CustCheckInRoom> list = checkInManager.findCustCheckInRoomListBySearch(mer.getId(), custName, idNo, lcdStart, lcdEnd, status, roomNo, contractualUnitName, planDepartureDateStart, planDepartureDateEnd);
		
		String fileName = "旅客查询列表报表.xls";
		// 导出Excel
		PoiExcelServletUtil ps = new PoiExcelServletUtil();
		ps.initWorkBook();
		ps.createSheet(0, "旅客查询列表");
		ps.createRow(0, 15);
		ps.setCell(0, "序号",ps.getTitleStyle());
		ps.setCell(1, "姓名",ps.getTitleStyle());
		ps.setCell(2, "性别",ps.getTitleStyle());
		ps.setCell(3, "登记时间",ps.getTitleStyle());
		ps.setCell(4, "预计离店时间",ps.getTitleStyle());
		ps.setCell(5, "房型",ps.getTitleStyle());
		ps.setCell(6, "人数",ps.getTitleStyle());
		ps.setCell(7, "房价",ps.getTitleStyle());
		ps.setCell(8, "折扣",ps.getTitleStyle());
		ps.setCell(9, "折扣价",ps.getTitleStyle());
		ps.setCell(10, "房号",ps.getTitleStyle());
		ps.setCell(11, "床号",ps.getTitleStyle());
		ps.setCell(12, "协议单位",ps.getTitleStyle());
		ps.setCell(13, "联系电话",ps.getTitleStyle());
		ps.setCell(14, "入住类型",ps.getTitleStyle());
		ps.setCell(15, "状态",ps.getTitleStyle());
		long preLongId = 0L;
		for (int i = 0; i< list.size(); i++ ) {
			CustCheckInRoom custCheckInRoom = list.get(i);
			CheckIn checkIn = custCheckInRoom.getCheckIn();
			// 排除同一个类进行多次转码
			if (preLongId != checkIn.getId()) {
				// 转码，因为checkIn的对象可能前后同一个，前面转码后面再转码就置为空
				Map<String, String> sex = VOConstantList.getCheckInSexMap();
				checkIn.setSex(sex.get(checkIn.getSex()));
				Map<String, String> idType = VOConstantList.getCheckInIdTypeMap();
				checkIn.setIdType(idType.get(checkIn.getIdType()));
				Map<String, String> stayType = VOConstantList.getCheckInStayTypeMap();
				checkIn.setStayType(stayType.get(checkIn.getStayType()));
				Map<String, String> settleModel = VOConstantList.getCheckInSettleModeMap();
				checkIn.setSettleMode(settleModel.get(checkIn.getSettleMode()));
				Map<String, String> custType = VOConstantList.getCheckInCustTypeMap();
				checkIn.setCustType(custType.get(checkIn.getCustType()));
				Map<String, String> checkInStatus = VOConstantList.getCheckInStatusMap();
				checkIn.setStatus(checkInStatus.get(checkIn.getStatus()));
				preLongId = checkIn.getId();
			}
			// 内容行
			ps.createRow((i+1), 13);
			ps.setCell(0, (i+1), ps.getContentStyle());
			ps.setCell(1, checkIn.getCustName()==null?"":checkIn.getCustName(), ps.getContentStyle());
			ps.setCell(2, checkIn.getSex()==null?"":checkIn.getSex(), ps.getContentStyle());
			ps.setCell(3, checkIn.getLcd(), ps.getContentStyle());                            // yyyy-MM-dd HH:mm
			ps.setCell(4, checkIn.getPlanDepartureDate(), ps.getContentStyle()); // yyyy-MM-dd HH:mm
			ps.setCell(5, checkIn.getRoomType().getName()==null?"":checkIn.getRoomType().getName(), ps.getContentStyle());
			ps.setCell(6, checkIn.getPeopleNum(), ps.getContentStyle());
			ps.setCell(7, custCheckInRoom.getRegistPrice(), ps.getContentStyle());
			ps.setCell(8, custCheckInRoom.getDiscount(), ps.getContentStyle());
			ps.setCell(9, custCheckInRoom.getAmount(), ps.getContentStyle());
			ps.setCell(10, custCheckInRoom.getRoomNo()==null?"":custCheckInRoom.getRoomNo(), ps.getContentStyle());
			ps.setCell(11, custCheckInRoom.getBedNo()==null?"":custCheckInRoom.getBedNo(), ps.getContentStyle());
			ps.setCell(12, checkIn.getContractualUnitName()==null?"":checkIn.getContractualUnitName(), ps.getContentStyle());
			ps.setCell(13, checkIn.getPhone()==null?"":checkIn.getPhone(), ps.getContentStyle());
			ps.setCell(14, checkIn.getStayType()==null?"":checkIn.getStayType(), ps.getContentStyle());
			ps.setCell(15, checkIn.getStatus()==null?"":checkIn.getStatus(), ps.getContentStyle());
		}
		
		// 序列化字节流
		// InputStreamSerializable iss = new InputStreamSerializable(is);
		// return new  ModelAndView("downPoolReportFile","contentStream",iss.getInStream());
		request.setAttribute("fileName", fileName);
		request.setAttribute("contentStream", ps.exportServletInputStream());
		return "forward:/downloadExpFile";
	}
	
	/**
	 * 将查询传入的日期字符串转换为日期类型
	 * @param dateStr
	 * @return
	 */
	private Date formatDate(String dateStr) {
		Date date = null;
		if (dateStr != null && !"".equals(dateStr.trim())){
			String formatStr = null;
			if(dateStr.trim().length()==16) {
				formatStr = "yyyy-MM-dd HH:mm";
			} else if (dateStr.trim().length()==10) {
				formatStr = "yyyy-MM-dd";
			} else {
				formatStr = "yyyy-MM-dd HH:mm:ss";
			}
			try {
				date = new SimpleDateFormat(formatStr).parse(dateStr.trim());
			} catch (ParseException e) {
			}
		}
		return date;
	}
}