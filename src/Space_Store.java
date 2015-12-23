import java.util.Scanner;

public class Space_Store extends Creature implements MapSpaces
{

	public Space_Store()
	{
		super("Store", 0, 0, 0);
	}

	public Creature doAction(int row, int column, PlayerCharacter player, PlayerMovement movement, Scanner scan)
	{
		Space_Store store = new Space_Store();
		Description description = new Description();
		//Scanner scan = new Scanner(System.in);

		//Starting merchant
		if (row == 0 && column == 0)
		{
			description.room(row, column, 0);
			System.out.println("\nMerchant: " + player.getName() + " what would you like to buy?");
			description.merchantOneMenu();
			int merchantSelection = -1;

			while (merchantSelection != 0)
			{
				System.out.print("___");
				merchantSelection = scan.nextInt();



				if (merchantSelection == 1 && player.getCoins() >= 5)
				{
					System.out.println("\nYou buy a Minor Potion.");
					player.items.minorHealthPotions("addPotion");
					player.setCoins(player.getCoins() - 5);
				}

				else if (merchantSelection == 2 && player.getCoins() >= 20)
				{
					if (player.equipment.equipmentCheck("Sword") || player.equipment.equipmentCheck("Expertly Crafted Sword") || player.equipment.equipmentCheck("Time Sword"))
					{
						System.out.println("You cannot carry another weapon.");
					}
					else
					{
						System.out.println("You buy a Sword! This item gives you an extra +2 damage.");
						player.equipment.sword("yes");
						//player.equipmentList("Sword", "add");
						//player.setCoins(player.getCoins() - 20);
					}
				}

				else if (merchantSelection == 3 && player.getCoins() >= 10)
				{
					if (player.equipment.equipmentCheck("Shield"))
					{
						System.out.println("You only need one shield.");
					}
					else
					{
						System.out.println("You buy a Shield! You can use this item to block enemy attacks.");
						player.equipment.equipmentList("Shield", "add");
						player.setCoins(player.getCoins() - 10);

						
					}
				}

				else if (merchantSelection == 4 && player.getCoins() >= 20)
				{
					if (player.equipment.equipmentCheck("Leather Armor") || player.equipment.equipmentCheck("Chainmail Armor") || player.equipment.equipmentCheck("Plate Armor"))
					{
						System.out.println("Try as you might you are unable to fit on another set of armor.");
					}
					else
					{
						System.out.println("You buy Leather Armor! This item gives you +2 armor.");
						player.equipment.leatherArmor("yes");
						//player.equipmentList("Leather Armor", "add");
						//player.setCoins(player.getCoins() - 20);
					}
				}

				else if (merchantSelection == 5 && player.getCoins() >= 20)
				{
					if (player.equipment.equipmentCheck("Hammer") == true)
					{
						System.out.println("You really can't think of a use for having two of these.");
					}
					else
					{
						System.out.println("You buy a Hammer! You can use the hammer to smash things.");
						player.equipment.equipmentList("Hammer", "add");
						player.setCoins(player.getCoins() - 20);
					}
				}
				else if (merchantSelection == 6 && player.getCoins() >= 10)
				{
					if (player.equipment.equipmentCheck("Rope"))
					{
						System.out.println("You really can't think of a use for having two of these.");
					}
					else
					{
						System.out.println("You buy a Rope! You can use the rope to climb things.");
						player.equipment.equipmentList("Rope", "add");
						player.setCoins(player.getCoins() - 10);
					}
				}

				else if (merchantSelection == 7)
				{
					description.hints();
				}

				else if (merchantSelection == 0)
				{
					System.out.println("\nMerchant: Goodluck out there " + player.getName() + ".");
				}
				else
				{
					System.out.println("\nI'm sorry " + player.getName() + " you don't have the money for that.");
				}
			}
		}
		if (row == 3 && column == 2)

		{
			System.out.println("City");
		}


		return store;
	}
}