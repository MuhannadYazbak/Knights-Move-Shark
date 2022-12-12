package model;

import java.util.Objects;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import utils.Difficulty;

public class Question {

	private SimpleStringProperty questionText;                                   										 
	private Difficulty level;                             										 
	private SimpleStringProperty answer1;
	private SimpleStringProperty answer2;
	private SimpleStringProperty answer3;
	private SimpleStringProperty answer4;
	private SimpleIntegerProperty rightAnswer;																		  
	private SimpleStringProperty author;	

	public Question(String questionText, Difficulty level, String answer1, String answer2, String answer3, String answer4,
			int rightAnswer, String author) {
		this.questionText = new SimpleStringProperty(questionText);
		this.level = level;
		this.answer1 = new SimpleStringProperty(answer1);
		this.answer2 = new SimpleStringProperty(answer2);
		this.answer3 = new SimpleStringProperty(answer3);
		this.answer4 = new SimpleStringProperty(answer4);
		this.rightAnswer = new SimpleIntegerProperty(rightAnswer);
		this.author = new SimpleStringProperty(author);
	}
	
//	public String getCorrectAnswer() {
//		
//		switch (getRightAnswer()) {
//		case 1:
//			return getAnswer1();
//		case 2:
//			return getAnswer2();
//		case 3:
//			return getAnswer3();
//		case 4:
//			return getAnswer4();
//
//		}
//		return "";
//		
//	}
//	
	
	public void setCorrectAnswer(int correct) {
		this.rightAnswer = new SimpleIntegerProperty(correct);
	}
	
	public String getQuestionText() {
		return questionText.get();
	}
	public void setQuestionText(String questionText) {
		this.questionText = new SimpleStringProperty(questionText);
	}
	
	public Difficulty getLevel() {
		return level;
	}

	public void setLevel(Difficulty level) {
		this.level = level;
	}

	public String getAnswer1() {
		return answer1.get();
	}
	public void setAnswer1(String answer1) {
		this.answer1 = new SimpleStringProperty(answer1);
	}
	public String getAnswer2() {
		return answer2.get();
	}
	public void setAnswer2(String answer2) {
		this.answer2 = new SimpleStringProperty(answer2);
	}
	public String getAnswer3() {
		return answer3.get();
	}
	public void setAnswer3(String answer3) {
		this.answer3 = new SimpleStringProperty(answer3);
	}
	public String getAnswer4() {
		return answer4.get();
	}
	public void setAnswer4(String answer4) {
		this.answer4 = new SimpleStringProperty(answer4);
	}
	public int getRightAnswer() {
		return rightAnswer.get();
	}
	public void setRightAnswer(int rightAnswer) {
		this.rightAnswer = new SimpleIntegerProperty(rightAnswer);
	}
	public String getAuthor() {
		return author.get();
	}
	public void setAuthor(String author) {
		this.author = new SimpleStringProperty(author);
	}

	@Override
	public int hashCode() {
		return Objects.hash(questionText);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(questionText, other.questionText);
	}

	@Override
	public String toString() {
		return "Question [text=" + questionText + ", diff=" + level + ", answer1=" + answer1 + ", answer2=" + answer2
				+ ", answer3=" + answer3 + ", answer4=" + answer4 + ", rightAnswer=" + rightAnswer + ", author="
				+ author + "]";
	}
	
	
	
	
	

}