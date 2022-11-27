package utils;

public class Constants {
	
	public static final String JSON_QUESTION_FILE_PATH="src/Questions.json";
	/**
	 * 
	 */
	public static final String JSON_HISTORY_FILE_PATH="src/History.json";

	/**
	 * Score when the user answered the Easy Question correctly.
	 */
	public static final int EASY_QUEST_SCORE = 1;
	/**
	 * Score when the user answered the Medium Question correctly.
	 */
	public static final int MEDIUM_QUEST_SCORE = 2;
	/**
	 * Score when the user answered the Hard Question correctly.
	 */
	public static final int HARD_QUEST_SCORE = 3;
	/**
	 * Score to decrease when the user answers wrong the Easy Question.
	 */
	public static final int EASY_QUEST_PUNISH = 2;
	/**
	 * Score to decrease when the user answers wrong the Medium Question.
	 */
	public static final int MEDIUM_QUEST_PUNISH = 3;
	/**
	 * Score to decrease when the user answers wrong the Hard Question .
	 */
	public static final int HARD_QUEST_PUNISH = 4;
}
