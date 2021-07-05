package spms.servlets;


import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import spms.bind.DataBinding;
import spms.bind.servletRequestDataBinder;
import spms.controls.Controller;
import spms.listeners.ContextLoaderListener;
@SuppressWarnings("serial")
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		res.setContentType("text/html; charset=utf-8");
		String servletPath =  req.getServletPath();
		try {
			//ServletContext sc = this.getServletContext();
			ApplicationContext ctx = ContextLoaderListener.getApplicationContext();
			
			HashMap<String,Object> model = new HashMap<String,Object>();
			model.put("session", req.getSession());
//			Controller pageController = (Controller)sc.getAttribute(servletPath);
			Controller pageController = (Controller)ctx.getBean(servletPath);
			if(pageController == null) {
				throw new Exception("요청한 서비를 찾을 수 없습니다.");
			}
			
			if(pageController instanceof DataBinding) {
				preapareRequestData(req,model,(DataBinding)pageController);
			}
			
			String viewUrl = pageController.execute(model);
			
			for(String key : model.keySet()) {
				req.setAttribute(key, model.get(key));
			}
			if(viewUrl.startsWith("redirect:")) {
				res.sendRedirect(viewUrl.substring(9));
				return;
			}else {
				RequestDispatcher rd = req.getRequestDispatcher(viewUrl);
				rd.include(req, res);
			}
		}catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, res);
		}
	}
		


	private void preapareRequestData(HttpServletRequest req, HashMap<String, Object> model,
			DataBinding dataBinding) throws Exception {
		Object[] dataBinders = dataBinding.getDataBinders();
		String dataName = null;
		Class<?> dataType = null;
		Object dataObj = null;
		for(int i = 0 ; i<dataBinders.length; i+=2) {
			dataName =(String)dataBinders[i];
			dataType = (Class<?>)dataBinders[i+1];
			dataObj = servletRequestDataBinder.bind(req,dataType,dataName);
			model.put(dataName,dataObj);	
		} 
	}
}

