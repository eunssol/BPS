package mvc;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerWithURI extends HttpServlet {

	// 매핑객체 저장 <"boardList", BoardListController>
	Map<String, CommonController> map = new HashMap<String, CommonController>();

	public void init() throws ServletException {
		String file = getInitParameter("file"); // /WEB-INF/command.properties
		file = getServletContext().getRealPath(file); // D:/java/workspace/web/src/main/webapp/WEB-INF/command.properties
		System.out.println(file);
		Properties prop = new Properties();
		try (FileReader fr = new FileReader(file)) {
			prop.load(fr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Set keyset = prop.keySet();
		Iterator iter = keyset.iterator();
		while (iter.hasNext()) {
			String cmd = (String) iter.next();
			String className = prop.getProperty(cmd);
			try {
				Class className2 = Class.forName(className);
				CommonController command = (CommonController) className2.newInstance();
				map.put(cmd, command);
			} catch (Exception e) {
			}
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req, res);
	}

	void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//System.out.println(req.getRequestURI().replace(req.getContextPath(), ""));
		// /web/controller.do -> /controller.do
		// /web2/board/list.do -> /board/list.do
		
		// URI패턴으로 처리
		String cmd = req.getRequestURI().replace(req.getContextPath(), "");
		CommonController command = map.get(cmd);

		// 로직처리 후 뷰를 리턴
		String view = command.process(req, res);

		// 리다이렉트인지 포워드인지 체크
		if (view.startsWith("redirect:")) {
			res.sendRedirect(view.substring(9));
		} else {
			// jsp로 포워딩
			RequestDispatcher disp = req.getRequestDispatcher(view);
			disp.forward(req, res); // 실제포워딩
		}
	}
}
