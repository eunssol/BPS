package spms.controls;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spms.bind.DataBinding;
import spms.dao.ProjectDao;
@Component("/project/delete.do")
public class ProjectDeleteController implements Controller, DataBinding {
	@Autowired
	ProjectDao projectdao;
//	public ProjectDeleteController setProjectDao(ProjectDao projectDao) {
//		this.projectdao = projectDao;
//		return this;
//	}
	@Override
	public Object[] getDataBinders() {
		return new Object[]{
				"no",Integer.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Integer no = (Integer)model.get("no");
		projectdao.delete(no);
		return "redirect:list.do";
	}

}
