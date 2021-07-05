package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.JdbcUtil;
import mvc.CommonController;

public class MemberLoginController implements CommonController {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		String view = "";
		if (req.getMethod().equals("GET")) {
			view = "/member/loginForm.jsp";
		} else if (req.getMethod().equals("POST")) {
			// 로그인체크
			try {
				MemberVO vo = MemberDAO.getInstance().login(
														JdbcUtil.getConnection(), 
														req.getParameter("id"), 
														req.getParameter("pwd"));
				if (vo == null) { // 로그인 실패
					view = "/member/loginForm.jsp";
					req.setAttribute("msg", "아이디와 비밀번호를 확인해주세요.");
				} else { // 로그인 성공
					// 세션객체
					HttpSession sess = req.getSession();
					sess.setAttribute("loginInfo", vo);
					view = "redirect:/webproject/index.do";
				}
			} catch(Exception e) {}
		}
		return view;
	}

}
