package com.myframework.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Dispatcher {
	public Object executeAction(Controller ct, String action);
	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
	public void setAttributesModel(HttpServletRequest request, Controller ct);
}
