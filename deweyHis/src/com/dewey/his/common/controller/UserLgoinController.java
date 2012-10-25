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
	 * �û���¼
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
		
		// Session�Ľ���
		HttpSession session = request.getSession();

		// �ѵ�¼�����
		MerUser sessionUser = (MerUser) session.getAttribute("MER_USER");
		if (sessionUser != null && sessionUser.getLoginName() != null) {
			// ��¼ҳ�����
			if (loginName != null && password != null) {
				// ��ͬ�û��ٴε�¼��session��ûʧЧ�����ص���¼��ҳ��
				if (loginName.equals(sessionUser.getLoginName()) && password.equals(sessionUser.getPassword())) {
					return "forward:/pages/index.jsp";
				} else {
					// �ǵ�ǰsession�û��ɹ���¼
					session.invalidate();
					session = request.getSession();
				}
			} else {
				// �ǵ�¼ҳ�����
				return "forward:/pages/index.jsp";
			}
		}

		// δ��¼ȱ�ٵ�¼��Ϣ�򷵻ص�¼��ҳ
		if (loginName == null || "".equals(loginName.trim()) || password == null || "".equals(password.trim())) {
			return "forward:/login.jsp";
		}
		
		// ��ȡsession��֤��
		String randCheckCode = (String) session.getAttribute("RAND_CHECK_CODE");
		if (checkCode == null || randCheckCode == null || !checkCode.equals(randCheckCode)) {
			request.setAttribute("message", "У�������");
			return "forward:/login.jsp";
		}
		
		
		/*
		 * ƽ̨�����½����
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
			return "forward:/pages/platForm/list.jsp";// ƽ̨����-�̻��б�
		}
		 
		// ͨ���û�����ѯ�û���Ϣ
		Object[]  oa = merUserLoginManager.getUserMerByUserName(deweyNo, loginName);
		if (oa == null) {
			// û�в��ҵ��û����̻���Ϣ�����ص�¼ҳ��,��ʾ������Ϣ
			request.setAttribute("message", "�û����̻������ڣ�");
			return "forward:/login.jsp"; // �жϣ�����ת��ͬ��ҳ��
		}
		MerUser user = (MerUser)oa[0];
		Mer  mer = (Mer)oa[1];
		
		// �û���������
		if (user == null) {
			// û�в��ҵ��û������ص�¼ҳ��,��ʾ������Ϣ
			request.setAttribute("message", "�û������ڣ�");
			return "forward:/login.jsp"; // �жϣ�����ת��ͬ��ҳ��
		}
		
		// �鿴�û��Ƿ�������״̬
		if (!"1".equals(user.getStatus())) {
			request.setAttribute("message", "�û���û���ã�");
			return "forward:/login.jsp"; // �жϣ�����ת��ͬ��ҳ��
		}
		
		// �û���ɫ�Ƿ�Ϊ��
		if (user.getRole() == null || "".equals(user.getRole().trim())) {
			request.setAttribute("message", "�û���ûȨ��ʹ��ϵͳ��");
			return "forward:/login.jsp"; // �жϣ�����ת��ͬ��ҳ��
		}
		
		// ��¼�û�����Ϣ
		String ipAddress = request.getRemoteAddr();

		// �û����벻��
		if (!password.equals(user.getPassword()) ) {
			// ����������󣬷��ص�¼ҳ��,��ʾ������Ϣ
			request.setAttribute("message", "�û����벻�ԣ�");
			return "forward:/login.jsp";
		}
		
		// session�����û���Ϣ
		session.setAttribute("MER_USER", user);
		session.setAttribute("MER", mer);
		
		// ��¼�û���¼��־
		MerUserLog merUserLog = new MerUserLog();
		merUserLog.setMerUserId(user.getId());
		merUserLog.setMerUseName(user.getChineseName());
		// �û���¼����
		merUserLog.setOprType("1");
		merUserLog.setOprDate(new Timestamp(new Date().getTime()));
		merUserLoginManager.save(merUserLog);

		logger.info("�û�[" + ipAddress + " : " + user.getLoginName() + "]��¼�ɹ��ˣ�");
		return "forward:/pages/index.jsp";
	}
	
	/**
	 * ��߲˵����Ȩ�޹���  
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/leftmenu")
	//@ResponseBody
	public String  leftMenuContent(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		// ��session�л���û���Ϣ
		HttpSession session = request.getSession(false);
		MerUser  userinfo = (MerUser)session.getAttribute("MER_USER");
		// �û���ӵ�еĽ�ɫID
		String userRole =  userinfo.getRole();
		// �û���ӵ�еĽ�ɫID����
		String rolses[] = userRole.split(",");
		// ����ID����
		Map<String, FunctionVO> functionsMap = Constant.createNewFunctionsMapConstant();
		// ��ȡ������ɫ����Ϣ
		for (String role : rolses) {
			MerRole roleObject = merRoleManager.getById(Long.valueOf(role));
			// ��ɫ����ʱ
			String readwrite = roleObject.getReadwrite();
			if (readwrite != null && !"".equals(readwrite.trim())) {
				// �����б�
				String[] functionArray = readwrite.trim().split(",");
				// �û����õĽ�ɫ����Ϊѡ��״̬
				for (String function : functionArray) {
					if (function != null && !"".equals(function.trim())) {
						FunctionVO functionVO = functionsMap.get(function.trim());
						if (functionVO != null)
							functionVO.setChecked("1");
					}
				}
			}
		}
		
		// ɾ����û�е�ѡ��Ĺ���
		Constant.removeNoCheckedFunctionsMap(functionsMap);
		
		// ��ҳ��дJSON�ַ���
		JsonBinder jsonBinder = JsonBinder.buildNonDefaultBinder();
		String jsonString = jsonBinder.toJson(functionsMap.get("FM"));
		//jsonBinder.writeToPage(response.getOutputStream(), functionsMap.get("FM"));
		// �û��Ĺ�����
		model.addAttribute("menu", jsonString);
		// �û��Ŀ�ݹ����б�
		model.addAttribute("quickMenu", Constant.getQuickMenuFunctionsMap(functionsMap));
		return "forward:/pages/leftmenu.jsp";
	}

	/**
	 * �û�ע��
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(@CookieValue("JSESSIONID") String sessionId, HttpServletRequest request, HttpServletResponse response) {

		logger.info("�˳����û�JSESSIONIDֵΪ��" + sessionId);

		HttpSession session = request.getSession(false);
		try {
			if (session != null) {
				// ��session�л���û���Ϣ
				MerUser  userinfo = (MerUser) session.getAttribute("MER_USER");
				if (userinfo.getLoginName() == null) {
					return "forward:/index.jsp";
				}

				session.invalidate();

				// ת��ע��ҳ�棬�Ա�ҳ�������������Ϣ��ʾ
				return "forward:/logout.jsp"; // "redirect:/logout.jsp";
			}
		} catch (Exception e) {

		}
		return "forward:/pages/index.jsp";
	}
	
	/**
	 * ͼƬ��֤���ʵ��
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/checkCode.gif")
	public void checkCodeGif1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		//out.clear();//������resin�������������tomacat���Բ�Ҫ���
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

		// �����ɵ���֤�뱣�浽Session��
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
	 * �޸�����
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
		// ��������֤ͨ���������޸�����
		if (user.getPassword().equals(oldPassword)) {
			if (merUserLoginManager.changeUserPassword(newPassword1,user.getId()) == 1) {
				chgPasswordMessage = "�����޸ĳɹ�!";
				user.setPassword(newPassword1);
			} else {
				chgPasswordMessage = "�����޸�ʧ�ܣ�����ϵϵͳ����Ա��!";
			}
		} else {
			chgPasswordMessage = "�����޸�ʧ�ܣ�  ��ʾ��ԭ����У�����!";
		}

		// �����ҳ��
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>�޸���������ʾ</title></head><body>" + chgPasswordMessage + "</body></html>");
		out.close();
	}
}