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
public class ProduitEmballe extends Produit implements IProduitEmballe{

	public ProduitEmballe() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setPrix(double prix) {
		this.prix = prix;
		System.out.println("prix brut de produit Emballe : " + this.prix);
		
	}
	
	@Override
	public void setPrixKilo(double prixKilo) {
		this.prixKilo = prix / poids;
		System.out.println("prix au kilo calculé : " + this.prixKilo);
		
	}


}
