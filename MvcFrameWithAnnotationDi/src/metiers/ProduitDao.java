package metiers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.framework.di.Component;
@Component(name="ProduitDao")
public class ProduitDao implements IProduitDao {
	EntityManagerFactory entityManagerFactory;
	private EntityManager em;

	public ProduitDao() {
		// TODO Auto-generated constructor stub
		entityManagerFactory = Persistence.createEntityManagerFactory("UP_CAT");
		em = entityManagerFactory.createEntityManager();
	}

	@Override
	public void addProduit(Produit p) {
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		try {
			em.persist(p);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

	}

	@Override
	public List<Produit> listProduits() {
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		try {
			return em.createQuery("select p from Produit p").getResultList();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public List<Produit> produitsParMC(String mc) {
		try {
			return em.createQuery("select p from Produit p where p.designation like %:x%").setParameter("x", mc)
					.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Produit getProduit(Long idProduit) {

		return em.find(Produit.class, idProduit);
	}

	@Override
	public void updateProduit(Produit p) {
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		try {
			em.merge(p);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}

	@Override
	public void deleteProduit(Long idP) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		try {
			Produit p=getProduit(idP);
			em.remove(p);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}

}
