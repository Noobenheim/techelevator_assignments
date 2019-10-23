package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.techelevator.item.Item;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE };

	private static final String PURCHASE_MENU_OPTION_DISPLAY_ITEMS = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_PURCHASE = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH = "Finish Transaction";
	private static final String PURCHASE_MENU_OPTION_SHUT_DOWN = "Shut Down";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_DISPLAY_ITEMS,
			PURCHASE_MENU_OPTION_PURCHASE, PURCHASE_MENU_OPTION_FINISH, PURCHASE_MENU_OPTION_SHUT_DOWN };
	
	private Menu menu;
	private VendingMachine vendingMachine;
	
	public VendingMachineCLI(Menu menu) throws FileNotFoundException, IOException {
		this.menu = menu;
		
		File inputFile = new File("vendingmachine.csv");
		this.vendingMachine = new VendingMachine(inputFile);
	}
	
	public void run() {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println(vendingMachine.getMenu());
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				System.out.println("Current Money Provided: " + vendingMachine.getSessionMoney());
				String choice2 = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				
				switch(choice2) {
					case PURCHASE_MENU_OPTION_DISPLAY_ITEMS:
						int dollarsToAdd = menu.feedMoney();
						vendingMachine.addMoney(dollarsToAdd);
						break;
					case PURCHASE_MENU_OPTION_PURCHASE:
						String selection = menu.purchaseItem();
						Item item = vendingMachine.vend(selection);
						if(item == null) {
							menu.invalidSelection(selection);
						} else {
							menu.displayVendedItem(item);
						}
						break;
					case PURCHASE_MENU_OPTION_FINISH:
						finishTransaction();
						break;
					case PURCHASE_MENU_OPTION_SHUT_DOWN:
						vendingMachine.shutdown();
						System.exit(0);
						break;
					default:
						break;
				}
				
			}
		}
	}
	
	void finishTransaction() {
		String consumed = vendingMachine.consumeItems();
		System.out.println("-------------------------------------");
		System.out.println(consumed);
		System.out.println("-------------------------------------");
		String change = vendingMachine.giveChange();
		System.out.println(change);
		System.out.println("-------------------------------------");
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
