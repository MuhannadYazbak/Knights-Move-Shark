package model;

import java.util.Objects;

public class Answer {
	private static int ID=1;                          // Automatic id generator to be restarted to 1 when reaches 4.
	public int answerID;							  // the answer id
	public int questionID;                            // indicates to which question's answers this answer belongs.
	public boolean isCorrect;						  // indicates whether the answer is the correct answer for the question or not.	
	public String answerText;						  // the answer's text/
	public static int getID() {
		return ID;
	}
	public static void setID(int iD) {
		ID = iD;
	}
	public int getAnswerID() {
		return answerID;
	}
	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public Answer(String answerText, int questionID) {
		super();
		if ((Answer.ID+1)% 4 != 0) {
			this.answerID = ID++;
		}
		else {
			this.answerID = 4;
		}
		this.questionID = questionID;
		this.answerText = answerText;
//		if (SysData.getInstance().getQuestions().get(questionID).getRightAnswer() == this.answerID)
//			this.isCorrect = true;
		this.isCorrect = false;
	}
	
	public Answer(String answerText) {
		super();
		this.answerText = answerText;
	}
	@Override
	public int hashCode() {
		return Objects.hash(answerID, questionID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		return answerID == other.answerID && questionID == other.questionID;
	}
	@Override
	public String toString() {
		return "Answer [answerID=" + answerID + ", questionID=" + questionID + ", isCorrect=" + isCorrect
				+ ", answerText=" + answerText + "]";
	}
	
}
