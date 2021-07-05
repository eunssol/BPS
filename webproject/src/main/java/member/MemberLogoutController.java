package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.CommonController;

public class MemberLogoutController implements CommonController {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().invalidate();
		return "redirect:/webproject/index.do";
	}

}
