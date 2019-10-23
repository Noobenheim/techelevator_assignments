package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.item.Item;
import com.techelevator.item.Candy;
import com.techelevator.item.Chip;
import com.techelevator.item.Drink;
import com.techelevator.item.Gum;

public class VendingMachine {
	
	public static final int FULL_CAPACITY = 5;
	
	private Map<String, VendingMachineSlot> slots = new LinkedHashMap<String, VendingMachineSlot>();
	private Map<Item, Integer> allSoldItems = new LinkedHashMap<Item, Integer>();
	private List<Item> sessionSoldItems;
	private int totalMoneyInCents = 0;
	private int sessionInputMoney = 0;
	private int runningLogAmount = 0;
	private PrintWriter log;
	
	private boolean loggingEnabled;

	public VendingMachine(File inventoryFile) throws FileNotFoundException, IOException {
		this(inventoryFile, true); // call the other constructor, default logging enabled 
	}

	public VendingMachine(File inventoryFile, boolean loggingEnabled) throws FileNotFoundException, IOException {		
		Scanner inputFileStream = new Scanner(inventoryFile);
		sessionSoldItems = new ArrayList<Item>();

		this.loggingEnabled = loggingEnabled;
		
		if(this.loggingEnabled) {
			log = new PrintWriter(new FileWriter("log.txt", true));
		}
		
		while(inputFileStream.hasNextLine()) {
			String currentLine = inputFileStream.nextLine();
			String[] parts = currentLine.split("\\|");
			String slotLocation = parts[0];
			String name = parts[1];
			int priceInCents = (int)(Double.parseDouble(parts[2]) * 100.0);
			String type = parts[3];
			
			Item item;
			switch(type) {
				case "Gum":
					item = new Gum(name);
					break;
				case "Candy":
					item = new Candy(name);
					break;
				case "Drink":
					item = new Drink(name);
					break;
				case "Chip":
					item = new Chip(name);
					break;
				default:
					item = new Drink("Four Loko");
			}
			
			VendingMachineSlot currentSlot = new VendingMachineSlot(name, item, FULL_CAPACITY, priceInCents);
			slots.put(slotLocation, currentSlot);
			
			allSoldItems.put(item, 0);
		}
		
		inputFileStream.close();
	}
	
	public String getMenu() {
		String header =	"===========================================\n" +
				        "SLOT  NAME                 PRICE   QUANTITY\n" +
	                    "===========================================\n";

		String output = "";
		for(Map.Entry<String, VendingMachineSlot> kv : slots.entrySet()) {
			String slotLocation = kv.getKey();
			VendingMachineSlot vms = kv.getValue();
			
			String itemName = vms.getItem().getName();
			String price = DecimalFormat.getCurrencyInstance().format(vms.getPriceInCents() / 100.0);
			int quantityRemaining = vms.getQty();
			
			output += String.format(" %-4s %-20s %-10s %-5d%n", slotLocation, itemName, price, quantityRemaining);
		}
		
		return header + output;
	}
		
	public Item vend(String slotLocation) {
		Item result = null;

		if(slots.containsKey(slotLocation)) {
			VendingMachineSlot vms = slots.get(slotLocation);
			int priceInCents = vms.getPriceInCents();
			
			if(priceInCents > this.sessionInputMoney) {
				System.out.println("You do not have enough money to complete this transaction!");
			} else if(vms.getQty() <= 0) {
				System.out.println("Sold Out!");
			} else {
				result = vms.getItem();
				vms.decrement();
				this.totalMoneyInCents += priceInCents;
				this.sessionInputMoney -= priceInCents;
				
				String transaction = result.getName() + " " + slotLocation;
				log(transaction, priceInCents);

				sessionSoldItems.add(result);
				allSoldItems.put(result, allSoldItems.get(result) + 1);
				
			}
		} else {
			System.out.print("Invalid selection!");
		}
		
		return result;
	}
	
	public int getQty(String slotLocation) {
		if(slots.containsKey(slotLocation)) {
			return slots.get(slotLocation).getQty();
		}	
		return 0;
	}
	
	public void addMoney(int dollarsToAdd) {
		log("FEED MONEY:", dollarsToAdd * 100);
		this.sessionInputMoney += (dollarsToAdd * 100);
	}
	
	public String getSessionMoney() {
		return DecimalFormat.getCurrencyInstance().format(sessionInputMoney / 100.0);
	}
	
	public String consumeItems() {
		String consumed = "";
		
		for(Item i : sessionSoldItems) {
			consumed += i.consume() + "\n";
		}
		
		sessionSoldItems = new ArrayList<Item>();
		return consumed;
	}
	
	public String giveChange() {
		log("GIVE CHANGE: ", this.sessionInputMoney);

		String result = giveChange(this.sessionInputMoney);
		this.sessionInputMoney = 0;
		
		return result;
	}
	
	public void log(String transaction, int amountInCents) {
		if(loggingEnabled) {			
			Date timestamp = new Date();
			
			if(transaction.toUpperCase().contains("FEED")) {
				runningLogAmount += amountInCents;
			} else {
				runningLogAmount -= amountInCents;			
			}
	
			double transactionAmount = (double)amountInCents / 100.0;
			String transactionCurrency = NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(transactionAmount);
	
			double totalAmount = (double)runningLogAmount / 100.0;
			String totalCurrency = NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(totalAmount);
	
			log.println(timestamp + "\t" + transaction + "\t" + transactionCurrency + "\t" + totalCurrency);
			log.flush();
		}
	}
	
	public void shutdown() {
		if(loggingEnabled) {
			
			try {
				PrintWriter salesReport = new PrintWriter("sales_report.txt");
				
				for(Item i : allSoldItems.keySet()) {
					salesReport.println(i.getName() + "|" + allSoldItems.get(i));
				}
				
				double amount = (double)totalMoneyInCents / 100.0;
				String currency = NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(amount);
	
				salesReport.println();
				salesReport.println("**TOTAL SALES** " + currency);
				
				salesReport.flush();
				salesReport.close();
				
				this.giveChange();
				log.flush();
				log.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("Could not create Sales Report.");
			}
		}
		
	}
	
	
	public static String giveChange(int moneyInCents) {
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		
		while(moneyInCents >= 25) {
			moneyInCents -= 25;
			quarters++;
		}
		
		while(moneyInCents >= 10) {
			moneyInCents -= 10;
			dimes++;
		}
		
		while(moneyInCents >= 5) {
			moneyInCents -= 5;
			nickels++;
		}
				
		return quarters + " Quarter" + (quarters == 1 ? ", " : "s, ") + 
			      dimes + " Dime"    + (dimes    == 1 ? ", " : "s, ") + 
			    nickels + " Nickel"  + (nickels  == 1 ?  ""  : "s");
	}

}
