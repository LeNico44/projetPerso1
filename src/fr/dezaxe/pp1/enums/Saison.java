/**
 * 
 */
package fr.dezaxe.pp1.enums;

/**
 * @author nicolas
 *
 */
public enum Saison {
	Printemps,
	Eté,
	Automne,
	Hiver;
	
	private static Saison value;

	public static Saison parseSaison(String parameter) {
		switch(parameter) {
			case "Leclerc":
				Saison.value = Saison.Eté;
				break;
			case "Chlorophylle":
				Saison.value = Saison.Automne;
				break;
			case "HyperU":
				Saison.value = Saison.Hiver;
				break;
			default : 
				Saison.value = Saison.Printemps;
		}
		return Saison.value;
	}

}
