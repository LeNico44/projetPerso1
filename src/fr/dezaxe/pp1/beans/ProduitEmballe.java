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
class ProduitEmballe extends Produit implements IProduitEmballe{

	/**
	 * 
	 */
	public ProduitEmballe() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setPrix(double prix) {
		this.prix = prix;
		
	}

}
