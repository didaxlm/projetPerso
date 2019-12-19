package co.simplon.projet.garage.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.jdi.connect.spi.TransportService.ListenKey;

import co.simplon.projet.garage.model.Car;

@RestController
@CrossOrigin("*")
@RequestMapping("/garage")//fin du chemin principal de l'url
public class GarageController 
{
	private List<Car> listeVoiture;
	// creation constructeur liste
	public GarageController ()
	{
		Car maVoiture1 = new Car("Honda", "Civic","CV-R", "HR-V", "Bleu");
		Car maVoiture2 = new Car("Mercedes", "class E"," class A", "class C", "Vert");
		Car maVoiture3 = new Car("Citroen","C3", "C5", "Berlingo", "Noir");
		Car maVoiture4 = new Car("Renault", "Twingo", "Scenic", "Megane", "Blanc");
		Car maVoiture5 = new Car("Volkswagen","Passat", "Tiguan", "Golf", "Rouge");
		
		listeVoiture = new ArrayList<Car> (Arrays.asList(maVoiture1, maVoiture2, maVoiture3, maVoiture4, maVoiture5));
	}
	
	//création d'un nouvel objet json
	@PostMapping("/newCar")
	public List<Car> createCar(
			@RequestParam(value="marque")String marque, 
			@RequestParam(value="modele1")String modele1, 
			@RequestParam(value="modele2")String modele2, 
			@RequestParam(value="modele3")String modele3, 
			@RequestParam(value="color")String color) 
	{
		Car nouvelleVoiture = new Car(marque, modele1, modele2, modele3, color);
		listeVoiture.add(nouvelleVoiture);
		return listeVoiture;
	}
	
	@RequestMapping("/cars")// chemin secondaire (ex : .../garage/cars)
	public List<Car> getCarList()
	{
		return listeVoiture;
	}
	
	@RequestMapping("/id")
	public ResponseEntity<Car> voitureId (@RequestParam(value="id")int id)
	{
		for (Car car : listeVoiture) {
			if (car.getId() == id) {
				return ResponseEntity.ok(car);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	/*@RequestMapping("/erreur")
	public ResponseEntity<String> erreur()
	{
		return ResponseEntity.notFound().build();
	}*/
}

