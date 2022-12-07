package model;

import java.util.Arrays;
import java.util.Objects;

import utils.Difficulty;
import utils.PlusOrMinus;
//* new one //
public class Game {
	public static int ID=1;
	public int id;
	public String player;
	public int level;
	public int score;
	public static Square[][] board = new Square[8][8];
	public static King king;
	public static Knight knight;
	public static Queen queen;
	
	
	public Game(String player, int level, int score, King king, Knight knight, Queen queen) {
		super();
		this.player = player;
		this.level = level;
		this.score = score;
		Game.king = king;
		Game.knight = knight;
		Game.queen = queen;
		this.id = getID();
		setID(getID()+1);
	}
	public static int getID() {
		return ID;
	}
	public static void setID(int iD) {
		ID = iD;
	}
	public static Square[][] getBoard() {
		return board;
	}
	public static void setBoard(Square[][] board) {
		Game.board = board;
	}
	public static King getKing() {
		return king;
	}
	public static void setKing(King king) {
		Game.king = king;
	}
	public static Knight getKnight() {
		return knight;
	}
	public static void setKnight(Knight knight) {
		Game.knight = knight;
	}
	public static Queen getQueen() {
		return queen;
	}
	public static void setQueen(Queen queen) {
		Game.queen = queen;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		Game other = (Game) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "Game [id=" + id + ", player=" + player + ", level=" + level + ", score=" + score + ", board="
				+ Arrays.toString(board) + "]";
	}
	public Game(String player) {
		super();
		this.id = Game.ID++;
		this.player = player;
		this.score = 0;
		this.level = 1;
	}
	public static Square squareByIndx(int i, int j) {
		if(board == null)
			return null;
		return board[i][j];
	}
	public int UpdateScore(int score, PlusOrMinus POM, Difficulty d) {
		if(d == d.Easy && POM == POM.Plus)
			return score+=1;		
		
		else if(d == d.Easy && POM == POM.Minus)
			return score-=2;
		
		if(d == d.Medium && POM == POM.Plus)
			return score+=2;		
		
		else if(d == d.Medium && POM == POM.Minus)
			return score-=3;
		
		if(d == d.Hard && POM == POM.Plus)
			return score+=3;		
		
		else return score-=4;
		
	}
	
	public int NextLevel(int score, int level) {
		if(score>=15)
			return ++level;
		
		else return level;
	}
	
	/*public Square[][] LeadBoard(){
		
		
	}*/
	
	public boolean Winner(int score) {
		if(score>200)
			return true;
		return false;
	}
	
	public Game GameOver(Game g) {
		/*
		 * 
		 * if(game is over return game*/
		
		return null;
	}
	
	public void ForgetLast3() {
		
	}
	
	public Square JumpRandomly(Knight k, Square s) {
		
		// choose random move from the possible moves
		
		return null;
	}
	
	public void ChangeSquareType() {
		
	}
	
	public boolean PauseGame(Game g) {
		return false;
	}
	
	
	
	

}
