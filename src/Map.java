public class Map
{

	private char [][] map = new char[6][6];
	private boolean hint = true;

	public Map()
	{
		//this.map = map;
		this.hint = true;
	}

	public void setMap(char object)
	{
		for (int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map.length; j++)
			{
				this.map [i][j] = object;
			}
		}
		this.map[0][0] = 'S';
	}

	//The row and column are kept track of elsewhere.
	//Here I'm just displaying what the map should look like.
	public void displayMap(int row, int column)
	{
		if (hint == true)
		{
			System.out.println("'P' is your position.\n");
			hint = false;
		}

		for (int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map[i].length; j++)
			{
				if (row == i && column == j)
					System.out.print("P  ");
				else
					System.out.print(map[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public void updateMap(int row, int column)
	{
		//Reveal map -- Better way to do this?

		if (row == 0 && column == 0)
		map [row][column] = 'S';
		if (row == 1 && column == 0)
		map [row][column] = 'x';
		if (row == 2 && column == 0)
		map [row][column] = 'x';
		if (row == 3 && column == 0)
		map [row][column] = 'x';
		if (row == 4 && column == 0)
		map [row][column] = 'x';
		if (row == 5 && column == 0)
		map [row][column] = 'B';


		//re-done with Carey's suggestion.
		if (column == 1)
		{
			if (row == 0)
				map [row][column] = 'x';
			else if (row == 1)
				map [row][column] = 'x';
			else if (row == 2)
				map [row][column] = 'x';
			else if (row == 3)
				map [row][column] = 'x';
			else if (row == 4)
				map [row][column] = 'V';
			else if (row == 5)
				map [row][column] = 'x';
		}


		if (row == 0 && column == 2)
		map [row][column] = 'x';
		if (row == 1 && column == 2)
		map [row][column] = 'x';
		if (row == 2 && column == 2)
		map [row][column] = 'x';
		if (row == 3 && column == 2)
		map [row][column] = 'C';
		if (row == 4 && column == 2)
		map [row][column] = 'x';
		if (row == 5 && column == 2)
		map [row][column] = 'x';

		if (row == 0 && column == 3)
		map [row][column] = 'x';
		if (row == 1 && column == 3)
		map [row][column] = 'x';
		if (row == 2 && column == 3)
		map [row][column] = 'x';
		if (row == 3 && column == 3)
		map [row][column] = 'x';
		if (row == 4 && column == 3)
		map [row][column] = 'H';
		if (row == 5 && column == 3)
		map [row][column] = 'x';

		if (row == 0 && column == 4)
		map [row][column] = 'R';
		if (row == 1 && column == 4)
		map [row][column] = 'R';
		if (row == 2 && column == 4)
		map [row][column] = 'x';
		if (row == 3 && column == 4)
		map [row][column] = 'x';
		if (row == 4 && column == 4)
		map [row][column] = 'L';
		if (row == 5 && column == 4)
		map [row][column] = 'D';

		if (row == 0 && column == 5)
		map [row][column] = 'M';
		if (row == 1 && column == 5)
		map [row][column] = 'R';
		if (row == 2 && column == 5)
		map [row][column] = 'x';
		if (row == 3 && column == 5)
		map [row][column] = 'B';
		if (row == 4 && column == 5)
		map [row][column] = 'L';
		if (row == 5 && column == 5)
		map [row][column] = 'F';
	}
}