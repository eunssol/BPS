package spms.controls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spms.bind.DataBinding;
import spms.dao.MemberDao;
@Component("/member/delete.do")
public class MemberDeleteController implements Controller,DataBinding {
	@Autowired
	MemberDao dao;
//	 public MemberDeleteController setMemberDao (MemberDao dao) {
//		this.dao=dao;
//		return this;
//	}
	 public Object[] getDataBinders() {
		 return new Object[] {
			"no",Integer.class };
	 }

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		
		
	    model.put("member", dao.delete((Integer)model.get("no")));
			return "redirect:list.do";
		}
	}


