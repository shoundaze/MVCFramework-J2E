package com.myframework.controllers;

import java.util.LinkedHashMap;

import com.framework.di.Component;
@Component(name="model")
public class Model extends LinkedHashMap<String, Object> implements IModel{

	public Model addAttribute(String s,Object o) {
		super.put(s, o);
		return this;
	}
	
}
