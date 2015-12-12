import java.util.Scanner;

public class Creature_Troll extends Creature implements MapSpaces
{
	protected boolean fire;

	public Creature_Troll()
	{
		super("River Troll", 10, 5, 9);
		this.fire = false;
	}

	public Creature doAction(int row, int column, PlayerCharacter player, PlayerMovement movement, Scanner scan)
	{
		Creature_Troll troll = new Creature_Troll();
		if (row == 0 && column == 4)
		{
			System.out.println("As you begin to make your way across the river you notice movement around a collection\n"
					+ "of boulders near the water's edge. Before you can fully gather your thoughts a lanky river troll\n"
					+ "springs forward from behind the rocks to attack you!");
		}
		else
		{
		System.out.println("You are attacked by a troll!");
		}
		return troll;
	}

	public int creatureCombat(int armor, int block)
	{
		int creatureDamage = (getDamage() / block);
		int totalDamage = creatureDamage - armor;
		
		if (armor > totalDamage)
		{
			totalDamage = 0;
		}
		
		System.out.println("The " + getName() + " giggles and whacks you for " + totalDamage + " (" + creatureDamage + "-" + armor + ") damage!");

		if (fire == false)
		{
			System.out.println("The Troll regenerates 5 Health.");
			this.hp = hp + 5;
		}
		return totalDamage;
	}

	public int weakness(String element)
	{
		if (element.equals("fire"))
		{
			fire = true;
			System.out.println("The troll shrieks as it is scorched by the fire. \nThe troll will no longer regenerate.");
			return 1;
		}
		else
		{
			return 0;
		}
	}
}