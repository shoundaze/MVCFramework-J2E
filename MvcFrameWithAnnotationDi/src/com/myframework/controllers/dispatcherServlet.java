package com.myframework.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.ControllerEventListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import com.framework.di.AnnotationApplicationContext;
import com.google.gson.Gson;
import com.myframework.views.View;
import com.myframework.views.ViewResolver;

import controllers.MyController;

@WebServlet("/pages/*")
public class dispatcherServlet extends HttpServlet implements Dispatcher{
	AnnotationApplicationContext app;
	AnnotationApplicationContext frame;
	private String controllerName;
	private String actionName;
	private ControllerAction ca;
	Object resView = "";
	private View view;

	public dispatcherServlet() {
		super();

	}

	
	public void defaultSalutaions(HttpServletRequest req,HttpServletResponse response) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/frame_template/hello.jsp").forward(req, response);;
		
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		// System.out.println(getServletContext().);
		app = new AnnotationApplicationContext("com.myframework.controllers", "com.myframework.views", "controllers",
				"metiers");
		ViewResolver vResolver = (ViewResolver) app.getBean("vr");
		view = vResolver.propretiesView(getServletContext());

	}

	 public Object executeAction(Controller ct, String action) {
		Class objectClass = ct.getClass();
		Method method;
		Object vue = "";
		try {

			method = objectClass.getMethod(action);

			vue = method.invoke(ct);

		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			log(e.getMessage());

			vue = "frame_error";
			view.setPrefix("frame_template");
			view.setSuffix(".html");

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vue;
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI().substring(request.getContextPath().length());
		if(!url.equals("/pages/")) {
		ca = new ControllerAction(url);
		controllerName = ca.getController();
		actionName = ca.getAction();

		Controller ct = (Controller) app.getBean(controllerName);

		ct.request = request;
		ct.response = response;

		resView = executeAction(ct, actionName);

		if (resView instanceof String) {
			String viewS = (String) resView;
			if (!viewS.startsWith("redirect:/")) {
				Map<String, String[]> map = request.getParameterMap();
				setAttributesModel(request, ct);
				String forward = "/WEB-INF/" + view.getPrefix() + "/" + viewS + "" + view.getSuffix();

				request.getRequestDispatcher(forward).forward(request, response);
			}

			else {
				viewS = viewS.substring(9);
				System.out.println(resView);
				response.sendRedirect(".." + viewS);

			}
		}

		else {

			Gson g = new Gson();
			String json = g.toJson(resView);
			response.addHeader("Access-Control-Allow-Origin","*");
			PrintWriter pr=response.getWriter();
			
			pr.write(json);
		}}
		
		
		else {
			
			defaultSalutaions(request,response);
		}

	}

	public void setAttributesModel(HttpServletRequest request, Controller ct) {
		Iterator i = ct.model.keySet().iterator();
		String cle = null;
		Object valeur = null;
		while (i.hasNext()) {
			cle = (String) i.next();
			valeur = ct.model.get(cle);
			request.setAttribute(cle, valeur);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
