
import java.io.IOException;
import java.util.Scanner;

public class Play
{
	public static void main (String [] args) throws IOException 
	{
		System.out.println("1.New Game \n2.Load Character");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();


		play(choice, scan);

	}

	public static void play(int choice, Scanner scan) throws IOException
	{
		PlayerMovement movement = new PlayerMovement(0, 0);
		Description description = new Description();
		Map map = new Map();
		map.setMap('*');
		Encounter encounter = new Encounter(choice);
		encounter.buildMapSpaces();
		
		if (choice == 1)
		{
			//Enable this when done. 
			//description.intro();
			
			encounter.start();
		}
		

		

		boolean options = false;
		int menu = 0;
		String menuInput;

		do
		{	
			if (options && menu <= 4)
			{
				map.displayMap(movement.getRow(), movement.getColumn());
				System.out.println();
			}
			
			description.menu();
			
			do
			{
				menuInput = scan.next().trim();
				menu = setInput(menuInput, description);	
			}
			while (menu == 0 || menuInput == null);
			
			//menu = scan.nextInt();
			
			System.out.println();
			map.updateMap(movement.getRow(), movement.getColumn());

			switch (menu)
			{
				case 1:  movement.setRow(menu); break;
				case 2:  movement.setRow(menu); break;
				case 3:  movement.setColumn(menu); break;
				case 4:  movement.setColumn(menu); break;
				case 5:  map.displayMap(movement.getRow(), movement.getColumn()); break;
				case 6:  encounter.player.statusScreen(scan); break;
				case 7:  boolean check = encounter.player.option(scan);
						 if (check == true) {
							 encounter.displayHpCheck(true);
							 options = true;
						 }
						 else {	 
							 encounter.displayHpCheck(false);
							 options = false;
						 } break;	 
				case 8:  try {
							 encounter.loadAndSave();
						 }
						 catch (IOException e) {
							 System.out.println(e);
						 } break;
				case 10: System.out.println("Thanks for playing."); break;
				//Put a check here to make sure, then exit the program. 
				default:  break;
			}
			
			//Debug
			//System.out.println(menu);
			
			if (menu < 8 && menu != 10)
			{
				map.updateMap(movement.getRow(), movement.getColumn());
				if (movement.getWallCheck() == false && menu < 5)
				{
					encounter.room(movement.getRow(), movement.getColumn(), movement, scan);
				}
				System.out.println();
			}
		}
		//Implement quit later.
		while (menu != 10);
		scan.close();
	}
	
	public static int setInput(String input, Description description)
	{
		int menu = 0;
		
		try 
		{
			if (input.equals("w"))
				menu = 1;
			else if (input.equals("s"))
				menu = 2;
			else if (input.equals("a"))
				menu = 3;
			else if (input.equals("d"))
				menu = 4;
			else 
				menu = Integer.parseInt(input);	
		}
		catch(NumberFormatException e)
		{
			System.out.println("\n***Invalid Input. Please select another option.\n");	
			description.menu();
		}
		finally
		{
			if (menu > 8 && menu != 10)
			{
				System.out.println("\n***Invalid Input. Please select another option.");
			}	
		}	
		return menu;
	}
}



