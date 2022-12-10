package utils;

//questions difficulty, reward and punishment
public enum Difficulty {
	
	EASY("Easy",0),MEDIUM("Medium",1),HARD("Hard",2);
	private String name;
	private int reward;
	private int punishment;
	private Difficulty(String name,int difficulty) {
		this.name = name;
		switch (difficulty) {
		case 0:
			this.reward = Constants.EASY_QUEST_SCORE;
			this.punishment = Constants.EASY_QUEST_PUNISH;
			break;
		case 1:
			this.reward = Constants.MEDIUM_QUEST_SCORE;
			this.punishment = Constants.MEDIUM_QUEST_PUNISH;
			break;
		case 2:
			this.reward = Constants.HARD_QUEST_SCORE;
			this.punishment = Constants.HARD_QUEST_PUNISH;
			break;
		}
	}
	public String getName() {
		return name;
	}
	public int getReward() {
		return reward;
	}
	public int getPunish() {
		return punishment;
	}
	public static Difficulty getDifficultybyID(int id) {
		if(id == 1) {
			return Difficulty.EASY;
		}else if(id == 2){
			 return Difficulty.MEDIUM;
		}else if(id == 3){
			return Difficulty.HARD;
		}else {
			return Difficulty.EASY; 
		}
	}

		
	public static String getIDByDifficulty(Difficulty difficulty) 
	{
		if(difficulty == Difficulty.EASY) {
			return "1";
		}else if(difficulty == Difficulty.MEDIUM){
			return "2";
		}else if(difficulty == Difficulty.HARD){
			return "3";
		}else {
			return "1";
		}
	}
		
}