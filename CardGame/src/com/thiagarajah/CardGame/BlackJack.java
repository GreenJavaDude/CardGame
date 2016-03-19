package com.thiagarajah.CardGame;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.thiagarajah.CardGame.res.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BlackJack extends Application{//TODO Image
	
	private Scene scene;
	
	private HBox center;
	private HBox south;
	private BorderPane pane;
	
	private TextArea pos1;
	private TextArea pos2;
	private TextArea pos3;
	private TextArea pos4;
	private TextArea pos5;
	private TextArea pos6;
	private TextArea pos7;
	private Button newCard;
	private Button stop;
	private TextField moneyDisplay;
	
	private Money myMoney;
	private Deck deck;
	private int score;
	private int posEmpty;
	private ArrayList<TextArea> pos;
	private int cardIndex;
	private ArrayList<Card> playedCards;
	
	private final int START_MONEY = 50;
	private final int DECREASE_MONEY_CARD = 10;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) throws Exception {
		pos1 = new TextArea();
		pos2 = new TextArea();
		pos3 = new TextArea();
		pos4 = new TextArea();
		pos5 = new TextArea();
		pos6 = new TextArea();
		pos7 = new TextArea();
		
		moneyDisplay = new TextField();
		
		pos1.setEditable(false);
		pos2.setEditable(false);
		pos3.setEditable(false);
		pos4.setEditable(false);
		pos5.setEditable(false);
		pos6.setEditable(false);
		pos7.setEditable(false);
		
		moneyDisplay.setEditable(false);
		
		newCard = new Button("New card");
		newCard.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				if(!myMoney.getBankrupt()){
					if(posEmpty<7){
						pos.get(posEmpty).setText(deck.getCards().get(cardIndex).toString());
						playedCards.add(deck.getCards().get(cardIndex));
						posEmpty++;
						cardIndex++;
						
						if(posEmpty == 8){
							endGame();
						}else{
							myMoney.decreaseMoney(DECREASE_MONEY_CARD);
						}
					}else{
						endGame();
					}
					
					moneyDisplay.setText(myMoney.getMoney() + "");
				}else{
					JOptionPane.showMessageDialog(null, "You're bankrupt!","Info", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
			}
		});
		
		stop = new Button("Stop");
		stop.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				endGame();
			}
		});
		
		center = new HBox();
		south = new HBox();
		pane = new BorderPane();
		
		center.getChildren().addAll(pos1, pos2, pos3, pos4, pos5, pos6, pos7);
		south.getChildren().addAll(newCard, stop, moneyDisplay);
		
		pane.setCenter(center);
		pane.setBottom(south);
		
		scene = new Scene(pane, 1000, 100);
		stage.setScene(scene);
		stage.setTitle("Blackjack");
		stage.show();
		initialize();
	}
	
	private void initialize(){
		deck = new Deck();
		myMoney = new Money();
		deck.shuffle();
		myMoney.setMoney(START_MONEY);
		posEmpty = 0;
		pos = new ArrayList<TextArea>();
		pos.add(pos1);
		pos.add(pos2);
		pos.add(pos3);
		pos.add(pos4);
		pos.add(pos5);
		pos.add(pos6);
		pos.add(pos7);
		cardIndex = 0;
		playedCards = new ArrayList<Card>();
		score = 0;
		moneyDisplay.setText(myMoney.getMoney() + "");
	}
	
	private void endGame(){
		//calculate score
		for(Card aCard : playedCards){
			score += aCard.getRank().getRankpoints();
		}
		while(score>=10){
			score -= 10;
		}
		int increaseMon = 0;
		switch(score){
		case 7: increaseMon = 100;break;
		case 6: increaseMon = 60;break;
		case 5: increaseMon = 50;break;
		case 4: increaseMon = 40;break;
		case 3: increaseMon = 30;break;
		case 2: increaseMon = 20;break;
		case 1:increaseMon = 10;break;
		}
		//after score
		if(increaseMon != 0){
			myMoney.increaseMoney(increaseMon);
			JOptionPane.showMessageDialog(null, "You won "+increaseMon+" dollars!","Info", JOptionPane.INFORMATION_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null, "You lost...","Info", JOptionPane.INFORMATION_MESSAGE);
		}
		newGame();
	}
	
	private void newGame(){
		deck.shuffle();
		
		posEmpty = 0;
		cardIndex = 0;
		playedCards = new ArrayList<Card>();
		score = 0;
		
		pos1.setText("");
		pos2.setText("");
		pos3.setText("");
		pos4.setText("");
		pos5.setText("");
		pos6.setText("");
		pos7.setText("");
		moneyDisplay.setText(myMoney.getMoney() + "");
	}
}











