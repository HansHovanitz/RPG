import java.util.InputMismatchException;
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
	
	public int getForm()
	{
		return form;
	}
	
	public void setForm(int form)
	{
		this.form = form;
	}
	
	public Creature doAction(int row, int column, PlayerCharacter player, PlayerMovement movement, Scanner scan)
	{
		Creature_Entropy entropy = new Creature_Entropy();
		return entropy;
	}
 
	public void battleEntropy(PlayerCharacter player, Creature_Entropy monster, Scanner scan, int attackType, String scroll)
	{
		if (form == 1){
			
		}
		
	}
	
	
	
	
	
	
	
	

	
	public void headHelper(int damageDone)
	{
		if (damageDone > 15)
		{
			System.out.println("The head still looks close to full health.");
		}
		else if (damageDone > 0)
		{
			System.out.println("The head is visibly damaged.");
		}
		else
		{
			System.out.println("You cut off the hydra's head!");
		}
		System.out.println("");
	}

}