package com.techelevator.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class NotificationSignupDAO {
	
	private PrintWriter writer;

	public NotificationSignupDAO() {
		File signupFormLogFile = getSignupLogFile();
		try {
			FileOutputStream out = new FileOutputStream(signupFormLogFile, true);
			this.writer = new PrintWriter(out, true);
		} catch (FileNotFoundException fnfe) {
			System.out.println("Could not open " + signupFormLogFile.getAbsolutePath() + " for logging!");
		}		
	}
	
	public void saveNotificationSignup(String firstName, String lastName, int age, String emailAddress) {
		LocalDateTime now = LocalDateTime.now();
		writer.println(now+"|"+lastName+", "+firstName+"|"+age+"|"+emailAddress);
	}
		
	private File getSignupLogFile() {
		String homeDirectory = System.getProperty("user.home");
		return new File(homeDirectory, "notificationSignups.csv");
	}

}
