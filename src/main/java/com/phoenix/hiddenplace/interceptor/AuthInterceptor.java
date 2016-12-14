package com.phoenix.hiddenplace.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();

		if (session.getAttribute("login") == null) {

			System.out.println("현재 로그인 상태가 아닙니다.");

			saveDest(request);

			response.sendRedirect("/user/loginView");

			return false;
		}

		return true;
	}

	// 요청한 페이지의 url을 가져오는 메서드
	private void saveDest(HttpServletRequest request) {

		String method = request.getMethod();
		String uri = request.getRequestURI();
		String query = request.getQueryString();
		System.out.println("method : " + method);
		System.out.println("uri : " + uri);
		System.out.println("query : " + query);

		if (query == null || query.equals("null")) {
			query = "";
		} else {
			query = "/" + query;
		}

		// if (req.getMethod().equals("GET")) {
		// logger.info("dest: " + (uri + query));

		System.out.println("dest: " + (uri + query)); // - /user/mypageView
		request.getSession().setAttribute("dest", uri + query);
		// }
	}

}
