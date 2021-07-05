package member;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.JdbcUtil;
import mvc.CommonController;

public class MemberJoinController implements CommonController {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
	
		String view = "";
		// 가입폼(get), 가입처리(post)
		if (req.getMethod().equals("GET")) {
			// 가입폼
			view = "/member/joinForm.jsp";
		} else if (req.getMethod().equals("POST")) {
			// 가입처리
			// 파라미터 받기
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			// 아이디, 비밀번호, 이름 값 확인
			Map<String, String> msg = new HashMap<String, String>();
			boolean isInsert = true;
			if ("".equals(id)) {
				msg.put("idMsg", "아이디를 입력해 주세요.");
				isInsert=false;
			}
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
			// 아이디 중복확인
			if (dao.isDuplicateId(conn, id)) {
				msg.put("idDupMsg", "아이디가 중복되었습니다.");
				isInsert=false;
			}
			// 등록
			if (isInsert) {
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				dao.insert(conn, vo);
				view = "/member/joinSuccess.jsp";
			} else {
				// 회원가입버튼을 눌렀지만
				// 아이디,비밀번호,이름을 입력안했거나, 아이디가 중복된경우
				req.setAttribute("msg", msg);
				view = "/member/joinForm.jsp";
			}
		}
		return view;
	}

}
