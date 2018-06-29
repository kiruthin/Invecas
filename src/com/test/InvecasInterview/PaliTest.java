package com.test.InvecasInterview;

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Stream;
/*
* @author      Kiruthi Njenga
* @version     %I%, %G%
* @since       1.0
*/
public class PaliTest {
	/**
	 *    Assumptions
	 *    <p>
	 *       1) Ignore all non-alphanumeric characters a
	 *       2) Assume that upper-and lower-case characters are identical. 
	 *    </p>    
	 *     
	 */
	/**
	 * Logger initialization
	 */
	private static Logger logger  = Logger.getLogger( PaliTest.class.getName() );
	
	/** 
	 *  This is constructor method for our PaliTest class. 
	 */
	
	public PaliTest(){	
	}

	/**
	 * The main method for String counter class. 	
	 * <p>
	 *  Usage: PaliTest [StringToTest]
	 * </p>
	 * @param args The required arguments are:
	 * <p> args[0] is the string to test</p>
	 */
	public static void main(String[] args) {
		final StringBuffer sb = new StringBuffer();
		if(args ==null || args.length ==0 )
		{
			//An empty string is technically a palindrome.
			System.out.printf("The empty string is a Palindrome");
		}
		else
		{
			Stream<String> stream = Arrays.stream(args);
			stream
				.map(x -> x.toUpperCase())
				.map(x -> x.replaceAll("[^A-Z0-9]*", ""))
				.forEach(x -> sb.append(x));
		}
		PaliTest pt = new PaliTest();
		System.out.printf("The string %s is a%s Palindrome.\n", sb.toString(), (pt.testString(sb.toString())? "": " not"));
		pt.testString(sb.toString());	
	}
	/**
	 *  		
	 *  Test is a string is a Palindrome
	 *  @return <code>boolean</code> Returns true if string is a palindrome, otherwise returns false.  
	 */	
	public boolean testString(String inputString)
	{
		/*
		*	An empty is techincally a palindrome, single character could be considered a palindrome
		*/
		if (inputString.length() ==0 || inputString.length() ==1) return true;
		/*
		 * Set string to uppercase, remove non-alphanumberic characters
		 */
		inputString = inputString.toUpperCase().replaceAll("[^A-Z0-9]*", "");
		/*
		 * 	Split the Input length into 2. Traverse the individual characters of the string while 
		 *    checking for equality.  
		 */
		
		for (int x=0; inputString.length()> 0 && x< inputString.length()/2+1; x++)
		{
			int y = (inputString.length()-1) - x;
			if (inputString.charAt(x) != inputString.charAt(y))
			{
				return false;
			}
		}
		return true;
		//TODO: I wonder if we can use exclusiveOr operation of the string and reverse of the string 
		//   to test if there are identical. If all zeros, then its a palindrome. 
	}
}
