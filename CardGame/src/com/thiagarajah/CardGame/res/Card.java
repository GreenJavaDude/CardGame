package com.thiagarajah.CardGame.res;

public class Card {
	private CardSuite suite;
	private CardRank rank;
	
	public Card(CardSuite s, CardRank r){
		suite = s;
		rank = r;
	}
	
	public CardSuite getSuite(){
		return suite;
	}
	
	public CardRank getRank(){
		return rank;
	}
	
	public String toString(){
		return rank + " OF " + suite;
	}
}