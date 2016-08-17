import java.util.Scanner;

public class Space_Terrain extends Creature implements MapSpaces
{
	protected int terrainNumber;
	protected boolean mountainSwitch;

	public Space_Terrain()
	{
		super("Terrain", 0, 0, 0);
		this.mountainSwitch = false;
	}

	public int getTerrainNumber()
	{
		return terrainNumber;
	}

	public void setTerrainNumber(int terrainNumber)
	{
		this.terrainNumber = terrainNumber;
	}

	public Creature doAction(int row, int column, PlayerCharacter player, PlayerMovement movement, Scanner scan)
	{
		Space_Terrain terrain = new Space_Terrain();
		
		if ((row == 4 && column == 4) || (row == 4 && column == 5))
		{
			System.out.println("As you approach the fiery river you succumb to the intense heat...");

			for (int i = 0; i < 5; i++)
			{
				System.out.print(".  ");

				try {
					Thread.sleep(500);
				}

				catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			
			if (player.getHp() >= 5)
			{
				System.out.println("\nAs you regain some semblance of consciousness you find yourself in a healer's hut.");
				System.out.println("Healer: " + player.getName() + " you must be careful. I found you near dead.");
				
				if (player.equipment.equipmentCheck("Plate Armor"))
				{
					System.out.println("\nLuckily it appears your armor shielded you somewhat and you should be able to continue on.");
				}
				else
				{
					System.out.println("I was able to get you here and heal some of your wounds. Next time you may not be so lucky.");
					player.setHp(8);
				}
				//Move player.
				movement.setRow(4, true);
				movement.setColumn(3, true);
			}
			else
			{
				//Player is dead.
				player.dead(); 
				movement.setRow(0, true);
				movement.setColumn(0, true);
			}
		}
		
		if (row == 0 && column == 5)
		{
			System.out.println("As you make your way out of the river a tall, rocky mountain stands before you.");

			if (player.equipment.equipmentCheck("Rope"))
			{
				//Bodhisattva
				System.out.println("You use your rope to help you scale the mountain.\n When you reach the top of the mountain you "
						+ "you see a few trees and nestled between them is a small temple not much larger than a shack. It appears to "
						+ "be crafted with wood that was once brilliant blue and red but is now so faded with age that it has nearly "
						+ "to its natural color.\n Sitting in front of the temple is an old man in. The top of his head is bare but he "
						+ "has a suprisingly well kept long black beard. As you approach the man he does not shift his gaze to look at "
						+ "you. When you are standing but a few feet from him he begins to speak...");		
				System.out.println("Bodhisattva: The poor have it. The rich need it. If you eat it you will surely die.");
				System.out.println("Bodhisattva: What is it?");
				System.out.print("___");

				String question = scan.nextLine().toLowerCase();

				if (question.equals("nothing"))
				{
					System.out.println("Bodhisattva: It does not concern me what happens to this world. But it is clear that you wish to "
							+ "save it. You have demonstrated an ability to confront challenges with tools other than weapons. If you are "
							+ "to indeed save this world you will need to use your mind as well as a sword. I will give you the Time Key. "
							+ "It will allow you to pass through the Door of Chronos and confront entropy before it makes its way to this "
							+ "world and devours it. The Door of Chronos lies far to the south. On your journey there you may come across "
							+ "rivers of lava. Somewhere in that area lives an ancient beat -- a lava hydra. It is said that the hydra "
							+ "guards a 'Time Sword'. It is not necessary to face Entropy with the Time Sword, but it will surley help "
							+ "you. Good luck " + player.getName() + ".");
					player.equipment.equipmentList("Time Key", "add");
				}
				else
				{
					System.out.println("Bodhisattva: I'm sorry " + player.getName() + " " + question + " is not correct.\nI can see you "
							+ "must ponder this question further.");
					for (int i = 0; i < 3; i++)
					{
						System.out.print(".  ");

						try {
							Thread.sleep(500);
						}

						catch (InterruptedException e) {
							System.out.println(e.getMessage());
						}
					}
					System.out.println("Before you can finish thinking about what the Bodhisattva said he closes his eyes and mutters "
							+ "something in a long forgotten tongue. You then find yourself back at the base of the mountain.");
					movement.setRow(6, true);
					movement.setColumn(5, true);
				}
			}
			else if(mountainSwitch == false)
			{
				System.out.println("You cautiously begin to ascend the great mountain but accidently slip and plummet "
						+ "towards the water\nbelow. The next thing you remember is your eyes slowly opening as you are"
						+ "staring up into the vast sky. \nYou must have fallen into the river and were carried by its current"
						+ "before settling on its winding shore.");
				movement.setRow(6, true);
				movement.setColumn(3, true);
				mountainSwitch = true;
			}
			else
			{
				System.out.println("You begin to make your way up the mountain but it soon becomes apparent that "
						+ "this was a poor life choice.\nThe rocks are too slippery. As you tumble down the mountain "
						+ "you think to yourself that there must be a\nbetter way to approach this situation.");
				movement.setRow(6, true);
				movement.setColumn(3, true);

			}
		}
		
		//Entrance to final area. 
		if (row == 5 && column == 4)
		{
			System.out.println("A mighty door stands here. This is the Door of Chronos. You know that the door must have a finite height and width but "
					+ "it seems to stretch on forever. It was forged before the oldest recordings of history by some long "
					+ "vanished elder race to serve as a barrier to hold back decay. However, due to the entropy seeping into "
					+ "your world, the door is now faintly shimmering and pulsing. You know that before long the door will fall "
					+ "and your world will be consumed by entropy until, eventually there is 'nothing' left.\n");
			if (player.equipment.equipmentCheck("Time Key"))
			{
				System.out.println("You possess the Time Key. You take a deep breath and step forward into the door.");
				
			}
			else
			{
				System.out.println("You do not yet possess the Time Key. You must continue the search.");
			
			}
		}
		
		//Final encounter story here
		if (row == 5 && column == 5)
		{
			if (player.equipment.equipmentCheck("Time Key"))
			{
				//System.out.println(player.equipment.equipmentCheck("Time Key"));	
				Creature_Entropy entropy = new Creature_Entropy();
				return entropy;
			}
			else
			{
				System.out.println("You do not possess the Time Key. You will need this item to enter the entropy door.");
				movement.setRow(5, true);
				movement.setColumn(4, true);
			}	
		}
		return terrain;
	}
}
		


