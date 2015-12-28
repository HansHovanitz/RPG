import java.util.ArrayList;
import java.util.Scanner;


public class ItemsConsumable 
{
	protected PlayerCharacter player;
	
	ItemsConsumable(PlayerCharacter player)
	{
		this.player = player;
	}
	//CONSUMABLE ITEMS
	//combine this and helper (below) method.
		public String useConsumableItem(String combat, Scanner scan)
		{
			//Scanner scan = new Scanner(System.in);

			System.out.println("What item would you like to use?");

			consumableItemsList();

			System.out.print("___");

			int itemToUse = scan.nextInt();

			String scroll = "nothing";

			//boolean returnedItem = useConsumableItemHelper(itemToUse);

			if (itemToUse == 1 && minorHealthPotions.size() > 0)
			{
				minorHealthPotions("usePotion");
			}
			else if (itemToUse == 2 && healthPotions.size() > 0)
			{
				healthPotions("usePotion");
			}
			else if (itemToUse == 3 && scrollCheck("Fire Scroll") > 0)
			{
				if (combat.equals("notInCombat"))
				{
					System.out.println("\nYou can only use scrolls in combat.");
				}
				else
				{
					scroll = "fire";
					scrolls("removeFire");
				}
			}
			else if (itemToUse == 4 && scrollCheck("Ice Scroll") > 0)
			{
				if (combat.equals("notInCombat"))
				{
					System.out.println("\nYou can only use scrolls in combat.");
				}
				else
				{
					scroll = "ice";
					scrolls("removeIce");
				}
			}
			else if (itemToUse == 0)
			{
				scroll = "return";
			}
			else
			{
				System.out.println("\nYou don't have any!");
			}

			return scroll;


			//if itemToUse == 10) I don't want to use any items.
		}

		//public boolean useConsumableItemHelper(int item)
		//{

			//if (minorHealthPotions.size() > 0 && item == 1)
			//{
			//	return true;
			//}
			//else
			//{
			//	return false;
			//}
		//}


		public void consumableItemsList()
		{


			if (minorHealthPotions.size() > 0)
			{
				System.out.println("1. Minor Potion (" + minorHealthPotions.size() + ")");
			}
			else
			{
				System.out.println("1. ");
			}
			if (healthPotions.size() > 0)
			{
				System.out.println("2. Potion (" + healthPotions.size() + ")");
			}
			else
			{
				System.out.println("2. ");
			}
			if (scrollCheck("Fire Scroll") > 0)
			{
				System.out.println("3. Fire Scroll (" + scrollCheck("Fire Scroll") + ")");
			}
			else
			{
				System.out.println("3. ");
			}
			if (scrollCheck("Ice Scroll") > 0)
			{
				System.out.println("4. Ice Scroll (" + scrollCheck("Ice Scroll") + ")");
			}
			else
			{
				System.out.println("4. ");
			}


			System.out.println("0. Exit");
		}





	//ALL CONSUMABLE ITEMS :

		ArrayList<Integer> minorHealthPotions = new ArrayList<Integer>();
		public void minorHealthPotions(String potion)
		{
			if (potion.equals("addPotion"))
			{
				minorHealthPotions.add(1);
			}

			if (potion.equals("subtractPotion"))
			{
				minorHealthPotions.remove(0);
			}

			if (potion.equals("totalPotions"))
			{
				System.out.println(minorHealthPotions.size() + " Minor Health Potions.");
			}

			if (potion.equals("usePotion"))
			{
				System.out.println("\nYou heal yourself for 8 HP.");
				
				int hp = player.getHp()+8; 

				player.setHp(hp);
				
				if (hp > player.getMaxHp())
				{
					player.setHp(player.getMaxHp());
				}
				minorHealthPotions.remove(0);
			}
		}

		ArrayList<Integer> healthPotions = new ArrayList<Integer>();
		public void healthPotions(String potion)
		{	
			if (potion.equals("addPotion"))
			{
				healthPotions.add(1);
			}

			if (potion.equals("subtractPotion"))
			{
				healthPotions.remove(0);
			}

			if (potion.equals("totalPotions"))
			{
				System.out.println(healthPotions.size() + " Health Potions.");
			}

			if (potion.equals("usePotion"))
			{
				System.out.println("\nYou heal yourself for 16 HP.");

				int hp = player.getHp() + 16;
				
				player.setHp(hp);
				
				if (hp > player.getMaxHp())
				{
					player.setHp(player.getMaxHp());
				}
				healthPotions.remove(0);
			}
		}

		ArrayList<String> scrolls = new ArrayList<String>();
		public void scrolls(String scrollAddOrRemove)
		{
			if (scrollAddOrRemove.equals("addFire"))
			{
				scrolls.add("Fire Scroll");
			}
			if (scrollAddOrRemove.equals("removeFire"))
			{
				for (int i = 0; i < scrolls.size(); i++)
				{
					if (scrolls.get(i).equals("Fire Scroll"))
					{
						scrolls.remove(i);
						break;
					}
				}
			}
			if (scrollAddOrRemove.equals("addIce"))
			{
				scrolls.add("Ice Scroll");
			}
			if (scrollAddOrRemove.equals("removeIce"))
			{
				for (int i = 0; i < scrolls.size(); i++)
				{
					if (scrolls.get(i).equals("Ice Scroll"))
					{
						scrolls.remove(i);
						break;
					}
				}
			}

		}

		public int scrollCheck(String scroll)
		{
			int counter = 0;

			for (int i = 0; i < scrolls.size(); i++)
			{
				if (scrolls.get(i).equals(scroll))
				{
					counter++;
				}
			}
			return counter;
		}




















}
