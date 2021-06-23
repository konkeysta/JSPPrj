package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc2 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		// 어플리케이션 저장소로 자원을 저장한다. (v_, op)

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String v_ = request.getParameter("v"); // 입력되는 값
		String op = request.getParameter("operator");

		int v = 0; // 값을 입력받지 않을 시 0으로 처리

		if (!v_.equals(""))
			v = Integer.parseInt(v_);

		if (op.equals("=")) {  // 계산

			int x = (Integer) application.getAttribute("value"); // 저장소에 저장된 값, Object 로 반환
			int y = v; // 사용자가 전달한 값
			String operator = (String) application.getAttribute("op"); // 저장소에 저장된 계산 값

			int result = 0;

			if (operator.equals("+")) {
				result = x + y;
			} else
				result = x - y;
	
			response.getWriter().printf("result is %d\n", result);

		} else { // 값을 저장
			application.setAttribute("value", v);
			application.setAttribute("op", op);
			// 컬렉션(Map) 처럼 이용
			

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

}
