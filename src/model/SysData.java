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
		putQuestions(JsonDataManager.getInstance().readJSONDataFRomFile()); //Calls the method that put the questions in the right places
		historyGamesForShow = JsonDataManager.getInstance().readHistoryDataFRomFile(); //Reads the History Json File
		sortArrayList(); // Sort the top 10
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
		
			if(q.getDiff() == Difficulty.easy)
				this.easyQuestions.put(q.getText(), q);
			if(q.getDiff()  == Difficulty.medium)
				this.mediumQuestions.put(q.getText(), q);
			if(q.getDiff()  == Difficulty.hard)
				this.HardQuestions.put(q.getText(), q);
		}
	}
	

	/**
	 * 
	 * Adds a question to the DB and write it the json file. This is the Observers
	 */
	public void addQuestion(Question q) {
		this.questions.put(q.getText(), q);
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
		
}
