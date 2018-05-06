package fr.dezaxe.pp1.dao;

import javax.persistence.EntityManager;

import fr.dezaxe.pp1.beans.IRecette;

public class RecetteDAOImpl implements RecetteDAO {
	private EntityManager em;
	
	public RecetteDAOImpl() {
	 em = NoteEntityManager.getInstance().getEntityManager();
	}

	@Override
	public void creerRecette(IRecette recette) {
		
		em.getTransaction().begin();
		em.persist(recette);
		em.getTransaction().commit();
		
	}
	
	
}
