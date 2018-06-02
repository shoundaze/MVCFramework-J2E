package com.myframework.controllers;

import java.util.List;

import com.framework.di.Autowired;
import com.framework.di.Component;
import com.myframework.controllers.Controller;


import metiers.IProduitDao;
import metiers.Produit;
@Component(name="DController")
public class DController extends Controller{
	
	

	
	
	public Object index() {

		return "test";
	}
	







}
