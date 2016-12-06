package com.phoenix.hiddenplace.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final String LOGIN = "login";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
				System.out.println("pre핸들");
		if(session.getAttribute(LOGIN) != null) {
			System.out.println("세션에서 login 속성을 삭제함.");
			session.removeAttribute(LOGIN);
		}
		
		return true;
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object user = modelMap.get("user");
		
		if(user != null) {
			System.out.println("세션에 login 속성을 생성함.");
			session.setAttribute(LOGIN, user);
			response.sendRedirect("/board/list");
		}
		
	}

}