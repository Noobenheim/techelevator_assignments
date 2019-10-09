package com.techelevator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Question {
	public static final char CORRECT_ANSWER_MARK = '*';
	public static final String QUESTION_DELIMITER = "\\|";
	
	private String question;
	private List<String> wrongAnswers = new ArrayList<>();
	private String correctAnswer = null;
	private int correctAnswerIndex = -1; // so if not shuffled, it'll be in the same spot
	
	public Question(String line) {
		if( line == null || line.trim().equals("") ) {
			throw new IllegalArgumentException("String information cannot be null or empty.");
		}
		String[] parsed = line.split(QUESTION_DELIMITER);
		
		question = parsed[0];
		
		for( int i=1; i<parsed.length; i++ ) {
			if( parsed[i].indexOf(CORRECT_ANSWER_MARK) == parsed[i].length()-1 ) {
				correctAnswer = parsed[i].substring(0, parsed[i].length()-1);
				correctAnswerIndex = i-1;
			} else {
				wrongAnswers.add(parsed[i]);
			}
		}
		
		// verify correct answer doesn't match other answers
		for( int i=0; i<this.wrongAnswers.size(); i++ ) {
			if( this.wrongAnswers.get(i).equals(this.correctAnswer) ) {
				throw new IllegalArgumentException("Correct answer must be unique");
			}
		}
		
		if( correctAnswer == null ) {
			throw new IllegalArgumentException("Question needs a correct answer marked.");
		}
		if( wrongAnswers.size() == 0 ) {
			throw new IllegalArgumentException("The test needs to be more complicated.");
		}
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	public String[] getAnswers() {
		// shuffle answers by default
		return getAnswers(true);
	}
	public String[] getAnswers(boolean shuffle) {
		if( shuffle ) {
			Random random = new Random();
			String[] randomized = new String[this.wrongAnswers.size()+1];
			List<String> copy = new ArrayList<String>(this.wrongAnswers);
			copy.add(this.correctAnswer);
			
			for( int i=0; i<randomized.length; i++ ) {
				randomized[i] = copy.remove(random.nextInt(copy.size()));
			}
			
			return randomized;
		}
		// not shuffled
		String[] returnArray = new String[this.wrongAnswers.size()+1];
		
		boolean gotCorrect = false;
		for( int i=0; i < returnArray.length; i++ ) {
			if( i == this.correctAnswerIndex ) {
				gotCorrect = true;
				returnArray[i] = this.correctAnswer;
			} else {
				returnArray[i] = this.wrongAnswers.get(i - (gotCorrect?1:0));
			}
		}
		
		return returnArray;
	}
	public String getCorrectAnswer() {
		return this.correctAnswer;
	}
	public boolean isCorrectAnswer(String answer) {
		return answer.equals(this.correctAnswer);
	}
	
	public static Queue<Question> randomizeQuestions(Collection<Question> questions) {
		Queue<Question> randomized = new LinkedList<>();
		List<Question> copy = new ArrayList<>(questions);
		
		Random random = new Random();
		
		while( copy.size() > 0 ) {
			randomized.offer( copy.remove(random.nextInt(copy.size())) );
		}
		
		return randomized;
	}
}
