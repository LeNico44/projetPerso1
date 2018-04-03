/**
 * 
 */
package fr.dezaxe.pp1.beans;

/**
 * @author nicolas
 *
 */
public class Loader {
	
	public static IProduitEmballe creerProduitEmballe() {
		return new ProduitEmballe();
	}
	
	public static IProduitVrac creerProduitVrac() {
		return new ProduitVrac();
	}
}
