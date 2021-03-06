package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pojo.BackendUser;

public class SysInterceptor extends HandlerInterceptorAdapter {
	private Logger logger = Logger.getLogger(SysInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request,
							HttpServletResponse response,
							Object handler) throws Exception{
		logger.debug("SysInterceptor preHandle!");
		HttpSession session = request.getSession();
		BackendUser backendUser = (BackendUser) session.getAttribute("backendUserSession");
		if(null == backendUser){
			response.sendRedirect(request.getContextPath() + "/403.jsp");
			return false;
		}
		return true;
	}
}
