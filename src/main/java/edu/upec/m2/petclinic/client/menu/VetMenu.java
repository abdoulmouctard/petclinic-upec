package edu.upec.m2.petclinic.client.menu;

import java.util.function.BiConsumer;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

import edu.upec.m2.petclinic.client.Menu;
import edu.upec.m2.petclinic.model.Vet;
import edu.upec.m2.petclinic.service.VetDao;

public class VetMenu implements BiConsumer<TextIO, RunnerData>{
	private VetDao dao = new VetDao();
    public static void main(String[] args) {
        TextIO textIO = TextIoFactory.getTextIO();
        new VetMenu().accept(textIO, null);
    }
	@Override
	public void accept(TextIO textIO, RunnerData arg1) {
		
		VetActions action = textIO.newEnumInputReader(VetActions.class).read("Sélectionnez une action ?");	
		
		switch (action) {
		case LIST:
			displayList(textIO);
			break;
		case CREATE:
			this.createNewVet(textIO);
			break;
		case DELETE:
			this.delete(textIO);
			break;
			
		case UPDATE:
			
				this.update(textIO);
				break;
		case BACK:
			
			break;			
		default:
			break;
		}
		Menu.getInstance(textIO).displayMainMenu();
	}
	private void update(TextIO textIO) {
		Long id = textIO.newLongInputReader().withDefaultValue(-1L).read("ID : ");
		Vet vet = this.dao.findById(id);
		TextTerminal<?> terminal = textIO.getTextTerminal();
		if(vet!=null) {
	        String firstName = textIO.newStringInputReader()
	                .read("Prénom");
	        String lastName = textIO.newStringInputReader()
	                .read("Nom");
	        String email = textIO.newStringInputReader()
	                .read("Adresse mail");
	        vet.setFirstName(firstName);
	        vet.setLastName(lastName);
	        vet.setEmail(email);
		}else {
			terminal.println("Le vet avec l'id  <"+id+"> n'existe pas");
		}
	}
	private void delete(TextIO textIO) {
		Long id = textIO.newLongInputReader().withDefaultValue(-1L).read("ID : ");
		Vet vet = this.dao.findById(id);
		TextTerminal<?> terminal = textIO.getTextTerminal();
		if(vet!=null) {
			this.dao.remove(vet);
		}else {
			terminal.println("Le vet avec l'id  <"+id+"> n'existe pas");
		}		
	}
	private void createNewVet(TextIO textIO) {
        String firstName = textIO.newStringInputReader()
                .read("Prénom");
        String lastName = textIO.newStringInputReader()
                .read("Nom");
        String email = textIO.newStringInputReader()
                .read("Adresse mail");
        Vet vet  = new Vet();
        vet.setFirstName(firstName);
        vet.setLastName(lastName);
        vet.setEmail(email);
        this.dao.persist(vet);
	}
	private void displayList(TextIO textIO) {
		TextTerminal<?> terminal = textIO.getTextTerminal();
		for(Vet vet : dao.findAll()) {
			terminal.println(vet.getId()+" : "+vet.getFirstName()+" "+vet.getLastName());
		}
		
	}
	@Override
	public String toString() {
		return "Gestion des professionnelles";
	}

}
