
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.mem.MemberVO;

@WebServlet("/ct")
public class CookieTest extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. String data
		String data = "bitcocom";

		// 2. Object data
		MemberVO vo = new MemberVO(1, "���浿", 20, "bit@hanmail.net", "�Ұ�");

		// view page�� ������ ����(display.jsp) :3~5����
		// 1. forward������� (��û �Ƿ��� ������������ ���¸� ������)
		//request.setAttribute("data", data);
		//RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
		//rd.forward(request, response);

		// 2. Q) display.jsp, display2.jsp�� ���� ������ �� �ִ� �����?????
		// �ڡڡ���Ű��� �ڡڡ�

		Cookie c = new Cookie("data", data); // cookie�� ����

		// ��ȿ�Ⱓ�� ����
		c.setMaxAge(60 * 60 * 24); // �� �� �ð� ===24�ð���ȿ�Ⱓ====>������Ű
		// c.setMaxAge(-1); //�� �� �ð� ====>������Ű
		// c.setMaxAge(0); //�� �� �ð� ====>��Ű ����

		response.addCookie(c);
		PrintWriter out = response.getWriter();
		out.print("set cookie~");

	}

}
