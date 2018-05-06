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
	private static final String CHAMP_RESTE = "reste";
	
	//J'ai copier ces lignes, ça doit être pour gérer les erreurs mais ce n'est pas très clair dans ma tête !
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	private boolean chkErreur;
	
	public boolean isChkErreur() {
		return chkErreur;
	}
	
	public void setChkErreur(boolean chkErreur) {
		this.chkErreur = chkErreur;
	}
	
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
		String reste = getValeurChamp(request, CHAMP_RESTE);
		
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
			System.out.println("PATATE !!!" + libelle);
			validationLibelle(libelle);
			
		} catch (Exception e) {
			setErreur(CHAMP_LIBELLE, e.getMessage());
		}
		produit.setLibelle(libelle);
		
		//verif poids
		if(poids != null)
			produit.setPoids((double)Math.round(Double.parseDouble(poids)*1000)/1000);
		
		if(radio.equals("prodemb")) {
			
			//verif prix
			if(prix != null)
				produit.setPrix((double)Math.round(Double.parseDouble(prix)*100)/100);
			else
				produit.setPrix(0);//Je ne sais pas vraiment à quoi ça sert, mais sans le else, ça n'envoit pas dans la base de données.
			
			//verif prix au kilo
			if(prixkilo != null)
				produit.setPrixKilo((double)Math.round(Double.parseDouble(prixkilo)*100)/100);
			else
				produit.setPrixKilo(0);//Je ne sais pas vraiment à quoi ça sert, mais sans le else, ça n'envoit pas dans la base de données.
			
		}else {
			
			//verif prix au kilo
			if(prixkilo != null)
				produit.setPrixKilo((double)Math.round(Double.parseDouble(prixkilo)*100)/100);
			else
				produit.setPrixKilo(0);//Je ne sais pas vraiment à quoi ça sert, mais sans le else, ça n'envoit pas dans la base de données.
			
			//verif prix
			if(prix != null)
				produit.setPrix((double)Math.round(Double.parseDouble(prix)*100)/100);
			else
				produit.setPrix(0);//Je ne sais pas vraiment à quoi ça sert, mais sans le else, ça n'envoit pas dans la base de données.
		}
		
		
		
		
		
		//verif magasin
		produit.setMagasin(Magasin.parseMagasin(magasin));
		
		
		if(erreurs.isEmpty()) {
			resultat = "Succès de la création !";
			chkErreur = true;
		}else {
			resultat = "échec de la création !";
			chkErreur = false;
		}
		
		
		
		//Reste en stock
		if(reste != null)
			produit.setReste((double)Math.round(Double.parseDouble(reste)*1000)/1000);
		else
			produit.setReste(0);
		
		//Stock
		produit.setStock();
		
		
		return produit;
		
	}
	
	private void validationLibelle(String libelle) throws Exception {
		
		if(libelle != null) {
			System.out.println("Coucou !!! ");
			throw new Exception("Coucou !!! ");
		}
		
//		System.out.println("validationLibelle");
//		if( libelle != null ) {
//			System.out.println("Libelle n'est pas vide !");
//	        if ( libelle.length() < 3 ) {
//	        	System.out.println("Libelle fait moins de trois caractères !");
//	            throw new Exception( "Le libellé doit contenir au moins 3 caract�res." );
//	        }
//	    }
//		else {
//			System.out.println("Libelle est vide !");
//	        throw new Exception( "Merci de saisir un nom de produit." );
//	    }
		
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
