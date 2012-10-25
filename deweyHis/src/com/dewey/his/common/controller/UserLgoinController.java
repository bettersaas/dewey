package com.dewey.his.common.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dewey.his.common.model.FunctionVO;
import com.dewey.his.common.model.Mer;
import com.dewey.his.common.service.MerUserLoginManager;
import com.dewey.his.common.util.Constant;
import com.dewey.his.sys.model.MerRole;
import com.dewey.his.sys.model.MerUser;
import com.dewey.his.sys.model.MerUserLog;
import com.dewey.his.sys.service.MerRoleManager;
import common.base.controller.BaseController;
import common.util.json.JsonBinder;

@Controller
// @SessionAttributes("MER")    @ModelAttribute("MER") Mer mer
public class UserLgoinController extends BaseController<MerUser, Long> {

	private Logger logger = Logger.getLogger(UserLgoinController.class);

	//@Autowired
	private MerUserLoginManager merUserLoginManager;

	public void setMerUserLoginManager(MerUserLoginManager merUserLoginManager) {
		this.merUserLoginManager = merUserLoginManager;
	}
	
	private MerRoleManager merRoleManager;

	public void setMerRoleManager(MerRoleManager merRoleManager) {
		this.merRoleManager = merRoleManager;
	}

	/**
	 * 用户登录
	 * 
	 * @param request
	 * @param response
	 * @param loginName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login")
	public String login(//@ModelAttribute(SessionUtils.SESSION_USER_INFO) SessionUser sessionUser, SessionStatus status,
			HttpServletRequest request, HttpServletResponse response, 
			@RequestParam(value="deweyNo", required=false) String deweyNo,
			@RequestParam(value="loginName", required=false) String loginName, 
			@RequestParam(value="password", required=false) String password, 
			@RequestParam(value="checkCode", required=false) String checkCode) throws Exception {
		
		// Session的建立
		HttpSession session = request.getSession();

		// 已登录的情况
		MerUser sessionUser = (MerUser) session.getAttribute("MER_USER");
		if (sessionUser != null && sessionUser.getLoginName() != null) {
			// 登录页面进来
			if (loginName != null && password != null) {
				// 相同用户再次登录，session并没失效，返回到登录的页面
				if (loginName.equals(sessionUser.getLoginName()) && password.equals(sessionUser.getPassword())) {
					return "forward:/pages/index.jsp";
				} else {
					// 非当前session用户成功登录
					session.invalidate();
					session = request.getSession();
				}
			} else {
				// 非登录页面过来
				return "forward:/pages/index.jsp";
			}
		}

		// 未登录缺少登录信息则返回登录首页
		if (loginName == null || "".equals(loginName.trim()) || password == null || "".equals(password.trim())) {
			return "forward:/login.jsp";
		}
		
		// 获取session验证码
		String randCheckCode = (String) session.getAttribute("RAND_CHECK_CODE");
		if (checkCode == null || randCheckCode == null || !checkCode.equals(randCheckCode)) {
			request.setAttribute("message", "校验码错误！");
			return "forward:/login.jsp";
		}
		
		
		/*
		 * 平台管理登陆控制
		*/
		if ("dewey".equals(deweyNo.trim())&&"administrator".equals(loginName.trim()) && "1a2s3d4f5g".equals(password.trim())) {
			Mer  mer1 = new Mer();
			mer1.setDeweyNo("dewey");
			mer1.setId(999999l);
			MerUser user1 = new MerUser();
			user1.setChineseName("administrator");
			user1.setId(12311L);
			user1.setLoginName("admin");
			user1.setMer(mer1);
			session.setAttribute("MER_USER", user1);
			session.setAttribute("MER", mer1);
			return "forward:/pages/platForm/list.jsp";// 平台管理-商户列表
		}
		 
		// 通过用户名查询用户信息
		Object[]  oa = merUserLoginManager.getUserMerByUserName(deweyNo, loginName);
		if (oa == null) {
			// 没有查找到用户和商户信息，返回登录页面,显示错误信息
			request.setAttribute("message", "用户和商户不存在！");
			return "forward:/login.jsp"; // 判断，将跳转不同的页面
		}
		MerUser user = (MerUser)oa[0];
		Mer  mer = (Mer)oa[1];
		
		// 用户名不存在
		if (user == null) {
			// 没有查找到用户，返回登录页面,显示错误信息
			request.setAttribute("message", "用户不存在！");
			return "forward:/login.jsp"; // 判断，将跳转不同的页面
		}
		
		// 查看用户是否是启用状态
		if (!"1".equals(user.getStatus())) {
			request.setAttribute("message", "用户还没启用！");
			return "forward:/login.jsp"; // 判断，将跳转不同的页面
		}
		
		// 用户角色是否为空
		if (user.getRole() == null || "".equals(user.getRole().trim())) {
			request.setAttribute("message", "用户还没权限使用系统！");
			return "forward:/login.jsp"; // 判断，将跳转不同的页面
		}
		
		// 登录用户端信息
		String ipAddress = request.getRemoteAddr();

		// 用户密码不对
		if (!password.equals(user.getPassword()) ) {
			// 密码输入错误，返回登录页面,显示错误信息
			request.setAttribute("message", "用户密码不对！");
			return "forward:/login.jsp";
		}
		
		// session保存用户信息
		session.setAttribute("MER_USER", user);
		session.setAttribute("MER", mer);
		
		// 记录用户登录日志
		MerUserLog merUserLog = new MerUserLog();
		merUserLog.setMerUserId(user.getId());
		merUserLog.setMerUseName(user.getChineseName());
		// 用户登录动作
		merUserLog.setOprType("1");
		merUserLog.setOprDate(new Timestamp(new Date().getTime()));
		merUserLoginManager.save(merUserLog);

		logger.info("用户[" + ipAddress + " : " + user.getLoginName() + "]登录成功了！");
		return "forward:/pages/index.jsp";
	}
	
	/**
	 * 左边菜单兼顾权限管理  
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/leftmenu")
	//@ResponseBody
	public String  leftMenuContent(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		// 从session中获得用户信息
		HttpSession session = request.getSession(false);
		MerUser  userinfo = (MerUser)session.getAttribute("MER_USER");
		// 用户所拥有的角色ID
		String userRole =  userinfo.getRole();
		// 用户所拥有的角色ID数组
		String rolses[] = userRole.split(",");
		// 功能ID数组
		Map<String, FunctionVO> functionsMap = Constant.createNewFunctionsMapConstant();
		// 获取挨个角色的信息
		for (String role : rolses) {
			MerRole roleObject = merRoleManager.getById(Long.valueOf(role));
			// 角色设置时
			String readwrite = roleObject.getReadwrite();
			if (readwrite != null && !"".equals(readwrite.trim())) {
				// 功能列表
				String[] functionArray = readwrite.trim().split(",");
				// 用户设置的角色功能为选择状态
				for (String function : functionArray) {
					if (function != null && !"".equals(function.trim())) {
						FunctionVO functionVO = functionsMap.get(function.trim());
						if (functionVO != null)
							functionVO.setChecked("1");
					}
				}
			}
		}
		
		// 删除掉没有的选择的功能
		Constant.removeNoCheckedFunctionsMap(functionsMap);
		
		// 给页面写JSON字符串
		JsonBinder jsonBinder = JsonBinder.buildNonDefaultBinder();
		String jsonString = jsonBinder.toJson(functionsMap.get("FM"));
		//jsonBinder.writeToPage(response.getOutputStream(), functionsMap.get("FM"));
		// 用户的功能树
		model.addAttribute("menu", jsonString);
		// 用户的快捷功能列表
		model.addAttribute("quickMenu", Constant.getQuickMenuFunctionsMap(functionsMap));
		return "forward:/pages/leftmenu.jsp";
	}

	/**
	 * 用户注销
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(@CookieValue("JSESSIONID") String sessionId, HttpServletRequest request, HttpServletResponse response) {

		logger.info("退出的用户JSESSIONID值为：" + sessionId);

		HttpSession session = request.getSession(false);
		try {
			if (session != null) {
				// 从session中获得用户信息
				MerUser  userinfo = (MerUser) session.getAttribute("MER_USER");
				if (userinfo.getLoginName() == null) {
					return "forward:/index.jsp";
				}

				session.invalidate();

				// 转到注销页面，以便页面有相关提醒信息显示
				return "forward:/logout.jsp"; // "redirect:/logout.jsp";
			}
		} catch (Exception e) {

		}
		return "forward:/pages/index.jsp";
	}
	
	/**
	 * 图片验证码的实现
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/checkCode.gif")
	public void checkCodeGif1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		//out.clear();//这句针对resin服务器，如果是tomacat可以不要这句
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		int width = 60, height = 20;
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);

		Graphics g = image.getGraphics();
		Random random = new Random();

		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);

		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		char c[] = new char[62];

		for (int i = 97, j = 0; i < 123; i++, j++) {
			c[j] = (char) i;
		}
		for (int o = 65, p = 26; o < 91; o++, p++) {
			c[p] = (char) o;
		}
		for (int m = 48, n = 52; m < 58; m++, n++) {
			c[n] = (char) m;
		}
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			int x = random.nextInt(62);
			String validate = String.valueOf(c[x]);
			sRand += validate;

			g.setColor(new Color(20 + random.nextInt(110), 20 + random
			.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(validate, 13 * i + 6, 16);
		}

		// 将生成的验证码保存到Session中
		HttpSession session = request.getSession(true);
		session.setAttribute("RAND_CHECK_CODE", sRand.toString());
		g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}
	
	/**
	 * @param s
	 * @param e
	 * @return
	 */
	public Color getRandColor(int s, int e) {
		Random random = new Random();
		if (s > 255)
			s = 255;
		if (e > 255)
			e = 255;
		int r = s + random.nextInt(e - s);
		int g = s + random.nextInt(e - s);
		int b = s + random.nextInt(e - s);
		return new Color(r, g, b);
	}
	
	/**
	 * 修改密码
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/chgPwd")
	public void chaPwd(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="loginName") String loginName,
			@RequestParam(value="oldPassword") String oldPassword,
			@RequestParam(value="newPassword1") String newPassword1,
			@RequestParam(value="newPassword2") String newPassword2) throws IOException {
		
		HttpSession session = request.getSession();
		Mer sessionMer = (Mer) session.getAttribute("MER");
		//MerUser sessionUser = (MerUser) session.getAttribute("MER_USER");

		String chgPasswordMessage = null;
		MerUser user = merUserLoginManager.getUserByUserName(sessionMer.getDeweyNo(), loginName);
		// 旧密码验证通过，可以修改密码
		if (user.getPassword().equals(oldPassword)) {
			if (merUserLoginManager.changeUserPassword(newPassword1,user.getId()) == 1) {
				chgPasswordMessage = "密码修改成功!";
				user.setPassword(newPassword1);
			} else {
				chgPasswordMessage = "密码修改失败，请联系系统管理员！!";
			}
		} else {
			chgPasswordMessage = "密码修改失败！  提示：原密码校验错误！!";
		}

		// 输出到页面
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>修改密码结果显示</title></head><body>" + chgPasswordMessage + "</body></html>");
		out.close();
	}
}