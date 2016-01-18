import java.io.*;
import java.util.Scanner;

public class SaveAllStates {
	
	Scanner scan;
	String filename;
	
	public SaveAllStates(Scanner scan)
	{
		this.scan = scan;
		filename = new String();
	}
	
	public void saveState(Encounter encounter) throws IOException
	{
		InputStreamReader isr = new InputStreamReader (System.in);
		BufferedReader stdin = new BufferedReader (isr);
		
		//filename = scan.nextLine();
		
		System.out.println("Please name your save file:");
		filename = stdin.readLine().trim();
		FileOutputStream file1 = null;
		ObjectOutputStream outStream = null;
		
		try
        {
            file1 = new FileOutputStream(filename);
            outStream = new ObjectOutputStream(file1);

            outStream.writeObject(encounter);

            System.out.print("\n\"" + filename + "\""+ " was saved successfully!\n\n");
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