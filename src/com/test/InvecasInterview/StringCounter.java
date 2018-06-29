package com.test.InvecasInterview;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.test.InvecasInterview.Objects.MyHash;
/*
* @author      Kiruthi Njenga
* @version     %I%, %G%
* @since       1.0
*/
public class StringCounter {
	/**
	 *    Assumptions
	 *    <p>
	 *       1) We will assume that strings are case sensitive. 
	 *       2) We will assume that the input files are in String, int format. Inputs not conforming to this format are ignored. 
	 *    </p>    
	 *          
	 *    Input file format
	 *          "John,2"
	 *			"Jane,1"
	 *		 	"John,1"
	 */
	/**
	 * Path of the input file
	 */
	private String FPath          = null;
	/**
	 * Logger initialization
	 */
	private static Logger logger  = Logger.getLogger( StringCounter.class.getName() );
	/**
	 * HashMap to use.
	 */
	final private MyHash mh       = new MyHash();		
	
	/** 
	 *  This is constructor method for our StringCounter class. 
	 *   @param path A String of the absolute path to file with key value pairs. 
	 */
	
	public StringCounter(String path){
		FPath        = path;	
	}
	/** 
	 *  This is constructor method for our StringCounter class. 
	 */
	
	public StringCounter(){
		this(null);	
	}
	/**
	 * The main method for String counter class. 	
	 * <p>
	 *  Usage: StringCounter [filepath]
	 * </p>
	 * @param args The required arguements are:
	 * <p> args[0] is the file path</p>
	 */
	public static void main(String[] args) {
		String path = "";
		if(args ==null || args.length ==0 || args.length !=1)
		{
			StringCounter.logger.log(Level.SEVERE, "Usage: StringCounter [filepath]");
			return;
		}
		else
		{
			path   = args[0];
		}
		StringCounter sc = new StringCounter(path);
		
		try 
		{
			sc.initialize_hash();
			sc.print();
		} catch (IOException e) {
			StringCounter.logger.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	 *  		
	 *  Print the string counters from the HashMap
	 *  @return <code>String</code> Return the output string in the format: The total for %s is %d.  
	 */	
	public String print()
	{
		StringBuffer returnme = new StringBuffer();
		mh.forEach((key, value)->{
			returnme.append(String.format("The total for %s is %d.\n", key, value));
			});
		
		return returnme.toString();
	}
    /** 
     * Given the absolute path to the input file, read the contents initialize our hashmap.
     * We will assume that the strings are case sensitive.
     * @param  filepath <code>String</code> filepath  the absolute path of the input file
     * @return <code>void</code> No return values.  
     * @throws IOException If there is an IO error when trying to retrieve the file.
     */
	public void initialize_hash() throws IOException
	{
		Files.lines(new File(FPath).toPath()) 
					.map(s -> s.trim()) 
					.filter(s -> !s.isEmpty())
					//.map(s -> s.toLowerCase())
					.filter(s -> s.contains(","))
					.map(s -> s.split(","))
					.filter(s -> s.length==2)
					.forEach(s -> 
						{
							mh.put(s[0], new Integer(s[1]));
						});
	}
	/**
	 * @return the fPath
	 */
	public String getFPath() {
		return FPath;
	}
	/**
	 * @param fPath the fPath to set
	 */
	public void setFPath(String fPath) {
		FPath = fPath;
	}
}
