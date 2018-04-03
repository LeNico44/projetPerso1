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

	public ProduitVrac() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setPrix(double prix) {
		// TODO Auto-generated method stub
		
	}

}
