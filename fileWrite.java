/* READ THIS!: The idea behind this class is that we save the "writeBuffer" in memory but do not actually write the file to disk until someone calls the 
 * "saveFile" method. The reason for this is for performance and to prevent keeping an open file pointer (which is poor form and risky) */

package Moviemania;

import java.io.FileWriter;
import java.util.ArrayList;

public class fileWrite {
	// Fields
	private ArrayList<String> writeBuffer;
	private String filename;
	
	// Constructor
	public fileWrite(String filename)
	{
		this.filename = filename;			// Save filename for later
		writeBuffer = new ArrayList<>();
	}
	
	//Methods
	public void writeLine(String newLine)
	{
		// TODO: Add the newLine to the writeBuffer...
		writeBuffer.add(newLine);
	}
	
	public void saveFile()
	{
		// TODO: Save all of the lines in the writeBuffer to the file (given in filename)
		FileWriter file;
		// TODO: Save all of the lines in the writeBuffer to the file (given in filename)
		try 
		{
			file = new FileWriter(filename,true);
			for(int i=0; i < writeBuffer.size(); i++) 
			{
				file.write("\n" + writeBuffer.get(i));
			}
			writeBuffer.clear();
			file.close();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void saveRewriteFile()
	{
		FileWriter file;
		// TODO: Save all of the lines in the writeBuffer to the file (given in filename)
		try 
		{
			file = new FileWriter(filename);
			file.write(writeBuffer.get(0));
			for(int i=1; i < writeBuffer.size(); i++)
			{
				file.write("\n" + writeBuffer.get(i));
			}
			writeBuffer.clear();
			file.close();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
