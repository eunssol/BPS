package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.CommonController;

public class MainController implements CommonController {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return "/main.jsp";
	}

}
