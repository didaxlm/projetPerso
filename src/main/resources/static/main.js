var liste = []; // contient la liste de toutes les voitures reçue par l'api

console.log("debut");

/**
 * Action à réaliser lorsque le dom est chargé
 */
$(document).ready(function () 
{
    // URL de l'api
    $.ajax({
        url: "/garage/cars"
    }).then(function (data) 
    {
        liste = data;
        chargerMenu();
    });
});

$("#submit").click(function(){
	$.post("/garage/newCar", {
		marque: $("#new-marque").val(),
		modele1: $("#new-model1").val(),
		modele2: $("#new-model2").val(),
		modele3: $("#new-model3").val(),
		color: $("#new-color").val()
	});
	document.location.reload(true);
});



function erreur()
{	
	document.location.href = "erreur.html"
}
/**
 * remplit le dropdown menu avec les marques de toutes les voitures de la liste
 */
function chargerMenu() 
{
  liste.forEach(function (voiture) 
  {
    var newMenuItem = document.createElement('button');
    newMenuItem.className = "dropdown-item";
    newMenuItem.type = "button";
    newMenuItem.textContent = voiture ["marque"];
    newMenuItem.addEventListener('click', function (event) 
    {
        // les actions à effectuer lorsqu'on clique sur un element du dropdown
    	chargerTout(voiture);     
    });
    document.getElementById("dropdown-list").appendChild(newMenuItem);
  });
}

function chargerVoitureType (voiture)
{
    console.log(voiture);
    let cardTitle = document.createElement('li');
    cardTitle.className = "card-title";
    cardTitle.innerText = voiture["modele1"] + " " + voiture["modele2"]+ " " + voiture["modele3"]; 

    document.getElementById("modele").appendChild(cardTitle);
}

function chargerVoitureId (voiture)
{
    let cardTitle = document.createElement('p');
    cardTitle.className = "card-title";
    cardTitle.innerText = voiture["id"];

    document.getElementById("id").appendChild(cardTitle);
}

function chargerVoitureColor (voiture)
{
    let cardTitle = document.createElement('li');
    cardTitle.className = "card-title";
    cardTitle.innerText = voiture["color"];

    document.getElementById("couleur").appendChild(cardTitle);
}

function chargerTout (voiture)
{
	chargerVoitureType(voiture);
	chargerVoitureId(voiture);
	chargerVoitureColor(voiture);
}

var champsRecherche = document.getElementById("new-id");
var rechercheId = document.getElementById("submit-id");


rechercheId.addEventListener('click', function(event){	
	$.ajax({
		url: "/garage/id?id=" + champsRecherche.value,
		success: (chargerTout),
		error: (erreur)
	});
});

