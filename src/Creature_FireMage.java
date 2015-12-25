//import java.util.Random;
import java.util.Scanner;

public class Creature_FireMage extends Creature implements MapSpaces
{
	protected boolean ice;
	protected int turn;

	public Creature_FireMage()
	{
		super("Fire Mage", 50, 5, 5);
		this.ice = false;
	}

	public Creature doAction(int row, int column, PlayerCharacter player, PlayerMovement movement, Scanner scan)
	{
		Creature_FireMage fireMage = new Creature_FireMage();
		return fireMage;
	}

	public int creatureCombat(int armor, int block)
	{
		int creatureDamage = (getDamage() / block);
		int totalDamage = creatureDamage - armor;
		turn ++;

		if (turn == 1)
		{
			if (armor > totalDamage)
			{
				totalDamage = 0;
			}
			System.out.println("The " + getName() + " strikes you with his staff for " + totalDamage + " (" + creatureDamage + "-" + armor + ") damage!");
		}
		if (turn == 2)
		{
			System.out.println("The " + getName() + " begins to channel his energy...");
			totalDamage = 0;
		}
		if (turn == 3)
		{
			if (ice == true)
			{
				System.out.println("The " + getName() + " struggles to regain his concentration and is only able to hit you for 3 damage!");
				totalDamage = 3;
			}
			else
			{
				System.out.println("The " + getName() + " hurls a mighty fireball towards you doing 12 (armor ignored) damage!");
				System.out.println("You need to think of a way to slow the 'fire' mage down.");
				totalDamage = 12;
			}
			turn = 0;
		}
		return totalDamage;
	}

	public int weakness(String element)
	{
		if (element.equals("ice"))
		{
			ice = true;
			System.out.println("\nThe mage grimmaces as the cold visibly rattles his concentration.");
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
			if (turn != 2 && ice != true)
			{
				System.out.println("You take an extra 5 fire damage.");
				extraDamage = 5;
			}
		}
		return extraDamage;
	}
}