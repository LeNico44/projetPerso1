/**
 * 
 */
package fr.dezaxe.pp1.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import fr.dezaxe.pp1.beans.IProduit;
import fr.dezaxe.pp1.beans.Loader;
import fr.dezaxe.pp1.enums.Magasin;

/**
 * @author nicolas
 *
 */
public class CreationProduitForm {
	private static final String CHAMP_RADIO = "radioProduit";
	private static final String CHAMP_LIBELLE = "libelle";
	private static final String CHAMP_PRIX_AU_KILO = "prixkilo";
	private static final String CHAMP_POIDS = "poids";
	private static final String CHAMP_PRIX = "prix";
	private static final String CHAMP_MAGASIN = "magasin";
	
	//J'ai copier ces lignes, ça doit être pour gérer les erreurs mais ce n'est pas très clair dans ma tête !
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	
	public String getResultat() {
		return resultat;
	}
	
	public Map<String, String> getErreurs(){
		return erreurs;
	}
	//Fin du "J'ai copier..."
	
	public IProduit creerProduit(HttpServletRequest request) {
		//récupération des champs rentrés
		String radio = getValeurChamp(request, CHAMP_RADIO);
		String libelle = getValeurChamp(request, CHAMP_LIBELLE);
		String prixkilo = getValeurChamp(request, CHAMP_PRIX_AU_KILO);
		String poids = getValeurChamp(request, CHAMP_POIDS);
		String prix = getValeurChamp(request, CHAMP_PRIX);
		String magasin = getValeurChamp(request, CHAMP_MAGASIN);
		
		IProduit produit;
		
		//vérification des différents champs !
		
		//verif radio
		if(radio.equals("prodemb")) {
			produit = Loader.creerProduitEmballe();
		}else {
			produit = Loader.creerProduitVrac();
		}
		
		
		//verif libellé
		try {
			System.out.println("test le champ libelle");
			validationLibelle(libelle);
		} catch (Exception e) {
			setErreur(CHAMP_LIBELLE, e.getMessage());
		}
		produit.setLibelle(libelle);
		
		//verif prix au kilo
		if(radio.equals("prodemb")) {
			produit.setPrixKilo(Double.parseDouble(prix) / Double.parseDouble(poids));
		}else {
			if(prixkilo != null)
			produit.setPrixKilo((double)Math.round(Double.parseDouble(prixkilo)*100)/100);
		}
		
		//verif poids
		if(poids != null)
		produit.setPoids((double)Math.round(Double.parseDouble(poids)*1000)/1000);
		
		//verif prix
		if(radio.equals("prodvrac")) {
			produit.setPrix(Double.parseDouble(prixkilo) * Double.parseDouble(poids));
		}else {
			if(prix != null)
			produit.setPrix((double)Math.round(Double.parseDouble(prix)*100)/100);
		}
		
		//verif magasin
		produit.setMagasin(Magasin.parseMagasin(magasin));
		
		return produit;
		
		
		
	}
	
	private void validationLibelle(String libelle) throws Exception {
		System.out.println("Passage dans la procédure de validation du libellé.");
		if( libelle != null ) {
			System.out.println("le libellé n'est pas null !");
	        if ( libelle.length() < 3 ) {
	        	System.out.println("le libellé contient moins de 3 caractères.");
	            throw new Exception( "Le libellé doit contenir au moins 3 caract�res." );
	        }
	    }
		else {
			System.out.println("Le champ nom produit n'est pas renseigné." + libelle);
	        throw new Exception( "Merci de saisir un nom de produit." );
	    }
		
		System.out.println("Le produit est valide.");
	}
	
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}
	
	//définition de la méthode getValeurChamp
	private String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if(valeur == null || valeur.trim().length() == 0) {
			return null;
		}else {
			return valeur;
		}
	}
}
