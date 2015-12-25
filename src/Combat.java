import java.util.Scanner;

public class Combat 
{
	public boolean battle(PlayerCharacter player, Creature monster, boolean displayHp, Scanner scan)
	{
		Description description = new Description();
		boolean victory = false;
		do
		{
			description.combatMenu();
			String scroll = "";
			int block = 1;
			boolean loopAgain = false;
			boolean hydra = false;
			
			//Check special creature cases
			if (monster.getName().equals("Lava Hydra"))
			{
				hydra = true;
			}
			
			int action = scan.nextInt();
			System.out.println();

			switch (action)
			{
				case 1: if (hydra)
						{				
							((Creature_LavaHydra) monster).battleHydra(player, (Creature_LavaHydra) monster, scan); break;
						}
						else 
						{
							monster.setHp(monster.getHp() - player.playerCombat(monster.getName())); break;
						}
				case 2: if (player.equipment.equipmentCheck("Shield"))
						{
							block = 2;
						}
						else
						{
							System.out.println("You have no shield to block with!");	
						}
						break;
				case 3: scroll = player.items.useConsumableItem("inCombat", scan);
						if (scroll.equals("fire") || scroll.equals("ice"))
						{
							monster.setHp(monster.getHp() - player.scrollCombat(monster.getName(), monster.weakness(scroll)));
						}
						break;
				case 4: System.out.println("Health Points: " + player.getHp() + "/" + player.getMaxHp());
						loopAgain = true;
				default: System.out.println("You do nothing");break;
			}

			if (monster.getHp() > 0 && loopAgain == false)
			{
				System.out.println();
				player.setHp(player.getHp() - (monster.creatureCombat(player.getArmor(), block) + monster.strength(player.resistCheck())));
				//I can just return 0 if I want to have it do other stuff -- for a charge up attack or story or whatever.
			}

			if (action != 4 && displayHp == true)
			{
				System.out.println("\nYour Health Points: " + player.getHp() + "/" + player.getMaxHp());
			}
		}
		while (player.getHp() > 0 && monster.getHp() > 0);


		if (player.getHp() > 0)
		{
			System.out.println("\nYou have slain the " + monster.getName() + "!");
			System.out.println("You find " + monster.getCoins() + " coins.");
			player.setCoins(player.getCoins() + monster.getCoins());
			monster.getLoot(player);
			victory = true;
		}
		else
		{
			//Implement later.
			System.out.println("You are dead.");
			victory = false;

			//call dead method (which play() checks
		}
		//scanner.close();
		return victory;
	}
}
