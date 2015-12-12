import java.util.Scanner;


public class Encounter
{
	public Encounter()
	{
		player = new PlayerCharacter("", 100, 100, 20, 1, 50);
		spaces = new MapSpaces[6][6];
		
		
		
		

		
		
		

		passPlayerCharacter();
		
		
		//Testing area
		System.out.println("ice scroll added");
		player.items.scrolls("addIce");
		//player.equipment.plateArmor("yes");
		

		

	}

	public void passPlayerCharacter()
	{
		player.passPlayer(player);
	}

	//Setting up the player's character.
	protected PlayerCharacter player;
	protected MapSpaces[][]spaces;

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



	Description description = new Description();
	Scanner scan = new Scanner(System.in);

	public void start()
	{
		System.out.println("What is your name?");
		String characterName = scan.nextLine();
		player.setName(characterName);
		System.out.println();
	}

	//public void statusScreen()
	//{
	//	player.statusScreen();
	//}

	boolean displayHp = false;
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

	//public Creature blah()
	//{
	//	Creature_Goblin goblin = new Creature_Goblin();
	//	return goblin;
	//}

/*

	public boolean combat(Creature monster)
	{
		boolean victory = false;
			do
			{
				description.combatMenu();
				String scroll = "";
				int block = 1;
				boolean loopAgain = false;


				int action = scan.nextInt();
				System.out.println();


				switch (action)
				{
					case 1: monster.setHp(monster.getHp() - player.playerCombat(monster.getName())); break;
					case 2: if (player.equipment.equipmentCheck("Shield"))
							{
								block = 2;
							}
							else
							{
								System.out.println("You have no shield to block with!");
								
							}
							break;
					case 3: scroll = player.items.useConsumableItem("inCombat");
							if (scroll.equals("fire") || scroll.equals("ice"))
							{
								monster.setHp(monster.getHp() - player.scrollCombat(monster.getName(), monster.weakness(scroll)));
							}
							break;
					case 4: System.out.println("Health Points: " + player.getHp() + "/" + player.getMaxHp());
							loopAgain = true;
					default: break;

					//case 1: monster.setHp(monster.getHp() - (player.getDamage() + 12  --player.specialItemCheck...if true return 2 or 3 or whatever--   ));  The +12 can be a monster weakness method of a specific monster.
				}



				if (monster.getHp() > 0 && loopAgain == false)
				{
					System.out.println();
					player.setHp(player.getHp() - (monster.creatureCombat(player.getArmor(), block) + monster.strength(player.resistCheck())));
					//I can just return 0 if I want to have it do other stuff -- for a charge up attack or story or whatever.
				}

				if (action != 4 && displayHp == true)
				{
					System.out.println("\nYour Health Points: " + player.getHp() + "/" + player.getMaxHp());
				}



			}
			while (player.getHp() > 0 && monster.getHp() > 0);



			//monster.test(); --Why Doesn't this work? -- will work in method with actual goblin in it..not the generic monster. Pass 'weakness' or whatever into combat maybe and then apply it to damage here).


			if (player.getHp() > 0)
			{
				System.out.println("\nYou have slain the " + monster.getName() + "!");
				System.out.println("You find " + monster.getCoins() + " coins.");
				player.setCoins(player.getCoins() + monster.getCoins());
				monster.getLoot(player);
				victory = true;

			}
			else
			{
				//Implement later.
				System.out.println("You are dead.");
				victory = false;

				//call dead method (which play() checks
			}
			return victory;



	}

*/

	public void room(int row, int column, PlayerMovement movement, Scanner scan)
	{

		//Random random = new Random();
		//int roomEncounter = random.nextInt(4);

		//int terrain = 0;
		//Space_Terrain terrainType = new Space_Terrain();
		//Space_Other otherType = new Space_Other();
		//Space_Store store = new Space_Store();
		Combat combat = new Combat();
		Creature encounter;


		//if (row == 0 && column == 0)
		//{
		//	townStore(row, column);
		//}
		//if (lockbox space)  check lockbox and give locket  --method for this
		/*
		if (encounter.getClass().equals(terrainType.getClass()))
		{
			//terrain = encounter.getTerrainNumber();
			//System.out.println(terrain + "terrain");
			/*if (row == 0 && column == 0)
			{
				townStore(row, column);
			}
			else if (row == 3 && column == 2)
			{
				cityStore(row, column);
			}
			else if (row == 0 && column == 5)
			{
				if (player.equipmentCheck("Rope"))
				{
					terrain = bodhisattva();
				}
				else
				{
					terrain = 1;
				}

			}
			else if (row == 5 && column == 4)
			{
				terrain = 2;
			}
			else
			{
				terrain = 3;
			}*/
		//}

		//else if (encounter.getClass().equals(store.getClass()))
		//{
		//}



		//else if (encounter.getClass().equals(otherType.getClass()))
		//{
			//if ((row == 2 && column == 1) || (row == 5 && column == 1) || (row == 2 && column == 5))
			//{
			//	healthLocket(row, column);
			//}


				// make a methid for this. if row = & column = then  lockBox() in enconter class (give checks if player has hammer, then gives health locket
		//}
		//else
		//{
			//boolean victory = combat.battle(player, encounter, displayHp);
			
			//player.equipment.victoryEquip(victory, row, column);
			
			
			//if (row == 5 && column == 0 && victory)
			//{
			//	player.equipment.plateArmor("yes");
			//}
		//}

		/*Fruit aFruit = aMethod(); // get a fruit.
		if (aFruit instanceof Apple) {
		  Apple apple = (Apple) aFruit;
		  // do apple things with the apple.
		  apple.somethingOnlyApplesDo();
		} // else if (aFruit instanceof Banana) {
		// Do Nothing With Bananas.
		// Banana banana = (Banana) aFruit;
		// }*/


		encounter = spaces[row][column].doAction(row, column, player, movement, scan);


		
		if (encounter.getClass() != Space_Other.class 
				&& encounter.getClass() != Space_Store.class 
				&& encounter.getClass() != Space_Terrain.class) 
			    //&& encounter.getClass() != Creature_Goblin.class)
		{
			boolean victory = combat.battle(player, encounter, displayHp, scan);
			
			player.equipment.victoryEquip(victory, row, column);	
		}




	}

	/*public int bodhisattva()
	{
		Scanner scan = new Scanner(System.in);

		int answer = 1;

		System.out.println("What is the answer");

		String question = scan.nextLine();


		if (question.equals("answer"))
		{
			answer = 0;
			player.equipmentList("Time Key", "add");
		}
		else
		{
			System.out.println("WRONG, back down the mountain with you");
		}



		return answer;


	}*/


	

}




