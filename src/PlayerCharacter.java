import java.util.Scanner;
import java.util.Random;

public class PlayerCharacter implements java.io.Serializable
{
	private static final long serialVersionUID = 999;
	protected PlayerCharacter player;
	protected ItemsConsumable items; 
	protected ItemsEquipment equipment;
	protected Description description = new Description();
	protected int deaths;
	private String name;
	private int hp;
	private int maxHp;
	private int damage;
	private int armor;
	private int coins;
	private boolean resist;

	public PlayerCharacter()
	{
		//Default Constructor 
	}
	
	public PlayerCharacter(String name, int hp, int maxHp, int damage, int armor, int coins)
	{
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.damage = damage;
		this.armor = armor;
		this.coins = coins;
		deaths = 0;
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
		int basicScrollDamage = 10;
		int fireDamage = 20;
		int iceDamage = 20;

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
			System.out.println("\nYour spell hits the " + creature + " for " + basicScrollDamage + " damage!");
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
		System.out.println("Toggle this option to always display Map and Health Points.");
		System.out.println("1. On");
		System.out.println("2. Off");
		System.out.print("___");
		int options = scan.nextInt();
		System.out.println("");

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
			System.out.println("**Invalid input** Option set to off.");
			return false;
		}
	}

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

	//Access player equipment and consumables.
	public void passPlayer(PlayerCharacter player)
	{
		this.player = player;
		items = new ItemsConsumable(player);
		equipment = new ItemsEquipment(player);
	}
	
	public void dead()
	{
		System.out.println("\nYou are dead.");
		for (int i = 0; i < 5; i++)
		{
			System.out.print(".  ");

			try{
				Thread.sleep(1000);
			}
			catch (InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
		System.out.println("You awaken back where your journey began... but you"
				+ "feel like something has diminished, like a small piece of you"
				+ "has been left behind.\n");
		deaths++;
	}
}


