package com.myframework.views;

public class View {

	protected String prefix;
	protected String suffix;
	
	public View() {
		// TODO Auto-generated constructor stub
	}

	public View(String prefix, String suffix) {
		super();
		this.prefix = prefix;
		this.suffix = suffix;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	
}
