package model;

import java.util.Arrays;
import java.util.Objects;

public class Game {
	public static int ID=1;
	public int id;
	public String player;
	public int level;
	public int score;
	public Square[][] board = new Square[8][8];
	
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
	
	
	
	

}
