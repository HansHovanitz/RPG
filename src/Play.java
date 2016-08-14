
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Play
{
	public static void main (String [] args) throws IOException 
	{
	    int choice = 1;
	    Scanner scan = new Scanner(System.in);
	    do
	    {
	        try {
	            System.out.println("1.New Game \n2.Load Character \n3.Quit");
	            choice = scan.nextInt();
	            if (choice > 0 && choice < 3)
	            {
	                play(choice, scan);
	            }
	        }
	        catch (InputMismatchException e) {
	        	scan.next();
	            System.out.println("Invalid Input\n");
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
		boolean finishedGame = false; 
		int menu = 0;
		String menuInput;
		
		//Debugging Area
		//-------------------------------------------
		
		//movement.setRow(0, true);
		//movement.setColumn(4, true);
		
		//-------------------------------------------

		do{	
			if (options && menu <= 4 && menu >= 1){
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

				case 9:  System.out.println("Are you sure you want to abandon your quest? Yes or No?");
						 String confirm = scan.next().toLowerCase();
						 if (confirm.equals("yes")) {
							 finishedGame = true;
						 } break;
				default:  break;
			}
			
			if (menu < 8 && menu > 0)
			{
				map.updateMap(movement.getRow(), movement.getColumn());
				if (movement.getWallCheck() == false && menu < 5)
				{
					encounter.room(movement.getRow(), movement.getColumn(), movement, scan);
				}
				System.out.println();
			}
			
			//Check to see if game is over. 
			if (finishedGame == false)
			{
				finishedGame = encounter.end();
			}	
		}
		while (!finishedGame);
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
			if (menu > 9 || menu < 1){
				System.out.println("\n**Invalid Input** Please select another option.");
			}	
		}	
		return menu;
	}
}



