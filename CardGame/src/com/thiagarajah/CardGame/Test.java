package com.thiagarajah.CardGame;

import com.thiagarajah.CardGame.res.Card;
import com.thiagarajah.CardGame.res.Deck;

public class Test {

	public static void main(String[] args) {
		Deck deck = new Deck();
		for(Card aCard : deck.getCards()){
			System.out.println(aCard.toString());
		}
		System.out.println("---------------------------");
		deck.shuffle();
		for(Card aCard : deck.getCards()){
			System.out.println(aCard.toString());
		}
	}

}
