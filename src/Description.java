

public class Description
{
	public Description ()
	{
	}

	public void enterRoom()
	{
		System.out.println("You enter the room...");
	}

	public void intro()
	{
		System.out.println("Welcome to the adventure!\n");

		for (int i = 0; i < 5; i++)
		{
			System.out.print(".  ");

			try
			{
				Thread.sleep(1000);
			}

			catch (InterruptedException e)
			{
				System.out.println(e.getMessage());
			}
		}
		System.out.println();
	}

	public void menu()
	{
		System.out.println("What would you like to do now?");
		System.out.println("1. Move 'Up'");
		System.out.println("2. Move 'Down'");
		System.out.println("3. Move 'Left'");
		System.out.println("4. Move 'Right'");
		System.out.println("5. View Map");
		System.out.println("6. See My Status");
		System.out.println("7. Options");
		System.out.print("___");
	}

	public void combatMenu()
	{
		System.out.println("\nWhat would you like to do now?");
		System.out.println("1. Attack");
		System.out.println("2. Block");
		System.out.println("3. Use Item");
		System.out.println("4. My Health");
		System.out.print("___");
	}

	public void statusMenu()
	{
		System.out.println("What would you like to view?");
		System.out.println("1. Character Information");
		System.out.println("2. Equipment");
		System.out.println("3. Consumable Items");
		System.out.print("___");
	}

	public void merchantOneMenu()
	{
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
	
	public void healerMenu()
	{
		System.out.println("\n1. Heal 10 points of health\t\t 5 coins");
		System.out.println("2. Heal to your full health\t\t 10 coins");
		System.out.println("3. Leave the area");
	}

	public void hints()
	{

	}









//LOOKS LIKE THIS IS MOSTLY DONE IN MONSTER CLASSES. 
	//Room descriptions
	public void room(int row, int column, int roomEncounter)
	{
		if (row == 0 && column == 0)
		{
			System.out.println("You enter the room...");
			System.out.println("A merchant greets you.");
		}
		else if (row == 1 && column == 0)
		{

			if (roomEncounter == 0)
			{
				System.out.println("You find nothing here...");
			}
			else
			{
				System.out.println("A Goblin awaits you!");
			}
		}
		else if (row == 2 && column == 0)
		{
			//System.out.println("You enter the room...");
			//System.out.println("There is nothing there");
		}




		else if (row == 2 && column == 0)
		{
			if (roomEncounter == 0 || roomEncounter == 1)
			{
				System.out.println(" TESTORC A orc attacks!");
			}
			else
			{
				System.out.println("TEST ORC You notice some bones strewn about the area, but there is no sign of any immediate danger.");
			}
		}
		//etc.

		else if (row == 3 && column == 0)
		{
		}

		else if (row == 4 && column == 0)
		{
		}

		else if (row == 5 && column == 0)
		{
		}





		else if (row == 0 && column == 1)
		{
		}

		else if (row == 1 && column == 1)
		{
		}

		else if (row == 2 && column == 1)
		{
		}
		else if (row == 3 && column == 1)
		{
		}

		else if (row == 4 && column == 1)
		{
		}

		else if (row == 5 && column == 1)
		{
		}












		else if (row == 2 && column == 2)
		{
			System.out.println("A fat ogre awakes!");
		}
	}
}