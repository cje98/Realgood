package com.kh.realgood.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.realgood.member.model.service.MemberService;


@WebServlet("/member/idDupCheck.do")
public class idDupCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public idDupCheckController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			int result = new MemberService().idDupCheck(id);
			
			// 중복 체크 결과 및 아이디를 다음 응답 화면으로 위임
			request.setAttribute("result", result);
			
			RequestDispatcher view = request.getRequestDispatcher("idDupForm.do");
			view.forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
