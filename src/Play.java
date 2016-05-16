
import java.io.IOException;
import java.util.Scanner;

public class Play
{
	public static void main (String [] args) throws IOException 
	{
		int choice;
		Scanner scan;
		do
		{
			System.out.println("1.New Game \n2.Load Character \n3.Quit");
			scan = new Scanner(System.in);
			choice = scan.nextInt();
			if (choice != 3)
			{
				play(choice, scan);
			}
		} while (choice != 3);
		System.out.println("Thanks for playing.");
		scan.close();
		//Program ends. 
	}

	public static void play(int choice, Scanner scan) throws IOException
	{
		PlayerMovement movement = new PlayerMovement(0, 0);
		Description description = new Description();
		Map map = new Map();
		
		//Player's character is created here.
		//Character is either created or loaded depending 
		//on the choice made from starting menu (main()).
		Encounter encounter = new Encounter(choice);
		
		map.setMap('*');
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

		do{	
			if (options && menu <= 4){
				map.displayMap(movement.getRow(), movement.getColumn());
				System.out.println();
			}
			
			description.menu();
			
			do{
				menuInput = scan.next().trim();
				menu = setInput(menuInput, description);	
			}
			while (menu == 0 || menuInput == null);
			
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
				case 7:  try {
					 encounter.save();
				 }
				 catch (IOException e) {
					 System.out.println(e);
				 } break;
				case 8:  boolean check = encounter.player.option(scan);
						 if (check == true) {
							 encounter.displayHpCheck(true);
							 options = true;
						 }
						 else {	 
							 encounter.displayHpCheck(false);
							 options = false;
						 } break;	 

				case 10: //System.out.println("Thanks for playing."); break;
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
		//scan.close();
	}
	
	public static int setInput(String input, Description description)
	{
		int menu = 0;
		
		try{
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
		catch(NumberFormatException e){
			System.out.println("\n**Invalid Input** Please select another option.\n");	
			description.menu();
		}
		finally{
			if (menu > 8 && menu != 10){
				System.out.println("\n**Invalid Input** Please select another option.");
			}	
		}	
		return menu;
	}
}



