/**
 * 
 */
package edu.gsu.csc1301.reversefile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
/**
 * This program reverses the order of the lines in a file
 * 
 * @author Patrick Copeland
 * @version 04/19/2020
 */
public class ReverseFile 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner (System.in);
		boolean done = false;
		while (!done)
		{
			try
			{
				//Gather names for input and  output files
				System.out.print("Please enter the file name for input: ");
				String fileName = in.next();
				ArrayList<String> data = readFile(fileName);
				
				System.out.print("Please enter the file name for output: ");
				String output = in.next();
				
				writeInReverse(output, data);
				
				done = true;

			} //Catch exceptions
			catch (FileNotFoundException exception)
			{
			   System.out.println("File not found.");
			}
			catch (NoSuchElementException exception)
			{
			   System.out.println("File contents invalid.");
			}
			catch (IOException exception)
			{
			   exception.printStackTrace();
			}
		}
		in.close();
	}
	
	/**
	 * This method opens a file and reads the lines of the file
	 * @param fileName the name of the file being read
	 * @return an array list of type string containing the lines of the file
	 */
	public static ArrayList<String> readFile(String fileName) throws IOException
	{
		File inputFile = new File(fileName);
		try (Scanner in = new Scanner(inputFile))
	    {
			return readLinesOfArray(in);
		}
	}
	
	/**
	 * This method reads the lines of an input file
	 * @param in the name of the scanner that reads the file
	 * @return an array list of type string containing the file data
	 */
	public static ArrayList<String> readLinesOfArray(Scanner in) throws IOException
	{
		ArrayList<String> lines = new ArrayList<>();
		while (in.hasNextLine())
		{
			lines.add(in.nextLine());
		}
		in.close();
		return lines;
	}
	
	/**
	 * This method reads the file in reverse order and copies 
	 * each line, in reverse order, into the output document
	 * @param output the output file, data the array list string 
	 * that was read by the scanner
	 * @return 
	 */
	public static void writeInReverse(String output, ArrayList<String> data)
	{
		try 
		{
			//Create the print writer and read through the data backward, recording each line in reverse order
			PrintWriter out = new PrintWriter(output);
			for (int i = data.size() - 1; i >= 0; i--)
			{
				out.println(data.get(i));
			}
			out.close();
		}
		catch (IOException exception)
	    {
			System.out.println("File not found.");
	    }
	}
}
