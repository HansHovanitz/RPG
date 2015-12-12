import java.util.Scanner;

public class Creature_Orc extends Creature implements MapSpaces
{
	public Creature_Orc()
	{
		super("Orc", 11, 4, 6);
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
			System.out.println("An orc attacks you!");
			Creature_Orc orc = new Creature_Orc();
			return orc;
		}

	}


}