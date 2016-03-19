package com.thiagarajah.CardGame.res;

public enum CardRank {
	ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);

    private int Rankpoints;

    CardRank(int points) {
        this.Rankpoints = points;
    }

    public int getRankpoints() {
        return this.Rankpoints;
    }
}