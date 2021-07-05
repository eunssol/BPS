package spms.controls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spms.bind.DataBinding;
import spms.dao.MemberDao;
import spms.vo.Member;
@Component("/member/update.do")
public class MemberUpdateController implements Controller,DataBinding {
	@Autowired
	MemberDao dao;
//	 public MemberUpdateController setMemberDao (MemberDao dao) {
//		this.dao=dao;
//		return this;
//	}
	 public Object[] getDataBinders() {
		 return new Object[] {
			"no",Integer.class,"member",spms.vo.Member.class };
	 }

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Member member = (Member)model.get("member");
		if(member.getEmail() == null) {
		      member = dao.selectOne(member.getNo());
		      model.put("member", member);
		      return "/member/MemberUpdateForm.jsp";
			
		}else {
			
			Member m = (Member)model.get("member");
			dao.update(m);
			return "redirect:list.do";
		}
	}

}
