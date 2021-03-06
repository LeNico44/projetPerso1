/**
 * 
 */
package fr.dezaxe.pp1.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.dezaxe.pp1.enums.Magasin;

/**
 * @author nicolas
 *
 */
@Entity
@Table(name="produit")
abstract class Produit implements IProduit {
	@Id
	@Column(name="a_id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String libelle;
	protected double prix;
	private double prixKilo;
	private double poids;
	
	@Enumerated(EnumType.STRING)
	private Magasin magasin;
	
	protected Produit() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public abstract void setPrix(double prix);

	public double getPrixKilo() {
		return prixKilo;
	}

	public void setPrixKilo(double prixKilo) {
		this.prixKilo = prixKilo;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}
	
	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	
	
}
