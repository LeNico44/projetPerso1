var valeur = 'prodemb';

function clickradio(){
	valeur = 'prodemb';
	for (i=0; i<document.formulaire.radioProduit.length; i++) {
		if (document.formulaire.radioProduit[i].checked) {
			valeur = document.formulaire.radioProduit[i].value;
			document.getElementById("valeur").innerHTML = valeur ;
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

document.getElementById("valeur").innerHTML = valeur ;

alert('tout est ok');