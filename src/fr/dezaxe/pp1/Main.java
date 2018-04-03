/**
 * 
 */
package fr.dezaxe.pp1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.dezaxe.pp1.beans.IProduit;
import fr.dezaxe.pp1.beans.Loader;
import fr.dezaxe.pp1.enums.Magasin;

/**
 * @author nicolas
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pp1");
		EntityManager em = emf.createEntityManager();
		
		IProduit produit = Loader.creerProduitEmballe();
		
		produit.setLibelle("riz complet");
		
		em.getTransaction().begin();
		em.persist(produit);
		em.getTransaction().commit();
		
		System.out.println(produit.getLibelle() + " acheté chez " + produit.getMagasin());

	}

}
