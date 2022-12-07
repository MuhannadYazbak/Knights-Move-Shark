package model;

import utils.Difficulty;

public class Question {

	public String text;                                   										 
	public Difficulty diff;                             										 
	public String answer1;
	public String answer2;
	public String answer3;
	public String answer4;
	public int rightAnswer;																		  
	public String author;	

	public Question(String text, Difficulty diff, String answer1, String answer2, String answer3, String answer4,
			int rightAnswer, String author) {
		this.text = text;
		this.diff = diff;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.rightAnswer = rightAnswer;
		this.author = author;
	}
	
	public String getCorrectAnswer() {
		
		switch (getRightAnswer()) {
		case 1:
			return getAnswer1();
		case 2:
			return getAnswer2();
		case 3:
			return getAnswer3();
		case 4:
			return getAnswer4();

		}
		return "";
		
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public Difficulty getDiff() {
		return diff;
	}

	public void setDiff(Difficulty diff) {
		this.diff = diff;
	}

	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	public int getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(int rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	
	

}
