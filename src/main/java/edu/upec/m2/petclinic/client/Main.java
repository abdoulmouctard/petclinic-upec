package edu.upec.m2.petclinic.client;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**Main class to launch petclinic application in console mode.
 * 
 * @author Salifou BERTHE
 *
 */
public class Main {
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);
	public static void main(String[] args) {
		LOG.debug("======================START=========================");
		TextIO textIO = TextIoFactory.getTextIO();
		Menu menu = Menu.getInstance(textIO);
		menu.displayMainMenu();
		LOG.debug("======================END============================");
	}
}
