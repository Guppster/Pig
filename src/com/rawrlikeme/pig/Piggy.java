package com.rawrlikeme.pig;

import java.util.Random;

public class Piggy {
	private int playerOneScore = 0;
	private int playerTwoScore = 0;
	
	Random r = new Random();
	
//	protected void roll(int player) {
//	
//	}
	
	// Method to roll die and get a random number between 1-6
	protected int rollDie() {
		int randomInt = r.nextInt(6) + 1;
		return randomInt;
	}
	
	// Method to reset the game 
	protected void resetGame() {
		// Reset Both Player's Scores
		setPlayer1Score(0); 
		setPlayer2Score(0); 
		//
	}
	
	
	
	protected void setPlayer1Score(int score) {
		playerOneScore = score;
	}
	
	protected int getPlayer1Score() {
		return playerOneScore;
	}
	
	protected void setPlayer2Score(int score) {
		playerTwoScore = score;
	}

	protected int getPlayer2Score() {
		return playerTwoScore;
	}
	
	
}