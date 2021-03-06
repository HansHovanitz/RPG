import java.util.Scanner;

public class Combat 
{
	public boolean battle(PlayerCharacter player, Creature monster, boolean displayHp, Scanner scan, PlayerMovement movement)
	{
		Description description = new Description();
		boolean victory = false;
		
		//Special creatures.
		boolean hydra = false;
		boolean entropy = false;
		
		//Check special creature cases.
		if (monster.getName().equals("Lava Hydra")){
			hydra = true;
		}
		if (monster.getName().equals("Entropy")){
			entropy = true;
		}
		
		do
		{
			description.combatMenu();
			String scroll = "empty";
			int block = 1;
			boolean loopAgain = false;
			
			int action = scan.nextInt();
			System.out.println();

			switch (action)
			{
				case 1: if (hydra){				
							((Creature_LavaHydra) monster).battleHydra(player, (Creature_LavaHydra) monster, scan, 1, scroll); break;
						}
						else if (entropy) {
							((Creature_Entropy) monster).battleEntropy(player, (Creature_Entropy) monster, scan, 1, scroll); break;			
						}
						else {
							monster.setHp(monster.getHp() - player.playerCombat(monster.getName())); break;
						}
				case 2: if (player.equipment.equipmentCheck("Shield")){
							block = 2;
						}
						else {
							System.out.println("You have no shield to block with!");	
						}
						break;
				case 3: scroll = player.items.useConsumableItem("inCombat", scan);
						if (scroll.equals("fire") || scroll.equals("ice")){
							if (hydra){
								((Creature_LavaHydra) monster).battleHydra(player, (Creature_LavaHydra) monster, scan, 2, scroll); break;
							}
							else if (entropy && ((Creature_Entropy) monster).getForm()==2){
								System.out.println("You can't seem to focus on any one of the parts well enough to cast your scroll.");
								//((Creature_Entropy) monster).battleEntropy(player, (Creature_Entropy) monster, scan, 2, scroll); break;
							}
							else {
								monster.setHp(monster.getHp() - player.scrollCombat(monster.getName(), monster.weakness(scroll)));
								break;
							}	
						}
						if (scroll.equals("return")){
							loopAgain = true;
						}
						System.out.println("test");
						break;
				case 4: System.out.println("Health Points: " + player.getHp() + "/" + player.getMaxHp());
						loopAgain = true;
						break;
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
			victory = false;
			//Player is dead. Move back to beginning.
			player.dead();
			movement.setRow(0, true);
			movement.setColumn(0, true);
		}
		return victory;
	}
}
