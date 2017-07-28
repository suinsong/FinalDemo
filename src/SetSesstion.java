
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
		// 처음 요청인지 아닌지 판단---->헤더에 32자리의 세션이 있나 없나

		HttpSession session = request.getSession();
		System.out.println(session.getId());
		System.out.println(session.getCreationTime());
		System.out.println(session.getMaxInactiveInterval());
		
		MemberVO vo= new MemberVO(1,"박나래",30,"nana@hanmail.net","자기소개입니다");
		session.setAttribute("vo", vo);

		// 다른 JSP에서 가져가게 하고 싶다면..?
		// display4.jsp
		// forward / redirect 둘 ㄷ ㅏ가능쓰

		// 1
		// response.sendRedirect("display4.jsp");

		// 2
		RequestDispatcher rd = request.getRequestDispatcher("display4.jsp");
		rd.forward(request, response);

	}

}
