
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.bit.mem.MemberVO;

@WebServlet("/ss.do")
public class SetSesstion extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ó�� ��û���� �ƴ��� �Ǵ�---->����� 32�ڸ��� ������ �ֳ� ����

		HttpSession session = request.getSession();
		System.out.println(session.getId());
		System.out.println(session.getCreationTime());
		System.out.println(session.getMaxInactiveInterval());
		
		MemberVO vo= new MemberVO(1,"�ڳ���",30,"nana@hanmail.net","�ڱ�Ұ��Դϴ�");
		session.setAttribute("vo", vo);

		// �ٸ� JSP���� �������� �ϰ� �ʹٸ�..?
		// display4.jsp
		// forward / redirect �� �� �����ɾ�

		// 1
		// response.sendRedirect("display4.jsp");

		// 2
		RequestDispatcher rd = request.getRequestDispatcher("display4.jsp");
		rd.forward(request, response);

	}

}
