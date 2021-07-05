package spms.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spms.bind.DataBinding;
import spms.dao.MemberDao;
import spms.vo.Member;
@Component("/auth/login.do")
public class LoginController implements Controller, DataBinding {
	@Autowired
	MemberDao dao;
//	 public LoginController setMemberDao (MemberDao dao) {
//		this.dao=dao;
//		return this;
//	}
	 public Object[] getDataBinders() {
		 return new Object[] {
			"member",spms.vo.Member.class };
	 }

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Member member = (Member)model.get("member"); 
		if(member.getEmail() == null) {
			return "../auth/LogInForm.jsp";
			
		}else {
			
			Member m = (Member)model.get("member");
				HttpSession session = (HttpSession)model.get("session");
				session.setAttribute("member", dao.exist(m.getEmail(),m.getPassword()));
				
			
			return "redirect:../member/list.do";
		}
	}

}
