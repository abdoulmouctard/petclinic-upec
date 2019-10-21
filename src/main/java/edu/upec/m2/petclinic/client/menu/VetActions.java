package edu.upec.m2.petclinic.client.menu;

public enum VetActions {
	LIST("Voir la liste des professionnelles"), 
	CREATE("Créer un professionnelle"),
	DELETE("Supprimer un professionnelle"),
	UPDATE("Mettre à jours un professionnelle"),
	BACK("Retour au menu principal");
	private String message;
	VetActions(String message){
		this.message = message;
	}
	public String toString() {
		return message;
	}
}
