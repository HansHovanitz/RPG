import java.util.Scanner;

public class Creature_Entropy extends Creature implements MapSpaces
{
	private int form;
	private int part[];
	private boolean timeSword;
	
	
	public Creature_Entropy()
	{
		super("Entropy", 10, 5, 9);
		form = 0;
		part = new int[]{40, 20, 20};
		timeSword = false;
	}
	
	public Creature doAction(int row, int column, PlayerCharacter player, PlayerMovement movement, Scanner scan)
	{
		Creature_Entropy entropy = new Creature_Entropy();
		System.out.println("entropy test");
		return entropy;
	}

}