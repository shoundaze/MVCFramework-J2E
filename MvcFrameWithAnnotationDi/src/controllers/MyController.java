package controllers;

import java.util.List;

import com.framework.di.Autowired;
import com.framework.di.Component;
import com.myframework.controllers.Controller;


import metiers.IProduitDao;
import metiers.Produit;
@Component(name="MyController")
public class MyController extends Controller{
	@Autowired(name="ProduitDao")
	public IProduitDao dao;
	

	
	
	public Object test() {

		return "test";
	}
	
public Object save() {
		
		Produit pr=new Produit(request.getParameter("designation"), Double.parseDouble(request.getParameter("prix")), Integer.parseInt(request.getParameter("qnatite")));
		System.out.println(dao);
		dao.addProduit(pr);
		model.addAttribute("produit",pr);
		return "confirmation";
	}

public Object liste() {
	List<Produit> produits=dao.listProduits();
	model.addAttribute("produits", produits);
	return "listeProduit";
}

public List<Produit> redirection() {
	response.setContentType("application/json;charset=UTF-8");
	List<Produit> produits=dao.listProduits();
	System.out.println("liste des produits" +produits);
	return produits;
}

public String supprimer() {
	Long id=Long.valueOf(request.getParameter("id"));
	dao.deleteProduit(id);
	return "redirect:/MyController/liste";
	
	
}






public void setDao(IProduitDao dao) {
	this.dao = dao;
}







}
