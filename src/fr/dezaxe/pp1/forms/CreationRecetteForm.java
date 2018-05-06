/**
 * 
 */
package fr.dezaxe.pp1.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.dezaxe.pp1.beans.IRecette;
import fr.dezaxe.pp1.beans.Loader;
import fr.dezaxe.pp1.enums.Saison;

/**
 * @author nicolas
 *
 */
public class CreationRecetteForm {
	private static final String CHAMP_TITRE = "titre";
	private static final String CHAMP_DESCRIPTION = "description";
	private static final String CHAMP_NBRE_PERSONNES = "nbrepersonnes";
	private static final String CHAMP_SAISON = "saison";
	
	
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
	
	/**
	 * 
	 */
	public IRecette creerRecette(HttpServletRequest request) {
		String titre = getValeurChamp(request, CHAMP_TITRE);
		String description = getValeurChamp(request, CHAMP_DESCRIPTION);
		String nbrepersonnes = getValeurChamp(request, CHAMP_NBRE_PERSONNES);
		String saison = getValeurChamp(request, CHAMP_SAISON);
		
		IRecette recette = Loader.creerRecette();
		
		recette.setTitre(titre);
		recette.setDescription(description);
		recette.setNbrePersonnes(Integer.parseInt(nbrepersonnes));
		recette.setSaison(Saison.parseSaison(saison));
		return recette;
	}

	private String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
	}

}
