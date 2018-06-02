package com.myframework.controllers;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
public class DispatcherFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURI().substring(req.getContextPath().length());
		
		if (path.startsWith("/WEB-INF/")) {
		    // Just let container's default servlet do its job.
			request.getRequestDispatcher(path).forward(request, response);
		} else if (path.startsWith("/static")){
			
			request.getRequestDispatcher("/WEB-INF"+path).forward(request, response);
		    
		}
		else {
			
			request.getRequestDispatcher("/pages/"+path).forward(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
