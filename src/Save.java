import java.io.*;
import java.util.Scanner;

public class Save {
	
	Scanner scan;
	String filename;
	
	public Save(Scanner scan)
	{
		this.scan = scan;
		filename = new String();
	}
	
	public void saveCharacter(PlayerCharacter player) throws IOException
	{
		InputStreamReader isr = new InputStreamReader (System.in);
		BufferedReader stdin = new BufferedReader (isr);
		
		//filename = scan.nextLine();
		
		System.out.println("What should be the name of your save file?\n");
		filename = stdin.readLine().trim();
		FileOutputStream file1 = null;
		ObjectOutputStream outStream = null;
		
		try
        {
            file1 = new FileOutputStream(filename);
            outStream = new ObjectOutputStream(file1);

            //Writes the program's Bank System file to a file of
            //the user's chosen name.
            outStream.writeObject(player);

            System.out.print(filename + " was written\n");
        }
        //Catch possible exceptions.
        catch (NotSerializableException ex)
        {
            System.out.println(ex);
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }
        finally
        {
            if (outStream != null)
            {
                outStream.close();
            }
        }
	}
}