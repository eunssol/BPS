package board;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.JdbcUtil;
import mvc.CommonController;

public class BoardInsertController implements CommonController {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
			// 파라미터 받기
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String view= "";
			// 아이디, 비밀번호, 이름 값 확인
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
				dao.insert(conn, vo);
				view = "redirect:/webproject/board/index.do";
			} else {
				// 회원가입버튼을 눌렀지만
				// 아이디,비밀번호,이름을 입력안했거나, 아이디가 중복된경우
				req.setAttribute("msg", msg);
				view = "/board/write.jsp";
			}
		
		return view;
	}

}
