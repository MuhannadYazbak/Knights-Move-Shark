package testUnits;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Question;
import model.SysData;
import utils.Difficulty;

public class QuestionTest {
	private static Question q = new Question("What is the best programming language?", Difficulty.HARD, "Python", "Java", "C", "React", 1, "Shark");
	
	/*
	 * Tests add question method, expects to find the added question in the JSON file.
	 */
	@Test
	void a1() {
		SysData.getInstance().addQuestion(q);
		assertTrue(SysData.getInstance().getQuestions().containsValue(q));
	}
	
	/*
	 * Tests that the added question was also successfully added to its level map.
	 */
	@Test
	void b2() {
		assertTrue(SysData.getInstance().getHardQuestions().containsValue(q));
	}
	
	/*
	 * Tests update question, expects not to find the original question
	 */
	@Test
	void c3() {
		SysData.getInstance().updateQuestion(q,new Question("What is the best  language?", Difficulty.EASY, "English", "Arabic", "Hebrew", "French", 2, "Shark") );
		assertFalse(SysData.getInstance().getQuestions().containsKey("What is the best programming language?"));
	}
	
	/*
	 * Tests that the question is now updated
	 */
	@Test
	void d4() {
		assertTrue(SysData.getInstance().getQuestions().containsKey("What is the best  language?"));
	}
	
	/*
	 * Tests that the updated question is also found in it's new level map.
	 */
	@Test
	void e5() {
		assertTrue(SysData.getInstance().getEasyQuestions().containsValue(q));
	}
	
	/*
	 *  Tests remove question method, expects not to find the removed question in theJSON file.
	 */
	@Test
	void f6() {
		SysData.getInstance().removeQuestion(q);
		assertFalse(SysData.getInstance().getQuestions().containsValue(q));
	}
	
	/*
	 * Tests that the removed question was also removed from its level map.
	 */
	@Test
	void g7() {
		assertFalse(SysData.getInstance().getEasyQuestions().containsValue(q));
	}

}
