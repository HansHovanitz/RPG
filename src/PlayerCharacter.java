import java.util.Scanner;
import java.util.Random;

public class PlayerCharacter
{
	
	protected PlayerCharacter player;
	protected ItemsConsumable items; 
	protected ItemsEquipment equipment;

	private String name;
	private int hp;
	private int maxHp;
	private int damage;
	private int armor;
	private int coins;

	private boolean resist;


	Description description = new Description();
	//Scanner scan = new Scanner(System.in);

	public PlayerCharacter(String name, int hp, int maxHp, int damage, int armor, int coins)
	{
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.damage = damage;
		this.armor = armor;
		this.coins = coins;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getHp()
	{
		return hp;
	}

	public void setHp(int hp)
	{
		this.hp = hp;
	}

	public int getMaxHp()
	{
		return maxHp;
	}

	public void setMaxHp(int maxHp)
	{
		this.maxHp = maxHp;
	}

	public int getDamage()
	{
		Random random = new Random();
		int randomDamage = random.nextInt(3) + damage;
		return randomDamage;
	}

	public void setDamage(int damage)
	{
		this.damage = damage;
	}

	public int getArmor()
	{
		return armor;
	}

	public void setArmor(int armor)
	{
		this.armor = armor;
	}

	public int getCoins()
	{
		return coins;
	}

	public void setCoins(int coins)
	{
		this.coins = coins;
	}

	public int playerCombat(String creature)
	{
		int playerDamage = getDamage();

		System.out.println("You hit the " + creature + " for " + playerDamage + " damage!");

		return playerDamage;
	}

	public int scrollCombat(String creature, int weakness)
	{
		int basicScrollDamage = 15;
		int fireDamage = 25;
		int iceDamage = 25;

		if (weakness == 1)
		{
			System.out.println("\nThe " + creature + " is weak towards fire. " + fireDamage + " damage!");
			return fireDamage;

		}
		if (weakness == 2)
		{
			System.out.println("\nThe " + creature + " is weak towards ice. " + iceDamage + " damage!");
			return iceDamage;
		}
		else
		{
			System.out.println("\nYou hit the " + creature + " for " + basicScrollDamage + " damage!");
			return basicScrollDamage;
		}


	}







	public void statusScreen(Scanner scan)
	{

		description.statusMenu();


		int statusSelection = scan.nextInt();

		System.out.println();

		if (statusSelection == 1)
		{
			System.out.println("Name: " + getName());
			System.out.println("Health Points: " + getHp() + "/" + getMaxHp());
			System.out.println("Average Attack Damage (includes equipment): " + (damage + 1));
			System.out.println("Armor Rating: " + getArmor());
			System.out.println("Coins: " + getCoins());
		}
		else if (statusSelection == 2)
		{
			equipment.viewEquipmentList();
		}
		else if (statusSelection == 3)
		{
			items.useConsumableItem("notInCombat", scan);
		}
	}

	
	public boolean option(Scanner scan)
	{
		//Scanner scan = new Scanner(System.in);
		System.out.println("Toggle this option to always display Map and Health Points.");
		System.out.println("1. On");
		System.out.println("2. Off");
		System.out.print("___");
		int options = scan.nextInt();

		if (options == 1)
		{
			return true;
		}
		else if (options == 2)
		{
			return false;
		}
		else
		{
			System.out.println("Invalid input. Option set to off.");
			return false;
		}
	}




	//Make boolean based method that checks for the players items..for example if I buy a sword or find an axe set boolean to true. If that boolean is true then +1 to player damage (or whatever)
	//Have an array for items that checks boolean status of each item. If boolean = true print out that item. Use a loop for go thru em.








	public boolean resistCheck()
	{
		return resist;
	}
	
	public void setResist(String element)
	{
		if (element.equals("fire"))
		{
			resist = true;
		}
		if (element.equals("removeFire"))
		{
			resist = false;
		}
	}




	public void passPlayer(PlayerCharacter player)
	{
		this.player = player;
		items = new ItemsConsumable(player);
		equipment = new ItemsEquipment(player);
	}



}


