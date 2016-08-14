import java.io.*;
import java.util.Scanner;

public class Load {
	
	Scanner scan;
	String filename;
	
	public Load(Scanner scan)
	{
		this.scan = scan;
		filename = new String();
	}
	
	public PlayerCharacter loadCharacter() throws IOException
	{
		InputStreamReader isr = new InputStreamReader (System.in);
		BufferedReader stdin = new BufferedReader (isr);
		
		FileInputStream file1 = null;
		ObjectInputStream inStream = null;
		
		//Default player. 
		PlayerCharacter player = new PlayerCharacter();
		
		int attempts = 0;
		boolean exit = false;
		
		while (!exit)
		{
			try
			{
				System.out.println("\nWhat file would you like to load?:");
				filename = stdin.readLine().trim();
				
				file1 = new FileInputStream(filename);
				inStream = new ObjectInputStream(file1);
				
				Object inputtedObject = inStream.readObject();
				
				boolean isSame = inputtedObject.getClass().equals(player.getClass());
				
				if (isSame == true)
				{
					player = (PlayerCharacter) inputtedObject;
					System.out.println("\n\"" + filename + "\""+ " was loaded successfully!\n");
					exit = true;
				}
			}
			catch (NotSerializableException ex)
	        {
	            System.out.println(ex);
	            attempts++;
	        }
	        catch (IOException ex)
	        {
	        	System.out.println("\nThere is no saved file of that name.");
	        	attempts++;
	        }
			catch (ClassNotFoundException ex)
			{
				ex.printStackTrace();
				attempts++;
			}
	        finally
	        {
	            if (inStream != null)
	            {
	                inStream.close();
	            }
	            if (attempts == 2 && exit != true)
	            {
	            	System.out.println("\nMake sure your input matches your save file name exactly.");
	            }
	            if (attempts == 3)
	            {
	            	System.out.println("\nDefault character loaded.\n");
	            	//Create default player.
	            	player = new PlayerCharacter("", 100, 100, 5, 1, 300);
	            	player.passPlayer(player);
	            	exit = true;
	            }
	        }	
		}
		return player;
	}
}
