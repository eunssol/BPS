package board;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.JdbcUtil;
import mvc.CommonController;

public class BoardEditController implements CommonController {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		try {
			Connection conn = JdbcUtil.getConnection();
			BoardDAO dao = BoardDAO.getInstance();
			int boardno = Integer.parseInt (req.getParameter("boardno"));
			BoardVO vo = dao.selectOne(conn, boardno);
			req.setAttribute("vo", vo);
		}catch (Exception e) {
		}
		
		return "/board/edit.jsp";
	}

}
