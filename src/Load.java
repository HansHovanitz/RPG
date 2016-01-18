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
	
	//Player character as param
	public PlayerCharacter loadCharacter() throws IOException
	{
		InputStreamReader isr = new InputStreamReader (System.in);
		BufferedReader stdin = new BufferedReader (isr);
		
		//filename = scan.nextLine();
		//
		PlayerCharacter player = new PlayerCharacter();
		
		System.out.println("\nWhat file would you like to load?:");
		filename = stdin.readLine().trim();
		FileInputStream file1 = null;
		ObjectInputStream inStream = null;
		
		try
		{
			file1 = new FileInputStream(filename);
			inStream = new ObjectInputStream(file1);
			
			Object inputtedObject = inStream.readObject();
			
			boolean isSame = inputtedObject.getClass().equals(player.getClass());
			
			if (isSame == true)
			{
				player = (PlayerCharacter) inputtedObject;
				System.out.println("\n\"" + filename + "\""+ " was loaded successfully!\n");
			}
		}
		catch (NotSerializableException ex)
        {
            System.out.println(ex);
        }
        catch (IOException ex)
        {
        	System.out.println("\nThere is no saved file of that name.\n");
        }
		catch (ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
        finally
        {
            if (inStream != null)
            {
                inStream.close();
            }
        }

		return player;
	}
}
