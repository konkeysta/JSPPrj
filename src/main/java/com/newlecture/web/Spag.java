package com.newlecture.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;
		String num_ = request.getParameter("n");
		if(num_ != null && !num_.equals(""))
			num = Integer.parseInt(num_);
		String result = "";

		if(num%2 != 0)
			result = "홀수";
		else
			result = "짝수";
		
		request.setAttribute("result", result); // request 저장소
		
		String[] names = {"newlec", "dragon"};
		
		request.setAttribute("names", names);
		//redirect: 새로운 요청을 하게 만듬
		//forward: 현재 작업한 내용을 이어갈 수 있도록 함
		RequestDispatcher dispatcher = request.getRequestDispatcher("spag.jsp"); // 요청 전달
		dispatcher.forward(request, response);
	}

}
