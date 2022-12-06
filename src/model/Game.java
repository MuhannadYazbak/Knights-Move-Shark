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
	public King king;
	public Knight knight;
	public Queen queen;
	
	
	public Game(String player, int level, int score, King king, Knight knight, Queen queen) {
		super();
		this.player = player;
		this.level = level;
		this.score = score;
		this.king = king;
		this.knight = knight;
		this.queen = queen;
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
	public King getKing() {
		return king;
	}
	public void setKing(King king) {
		this.king = king;
	}
	public Knight getKnight() {
		return knight;
	}
	public void setKnight(Knight knight) {
		this.knight = knight;
	}
	public Queen getQueen() {
		return queen;
	}
	public void setQueen(Queen queen) {
		this.queen = queen;
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
	
	
	
	

}
