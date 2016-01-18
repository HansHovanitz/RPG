import java.io.*;
import java.util.Scanner;

public class LoadAllStates {
	
	Scanner scan;
	String filename;
	
	public LoadAllStates(Scanner scan)
	{
		this.scan = scan;
		filename = new String();
	}
	
	//Player character as param
	public Encounter loadState() throws IOException
	{
		InputStreamReader isr = new InputStreamReader (System.in);
		BufferedReader stdin = new BufferedReader (isr);
		
		//filename = scan.nextLine();
		//
		Encounter encounter = new Encounter();
		
		System.out.println("\nWhat file would you like to load?:");
		filename = stdin.readLine().trim();
		FileInputStream file1 = null;
		ObjectInputStream inStream = null;
		
		try
		{
			file1 = new FileInputStream(filename);
			inStream = new ObjectInputStream(file1);
			
			Object inputtedObject = inStream.readObject();
			
			boolean isSame = inputtedObject.getClass().equals(encounter.getClass());
			
			if (isSame == true)
			{
				encounter = (Encounter) inputtedObject;
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

		return encounter;
	}
}