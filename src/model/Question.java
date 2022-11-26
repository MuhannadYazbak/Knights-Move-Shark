package model;

import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Question {
	private static int ID = 1;                           										   // Automatic ID for the class to generate automatic id for the instances.
	public int id;                                        										   // the question id.
	public String text;                                   										   // The Question's text.
	public Difficulty diff;                               										   // Difficulty level (easy,medium,hard).
	public ObservableList<Answer> answers = FXCollections.observableArrayList();          		   // DataStructure of the four possible answers for the question.
	public int rightAnswer;																		   // the number of the right answer.
	public String author;																		   // indicates the name of the author who wrote the question.
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public ObservableList<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(ObservableList<Answer> answers) {
		this.answers = answers;
	}
	public int getRightAnswer() {
		return rightAnswer;
	}
	/*
	 * set the right answer and update the asnwer of id (rightanswer - 1) to be the correct answer for the question.
	 */
	public void setRightAnswer(int rightAnswer) {
		this.rightAnswer = rightAnswer;
		this.answers.get(rightAnswer - 1).setCorrect(true);
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String newAuthor) {
		this.author = newAuthor;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return id == other.id;
	}
	
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", text=" + text + ", diff=" + diff + ", answers=" + answers + ", rightAnswer="
				+ rightAnswer + ", author=" + author + "]";
	}
	public Question(String text, Difficulty diff, ObservableList<Answer> answers, int rightAnswer, String author) {
		super();
		this.id = Question.ID++;
		this.text = text;
		this.diff = diff;
		this.answers = answers;
		this.rightAnswer = rightAnswer;
		this.author = author;
	}
	
	
	public Question() {
		super();
		this.id = Question.ID++;
	}
	/*
	 * adds answer to the answers data structure of this question, is used when adding a new question.
	 */
	public void addAnswer(String aText) {
		Answer answer = new Answer(aText, this.id);
		answers.addAll(answer);
	}
	
	

}
