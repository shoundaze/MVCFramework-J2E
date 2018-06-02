package com.myframework.controllers;

public class ControllerAction {

	private String[] actionController = new String[2];
	private String action;
	private String controller;

	public ControllerAction(String path) {
		// TODO Auto-generated constructor stub
		System.out.println("the path is"+path);
		actionController = path.split("/");
		
		action = actionController[3];
		controller = actionController[2];
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

}
