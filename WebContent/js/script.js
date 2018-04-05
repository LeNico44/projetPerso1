/*
 fonction qui permet de désactiver l'input inutile en fonction du bouton radio coché !
 */

var valeur = 'prodemb';

function clickradio(){
	valeur = 'prodemb';
	for (i=0; i<document.formulaire.radioProduit.length; i++) {
		if (document.formulaire.radioProduit[i].checked) {
			valeur = document.formulaire.radioProduit[i].value;
		}
	}
	if(valeur == 'prodemb'){
		document.formulaire.prix.disabled=false;
		document.formulaire.prixkilo.disabled=true;
		document.formulaire.prixkilo.value="";

	}else{
		document.formulaire.prixkilo.disabled=false;
		document.formulaire.prix.disabled=true;
		document.formulaire.prix.value="";
	}
}