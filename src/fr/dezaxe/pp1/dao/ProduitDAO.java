package fr.dezaxe.pp1.dao;

import java.util.List;

import fr.dezaxe.pp1.beans.IProduit;

public interface ProduitDAO {

	void creerProduit(IProduit produit);
	List<IProduit> listProduit();
	void supProduit(Integer id);
	

}
