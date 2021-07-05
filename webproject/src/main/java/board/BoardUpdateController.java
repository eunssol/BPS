package board;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.JdbcUtil;
import mvc.CommonController;

public class BoardUpdateController implements CommonController {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		int boardno = Integer.parseInt(req.getParameter("boardno"));
		String view= "";
		Map<String, String> msg = new HashMap<String, String>();
		boolean isInsert = true;
		if ("".equals(title)) {
			msg.put("titleMsg", "제목을 입력해주세요");
			isInsert=false;
		}
		if ("".equals(content)) {
			msg.put("contentMsg", "내용을 입력해 주세요.");
			isInsert=false;
		}
		
		BoardDAO dao = BoardDAO.getInstance();
		Connection conn = null;
		try { conn=JdbcUtil.getConnection(); } catch(Exception e) {}
		
		// 등록
		if (isInsert) {
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setBoardno(boardno);
			dao.update(conn, vo);
			view = "redirect:/webproject/board/index.do";
		} else {
			//req.setAttribute("msg", msg);
			view = "redirect:/webproject/board/edit.do?boardno="+boardno;
		}
	
	return view;
}

}


