//import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Creature_LavaHydra extends Creature implements MapSpaces
{
	private boolean ice = false;
	private int turn;
	private int []heads = new int[3];
	
	
	public Creature_LavaHydra()
	{
		super("Lava Hydra", 100, 5, 9);
		heads[0] = 30;
		heads[1] = 30;
		heads[2] = 30;
	}
	
	public Creature doAction(int row, int column, PlayerCharacter player, PlayerMovement movement, Scanner scan)
	{
		Creature_LavaHydra hydra = new Creature_LavaHydra();
		System.out.println("Before you a enormous Hydra slithers out of the molten river.\n"
				+ "The creature has three equally terrifying heads.");
		return hydra;
	}
	
	
	//Hydra's attack. Need to implement. 
	public int creatureCombat(int armor, int block)
	{
		int creatureDamage = (getDamage() / block);
		int totalDamage = creatureDamage - armor;
		
		System.out.println("");
		
		
		
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
			extraDamage = 0;
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
		
		if (miss == true)
		{
			System.out.println("You swing at the air and, not to your surprise, don't hit anything");
		}
		else
		{
			int playerDamage = player.getDamage();
			
			if (head == 1)
			{
				heads[0] -= playerDamage;
				System.out.println("You strike the Hydra's left head for " + playerDamage + "damage!");
			}
		}
	
	}
	
	public void getLoot(PlayerCharacter player)
	{
		player.equipment.timeSword("yes");
		System.out.println("\nDead Hydra.");
	}

}
