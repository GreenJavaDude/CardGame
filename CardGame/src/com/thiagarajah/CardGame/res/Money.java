package com.thiagarajah.CardGame.res;

public class Money {
	private double money;
	private boolean bankrupt;
	
	public Money(){
		money = 0.0;
		bankrupt = true;
	}
	
	private void update(){
		if(money > 0.0){
			bankrupt = false;
		}else{
			bankrupt = true;
		}
	}
	
	public void setMoney(double money){
		this.money = money;
		update();
	}
	
	public double getMoney(){
		return money;
	}
	
	public boolean getBankrupt(){
		return bankrupt;
	}
	
	public void increase(double money){
		this.money += money;
		update();
	}
	
	public void decrease(double money){
		this.money -= money;
		update();
	}
}