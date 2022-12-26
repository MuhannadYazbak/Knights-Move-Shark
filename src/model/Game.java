package model;

import utils.Difficulty;
import utils.PlusOrMinus;
import utils.Type;
//* new one //
public class Game {
	private static int ID=1;
	private int id;
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
    private PieceFactory pieceFactory;
	
	//Singleton class
    public static Game getInstance() {
		if(instance == null)
			instance = new Game();
		return instance; 
	}
    
    // if no game has been started, this constructor is called
    private Game() { 
    	pieceFactory = new PieceFactory();
    	king = (King) pieceFactory.makePiece("King",new Square(2, 2));
    	queen = (Queen) pieceFactory.makePiece("Queen", new Square(0, 7));
    	this.knight = (Knight) pieceFactory.makePiece("Knight", new Square(0, 0));
        this.startNewGame();
    }
    
    //method thats starts a new game and initialises values to their starting position
    public void startNewGame() {
        gameOver = false;
        youWon = false;
        this.score = 0;
        this.level = 1;
        // need to add level initialisation
    }
    
    // a method that returns a random regular square 
    public Square randomSquare() {
    	
    	boolean flag = true;
    	
    	do {
    		int randomNumber1 = (int) (Math.random() * 8);
        	int randomNumber2 = (int) (Math.random() * 8);
        	if(Game.getBoard[randomNumber1][randomNumber2].getSquareType().equals(Type.Regular))
        		flag = false;
    		
    	}while(flag);
    	
    	
    	return square;


    }
    
    // a function to handle RandomJump ,Forget , Blocked, Question squares.
    public void handleSquare(int i, int j, Type squareType) {
    	switch(squareType) {
    	
    	case RandomJump:
    		Square jumpTo = randomSquare();
    		
    		break;
    		
    	case Forget:
    		
    		break;
    		
    	case Blocked:
    		
    		break;
    		
    	case Regular:
    		
    		break;
    		
        case EasyQuestion:
    		
    		break;
    		
    	case MediumQuestion:
    		
    		break;
    		
    	case HardQuestion:
    		
    		break;
    	
    	}
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

	// we need to write it
    public void restartGame()/////////////////////////////////////////////////////////////////////////////////////////
    {
    	
    }
    
	
	public  Square squareByIndx(int i, int j) {
		if(board == null)
			return null;
		return board[i][j];
	}
	
	public int UpdateScore(int score, PlusOrMinus POM, Difficulty d) {
		if(d == d.EASY && POM == POM.Plus)
			return score+=1;		
		
		else if(d == d.EASY && POM == POM.Minus)
			return score-=2;
		
		if(d == d.MEDIUM && POM == POM.Plus)
			return score+=2;		
		
		else if(d == d.MEDIUM && POM == POM.Minus)
			return score-=3;
		
		if(d == d.HARD && POM == POM.Plus)
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
