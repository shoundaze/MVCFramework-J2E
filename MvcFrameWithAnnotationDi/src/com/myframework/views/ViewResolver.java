package com.myframework.views;

import javax.servlet.ServletContext;

public interface ViewResolver {

	public View propretiesView(ServletContext servletContext);
	
}
