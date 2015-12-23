import java.util.Scanner;

public class Creature_Ogre extends Creature implements MapSpaces
{
	protected int turn;

	public Creature_Ogre()
	{
		super("Ogre", 32, 4, 9);
		this.turn = 0;
	}

	public Creature doAction(int row, int column, PlayerCharacter player, PlayerMovement movement, Scanner scan)
	{
		Creature_Ogre ogre = new Creature_Ogre();
		System.out.println("An ogre attacks you!");
		return ogre;
	}

	public int creatureCombat(int armor, int block)
	{

		int creatureDamage = (getDamage() / block);
		int totalDamage = creatureDamage - armor;
		if (armor > totalDamage)
		{
			totalDamage = 0;
		}
		turn ++;

		if (turn == 1 || turn == 2)
		{
			System.out.println("The " + getName() + " grunts and slams you for " + totalDamage + " (" + creatureDamage + "-" + armor + ") damage!");
			if (armor > totalDamage)
			{
				totalDamage = 0;
			}
		}
		else if (turn == 3)
		{
			System.out.println("The " + getName() + " begings to strain himself and lifts his giant club above his head in a menacing fashion.");
			totalDamage = 0;
		}
		else if (turn == 4)
		{
			if (block == 1)
			{
				System.out.println("The " + getName() + " roars and crushes his club into you for 12 (armor ignored) damage!");
				totalDamage = 12;
			}
			else
			{
				System.out.println("The main brunt of the " + getName() + "'s club glances off your shield. \nYou take 3 (armor ignored) damage!");
				totalDamage = 3;
			}

			turn = 0;
		}
		return totalDamage;
	}
}


