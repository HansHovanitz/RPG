import java.util.ArrayList;


public class ItemsEquipment implements java.io.Serializable
{
	private static final long serialVersionUID = 999;
	protected PlayerCharacter player;
	protected ArrayList<String> equipmentList;
	private boolean[] healthLockets;
	
	public ItemsEquipment(PlayerCharacter player)
	{
		this.player = player;
		equipmentList = new ArrayList<String>();
		healthLockets = new boolean[3];
	}
	
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

	//to make sure another item is not sold or acquired.
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
		
		//Don't need. Add items via creature classes. 
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
			if (item.equals("yes"))
			{
				player.setDamage(player.getDamage() + 2);
				equipmentList("Sword", "add");
				player.setCoins(player.getCoins() - 20);
			}
			if (item.equals("no"))
			{
				player.setDamage(player.getDamage() - 2);
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
				player.setCoins(player.getCoins() - 20);
				
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
