import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class Encounter
{
	Scanner scan = new Scanner(System.in);
	
	//Setting up the player's character.
	protected PlayerCharacter player;
	protected MapSpaces[][]spaces;
	protected boolean displayHp;
	protected Description description;
	
	public Encounter()
	{
		//Default Constructor
	}
	
	public Encounter(int choice) throws IOException
	{
		if (choice == 1) {
			player = new PlayerCharacter("", 100, 100, 5, 1, 300);
			passPlayerCharacter();
		}
		else {
			load();
		}
		spaces = new MapSpaces[6][6];
		displayHp = false;
		description = new Description();
		
		
		//Debugging Area
		//-------------------------------------------
		System.out.println(player.getHp());
		System.out.println("ice scroll added");
		player.items.scrolls("addIce");
		player.items.scrolls("addIce");
		player.items.scrolls("addFire");
		//System.out.println("added creation cube");
		//player.equipment.creationCube("true");
		//System.out.println("time sword added");
		//player.equipment.timeSword("yes");
		//player.equipment.plateArmor("yes");
		//player.equipment.equipmentList("Time Key", "add");
		
		//-------------------------------------------	
	}
	
	//Enables player equipment.
	public void passPlayerCharacter()
	{
		player.passPlayer(player);
	}

	//Build Game Map.
	public void buildMapSpaces()
	{
		spaces[0][0] = new Space_Store();
		spaces[0][1] = new Space_Other();
		//Replace with Orc
		spaces[0][2] = new Creature_LavaHydra();
		spaces[0][3] = new Space_Other();
		spaces[0][4] = new Creature_Troll();
		spaces[0][5] = new Space_Terrain();
		spaces[1][0] = new Creature_Goblin();
		spaces[1][1] = new Creature_Goblin();
		spaces[1][2] = new Creature_Orc();
		spaces[1][3] = new Space_Other();
		spaces[1][4] = new Creature_Troll();
		spaces[1][5] = new Space_Other();
		spaces[2][0] = new Creature_Orc();
		spaces[2][1] = new Space_Other();
		spaces[2][2] = new Creature_Ogre();
		spaces[2][3] = new Creature_Orc();
		spaces[2][4] = new Space_Other();
		spaces[2][5] = new Space_Other();
		spaces[3][0] = new Creature_Orc();
		spaces[3][1] = new Creature_Ogre();
		spaces[3][2] = new Space_Store();
		spaces[3][3] = new Space_Other();
		spaces[3][4] = new Creature_FireMage();
		spaces[3][5] = new Creature_LavaHydra();
		spaces[4][0] = new Space_Other();
		spaces[4][1] = new Space_Other();
		//Put a new creature type here. 
		spaces[4][2] = new Creature_Orc();
		spaces[4][3] = new Space_Other();
		spaces[4][4] = new Space_Terrain();
		spaces[4][5] = new Space_Terrain();
		spaces[5][0] = new Creature_IceDemon();
		spaces[5][1] = new Space_Other();
		//Put a new creature type here
		spaces[5][2] = new Creature_Orc();
		spaces[5][3] = new Creature_FireMage();
		spaces[5][4] = new Space_Terrain();
		//Final boss -- Returns creature if player has time key. 
		spaces[5][5] = new Space_Terrain();   
	}

	//Gather player information.
	public void start()
	{
		System.out.println("What is your name?");
		String characterName = scan.nextLine();
		player.setName(characterName);
		System.out.println();
		
		//Story about vision quest. Entropy. 
	}
	
	//Check to see if the game is complete. 
	public boolean end()
	{
		return player.equipment.equipmentCheck("Creation Cube");
	}

	//Toggle always display player HP.
	public void displayHpCheck(boolean check)
	{
		if (check == true)
		{
			displayHp = true;
		}
		if (check == false)
		{
			displayHp = false;
		}
	}

	//Player encounters a map space.
	public void room(int row, int column, PlayerMovement movement, Scanner scan)
	{

		Combat combat = new Combat();
		Creature theEncounter;

		/*Fruit aFruit = aMethod(); // get a fruit.
		if (aFruit instanceof Apple) {
		  Apple apple = (Apple) aFruit;
		  // do apple things with the apple.
		  apple.somethingOnlyApplesDo();
		} // else if (aFruit instanceof Banana) {
		// Do Nothing With Bananas.
		// Banana banana = (Banana) aFruit;
		// }*/

		theEncounter = spaces[row][column].doAction(row, column, player, movement, scan);

		if (theEncounter.getClass() != Space_Other.class 
				&& theEncounter.getClass() != Space_Store.class 
				&& theEncounter.getClass() != Space_Terrain.class) 
		{
			
			//This is now changed. Victory is determined in individual create classes. 
			//getLoot() is called in combat class. 
			boolean victory = combat.battle(player, theEncounter, displayHp, scan, movement);
			
			player.equipment.victoryEquip(victory, row, column);	
			

		}
	}
	
	public void loadAndSave() throws IOException
	{
		description.loadAndSave();
		int selection = 0;
		try
		{
			selection = scan.nextInt();
			
		}
		catch(InputMismatchException e)
		{
			System.out.println(e);
		}
		
		if (selection == 1)
		{
			save();
		}
		else if (selection == 2)
		{
			load();
		}
		else
		{
			System.out.println("\nInvalid Input. Nothing saved or loaded.\n");
			scan.nextLine();
		}	
	}
	
	public void load() throws IOException
	{
		Load load = new Load(scan);
		player = load.loadCharacter();
	}
	
	public void save() throws IOException
	{
		Save save = new Save(scan);
		save.saveCharacter(player);
	}
}




