package fr.dezaxe.pp1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.dezaxe.pp1.beans.IProduit;
import fr.dezaxe.pp1.beans.Produit;


public class ProduitDAOImpl implements ProduitDAO {
	private EntityManager em;
	
	public ProduitDAOImpl() {
	 em = NoteEntityManager.getInstance().getEntityManager();
	}

	@Override
	public List<IProduit> listProduit() {
		 Query query = em.createQuery("SELECT p FROM Produit p ");
		 @SuppressWarnings("unchecked")
		 List<IProduit> produits = query.getResultList();
		 return produits;
	}

	@Override
	public void supProduit(Integer id) {
		System.out.println("coucou 2");
		Produit produit = em.find(Produit.class, id);
		
		em.getTransaction().begin();
		em.remove(produit);
		em.getTransaction().commit();
		System.out.println("coucou 3");
	}

	@Override
	public void creerProduit(IProduit produit) {
		
		em.getTransaction().begin();
		em.persist(produit);
		em.getTransaction().commit();
		
	}
	
	
}
