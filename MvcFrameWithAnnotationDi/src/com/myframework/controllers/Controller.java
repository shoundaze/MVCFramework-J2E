package com.myframework.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.framework.di.AnnotationApplicationContext;
import com.framework.di.Autowired;
import com.framework.di.Component;
@Component(name="Controller")
public abstract class Controller {
	public HttpServletRequest request;
	public HttpServletResponse response;
	@Autowired(name="model")
	public Model model=null;
	private AnnotationApplicationContext frame;
	
	
	public Controller() {
		
		
	
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	
	
	
}
