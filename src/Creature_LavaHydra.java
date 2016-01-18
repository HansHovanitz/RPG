import java.util.InputMismatchException;
import java.util.Scanner;

public class Creature_LavaHydra extends Creature implements MapSpaces
{
	private boolean ice = false;
	private int []heads = new int[3];
	
	
	public Creature_LavaHydra()
	{
		super("Lava Hydra", 100, 3, 9);
		heads[0] = 25;
		heads[1] = 25;
		heads[2] = 25;
	}
	
	public Creature doAction(int row, int column, PlayerCharacter player, PlayerMovement movement, Scanner scan)
	{
		if (player.equipment.equipmentCheck("Time Sword"))
		{
			Space_Other other = new Space_Other();
			System.out.println("The Lava Hydra's hulking corpse still lays here. \n"
					+ "You must continue on with your quest.");
			return other;
		}
		else
		{
			Creature_LavaHydra hydra = new Creature_LavaHydra();
			System.out.println("Before you a enormous Hydra slithers out of the molten river.\n"
					+ "The creature has three equally terrifying heads.");
			return hydra;
		}
	}
	 
	public int creatureCombat(int armor, int block)
	{
		int creatureDamage = (getDamage() / block);
		int totalDamage = 0;
		int headCount = 0;
		
		for (int i = 0; i < heads.length; i++)
		{
			if (heads[i] > 0)
			{
				System.out.println("You are hit by one of the hydra's heads.");
				totalDamage += (creatureDamage - armor);
				headCount++;
			}
		}
		System.out.println("");
		System.out.println("The " + getName() + "'s head(s) does " + totalDamage + " "
				+ "(" + (creatureDamage * headCount) + "-" + (armor * headCount) + ") damage!");
	
		return totalDamage;
	}
	
	public int weakness(String element)
	{
		if (element.equals("ice"))
		{
			ice = true;
			System.out.println("\nThe molten hide of the hydra momentairly freezes, the fluid lava crystallizing.\n"
					+ "The beast then seems to recover. However, it will no longer regenerate.");
			return 2;
		}
		else
		{
			return 0;
		}
	}
	
	public int strength(boolean resist)
	{
		int extraDamage = 0;
		
		if (resist)
		{
			System.out.println("Your armor helps reflect the extra heat damage");
		}
		else
		{	
			System.out.println("You take an extra 5 fire damage.");
			extraDamage = 5;
		}
		return extraDamage;
	}
	
	//Implement 3 heads. 
	public void battleHydra(PlayerCharacter player, Creature_LavaHydra monster, Scanner scan)
	{
		int head = 0;
		boolean miss = false;
		System.out.println("Which head do you attack?");
		System.out.print("1\n2\n3\n___");
		
		try
		{
			head = scan.nextInt();
			if (head > 3 || head < 1)
			{
				miss = true;
			}
		}
		catch(InputMismatchException e)
		{
			scan.nextLine();
			miss = true;
		}
		
		System.out.println("");
		
		if (miss == true)
		{
			System.out.println("You swing at the air and, not to your surprise, don't hit anything.");
		}
		else
		{
			int playerDamage = player.getDamage();
			
			if (head == 1)
			{
				heads[0] -= playerDamage; 
				System.out.println("You strike the Hydra's left head for " + playerDamage + " damage!");
				headHelper(heads[0]);
			}
			if (head == 2)
			{
				heads[1] -= playerDamage;
				System.out.println("You strike the Hydra's middle head for " + playerDamage + " damage!");
				headHelper(heads[1]);
			}
			if (head == 3)
			{
				heads[2] -= playerDamage;
				System.out.println("You strike the Hydra's right head for " + playerDamage + " damage!");
				headHelper(heads[2]);
			}
			
			//Debug
			//System.out.println(heads[0]);
			//System.out.println(heads[1]);
			//System.out.println(heads[2]);
			
			
			//Regenerate hydra heads
			int headCheck = 0;
			for (int i = 0; i < heads.length; i++)
			{
				if (heads[i] < 0)
				{
					headCheck++;
					for (int j = 0; j < heads.length; j++)
					{
						if (heads[j] > 15 && ice != true)
						{
							heads[i] = 20;
							headCheck--;
							if (i == 0)
							{
								System.out.println("The hydra's left head regrows!");
								break;	
							}
							else if (i == 1)
							{
								System.out.println("The hydra's middle head regrows!");
								break;
							}			
							else
							{
								System.out.println("The hydra's right head regrows!");
								break;
							}		
						}
					}
				}
				if (heads[i] > 15)
				{
					System.out.print("O");
				}
				else if (heads[i] > 0 && heads[i] < 15)
				{
					System.out.print("o");
				}
				else
				{
					System.out.print("x");
				}
				System.out.print("  ");
			}
			System.out.println("");
			
			if (headCheck == 3)
			{
				monster.setHp(0);
				//System.out.println("Dead");
			}
			headCheck = 0;
		}
	}
	
	public void headHelper(int damageDone)
	{
		if (damageDone > 15)
		{
			System.out.println("The head still looks close to full health.");
		}
		else if (damageDone > 0)
		{
			System.out.println("The head is visibly damaged.");
		}
		else
		{
			System.out.println("You cut off the hydra's head!");
		}
		System.out.println("");
	}
	
	public void getLoot(PlayerCharacter player)
	{
		if (player.equipment.equipmentCheck("Time Sword"))
		{
			//Already have time sword
		}
		else
		{
			player.equipment.timeSword("yes");
			System.out.println("After the hydra has collapsed and you are sure there is no more immediate danger, +"
					+ "you notice an ornate chest. Perhaps the hydra has been guarding the treasure. \n"
					+ "Inside the chest you find silver sword that looks ordinary at first. However, upon closer \n"
					+ "inspection, you realize that this must be the fabled 'Time Sword'. Temporal whisps dance \n"
					+ "around the sword's blade, appearing to fade in and out of existence. \n"
					+ "This should certainly help you in your adventure.");
		}
	}
}
