/**
 * 
 */
package fr.dezaxe.pp1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.dezaxe.pp1.beans.IProduit;
import fr.dezaxe.pp1.beans.Loader;
import fr.dezaxe.pp1.dao.ProduitDAO;
import fr.dezaxe.pp1.dao.ProduitDAOImpl;
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
		
		 ProduitDAO produitDAOImpl = new ProduitDAOImpl();
		 List<IProduit> listeProduits = produitDAOImpl.listProduit();
		 System.out.println();
		 System.out.println("Liste des produits en base avec JPA");
		 for (IProduit produit : listeProduits) {
		 System.out.println(produit.getLibelle());
		 }
	}

}
