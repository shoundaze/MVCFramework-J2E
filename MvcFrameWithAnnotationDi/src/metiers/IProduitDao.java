package metiers;

import java.util.List;

public interface IProduitDao {
	public void addProduit(Produit p);
	public List<Produit> listProduits();
	public List<Produit> produitsParMC(String mc);
	public Produit getProduit(Long idProduit);
	public void updateProduit(Produit p);
	public void deleteProduit(Long idP);
	
	
	
	
}
