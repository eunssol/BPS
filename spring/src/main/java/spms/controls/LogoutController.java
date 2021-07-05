package spms.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spms.dao.MemberDao;
@Component("/auth/logout.do")
public class LogoutController implements Controller {
	@Autowired
	MemberDao dao;
//	 public LogoutController setMemberDao (MemberDao dao) {
//		this.dao=dao;
//		return this;
//	}
	

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		session.invalidate();
		return "redirect:../member/list.do";
	}
}