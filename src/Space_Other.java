import java.util.Scanner;

public class Space_Other extends Creature implements MapSpaces
{
	protected boolean lockBox;
	protected boolean healerSwitch;
	protected boolean visionSwitch;
	protected Description description;

	public Space_Other()
	{
		super("Other", 0, 0, 0);
		description = new Description();
		this.healerSwitch = false;
		this.visionSwitch = false;
	}

	public Creature doAction(int row, int column, PlayerCharacter player, PlayerMovement movement, Scanner scan)
	{
		//Scanner scan = new Scanner(System.in);
		Space_Other other = new Space_Other();

		//Lock Box Spaces
		if ((row == 2 && column == 1) || (row == 2 && column == 5) || (row == 5 && column == 1))
		{
			lockBox(row, column, player);
		}



		if (row == 0 && column == 1)
		{
			System.out.println("The area is moderately forested.");
			System.out.println("To the South you can see what looks to be an endless colletion of trees.");
			System.out.println("To the East the trees begin to thin slightly and it sounds as if there is water in the distance");
		}

		if (row == 0 && column == 3)
		{
			System.out.println("While continuing through the forrest you hear the sound of water getting louder to the East.");
		}
		
		if (row == 1 && column == 5)
		{
			System.out.println("Standing beside the river, you look around to get a sense of direction. To the North a giant looming\n"
					+ " mountain dominates the skyline. To the South you can see faint hints of what looks to be smoke and steam rising\n"
					+ ". To the West is more forrest and river lands. To the East the river continues its meandering flow. You are certain\n"
					+ " that you could continue following the river East forever and never reach its end. That adventure will have to\n"
					+ " wait for another day."); 
			
		}
		
		if (row == 3 && column == 3)
		{
			System.out.println("Smooth rolling hills stretch out before you. To the West is \'The City\', to the North is a forrest, and to\n"
					+ " the South and East the great lava fields slowly ooze and bubble.");
			
		}
		
		if (row == 4 && column == 0)
		{
			System.out.println("Flakes of slows spin lazily in the hazy sky. Their is a cartian calmness that accompanies the\n +"
					+ " cold. Before you can become truly tranquil however, strong gusts of fridged air begin to mount from the South\n +"
					+ ", as if someone, or something, has sensed you getting closer.");
		}
		
		
		
		//Vision Quest
		if (row == 4 && column == 1)
		{
			if (visionSwitch == false)
			{
				System.out.println("Thin whips of fog dance eerily on the moist ground as you come into a clearing.\n"
						+ "This must be the place.");
				//Story for vision quest here.
				
				visionSwitch = true;
			}
			
		}
		
		if (row == 4 && column == 3)
		{
			int choice;
			
			if (healerSwitch == false)
			{
				System.out.println("As you approach a ramshackle hut nestled between a collection of oddly vibrant trees an elderly"
					+ " man sitting \nin front of the hut seems to take notice of you and slowly rises to his feet. \nHealer: Hello my friend,"
					+ "stay awhile and listen. I can aid in the healing of your wounds provided you pay me a sum that that I may later"
					+ "replenish my supplies.");
				
				healerSwitch = true;
			}
			else
			{
				System.out.println("Healer: Hello " + player.getName() + " are you in need of healing again?");	
			}
			
			description.healerMenu();
			choice = scan.nextInt();
			
			switch (choice)
			{
				case 1: if (player.getHp() + 10 > player.getMaxHp())
						{
							player.setHp(player.getMaxHp());
							System.out.println("\nYou have been healed!");
						}
						else
						{
							player.setHp(player.getHp() + 10);
							System.out.println("\nYou have been healed!");
						}
						break;
				case 2:		player.setHp(player.getMaxHp());
							System.out.println("\nYou have been healed!");
						break;
				case 0:	break;
				default:break;	
			}
			

			
			
			
		
			
			
		}
		


		//if ((row == 3 && column == 1) || (row == 3 && column == 1) || (row == 3 && column == 1))
		//{
			//this.lockBox = true;
		//}


		return other;
	}


	public void lockBox(int row, int column, PlayerCharacter player)
	{
		System.out.println("You enter a clearing and find a chest.");
		if (player.equipment.equipmentCheck("Hammer"))
		{	
			player.equipment.healthLocket("yes", row, column);
		}
		else
		{
				System.out.println("The chest appears locked. If only you had something to bash this open with...");
		}
	}

	public boolean getLockBox()
	{
		return lockBox;
	}

	public void setLockBox(boolean lockBox)
	{
		this.lockBox = lockBox;
	}
}