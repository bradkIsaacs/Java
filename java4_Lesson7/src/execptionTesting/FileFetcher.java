package execptionTesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileFetcher {
	String aLine = "";

	// we will look at the file one line at a time
	public void getHomework() {
		FileReader myFile; 
		BufferedReader in = null; // declare FileReader and BufferedReader as instance variables
		try {
			myFile = new FileReader("homework.txt"); //Do NOT declare here too or scope stays within try block
			System.out.println("I did get here");
			in = new BufferedReader(myFile);//Do NOT declare here too or scope stays within try block
		} catch (FileNotFoundException e) {
			System.out
					.println("Can't find the file, but keep goingws for future problems!");
		}
		while (aLine != null) {
			try {
				aLine = in.readLine();// of the file
			} catch (IOException e) {
				System.out.println("Now we have some other problem!");
			}
			if (aLine !=null) System.out.println(aLine);
		}
		System.out.println(aLine);// the Console
	}

	public static void main(String[] args) {
		FileFetcher testMe = new FileFetcher();
		testMe.getHomework();
	}
}