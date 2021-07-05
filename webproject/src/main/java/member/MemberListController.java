package member;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.JdbcUtil;
import mvc.CommonController;

public class MemberListController implements CommonController {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			Connection conn = JdbcUtil.getConnection();
			MemberDAO dao = MemberDAO.getInstance();
			List<MemberVO> list = dao.select(conn);
			req.setAttribute("list", list);
		}catch(Exception e) {
			
		}
		return "/member/list.jsp";
	}

}
