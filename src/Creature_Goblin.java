import java.util.Scanner;

public class Creature_Goblin extends Creature implements MapSpaces
{
	public Creature_Goblin()
	{
		super("Goblin", 7, 2, 4);
	}

	public Creature doAction(int row, int column, PlayerCharacter player, PlayerMovement movement, Scanner scan)
	{
		int encounter = randomEncounter(4);
		
		if (encounter == 0)
		{
			Space_Other other = new Space_Other();
			System.out.println("There doesn't appear to be anything here.");
			return other;
		}
		else
		{
			System.out.println("A goblin attacks you!");
			Creature goblin = new Creature_Goblin();
			return goblin;
		}
	}
}