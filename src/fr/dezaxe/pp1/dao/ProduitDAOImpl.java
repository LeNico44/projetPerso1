package fr.dezaxe.pp1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.dezaxe.pp1.beans.IProduit;

public class ProduitDAOImpl implements ProduitDAO {
	private EntityManager em;
	
	public ProduitDAOImpl() {
	 em = NoteEntityManager.getInstance().getEntityManager();
	}

	@Override
	public List<IProduit> listProduit() {
		 String sql = "SELECT p FROM Produit p ";
		 Query query = em.createQuery(sql);
		 List<IProduit> produits = query.getResultList();
		 return produits;
	}
}
