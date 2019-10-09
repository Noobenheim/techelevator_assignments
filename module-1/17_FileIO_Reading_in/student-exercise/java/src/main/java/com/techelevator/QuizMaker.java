package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		Scanner fileScanner = null;
		String input;
		File file;
		Queue<Question> questions = new LinkedList<>();
		
		System.out.println("Where is the quiz file?");
		input = inputScanner.nextLine();
		file = new File(input);
		
		try {
			fileScanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find file: "+input);
			inputScanner.close();
			System.exit(1);
		}
		
		while( fileScanner.hasNextLine() ) {
			questions.offer(new Question(fileScanner.nextLine()));
		}
		fileScanner.close();
		
		System.out.print("Randomize question order? (Y/N) ");
		input = inputScanner.nextLine();
		if( input.toLowerCase().equals("y") ) 
			questions = Question.randomizeQuestions(questions);
		
		System.out.print("Randomize answer order? (Y/N) ");
		input = inputScanner.nextLine();
		
		boolean randomizeAnswers = input.toLowerCase().equals("y");
		int numberOfQuestions = questions.size();
		int correctAnswers = 0;
		while( questions.size() > 0 ) {
			System.out.println();
			Question currentQuestion = questions.poll();
			String[] answers = currentQuestion.getAnswers(randomizeAnswers);
			
			System.out.println(currentQuestion.getQuestion());
			for( int i=0; i<answers.length; i++ ) {
				System.out.println((i+1)+". "+answers[i]);
			}
			
			int answer;
			do {
				System.out.print("\nYour answer: ");
				input = inputScanner.nextLine();
				
				try {
					answer = Integer.parseInt(input.trim());
					if( answer > 0 && answer <= answers.length ) {
						break;
					}
				} catch( NumberFormatException e) {
				}
				System.out.println("Invalid selection.");
			} while(true);
			
			if( currentQuestion.isCorrectAnswer(answers[answer-1]) ) {
				System.out.println("Correct!");
				correctAnswers++;
			} else {
				System.out.println("Sorry that isn't correct! The correct answer is "+currentQuestion.getCorrectAnswer());
			}
		}
		
		System.out.format("\nYou got %d answer%s correct out of %d questions asked.\n", correctAnswers, correctAnswers==1?"":"s", numberOfQuestions);
		inputScanner.close();
	}

}
