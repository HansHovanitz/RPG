import java.util.ArrayList;


public class ItemsEquipment 
{
	protected PlayerCharacter player;
	private boolean[] healthLockets = new boolean[3];
	
	ItemsEquipment(PlayerCharacter player)
	{
		this.player = player;
	}
	
	//EQUIPMENT ITEMS

		ArrayList<String> equipmentList = new ArrayList<String>();
		public void equipmentList(String item, String addOrRemove)
		{
			if (addOrRemove.equals("add"))
			{
				equipmentList.add(item);
			}
			if (addOrRemove.equals("remove"))
			{
				equipmentListRemovalHelper(item);
			}

			//add/remove eq here.   Have another method that goes thru list and prints it and another than goes thru and finds something.  If have already, then no allow to be added again (bought)
			//also need to remove it.  Write these out i think haha.
		}

		public void equipmentListRemovalHelper(String item)
		{
			for (int i = 0; i < equipmentList.size(); i++)
			{
				if (equipmentList.get(i).equals(item))
				{
					equipmentList.remove(i);
				}
			}
		}








	//method simply to print out equipmentList array.
		public void viewEquipmentList()
		{
			for (int i = 0; i < equipmentList.size(); i++)
			{
				System.out.println(equipmentList.get(i));
			}
			if (equipmentList.size() <= 0)
			{
				System.out.println("You don't have any equipment.");
			}
		}

	//to make sure another item is not sold or aquired.
		public boolean equipmentCheck(String check)
		{
			boolean equipmentCheck = false;

			for (String item : equipmentList)
			{
				if (item.equals(check))
				{
					equipmentCheck = true;
					break;
				}
			}
			return equipmentCheck;
		}

				//else return false      if returns false then let player buy it or receive it.
					//stuff      go thru the array and check to see if its there already.
					//for (String s : arrayList)
					  //  if (s.equals(value))
					    //(equipmentList[i] == check)
	        // ...





	//need equipmentRemoval..same method as equipment check only removes item if found from arrayList.


		public void healthLocket(String item, int row, int column)
		{
			if (item.equals("yes"))
			{
				if ((row == 2 && column == 1) && healthLockets[0] == false)
				{
					healthLockets[0] = true;
					healthLocketHelper();
				}

				if ((row == 2 && column == 5) && healthLockets[1] == false)
				{
					healthLockets[1] = true;
					healthLocketHelper();
				}

				if ((row == 5 && column == 1) && healthLockets[2] == false)
				{
					healthLockets[2] = true;
					healthLocketHelper();
				}
			}
			else
			{
				System.out.println("You have already looted the contents of the chest.");
			}
			
		}

		public void healthLocketHelper()
		{
			System.out.println("You smash open the chest with your Hammer and find what looks to be an enchanted item. \n+5 maximum HP.");
			
			player.setMaxHp(player.getMaxHp() + 5);
			player.setHp(player.getHp() + 5);
		
			equipmentList("Health Locket", "add");

		}
		
		public void victoryEquip(boolean victory, int row, int column)
		{
			if (victory)
			{
				if (row == 5 && column == 0)
				{
					//player.equipment.plateArmor("yes");
				}
			}		
		}
		




		public void sword(String item)
		{
			//boolean sword = false;

			if (item.equals("yes"))
			{
				//sword = true;
				player.setDamage(player.getDamage() + 2);
				equipmentList("Sword", "add");
				player.setCoins(player.getCoins() - 20);
			}
			if (item.equals("no"))
			{
				//sword = false;
				player.setDamage(player.getDamage() + 2);
				equipmentList("Sword", "remove");
			}
		}

		public void expertlyCraftedSword(String item)
		{
			if (item.equals("yes"))
			{
				player.setDamage(player.getDamage() + 5);	
				equipmentList("Expertly Crafted Sword", "add");
				player.setCoins(player.getCoins() - 50);
				
				if (equipmentCheck("Sword"))
				{
					sword("no");
				}
			}
			if (item.equals("no"))
			{
				player.setDamage(player.getDamage() - 5);
				equipmentList("Expertly Crafted Sword", "remove");
			}
		}

		public void timeSword(String item)
		{
			if (item.equals("yes"))
			{
				player.setDamage(player.getDamage() + 8);
				equipmentList("Time Sword", "add");
				if (equipmentCheck("Sword"))
				{
					sword("no");
				}
				if (equipmentCheck("Expertly Crafted Sword"))
				{
					expertlyCraftedSword("no");
				}
			}
			if (item.equals("no"))
			{
				player.setDamage(player.getDamage() - 8);
				equipmentList("Time Sword", "remove");
			}
		}


		public void leatherArmor(String item)
		{
			if (item.equals("yes"))
			{
				player.setArmor(player.getArmor() + 2);
				equipmentList("Leather Armor", "add");
				
			}
			if (item.equals("no"))
			{
				player.setArmor(player.getArmor() - 2);
				equipmentList("Leather Armor", "remove");
			}
		}

		public void chainmailArmor(String item)
		{
			if (item.equals("yes"))
			{
				player.setArmor(player.getArmor() + 5);
				equipmentList("Chainmail Armor", "add");
				player.setCoins(player.getCoins() - 50);
				if (equipmentCheck("Leather Armor"))
				{
					leatherArmor("no");
				}
			}
			if (item.equals("no"))
			{
				player.setArmor(player.getArmor() - 5);
				equipmentList("Chainmail Armor", "remove");
			}
		}

		public void plateArmor(String item)
		{
			if (item.equals("yes"))
			{
				player.setArmor(player.getArmor() + 8);
				equipmentList("Plate Armor", "add");
				playerResist("fire");
				if (equipmentCheck("Leather Armor"))
				{
					leatherArmor("no");
				}
				if (equipmentCheck("Chainmail Armor"))
				{
					chainmailArmor("no");
				}
			}
			if (item.equals("no"))
			{
				player.setArmor(player.getArmor() - 8);
				equipmentList("Plate Armor", "remove");
				playerResist("no");
			}
		}
		
		public void playerResist(String resistType)
		{
			if (resistType.equals("fire"))
			{
				player.setResist("fire");
			}
			if (resistType.equals("no"))
			{
				player.setResist("removeFire");
			}
		}

}
