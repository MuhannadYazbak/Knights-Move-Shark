package model;

import java.util.Arrays;
import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Question {
	private static int ID = 1;
	public int id;
	public String text;
	public Difficulty diff;
	public ObservableList<Answer> answers = FXCollections.observableArrayList();
	public int rightAnswer;
	public String author;
	
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
	public void setRightAnswer(int rightAnswer) {
		this.rightAnswer = rightAnswer;
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

}
