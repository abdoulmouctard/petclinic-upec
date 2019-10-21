package edu.upec.m2.petclinic.client;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import org.beryx.textio.TextIO;

import edu.upec.m2.petclinic.client.menu.ExitMenu;
import edu.upec.m2.petclinic.client.menu.RunnerData;
import edu.upec.m2.petclinic.client.menu.VetMenu;

public class Menu {
	private static Menu instance;
	private TextIO textIO;

	private Menu(TextIO textIO) {
		this.textIO = textIO;
	}
	public static synchronized Menu getInstance(TextIO textIO) {
		if(instance==null) {
			instance = new Menu(textIO);
		}
		return instance;
	}
	public void displayMainMenu() {
		List<BiConsumer<TextIO, RunnerData>> apps = Arrays.asList(
																	new VetMenu(),
																	new ExitMenu());
		BiConsumer<TextIO, RunnerData> resp = this.textIO.<BiConsumer<TextIO, RunnerData>>newGenericInputReader(null).withNumberedPossibleValues(apps)
				.read(System.lineSeparator()
						+ "------ PET CLINIC C O N S O L E   M E N U  -------"
						+ System.lineSeparator());
		resp.accept(this.textIO, null);
	}

	@Override
	public String toString() {
		return "Menu []";
	}

}
