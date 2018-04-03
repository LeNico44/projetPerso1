package fr.dezaxe.pp1.enums;

public enum Magasin {
	Leclerc,
	Chlorophylle,
	HyperU,
	Lidl,
	Chasseloire,
	Inconnu;

	private static Magasin value;

	public static Magasin parseMagasin(String parameter) {
		switch(parameter) {
			case "Leclerc":
				Magasin.value = Magasin.Leclerc;
				break;
			case "Chlorophylle":
				Magasin.value = Magasin.Chlorophylle;
				break;
			case "HyperU":
				Magasin.value = Magasin.HyperU;
				break;
			case "Lidl":
				Magasin.value = Magasin.Lidl;
				break;
			case "Chasseloire":
				Magasin.value = Magasin.Chasseloire;
				break;
			default : 
				Magasin.value = Magasin.Inconnu;
		}
		return Magasin.value;
	}
	
}
