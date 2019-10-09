package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		File file;
		Scanner fileScanner = null;
		String filename;
		String word;
		String inputBuffer;
		boolean caseSensitive;
		
		System.out.println("What is the file that should be searched?");
		filename = inputScanner.nextLine();
		file = new File(filename);
		
		try {
			fileScanner = new Scanner(file);
		} catch( FileNotFoundException e ) {
			System.err.println("File not found: "+file);
			inputScanner.close();
			System.exit(1);
		}
		
		System.out.println("What is the search word you are looking for?");
		word = inputScanner.nextLine();
		
		System.out.println("Should the search be case sensitive? (Y\\N)");
		inputBuffer = inputScanner.nextLine().trim().toLowerCase();
		
		if( !inputBuffer.equals("y") && !inputBuffer.contentEquals("n") ) {
			System.err.println("Invalid input. Expecting either 'Y' or 'N'");
			System.exit(1);
		}
		
		caseSensitive = inputBuffer.equals("y");
		
		if( !caseSensitive )
			word = word.toLowerCase();
		
		int counter = 0;
		for( int lineNumber = 1; fileScanner.hasNextLine(); lineNumber++ ) {
			String line = fileScanner.nextLine();
			String test = line;
			
			if( !caseSensitive )
				test = test.toLowerCase();
			
			if( test.indexOf(word) >= 0 ) {
				char start = ' ';
				//count instances
				int lastIndex = 0;
				int lastCounter = counter;
				while( test.indexOf(word, lastIndex) >= 0 ) {
					counter++;
					lastIndex = test.indexOf(word, lastIndex)+1;
				}
				if( lastCounter < counter-1 )
					start = '*';
				System.out.format("%s%d)  %s\n", start, lineNumber, line);
			}
		}
		System.out.format("\nFound %d occurances of '%s' in '%s'\n", counter, word, filename);
	}

}
