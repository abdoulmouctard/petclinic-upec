package edu.upec.m2.petclinic.client.menu;

import java.util.function.BiConsumer;

import org.beryx.textio.TextIO;

import edu.upec.m2.petclinic.client.Menu;

public class ExitMenu implements BiConsumer<TextIO, RunnerData> {

	@Override
	public void accept(TextIO textIO, RunnerData u) {
		
		boolean toSave = textIO.newBooleanInputReader()
			      .read("Voulez-vous Sortir du programme ?");
		if(!toSave) {
			Menu.getInstance(textIO).displayMainMenu();
		}else {
			textIO.dispose();
		}
	}
	@Override
	public String toString() {
		return "Sortir du programme";
	}
	
}
