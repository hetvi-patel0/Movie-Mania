package Moviemania;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Database {
	// Fields
	private ArrayList<Movie> movies;
	private fileWrite fw;
	// Constructor
	public Database(String filename) throws Exception
	{
		movies = new ArrayList<>();
		Movie singleMovie;
		fw = new fileWrite(filename);
		fileRead fr = new fileRead(filename);
		for(int i = 0; i < fr.getNumberOfLines(); i++)
		{
			String raw = fr.getLine(i);
			// TODO: Parse using the StringTokenizer here and place into movies as single entries...
			StringTokenizer st1 = new StringTokenizer(raw,"|");
	        String[] tokens = new String[st1.countTokens()];
	        for(int j=0;j<tokens.length;j++)
	        {
	        	tokens[j] = st1.nextToken();
	        	//System.out.println(tokens[j]);
	        }
	        singleMovie = new Movie(tokens[0],tokens[3],tokens[4],tokens[5],Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
	        movies.add(singleMovie);
		}
	}
	// Methods
	public void addEntry(Movie newEntry)
	{
		String newMovie = newEntry.getTitle() + "|" + newEntry.getYear() + "|" + newEntry.getRuntime() + "|" + newEntry.getActor1() + "|" + newEntry.getActor2() + "|" + newEntry.getDirector();
		fw.writeLine(newMovie);
		fw.saveFile();
	}
	
	public void searchByTitle(String title)
	{ 
		int flag=-1;
		for(int i=0;i<movies.size();i++)
	    {
	    	 if(movies.get(i).getTitle().equalsIgnoreCase(title))
	    	 {
	    		 flag = i;
	    		 System.out.println("Actors : " + movies.get(i).getActor1() + " , " + movies.get(i).getActor2());
	    		 System.out.println("Director : " + movies.get(i).getDirector());
	    		 System.out.println("Year : " + movies.get(i).getYear() + " made ");
	    		 System.out.println("Runtime : " + movies.get(i).getRuntime() + " minutes ");
	    		 break;
	    	 }
	    }
		if(flag==-1)
		{
			System.out.println("No titles found");
		}
	}
	
	public void searchByActor(String actor)
	{
		ArrayList<String> titlenames = new ArrayList<String>();
		for(int i=0;i<movies.size();i++)
		{
			if(movies.get(i).getActor1().equalsIgnoreCase(actor)||movies.get(i).getActor2().equalsIgnoreCase(actor))
			{
				titlenames.add(movies.get(i).getTitle());
			}
		}
		if(titlenames.size()==0)
		{
			System.out.println("No titles found for actor");
		}
		else
		{
			System.out.println("Movie Title of " + actor);
			for(int i=0;i<titlenames.size();i++)
			{
				System.out.println(titlenames.get(i));
			}
		}
	}
	
	public void searchByDirector(String director)
	{
		ArrayList<String> titlenames = new ArrayList<String>();
		for(int i=0;i<movies.size();i++)
		{
			if(movies.get(i).getDirector().equalsIgnoreCase(director)||movies.get(i).getDirector().equalsIgnoreCase(director))
			{
				titlenames.add(movies.get(i).getTitle());
			}
		}
		if(titlenames.size()==0)
		{
			System.out.println("No titles found for actor");
		}
		else
		{
			System.out.println("Movie Title of " + director);
			for(int i=0;i<titlenames.size();i++)
			{
				System.out.println(titlenames.get(i));
			}
		}
	}
	
	public void searchByYear(int year)
	{
		ArrayList<String> titlenames = new ArrayList<String>();
		for(int i=0;i<movies.size();i++)
		{
			if((movies.get(i).getYear())==year||(movies.get(i).getYear())==year)
			{
				titlenames.add(movies.get(i).getTitle());
			}
		}
		if(titlenames.size()==0)
		{
			System.out.println("No titles found for actor");
		}
		else
		{
			System.out.println("Movie Title of " + year);
			for(int i=0;i<titlenames.size();i++)
			{
				System.out.println(titlenames.get(i));
			}
		}
	}
	
	public void searchByRuntime(int runtime)
	{
		ArrayList<String> titlenames = new ArrayList<String>();
		for(int i=0;i<movies.size();i++)
		{
			if((movies.get(i).getRuntime())==runtime||(movies.get(i).getRuntime())==runtime)
			{
				titlenames.add(movies.get(i).getTitle());
			}
		}
		if(titlenames.size()==0)
		{
			System.out.println("No titles found for actor");
		}
		else
		{
			System.out.println("Movie Title of " + runtime);
			for(int i=0;i<titlenames.size();i++)
			{
				System.out.println(titlenames.get(i));
			}

		}
	}
	public void deleteentry(String dtitle)
	{
		int indexToDelete = -1;
		for(int i=0;i<movies.size() ;i++) 
		{
			if(dtitle.equalsIgnoreCase(movies.get(i).getTitle()))
			{
				indexToDelete = i;
				break;
			}
		}
		if(indexToDelete == -1)
		{
			System.out.println("No titles found");
		}
		else
		{
			movies.remove(indexToDelete);
			for(int i=0;i< movies.size() ;i++) 
			{
				String movieString = this.prepareMovieString(movies.get(i)); 
				fw.writeLine(movieString);
			}
			fw.saveRewriteFile();
    	}
	}
    public String prepareMovieString(Movie movie) 
    {
		String str = movie.getTitle() +"|"+movie.getYear() +"|"+movie.getRuntime() +"|"+movie.getActor1() +"|"+movie.getActor2()+"|"+movie.getDirector();
		return str;
	}
}
