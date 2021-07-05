package board;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.JdbcUtil;
import mvc.CommonController;

public class BoardListController implements CommonController {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			Connection conn = JdbcUtil.getConnection();
			BoardDAO dao = BoardDAO.getInstance();
			String searchWord = req.getParameter("searchWord");
			
			int totalCount=dao.count(conn,req.getParameter("searchWord"));
			int totalPage = totalCount/10;
			System.out.println(totalPage);
			if(totalCount % 10 >0)totalPage++;
			System.out.println(totalPage);
			
			int idx = 0;
			//page 파라미터로 (페이지번호-1)*페이지당갯수 
			int page = Integer.parseInt(req.getParameter("page")==null?"1":req.getParameter("page"));
			idx=(page-1)*10;
			List<BoardVO> list = dao.select(conn,searchWord,idx);
			req.setAttribute("list", list);
			System.out.println(totalPage);
			req.setAttribute("totalPage", totalPage);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "/board/list.jsp";
	}

}
