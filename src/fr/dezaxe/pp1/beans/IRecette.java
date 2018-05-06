/**
 * 
 */
package fr.dezaxe.pp1.beans;

import java.util.List;

import fr.dezaxe.pp1.enums.Saison;

/**
 * @author nicolas
 *
 */
public interface IRecette {
	
	public int getId();
	public void setId(int id);
	
	public String getTitre();
	public void setTitre(String titre);
	
	public String getDescription();
	public void setDescription(String description);
	
	public int getNbrePersonnes();
	public void setNbrePersonnes(int nbrePersonnes);
	
	public List<Produit> getProduits();
	public void setProduits(List<Produit> produits);
	
	public Saison getSaison();
	public void setSaison(Saison saison);

}
