package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter {

	public static void main(String[] args) {
		String destinationFileName = "FizzBuzz.txt";
		
		File destinationFile = new File(destinationFileName);
		
		try( PrintWriter writer = new PrintWriter(new FileWriter(destinationFile))) {
			for( int i = 1; i <= 300; i++ ) {
				String println;
				
				if( i%3 == 0 && i%5 == 0 ) {
					println = "FizzBuzz";
				} else if( i%3 == 0 || Integer.toString(i).contains("3") ) {
					println = "Fizz";
				} else if( i%5 == 0 || Integer.toString(i).contains("5") ) {
					println = "Buzz";
				} else {
					println = Integer.toString(i);
				}
				
				writer.println(println);
			}
			
			System.out.println("FizzBuzz.txt has been created.");
		} catch( IOException e ) {
			System.err.println("Failed to write to file.");
			System.exit(1);
		}
	}

}
