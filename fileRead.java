package Moviemania;

import java.util.ArrayList;
import java.io.*;

public class fileRead
{
	// Fields
	private ArrayList<String> lines;
	
	// Constructor
	public fileRead(String filename) throws Exception
	{
		lines = new ArrayList<>();
		//TODO: Open the filename, read in the data into the lines arraylist, and close the file when done...
		File file = new File(filename);	
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while((st = br.readLine()) != null)
	    {
	  		//System.out.println(st);
	  		lines.add(st);
	  	}
		br.close();
	}
	
	// Methods
	public int getNumberOfLines()
	{
		return lines.size();
		// TODO
	}
	
	public String getLine(int index)
	{
		String x = null;
		for(int i=0;i<lines.size();i++) 
		{
			if(i == index) {
				x= lines.get(i);
				break;
			}
		}
		return x;
	}
}
