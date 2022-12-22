package controller;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Game;
import model.Knight;
import model.Player;
import model.Square;
import model.SysData;

public class GameController implements Initializable{
	
	
	@FXML
    private ImageView S00,S01,S02,S03,S04,S05,S06,S07,S10,S11,S12,S13,S14,S15,S16,S17,S20,S21,S22,S23,S24,S25,S26,S27,S30,S31,S32,S33,S34,S35,S36,S37,S40,S41,S42,S43,S44,S45,S46,S47,S50,S51,S52,S53,S54,S55,S56,S57,S60,S61,S62,S63,S64,S65,S66,S67,S70,S71,S72,S73,S74,S75,S76,S77;
	private HashSet<ImageView> allImages = new HashSet<ImageView>();
	@FXML
    private ImageView I00,I01,I02,I03,I04,I05,I06,I07,I10,I11,I12,I13,I14,I15,I16,I17,I20,I21,I22,I23,I24,I25,I26,I27,I30,I31,I32,I33,I34,I35,I36,I37,I40,I41,I42,I43,I44,I45,I46,I47,I50,I51,I52,I53,I54,I55,I56,I57,I60,I61,I62,I63,I64,I65,I66,I67,I70,I71,I72,I73,I74,I75,I76,I77;
    
	@FXML
    private Button CI00,CI01,CI02,CI03,CI04,CI05,CI06,CI07,CI10,CI11,CI12,CI13,CI14,CI15,CI16,CI17,CI20,CI21,CI22,CI23,CI24,CI25,CI26,CI27,CI30,CI31,CI32,CI33,CI34,CI35,CI36,CI37,CI40,CI41,CI42,CI43,CI44,CI45,CI46,CI47,CI50,CI51,CI52,CI53,CI54,CI55,CI56,CI57,CI60,CI61,CI62,CI63,CI64,CI65,CI66,CI67,CI70,CI71,CI72,CI73,CI74,CI75,CI76,CI77;
	private HashSet<Button> allButtons = new HashSet<Button>();
	private HashSet<Button> PossibleButtons = new HashSet<Button>();
	
	@FXML
    private Button backBtn;

    @FXML
    private Label level,playerName,remainingTime,score;

    @FXML
    private AnchorPane screen;
    
    private static final Integer STARTTIME = 15;
    private Timeline timeline;
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
    
	private Image KING = new Image(getClass().getResourceAsStream("/lib/king.png"));
	private Image QUEEN = new Image(getClass().getResourceAsStream("/lib/queen.png"));
	private Image KNIGHT = new Image(getClass().getResourceAsStream("/lib/knight.png"));
	private Image Possible = new Image(getClass().getResourceAsStream("/lib/whitebg.png"));
	private Image Visited = new Image(getClass().getResourceAsStream("/lib/yellow.png"));
    private HashSet<ImageView> PossibleMovesKnight = new HashSet<ImageView>();
    private HashSet<ImageView> PossibleMovesQueen = new HashSet<ImageView>();
    
//    @FXML
//    void checkTime() {
//    	if(remainingTime.getText().equals("0")) {
//    		System.out.println("Gameoverrrrrrr");
//    	}
//    }
    @FXML
    void MoveTo() {

    	
    	
    	while(!remainingTime.getText().equals("0")) {
    		
    		switch(level.getText()) {
    		
    			case"1":{
    				for(Square s : Game.knight.allPossibleMoves()) {
    					PossibleButtons.add(getButtonByString("CI"+s.getRow()+s.getCol()));
    	    	
    					}
			
    			for(Button b: PossibleButtons) {
    				if(b.isPressed())
					PressedButton(b.getId());
					
				// else popup message ( please press on the white squares only 
    					}
			
			for(Button b: PossibleButtons)
				PossibleButtons.remove(b);
			
			if(SysData.getInstance().getHistoryGamesForShow().contains(Game.getInstance().getPlayer())) {
				for(Player p: SysData.getInstance().getHistoryGamesForShow()) {
					if(p.getName().equals(Game.getInstance().getPlayer().getName()) && p.getScore()>15 )
						Game.getInstance().setLevel(Game.getInstance().getLevel()+1);
						
				}
			}
			
			
			 System.out.println("makhoul");
			/*
			 * use wait()....................................
			 */try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 System.out.println("jawad");
			
			//	for(Square s: Game.queen.allPossibleMoves()) {
			//		PossibleMovesQueen.add(getImageByString("I"+s.getRow()+s.getCol()));
			//	}
			//	
			//	Game.queen.moveThePiece(PossibleMovesQueen);
			//}
			    	
    		
    			
    	    			
    		
    		
    		
    		/**
    		 * popup window GAME OVER
    		 */
    		break;
    		}
    			
    		
    
    	}break;	}
    }
    private ImageView getImageByString(String s) {
    	for(ImageView i : getAllImages()) {
    		if(s.equals(i.getId())) {
    			return i;
    		}
    	}
    	return null;
    }
    
    private Button getButtonByString(String s) {
    	for(Button i : getAllButtons()) {
    		if(s.equals(i.getId())) {
    			return i;
    		}
    	}
    	return null;
    }
    
    private void SetPossible() {
    	for(Square s : Game.knight.allPossibleMoves()) {
    		PossibleMovesKnight.add(getImageByString("I"+s.getRow()+s.getCol()));
	    	getImageByString("I"+s.getRow()+s.getCol()).setImage(Possible);
		}
    }
    
    private void RemovePossible() {
    	for(Square s : Game.knight.allPossibleMoves()) {
	    	getImageByString("I"+s.getRow()+s.getCol()).setImage(null);
		}
    }
    
    private void PressedButton(String s) {
    	switch(s) {
    	
    	case "CI00":{
    		I00.setImage(KNIGHT);
    		RemovePossible();
    		Square sq=new Square(0,0);
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI01":{
    		I01.setImage(KNIGHT);
    		RemovePossible();
    		Square sq=new Square(0,1);
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI02":{
    		I02.setImage(KNIGHT);
    		RemovePossible();
    		Square sq=new Square(0,2);
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI03":{
    		I03.setImage(KNIGHT);
    		RemovePossible();
    		Square sq=new Square(0,3);
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI04":{
    		I04.setImage(KNIGHT);
    		RemovePossible();
    		Square sq=new Square(0,4);
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI05":{
    		I05.setImage(KNIGHT);
    		RemovePossible();
    		Square sq=new Square(0,5);
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI06":{
    		I06.setImage(KNIGHT);
    		RemovePossible();
    		Square sq=new Square(0,6);
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI07":{
    		I07.setImage(KNIGHT);
    		RemovePossible();
    		Square sq=new Square(0,7);
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI10":{
    		I10.setImage(KNIGHT);
    		RemovePossible();
    		Square sq=new Square(1,0);
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI11":{
    		RemovePossible();
    		I11.setImage(KNIGHT);
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(1,1);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI12":{
    		RemovePossible();
    		I12.setImage(KNIGHT);
    		Square prevPlace=Game.knight.getCurrentPlace();
    		prevPlace.setVisisted(true);
    		//getImageByString("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(1,2);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI13":{
    		I13.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(1,3);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI14":{
    		I14.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(1,4);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI15":{
    		I15.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(1,5);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI16":{
    		I16.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(1,6);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI17":{
    		I17.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(1,7);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI20":{
    		I20.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(2,0);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI21":{
    		I21.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(2,1);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI22":{
    		I22.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(2,2);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI23":{
    		I23.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(2,3);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI24":{
    		I24.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(2,4);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI25":{
    		I25.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(2,5);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI26":{
    		I26.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(2,6);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI27":{
    		I27.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(2,7);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI30":{
    		I30.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(3,0);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI31":{
    		I31.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(3,1);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI32":{
    		I32.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(3,2);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI33":{
    		I33.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(3,3);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI34":{
    		I34.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(3,4);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI35":{
    		I35.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(3,5);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI36":{
    		I36.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(3,6);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI37":{
    		I37.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(3,7);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI40":{
    		I40.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(4,0);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI41":{
    		I41.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(4,1);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI42":{
    		I42.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(4,2);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI43":{
    		I43.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(4,3);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI44":{
    		I44.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(4,4);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI45":{
    		I45.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(4,5);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI46":{
    		I46.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(4,6);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI47":{
    		I47.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(4,7);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI50":{
    		I50.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(5,0);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI51":{
    		I51.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(5,1);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI52":{
    		I52.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(5,2);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI53":{
    		I53.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(5,3);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI54":{
    		I54.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(5,4);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI55":{
    		I55.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(5,5);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI56":{
    		I56.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(5,6);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI57":{
    		I57.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(5,7);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI60":{
    		I60.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(6,0);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI61":{
    		I61.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(6,1);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI62":{
    		I62.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(6,2);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI63":{
    		I63.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(6,3);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI64":{
    		I64.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(6,4);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI65":{
    		I65.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(6,5);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI66":{
    		I66.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(6,6);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI67":{
    		I67.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(6,7);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI70":{
    		I70.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(7,0);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI71":{
    		I71.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(7,1);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI72":{
    		I72.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(7,2);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI73":{
    		I73.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(7,3);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI74":{
    		I74.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(7,4);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI75":{
    		I75.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(7,5);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	case "CI76":{
    		I76.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(7,6);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	
    	case "CI77":{
    		I77.setImage(KNIGHT);
    		RemovePossible();
    		Square prevPlace=Game.knight.getCurrentPlace();
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
    		Square sq=new Square(7,7);
    		Game.knight.setCurrentPlace(sq);
    		break;
    		}
    	
    	}
    }
	@FXML
	 private void back(ActionEvent event) throws IOException {
		
		Parent pane = FXMLLoader.load(getClass().getResource("/views/MainMenu.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Main Menu");
		stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		allImages.add(I00);allImages.add(I01);allImages.add(I02);allImages.add(I03);allImages.add(I04);allImages.add(I05);allImages.add(I06);
		allImages.add(I07);allImages.add(I10);allImages.add(I11);allImages.add(I12);allImages.add(I13);allImages.add(I14);allImages.add(I15);
		allImages.add(I16);allImages.add(I17);allImages.add(I20);allImages.add(I21);allImages.add(I22);allImages.add(I23);allImages.add(I24);
		allImages.add(I25);allImages.add(I26);allImages.add(I27);allImages.add(I30);allImages.add(I31);allImages.add(I32);allImages.add(I33);
		allImages.add(I34);allImages.add(I35);allImages.add(I36);allImages.add(I37);allImages.add(I40);allImages.add(I41);allImages.add(I42);
		allImages.add(I43);allImages.add(I44);allImages.add(I45);allImages.add(I46);allImages.add(I47);allImages.add(I50);allImages.add(I51);
		allImages.add(I52);allImages.add(I53);allImages.add(I54);allImages.add(I55);allImages.add(I56);allImages.add(I57);allImages.add(I60);
		allImages.add(I61);allImages.add(I62);allImages.add(I63);allImages.add(I64);allImages.add(I65);allImages.add(I66);allImages.add(I67);
		allImages.add(I70);allImages.add(I71);allImages.add(I72);allImages.add(I73);allImages.add(I74);allImages.add(I75);allImages.add(I76);
		allImages.add(I77);
		
		allButtons.add(CI00);allButtons.add(CI01);allButtons.add(CI02);allButtons.add(CI03);allButtons.add(CI04);allButtons.add(CI05);
		allButtons.add(CI06);allButtons.add(CI07);allButtons.add(CI10);allButtons.add(CI11);allButtons.add(CI12);allButtons.add(CI13);
		allButtons.add(CI14);allButtons.add(CI15);allButtons.add(CI16);allButtons.add(CI17);allButtons.add(CI20);allButtons.add(CI21);
		allButtons.add(CI22);allButtons.add(CI23);allButtons.add(CI24);allButtons.add(CI25);allButtons.add(CI26);allButtons.add(CI27);
		allButtons.add(CI30);allButtons.add(CI31);allButtons.add(CI32);allButtons.add(CI33);allButtons.add(CI34);allButtons.add(CI35);
		allButtons.add(CI36);allButtons.add(CI37);allButtons.add(CI40);allButtons.add(CI41);allButtons.add(CI42);allButtons.add(CI43);
		allButtons.add(CI44);allButtons.add(CI45);allButtons.add(CI46);allButtons.add(CI47);allButtons.add(CI50);allButtons.add(CI51);
		allButtons.add(CI52);allButtons.add(CI53);allButtons.add(CI54);allButtons.add(CI55);allButtons.add(CI56);allButtons.add(CI57);
		allButtons.add(CI60);allButtons.add(CI61);allButtons.add(CI62);allButtons.add(CI63);allButtons.add(CI64);allButtons.add(CI65);
		allButtons.add(CI66);allButtons.add(CI67);allButtons.add(CI70);allButtons.add(CI71);allButtons.add(CI72);allButtons.add(CI73);
		allButtons.add(CI74);allButtons.add(CI75);allButtons.add(CI76);allButtons.add(CI77);
		
		remainingTime.textProperty().bind(timeSeconds.asString());
        if (timeline != null) 
        	timeline.stop();
                
        timeSeconds.set(STARTTIME);
        timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(STARTTIME+1),new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
        
        level.setText(Integer.toString(SysData.getInstance().getGame().getLevel()));
        score.setText(Integer.toString(SysData.getInstance().getGame().getScore()));
        playerName.setText(Game.getInstance().getPlayer().getName());

    	I00.setImage(KNIGHT);
    	// set Square 00 as visited.........................................................
    	I07.setImage(QUEEN);
    	SetPossible();

	}
	public HashSet<ImageView> getAllImages() {
		return allImages;
	}
	public HashSet<Button> getAllButtons() {
		return allButtons;
	}
	public void setAllButtons(HashSet<Button> allButtons) {
		this.allButtons = allButtons;
	}
	public void setAllImages(HashSet<ImageView> allImages) {
		this.allImages = allImages;
	}
	

}
