import java.util.Scanner;

public class Creature_Entropy extends Creature implements MapSpaces
{
	public Creature_Entropy()
	{
		super("Entropy", 10, 5, 9);
		//this.fire = false;
	}
	
	public Creature doAction(int row, int column, PlayerCharacter player, PlayerMovement movement, Scanner scan)
	{
		Creature_Entropy entropy = new Creature_Entropy();
		return entropy;
	}

}