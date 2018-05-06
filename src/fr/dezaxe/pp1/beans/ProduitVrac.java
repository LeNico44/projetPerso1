/**
 * 
 */
package fr.dezaxe.pp1.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author nicolas
 *
 */
@Entity
@Table(name="produit")
public class ProduitVrac extends Produit implements IProduitVrac {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProduitVrac() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setPrixKilo(double prixKilo) {
		this.prixKilo = prixKilo;
		System.out.println("prix au Kilo de Produit vrac : " + this.prixKilo);
		
	}
	
	@Override
	public void setPrix(double prix) {
		this.prix = prixKilo * poids;
		System.out.println("prix calculé : " + this.prix);
		
	}

}
