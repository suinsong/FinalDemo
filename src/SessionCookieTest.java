

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sc")
public class SessionCookieTest extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���� ��Ű: ������ ĳ�ø޸𸮿� ���� 
		
		String id="bit";
		
		
		// ȸ�� �α����� �����ߴٰ� ����..
		
		Cookie c= new Cookie("id",id);
		c.setMaxAge(-1); //������Ű===>���ӽð��� ���� ��Ű
		response.addCookie(c);
		
		PrintWriter out = response.getWriter();
		out.print("set cookie~");
		
		
	}

}
