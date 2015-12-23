import java.util.Scanner;

public class Creature_IceDemon extends Creature implements MapSpaces
{
	protected boolean fire;

	public Creature_IceDemon()
	{
		super("Balroth the Ice Demon", 10, 5, 9);
		this.fire = false;
	}

	public Creature doAction(int row, int column, PlayerCharacter player, PlayerMovement movement, Scanner scan)
	{
		if (player.equipment.equipmentCheck("Plate Armor"))
		{
			System.out.println("An eerie stillness permeates your senses. However, the altar is still destroyed and "
					+ "you know \nthat the deamon is dead. There is nothing to fear here. You must continue onward with your quest.");
			Space_Other other = new Space_Other();
			return other;
		}
		else
		{
			System.out.println("The swirling snow and strong winds continue to increase. Before you a great altar is visible.\n"
					+ "As you cautiosuly approach the runic symbols on the alter begin to glow and the shadowy form of an ancient\n"
					+ "demon materializes.");
			Creature_IceDemon demon = new Creature_IceDemon();
			return demon;
		}
	}

	public int creatureCombat(int armor, int block)
	{
		int creatureDamage = (getDamage() / block);
		int totalDamage = creatureDamage - armor;
		
		if (armor > totalDamage)
		{
			totalDamage = 0;
		}
		
		System.out.println(getName() + " does " + totalDamage + " (" + creatureDamage + "-" + armor + ") damage!");

		if (fire == false)
		{
			System.out.println("The Demon regenerates 8 Health.");
			this.hp = hp + 8;
		}	
		return totalDamage;
	}

	public int weakness(String element)
	{
		if (element.equals("fire"))
		{
			fire = true;
			System.out.println("The Demon roars angrily as the fire surrounds it. \n The " + getName() + " will no longer regenerate.");
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public void getLoot(PlayerCharacter player)
	{
		player.equipment.plateArmor("yes");
		System.out.println("\nWhere the mighty Demon once stood appears a pack with ordained with what appears to be long-"
		+ "forgotten runic symbols of some sort. \nAfter cautiously opening the pack you find that a set of old, yet "
		+ "intact plate armor is within. \nThis certainly looks more sturdy than your current armor.");
	}
}