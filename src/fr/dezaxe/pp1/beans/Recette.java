/**
 * 
 */
package fr.dezaxe.pp1.beans;

import java.util.List;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

import fr.dezaxe.pp1.enums.Saison;

/**
 * @author nicolas
 *
 */
@Entity
@Table(name="recette")
public class Recette implements IRecette, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="recette_id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@NotNull
	protected String titre;
	protected String description;
	protected int nbrePersonnes;
	
	@OneToMany(mappedBy="recette")
	protected List<Produit> produits;
	
	@Enumerated(EnumType.STRING)
	protected Saison saison;
	/**
	 * 
	 */
	protected Recette() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
		
	}
	
	/* (non-Javadoc)
	 * @see fr.dezaxe.pp1.beans.IRecette#getTitre()
	 */
	@Override
	public String getTitre() {
		// TODO Auto-generated method stub
		return titre;
	}

	/* (non-Javadoc)
	 * @see fr.dezaxe.pp1.beans.IRecette#setTitre(java.lang.String)
	 */
	@Override
	public void setTitre(String titre) {
		// TODO Auto-generated method stub
		this.titre = titre;

	}

	/* (non-Javadoc)
	 * @see fr.dezaxe.pp1.beans.IRecette#getDescription()
	 */
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	/* (non-Javadoc)
	 * @see fr.dezaxe.pp1.beans.IRecette#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		this.description = description;

	}

	/* (non-Javadoc)
	 * @see fr.dezaxe.pp1.beans.IRecette#getSaison()
	 */
	@Override
	public Saison getSaison() {
		// TODO Auto-generated method stub
		return saison;
	}

	/* (non-Javadoc)
	 * @see fr.dezaxe.pp1.beans.IRecette#setSaison(fr.dezaxe.pp1.enums.Saison)
	 */
	@Override
	public void setSaison(Saison saison) {
		// TODO Auto-generated method stub
		this.saison = saison;

	}

	@Override
	public int getNbrePersonnes() {
		// TODO Auto-generated method stub
		return nbrePersonnes;
	}

	@Override
	public void setNbrePersonnes(int nbrePersonnes) {
		// TODO Auto-generated method stub
		this.nbrePersonnes = nbrePersonnes;
		
	}

	@Override
	public List<Produit> getProduits() {
		// TODO Auto-generated method stub
		return produits;
	}

	@Override
	public void setProduits(List<Produit> produits) {
		// TODO Auto-generated method stub
		this.produits = produits;
		
	}


}
