
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
		MemberVO vo = new MemberVO(1, "나길동", 20, "bit@hanmail.net", "소개");

		// view page로 데이터 전송(display.jsp) :3~5가지
		// 1. forward방법으로 (요청 의뢰한 페이지에서만 상태를 유지함)
		//request.setAttribute("data", data);
		//RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
		//rd.forward(request, response);

		// 2. Q) display.jsp, display2.jsp도 값을 가져갈 수 있는 방법은?????
		// ★★★쿠키기법 ★★★

		Cookie c = new Cookie("data", data); // cookie를 만듦

		// 유효기간이 있음
		c.setMaxAge(60 * 60 * 24); // 분 초 시간 ===24시간유효기간====>파일쿠키
		// c.setMaxAge(-1); //분 초 시간 ====>세션쿠키
		// c.setMaxAge(0); //분 초 시간 ====>쿠키 삭제

		response.addCookie(c);
		PrintWriter out = response.getWriter();
		out.print("set cookie~");

	}

}
