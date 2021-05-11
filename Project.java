//Name: Hetvi Patel

package Moviemania;

import java.io.FileReader;
import java.util.Scanner;

public class Project
{
	public static void main(String[] args) throws Exception
	{
		String FILEPATH = "C:\\Users\\hetvi\\eclipse-workspace\\Labs\\src\\Moviemania\\db.txt";
		Database dtb;
		keyboardInput kb = new keyboardInput();
		Movie m;
		System.out.println("\t\t\t\t\t\tMOVIE MANIA");
		System.out.println("a.) new entry");
		System.out.println("b.) search by actor");
		System.out.println("c.) search by year");
		System.out.println("d.) search by runtime (in minutes)");
		System.out.println("e.) search by director");
		System.out.println("f.) search by title");
		System.out.println("g.) delete entry");
		System.out.println("h.) quit");
		String choice = null;
		do {
			System.out.println("Enter command> ");
			choice = kb.getKeyboardLine();
			switch(choice)
			{
			    case "new entry": 	System.out.println("Enter title> ");
				                    String title = kb.getKeyboardLine();
				                    while(title.length()<3)
				                    {
				                    	System.out.println("Invalid Entry..Try Again> ");
				                    	System.out.println("Enter title> ");
					                    title = kb.getKeyboardLine();
				                    }
				                    System.out.println("Enter year> ");
			                    	String year = kb.getKeyboardLine();
				                    System.out.println("Enter runtime(minutes)> ");
				                    String run = kb.getKeyboardLine();
				                    System.out.println("Enter actor 1> ");
				                    String act1 = kb.getKeyboardLine();
				                    System.out.println("Enter actor 2> ");
				                    String act2 = kb.getKeyboardLine();
				                    System.out.println("Enter director> ");
				                    String dir = kb.getKeyboardLine();
				                    m = new Movie(title, act1, act2, dir, Integer.parseInt(year), Integer.parseInt(run));
				                    dtb = new Database(FILEPATH);
				                    dtb.addEntry(m);
			                        break;
			    case "search by actor": System.out.println("Enter actor> ");
			                            String actr = kb.getKeyboardLine();
			                            dtb = new Database(FILEPATH);
			    	                    dtb.searchByActor(actr);
			                            break;
			    case "search by year": System.out.println("Enter year> ");
	                                   String yr = kb.getKeyboardLine();
	                                   dtb = new Database(FILEPATH);
			    	                   dtb.searchByYear(Integer.parseInt(yr));
			                           break;
	    	    case "search by runtime(minutes)": System.out.println("Enter runtime(minutes)> ");
	                                               String runt = kb.getKeyboardLine();
	                                               dtb = new Database(FILEPATH);
			    	                               dtb.searchByRuntime(Integer.parseInt(runt));
			    	                               break;
			    case "search by director": System.out.println("Enter director> ");
	                                       String direct = kb.getKeyboardLine();
	                                       dtb = new Database(FILEPATH);
	                                       dtb.searchByActor(direct); 
	  		                               break;
			    case "search by title": System.out.println("Enter title> ");
	                                    String ttle = kb.getKeyboardLine();
	                                    dtb = new Database(FILEPATH);
	                                    dtb.searchByTitle(ttle);
			                            break;
			    case "delete entry": System.out.println("Enter title to delete> ");
			                         String delete = kb.getKeyboardLine();
			                         dtb = new Database(FILEPATH);
			                         dtb.deleteentry(delete);
			                         break;
			    case "quit": System.exit(1);
			}
		}while(!choice.equals("quit"));
	}
}