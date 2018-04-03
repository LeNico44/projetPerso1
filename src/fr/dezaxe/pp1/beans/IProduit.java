/**
 * 
 */
package fr.dezaxe.pp1.beans;

import fr.dezaxe.pp1.enums.Magasin;

/**
 * @author nicolas
 *
 */
public interface IProduit {
	
	public int getId();
	public void setId(int id);
	
	public String getLibelle();
	public void setLibelle(String libelle);
	
	public double getPrix();
	public void setPrix(double prix);

	public double getPrixKilo();
	public void setPrixKilo(double prixKilo);

	public double getPoids();
	public void setPoids(double poids);
	
	public Magasin getMagasin();
	public void setMagasin(Magasin magasin);

}
