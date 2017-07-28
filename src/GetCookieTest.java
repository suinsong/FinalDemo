
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gc")
public class GetCookieTest extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ������� id��Ű ���� ������
		Cookie[] c = request.getCookies();
		
		String value=null;
		
		//�������� ��Ű�� ������ �ö� �ݺ����� �����!!!!!!
		
		for (int i = 0; i < c.length; i++) {
			String name=c[i].getName();
			if(name.equals("id")){
				value = c[i].getValue();
				break;
			}
			
			
		}
		PrintWriter out = response.getWriter();
		if(value!=null){
			out.println(value);
		}else{
			out.println("not cookie~~");
		}
		
	}

}
