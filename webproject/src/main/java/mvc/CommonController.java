package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommonController {
	String process(HttpServletRequest req, HttpServletResponse res);
}
