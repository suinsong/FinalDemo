

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ��Ű ����
		Cookie c = new Cookie("id","XXXX");
		c.setMaxAge(0);
		response.addCookie(c);
		
		response.sendRedirect("display3.jsp");
		

		
	}

}
