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

				try
				{
					Thread.sleep(500);
				}

				catch (InterruptedException e)
				{
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
				System.out.println("You use your rope to help you scale the mountain.");
				
				
				//bodhisattva story here
				
				System.out.println("What is the answer");

				String question = scan.nextLine();

				if (question.equals("answer"))
				{
					player.equipment.equipmentList("Time Key", "add");
				}
				else
				{
					System.out.println("WRONG, back down the mountain with you");
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
				System.out.println("YOU FALL IN THE RIVER");
				movement.setRow(6, true);
				movement.setColumn(3, true);

			}
		}
		
		//Entrance to final area here
		if (row == 5 && column == 4)
		{
			System.out.println("A mighty door stands here.");
			if (player.equipment.equipmentCheck("Time Key"))
			{
				System.out.println("You may pass.");
				
			}
			else
			{
				System.out.println("You may not pass.");
			
			}
		}
		
		//Final encounter story here
		if (row == 5 && column == 5)
		{
			if (player.equipment.equipmentCheck("Time Key"))
			{
				System.out.println(player.equipment.equipmentCheck("Time Key"));
				//All good	
				Creature_Entropy entropy = new Creature_Entropy();
				return entropy;
			}
			else
			{
				System.out.println("No key");
				movement.setRow(5, true);
				movement.setColumn(4, true);
			}
			
		}
		return terrain;
	}
}
		


