package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//Where is the input file (please include the path to the file)? [path-to-file]/input.txt
//How many lines of text (max) should there be in the split files? 3
//The input file has 50 lines of text.

public class FileSplitter {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		File inputFile;
		int maxLines = 0;
		
		do {
			System.out.print("Where is the input file (please include the path to the file)? ");
			inputFile = new File(inputScanner.nextLine());
			
			if( !inputFile.exists() ) {
				System.out.println("Source file does not exist.");
			}
		} while( !inputFile.exists() );
		
		boolean validInput = false;
		do {
			System.out.print("How many lines of text (max) should there be in the split files? ");
			String input = inputScanner.nextLine();
			
			try {
				maxLines = Integer.parseInt(input);
				validInput = true;
			} catch( NumberFormatException e ) {
				System.out.println("Please enter a valid number");
			}
		} while( !validInput );
		
		String ext;
		String name;
		if( inputFile.getName().indexOf('.') >= 0 ) {
			ext = inputFile.getName().substring(inputFile.getName().lastIndexOf('.'));
			name = inputFile.getName().substring(0, inputFile.getName().lastIndexOf('.'));
		} else {
			ext = "";
			name = inputFile.getName();
		}
		
		int lineCount = 0;
		try(Scanner fileScanner = new Scanner(inputFile) ) {
			for( long i=1; fileScanner.hasNextLine() && i < Long.MAX_VALUE; i++ ) {
				File outputFile = new File(name+"-"+i+ext);
				try( PrintWriter writer = new PrintWriter(new FileWriter(outputFile)) ) {
					for( int j = 0; j < maxLines && fileScanner.hasNextLine(); j++ ) {
						lineCount++;
						writer.println(fileScanner.nextLine());
					}
				} catch( IOException e ) {
					System.out.println("Error when writing to file.");
				}
			}
		} catch( IOException e ) {
			System.out.println("Unable to read file.");
		}
		System.out.println("The input file has "+lineCount+" lines of text.");
		
		inputScanner.close();
	}
}
