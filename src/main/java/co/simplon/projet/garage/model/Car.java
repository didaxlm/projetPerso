package co.simplon.projet.garage.model;

public class Car 
{
	private String marque;
	private String modele1;
	private String modele2;
	private String modele3;
	private String color;
	private int id;
	
	private static int globalId = 0;
	
	public String getColor() {
		return color;
	}	
	
	public int getId() {
		return id;
	}

	public String getMarque() {
		return marque;
	}

	public String getModele1() {
		return modele1;
	}

	public String getModele2() {
		return modele2;
	}

	public String getModele3() {
		return modele3;
	}

	public Car(String marque, String modele1, String modele2, String modele3, String color) 
	{
		this.marque = marque;
		this.modele1 = modele1;
		this.modele2 = modele2;
		this.modele3 = modele3;
		this.color = color;
		this.id = globalId ++;
	}
}
