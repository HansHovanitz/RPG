//import java.util.ArrayList;
import java.util.Scanner;

public class Creature_LavaHydra extends Creature implements MapSpaces
{
	public Creature_LavaHydra()
	{
		super("Lava Hydra", 10, 5, 9);
		//this.fire = false;
	}
	
	public Creature doAction(int row, int column, PlayerCharacter player, PlayerMovement movement, Scanner scan)
	{
		Creature_LavaHydra hydra = new Creature_LavaHydra();
		
		int i = 0;
		//Scanner scan = new Scanner(System.in);
		do {
			System.out.println("TEST");
			player.setHp(50);
			i++;
			scan.nextInt();
		} while (i < 3);
		
		
		return hydra;
	}

}
