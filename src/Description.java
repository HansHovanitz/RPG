import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Description implements Serializable
{
	Scanner scan;
	ArrayList<String> hints;
	
	public Description () {
		hints = populateHints();
	}

	public ArrayList<String> populateHints() {
		ArrayList<String> buildHints = new ArrayList<String>;
		String hintOne = "I hear trolls might be vulnderable to fire...";
		buildHints.add(hintOne);
		String hintTwo = "Legend speaks of a great icy beast in the distant SouthWest that possesses a relic of great power.";
		buildHints.add(hintTwo);
		String hintThree = "The hammers I sell aren't just used for building things."
		buildHints.add(hintThree);
		String hintFour = "";
		buildHints.add(hintFour);



	}

	public void enterRoom(){
		System.out.println("You enter the room...");
	}

	public void intro(){
		System.out.println("Welcome to the adventure!\n");

		for (int i = 0; i < 5; i++){
			System.out.print(".  ");

			try{
				Thread.sleep(1000);
			}

			catch (InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
		System.out.println();
	}

	public void menu(){
		System.out.println("What would you like to do now?");
		System.out.println("1. Move 'Up'");
		System.out.println("2. Move 'Down'");
		System.out.println("3. Move 'Left'");
		System.out.println("4. Move 'Right'");
		System.out.println("5. View Map");
		System.out.println("6. See My Status");
		System.out.println("7. Save Character");
		System.out.println("8. Options");
		System.out.println("9. Quit");
		System.out.print("___");
	}

	public void combatMenu(){
		System.out.println("\nWhat would you like to do now?");
		System.out.println("1. Attack");
		System.out.println("2. Block");
		System.out.println("3. Use Item");
		System.out.println("4. My Health");
		System.out.print("___");
	}

	public void statusMenu(){
		System.out.println("What would you like to view?");
		System.out.println("1. Character Information");
		System.out.println("2. Equipment");
		System.out.println("3. Consumable Items");
		System.out.print("___");
	}

	public void merchantOneMenu(){
		System.out.println("1. Minor Health Potion\t 5 coins");
		System.out.println("2. Sword\t\t 20 coins");
		System.out.println("3. Shield\t\t 10 coins");
		System.out.println("4. Leather Armor\t 20 coins");
		System.out.println("5. Hammer\t\t 20 coins");
		System.out.println("6. Rope\t\t\t 10 coins");
		System.out.println("7. Talk to the Merchant\t Free");  //He'll give random hints..like trolls being weak to fire etc.
		System.out.println();
		System.out.println("0. Exit Shop");
	}
	
	public void merchantTwoMenu(){
		System.out.println("1. Minor Health Potion\t  |\t 5 coins");
		System.out.println("2. Health Potion\t  |\t 15 coins");
		System.out.println("3. Expertly Crafted Sword |\t 50 coins");
		System.out.println("4. Shield\t\t  |\t 10 coins");
		System.out.println("5. Chainmail Armor\t  |\t 50 coins");
		System.out.println("6. Hammer\t\t  |\t 20 coins");
		System.out.println("7. Rope\t\t\t  |\t 10 coins");
		System.out.println("8. Ice Scroll\t\t  |\t 25 coints");
		System.out.println("9. Fire Scoll\t\t  |\t 25 coins");
		System.out.println("10. Talk to the Merchant  |\t Free");  //He'll give random hints..like trolls being weak to fire etc.
		System.out.println();
		System.out.println("0. Exit Shop");
	}
	
	public void healerMenu(){
		System.out.println("\n1. Heal 10 points of health\t\t 5 coins");
		System.out.println("2. Heal to your full health\t\t 10 coins");
		System.out.println("3. Leave the area");
	}
	
	public void loadAndSave(){
		System.out.println("Select what you would like to do:");
		System.out.println("1. Save");
		System.out.println("2. Load");
		System.out.print("___");
	}

	public void hints(){
		//randomly pick a number the length of the hints array and then output that index


	}
	
	//Room descriptions
	public void room(int row, int column, int roomEncounter){
		if (row == 0 && column == 0){
			System.out.println("You enter the room...");
			System.out.println("A merchant greets you.");
		}
	}
}