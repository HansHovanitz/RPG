public class PlayerMovement
{
	private int row;
	private int column;
	private boolean wallCheck;

	public PlayerMovement(int row, int column)
	{
		this.column = column;
		this.row = row;
		//this.wallCheck = wallCheck;
	}

	public int getRow()
	{
		return row;
	}

	//public void setRow(int row)
	//{
	//	this.row = row;
	//}

	public int getColumn()
	{
		return column;
	}

	//public void setColumn(int column)
	//{
	//	this.column = column;
	//}

	public boolean getWallCheck()
	{
		return wallCheck;
	}

	public void setWallCheck(boolean wallCheck)
	{
		this.wallCheck = wallCheck;
	}

	public void setRow(int a)
	{
		if (a == 1)
		{
			if (row <= 0)
			{
				System.out.println("You have reached the edge of the map.");
				wallCheck = true;
			}
			else
			{
				this.row = row -1;
				wallCheck = false;
			}
		}

		else if (a == 2)
		{
			if (row >= 5)
			{
				System.out.println("You have reached the edge of the map.");
				wallCheck = true;
			}
			else
			{
				this.row = row +1;
				wallCheck = false;
			}
		}


	}

	public void setRow(int a, boolean terrain)
	{
		if (a == 6)
		{
			this.row = 0;
			//this.row = row - 0;
		}
		if (a == 4)
		{
			this.row = 4;
		}
		if (a == 5)
		{
			this.row = 5;
		}
		

	}


	public void setColumn(int a)
	{
		if (a == 3)
		{
			if (column <= 0)
			{
				System.out.println("You have reached the edge of the map.");
				wallCheck = true;
			}
			else
			{
				this.column = column -1;
				wallCheck = false;
			}
		}

		else if (a == 4)
		{
			if (column >= 5)
			{
				System.out.println("You have reached the edge of the map.");
				wallCheck = true;
			}
			else
			{
				this.column = column +1;
				wallCheck = false;
			}
		}
	}

	public void setColumn(int a, boolean terrain)
	{
		//I can simplify this to just this.column = a; as long as I match up the arguments. 
		
		
		//Both same colum, don't need the same line of code twice but keeping it for reference. 
		if (a == 3)
		{
			this.column = 3;
			//this.column = column - 2;
		}
		if (a == 4)
		{
			this.column = 4;
		}
		if (a == 5)
		{
			this.column = 5;
		}

	}

//Or whereever they player needs to be moved to.
	/*public void movePlayer(int terrainCheck)
	{
		if (terrainCheck == 1)
		{
			this.column = 1;
			this.row = 1;

			System.out.println("YOU FALL IN THE RIVER");
		}



	}*/
}