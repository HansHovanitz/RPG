import java.util.Random;

public class Creature
{
	protected String name;
	protected int hp;
	protected int damage;
	protected int coins;
	protected int terrainNumber;

	public Creature(String name, int hp, int damage, int coins)
	{
		this.name = name;
		this.hp = hp;
		this.damage = damage;
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

	public int getDamage()
	{
		Random random = new Random();
		int randomDamage = random.nextInt(2) + damage;
		return randomDamage;
	}

	public void setDamage(int damage)
	{
		this.damage = damage;
	}

	public int getCoins()
	{
		return coins;
	}

	public void setCoins(int coins)
	{
		this.coins = coins;
	}

	public int getTerrainNumber()
	{
		return terrainNumber;
	}

	public void setTerrainNumber(int terrainNumber)
	{
		this.terrainNumber = terrainNumber;
	}

	public int creatureCombat(int armor, int block)
	{
		int creatureDamage = (getDamage() / block);
		int totalDamage = creatureDamage - armor;
		if (armor > totalDamage)
		{
			totalDamage = 0;
		}
		System.out.println("The " + getName() + " hits you for " + totalDamage + " (" + creatureDamage + "-" + armor + ") damage!");
		return totalDamage;
	}

	public int weakness(String element)
	{
		return 0;
	}

	public int strength(boolean resist)
	{
		if (resist == true)
		{
			return 0;
		}
		else
		{
			return 0;
		}
	}
	
	public int randomEncounter(int num)
	{
		Random random = new Random();
		int randomEncounterNumber = random.nextInt(num);
		
		return randomEncounterNumber;
	}

	public void getLoot(PlayerCharacter player)
	{
		//This is handled in individual creature classes. Default is null. 
	}
}