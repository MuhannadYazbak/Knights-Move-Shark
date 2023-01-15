package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import utils.Difficulty;

import utils.Type;
//* new one //
public class Game {
	private static int ID=1;
	private int id;
	private int scoreLevel1=0, scoreLevel2=0, scoreLevel3=0, scoreLevel4=0;
	private Player player;
	private int level;
	private int score;
	private Square[][] board;
	private King king ; 
	private Knight knight; 
	private Queen queen  ; 
	private static Game instance;
	private boolean gameOver;
    private boolean youWon;
    public static int skin;
    private PieceFactory pieceFactory;
    private Stack<lastObj> last = new Stack<>();
	
	//Singleton class
    public static Game getInstance() {
		if(instance == null)
			instance = new Game();
		return instance; 
	}
    
    public static int getSkin() {
		return skin;
	}

	public static void setSkin(int skin) {
		Game.skin = skin;
	}

	// if no game has been started, this constructor is called
    private Game() { 
    	pieceFactory = new PieceFactory();
    	king = (King) pieceFactory.makePiece("King",new Square(0, 7));
    	queen = (Queen) pieceFactory.makePiece("Queen", new Square(0, 7));
    	this.knight = (Knight) pieceFactory.makePiece("Knight", new Square(0, 0));
        this.startNewGame();
        getLast().add(new lastObj(new Square(0,0), 0));
    }
    
    //method thats starts a new game and initialises values to their starting position
    public void startNewGame() {
        gameOver = false;
        youWon = false;
        this.score = 0;
        this.level = 1;
        // need to add level initialisation
    }
    public void startNewGameLevel2() {
        gameOver = false;
        youWon = false;
        this.score = 0;
        this.level = 2;
        // need to add level initialisation
    }
    
    

    


	public static int getID() {
		return ID;
	}

	public static void setID(int iD) {
		ID = iD;
	}

	

	public Stack<lastObj> getLast() {
		return last;
	}

	public void setLast(Stack<lastObj> last) {
		this.last = last;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
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

	public Square[][] getBoard() {
		return board;
	}

	public void setBoard(Square[][] board) {
		this.board = board;
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

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	

	public int getScoreLevel1() {
		return scoreLevel1;
	}

	public void setScoreLevel1(int scoreLevel1) {
		this.scoreLevel1 = scoreLevel1;
	}

	public int getScoreLevel2() {
		return scoreLevel2;
	}

	public void setScoreLevel2(int scoreLevel2) {
		this.scoreLevel2 = scoreLevel2;
	}

	public int getScoreLevel3() {
		return scoreLevel3;
	}

	public void setScoreLevel3(int scoreLevel3) {
		this.scoreLevel3 = scoreLevel3;
	}

	public int getScoreLevel4() {
		return scoreLevel4;
	}

	public void setScoreLevel4(int scoreLevel4) {
		this.scoreLevel4 = scoreLevel4;
	}

	public boolean isYouWon() {
		return youWon;
	}

	public void setYouWon(boolean youWon) {
		this.youWon = youWon;
	}

	public PieceFactory getPieceFactory() {
		return pieceFactory;
	}

	public void setPieceFactory(PieceFactory pieceFactory) {
		this.pieceFactory = pieceFactory;
	}

	public static void setInstance(Game instance) {
		Game.instance = instance;
	}
    
	public  Square squareByIndx(int i, int j) {
		if(board == null)
			return null;
		return board[i][j];
	}
	
	public boolean Winner(int score) {
		if(score>200)
			return true;
		return false;
	}
	
	public void ForgetLast3() {
		
	}

}
