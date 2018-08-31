package commandlineprgct;

public class Settings {
	
	/**
	 * Method displays settings the menu.
	 */

	private static void displayMenu() {
		System.out.println("a. Create TODO database");
		System.out.println("b. BACK");
	}
	
	public static void settings() {
		
		char settings = 'b';
		
		displayMenu();
		
		settings = MainMenu.getSelection();

		//picking a selection broke
		/*while (settings != 'b') {

			switch (settings) {
			case 'a':
				//
				System.out.print("\n---Create---\n");				
				break;
			case 'c':
				//
				break;
			default:
				//
			}
			
		}*/
		
		
	}
}
