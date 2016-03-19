package com.thiagarajah.CardGame.res;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> cards;
	
	public Deck(){
		cards = new ArrayList<Card>();
		for(CardSuite aSuite : CardSuite.values()){
			for(CardRank aRank : CardRank.values()){
				Card card = new Card(aSuite, aRank);
				cards.add(card);
			}
		}
	}
	
	public void shuffle(){
		Collections.shuffle(cards);
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
}