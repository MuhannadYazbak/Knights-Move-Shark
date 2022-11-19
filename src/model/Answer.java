package model;

public class Answer {
	public String text;
	public boolean isCorrect;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	@Override
	public String toString() {
		return "Answer [text=" + text + ", isCorrect=" + isCorrect + "]";
	}
	public Answer(String text) {
		super();
		this.text = text;
	}
	
	

}
