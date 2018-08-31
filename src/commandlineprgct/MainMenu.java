package commandlineprgct;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
	
	public static Scanner kb = new Scanner(System.in);

	/**
	 * Method displays the Welcome Message.
	 */

	private static void displayWelcome() {
		System.out.println("***********************************");
		System.out.println("***TEST PROGRAM * ST-CONSOLE-APP***\n");
	}

	/**
	 * Method displays the Goodbye Message.
	 */

	private static void displayGoodbye() {
		System.out.println("\n***GOODBYE***");
		System.out.println("***********************************");
	}

	/**
	 * Method displays the menu.
	 */

	private static void displayMenu() {
		System.out.println("a. MEMORY FREE");
		System.out.println("b. TO DO APP");
		System.out.println("c. SETTINGS");
		System.out.println("q. QUIT");
	}

	/**
	 * Method prompts for and returns the user's menu selection. No data validation
	 * is performed.
	 * 
	 * @return character selection
	 */

	public static char getSelection() {
		
		char menuSelection;
		System.out.print("\nSelection? ");
		menuSelection = kb.nextLine().charAt(0);
		return menuSelection;
		
	}

	public static void main(String[] args) throws IOException {

		char selection = 'b';

		displayWelcome();
		displayMenu();

		selection = getSelection();

		while (selection != 'q') {

			switch (selection) {
			case 'a':
				//
				System.out.print("\n---MEMORY FREE---\n");
				TestRunnable.mainRunnable();
				break;
			case 'b':
				//
				System.out.print("\n---TO DO APP---\n");
				break;
			case 'c':
				//
				System.out.print("\n---SETTINGS---\n");
				Settings.settings();
				break;
			default:
				//
				System.out.print("\nNOT a valid selection\n");
				break;
			}

			// display menu and solicit selection
			displayMenu();
			selection = getSelection();
		} // end loop

		displayGoodbye();
		kb.close(); // close scanner.
	}

}
