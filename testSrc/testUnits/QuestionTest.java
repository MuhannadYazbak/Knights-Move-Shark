package testUnits;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.JsonDataManager;
import model.Question;
import model.SysData;
import utils.Difficulty;

public class QuestionTest {
	private static Question q = new Question("What is the best programming language in your opinion?", Difficulty.HARD, "Python", "Java", "C", "ReactJs", 1, "Shark");
	
	/*
	 * Tests add question method, expects to find the added question in the Questions data structure.
	 */
	@Test
	void a1() {
		SysData.getInstance().addQuestion(q);
		assertTrue(SysData.getInstance().getQuestions().containsValue(q));
	}
	
	/*
	 * Tests add question method, expects to find the added question in the Question JSON file.
	 */
	@Test
	void a2() {
		assertTrue(JsonDataManager.getInstance().readJSONDataFRomFile().containsKey(q.getQuestionText()));
	}
	
	/*
	 * Tests that the added question was also successfully added to its level map.
	 */
	@Test
	void b2() {
		assertTrue(SysData.getInstance().getHardQuestions().containsValue(q));
	}
	
	/*
	 * Tests update question, expects not to find the original question in the Question data structure.
	 */
	@Test
	void c3() {
		SysData.getInstance().updateQuestion(q,new Question("What is the best  language?", Difficulty.EASY, "English", "Arabic", "Hebrew", "French", 2, "Shark") );
		assertFalse(SysData.getInstance().getQuestions().containsKey("What is the best programming languag in your opinion?"));
	}
	
	/*
	 * Tests update question, expects not to find the original question in the Question JSON file.
	 */
	@Test
	void c4() {
		assertFalse(JsonDataManager.getInstance().readJSONDataFRomFile().containsKey("What is the best programming language in your opinion?"));
	}
	
	/*
	 * Tests that the question is now updated in the Question data structure.
	 */
	@Test
	void d4() {
		assertTrue(SysData.getInstance().getQuestions().containsKey("What is the best  language?"));
	}
	
	/*
	 * Tests that the question is now updated in the Question JSON file.
	 */
	@Test
	void d5() {
		assertTrue(JsonDataManager.getInstance().readJSONDataFRomFile().containsKey("What is the best  language?"));
	}
	
	/*
	 * Tests that the updated question is also found in it's new level map.
	 */
	@Test
	void e5() {
		assertTrue(SysData.getInstance().getEasyQuestions().containsValue(q));
	}
	
	/*
	 *  Tests remove question method, expects not to find the removed question in the Question data structure.
	 */
	@Test
	void f6() {
		SysData.getInstance().removeQuestion(q);
		assertFalse(SysData.getInstance().getQuestions().containsValue(q));
	}
	
	/*
	 *  Tests remove question method, expects not to find the removed question in the Questions JSON file.
	 */
	@Test
	void f7() {
		assertFalse(JsonDataManager.getInstance().readJSONDataFRomFile().containsValue(q));
	}
	
	/*
	 * Tests that the removed question was also removed from its level map.
	 */
	@Test
	void g7() {
		assertFalse(SysData.getInstance().getEasyQuestions().containsValue(q));
	}

}
