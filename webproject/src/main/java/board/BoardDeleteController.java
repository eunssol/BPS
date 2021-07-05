package board;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.JdbcUtil;
import member.MemberDAO;
import member.MemberVO;
import mvc.CommonController;

public class BoardDeleteController implements CommonController {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		try {
		Connection conn = JdbcUtil.getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = new BoardVO();
		vo.setBoardno(Integer.parseInt(req.getParameter("boardno")));
		dao.delete(conn, vo);
		}catch (Exception e) {}
		return "redirect:/webproject/board/index.do";
	}

}
