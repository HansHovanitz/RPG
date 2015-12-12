import java.util.Scanner;

interface MapSpaces
{
	Creature doAction(int row, int column, PlayerCharacter player, PlayerMovement movement, Scanner scan);
}