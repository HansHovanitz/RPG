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
	
	public PlayerCharacter loadCharacter(PlayerCharacter player) throws IOException
	{
		InputStreamReader isr = new InputStreamReader (System.in);
		BufferedReader stdin = new BufferedReader (isr);
		
		//filename = scan.nextLine();
		
		System.out.println("What file would you like to load?\n");
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
				System.out.println(filename + " was read\n");
			}
		}
		catch (NotSerializableException ex)
        {
            System.out.println(ex);
        }
        catch (IOException ex)
        {
            System.out.println(ex);
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
