package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import com.techelevator.item.Item;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);		
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while(choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if(selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch(NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if(choice == null) {
			invalidSelection(userInput);
		}
		return choice;
	}
	
	public void invalidSelection(String userInput) {
		out.println("\n*** "+userInput+" is not a valid option ***\n");
	}
	
	public void displayVendedItem(Item item) {
		out.println("Purchased: " + item.getName() + "\n");
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum+") "+options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}
	
	public int feedMoney() {
		String response = null;
		
		while(response == null) {
			out.print("What size bill are you inserting [$1, $2, $5, $10, $20]?\nEnter digits only >>> ");
			out.flush();
			response = in.nextLine().trim();
			
			if(!response.equals("0") && !response.equals("1") && !response.equals("2") && !response.equals("5") && !response.equals("10") && !response.equals("20")) {
				out.println(response + " is not a valid bill.");
				response = null;
			}
		}
		int dollarsToAdd = Integer.parseInt(response);
		return dollarsToAdd;
	}
	
	public String purchaseItem() {
		out.print("\nPlease choose an option >>> ");
		out.flush();
		String userInput = in.nextLine().trim();

		return userInput;
	}
	
}
