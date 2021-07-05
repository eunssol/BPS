package member;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.JdbcUtil;
import mvc.CommonController;

public class MemberEditController implements CommonController {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		String view = "";
		if (req.getMethod().equals("GET")) {
			MemberVO vo = (MemberVO)(req.getSession().getAttribute("loginInfo"));
			if (vo == null) { // 로그인안된상태
				view = "redirect:/webproject/index.do";
			} else { // 로그인된상태
				view = "/member/editForm.jsp";
				
				try {
					MemberVO data = MemberDAO.getInstance().selectOne(
										JdbcUtil.getConnection(),
										vo.getMemberno()
									);
					req.setAttribute("data", data);
				} catch (Exception e) {}
			}
		} else if (req.getMethod().equals("POST")) {
			// 가입처리
			// 파라미터 받기
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			// 아이디, 비밀번호, 이름 값 확인
			Map<String, String> msg = new HashMap<String, String>();
			boolean isInsert = true;
			if ("".equals(pwd)) {
				msg.put("pwdMsg", "비밀번호를 입력해 주세요.");
				isInsert=false;
			}
			if ("".equals(name)) {
				msg.put("nameMsg", "이름을 입력해 주세요.");
				isInsert=false;
			}
			MemberDAO dao = MemberDAO.getInstance();
			Connection conn = null;
			try { conn=JdbcUtil.getConnection(); } catch(Exception e) {}
			// 등록
			if (isInsert) {
				MemberVO vo = new MemberVO();
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setMemberno(Integer.parseInt(req.getParameter("memberno")));
				dao.update(conn, vo);
				view = "redirect:/webproject/index.do";
			} else {
				try {
					MemberVO data = MemberDAO.getInstance().selectOne(
							JdbcUtil.getConnection(),
							Integer.parseInt(req.getParameter("memberno"))
						);
					req.setAttribute("data", data);
				}catch(Exception e) {}
				req.setAttribute("msg", msg);
				view = "/member/editForm.jsp";
			}
		}
		return view;
	}

}
