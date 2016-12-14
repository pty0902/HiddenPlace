package com.phoenix.hiddenplace.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();
		System.out.println("LoginInterceptor 불러옴 preHandle ");

		if (session.getAttribute("login") != null) {
			System.out.println("세션에서 login 속성을 삭제함.");
			session.removeAttribute("login");
		}

		return true;

	}

}