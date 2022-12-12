package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import controller.JsonDataManager;
import utils.Difficulty;



public class SysData {
	
	private ArrayList<Player> historyGamesForShow;
	private HashMap<String, Question> easyQuestions;
	private HashMap<String, Question> mediumQuestions;
	private HashMap<String, Question> HardQuestions;
	private HashMap<String,Question> questions;
	private Question selectedQ;
	
	
    private static SysData instance;
	
	public static SysData getInstance() {
			if(instance == null)
				instance = new SysData();
			return instance; 
		}
	
	private SysData() {
		
		this.easyQuestions = new HashMap<String, Question>(); 
		this.mediumQuestions = new HashMap<String, Question>(); 
		this.HardQuestions = new HashMap<String, Question>();
		this.historyGamesForShow = new ArrayList<Player>();
		this.questions = JsonDataManager.getInstance().readJSONDataFRomFile(); //Reads the Question Json File
		this.selectedQ = new Question("",null,"","","","",0,"");
		putQuestions(JsonDataManager.getInstance().readJSONDataFRomFile()); //Calls the method that put the questions in the right places
		historyGamesForShow = JsonDataManager.getInstance().readHistoryDataFRomFile(); //Reads the History Json File
		sortArrayList(); 
	}
	
	public void sortArrayList() {
		Collections.sort(historyGamesForShow, new Comparator<Player>(){
		    public int compare(Player p1, Player p2) {
		        return p2.getScore().compareTo(p1.getScore());
		    }
		});
	}
	
	//Checks the difficulty and add the questions to the right places
	public void putQuestions(HashMap <String, Question> questions)
	{
		this.easyQuestions.clear();
		this.mediumQuestions.clear();
		this.HardQuestions.clear();
		for(Question q : questions.values())
		{
		
			if(q.getLevel() == Difficulty.EASY)
				this.easyQuestions.put(q.getQuestionText(), q);
			if(q.getLevel()  == Difficulty.MEDIUM)
				this.mediumQuestions.put(q.getQuestionText(), q);
			if(q.getLevel()  == Difficulty.HARD)
				this.HardQuestions.put(q.getQuestionText(), q);
		}
	}
	

	/**
	 * 
	 * Adds a question to the DB and write it the json file. This is the Observers
	 */
	public void addQuestion(Question q) {
		this.questions.put(q.getQuestionText(), q);
		JsonDataManager.getInstance().writeQuestionsIntoJsonFile(questions);
	}
	public void removeQuestion(Question q) {
		switch(q.getLevel()) {
		case EASY:
			this.easyQuestions.remove(q.getQuestionText());
			break;
		case MEDIUM:
			this.mediumQuestions.remove(q.getQuestionText());
			break;
		case HARD:
			this.HardQuestions.remove(q.getQuestionText());
			break;
		}
		this.questions.remove(q.getQuestionText());
		JsonDataManager.getInstance().writeQuestionsIntoJsonFile(questions);
	}
	public HashMap<String, Question> getQuestions() {
		return questions;
	}

	public void setQuestions(HashMap<String, Question> questions) {
		this.questions = questions;
	}

	public ArrayList<Player> getHistoryGamesForShow() {
		return historyGamesForShow;
	}

	public HashMap<String, Question> getEasyQuestions() {
		return easyQuestions;
	}

	public HashMap<String, Question> getMediumQuestions() {
		return mediumQuestions;
	}

	public HashMap<String, Question> getHardQuestions() {
		return HardQuestions;
	}

	public void setHistoryGamesForShow(ArrayList<Player> historyGamesForShow) {
		this.historyGamesForShow = historyGamesForShow;
	}

	public void setEasyQuestions(HashMap<String, Question> easyQuestions) {
		this.easyQuestions = easyQuestions;
	}

	public void setMediumQuestions(HashMap<String, Question> mediumQuestions) {
		this.mediumQuestions = mediumQuestions;
	}

	public void setHardQuestions(HashMap<String, Question> hardQuestions) {
		HardQuestions = hardQuestions;
	}
	public Question getSelectedQ() {
		return selectedQ;
	}
	public void setSelectedQ(Question selectedQ) {
		this.selectedQ.setQuestionText(selectedQ.getQuestionText());
		this.selectedQ.setAnswer1(selectedQ.getAnswer1());
		this.selectedQ.setAnswer2(selectedQ.getAnswer2());
		this.selectedQ.setAnswer3(selectedQ.getAnswer3());
		this.selectedQ.setAnswer4(selectedQ.getAnswer4());
		this.selectedQ.setLevel(selectedQ.getLevel());
		this.selectedQ.setRightAnswer(selectedQ.getRightAnswer());
		this.selectedQ.setAuthor(null);
	}

	
	public void updateQuestion (Question oldQ, Question newQ) {
		oldQ.setQuestionText(newQ.getQuestionText());
		oldQ.setAnswer1(newQ.getAnswer1());
		oldQ.setAnswer2(newQ.getAnswer2());
		oldQ.setAnswer3(newQ.getAnswer3());
		oldQ.setAnswer4(newQ.getAnswer4());
		oldQ.setLevel(newQ.getLevel());
		oldQ.setRightAnswer(newQ.getRightAnswer());
		oldQ.setAuthor(newQ.getAuthor());
		JsonDataManager.getInstance().writeQuestionsIntoJsonFile(questions);
		
	}
		
}