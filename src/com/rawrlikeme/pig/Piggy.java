package com.rawrlikeme.pig;

import java.util.Random;

public class Piggy {
	private int playerOneScore = 0; // Will hold the score for Player 1
	private int playerTwoScore = 0; // Will hold the score for Player 2
	private int currentPlayer = 1; // Will determine which player is currently active || Always start with 1 so the game will start off with player 1
	
	Random rand = new Random(); // Call a new Random Class for rolling the die in the rollDie Method
	
	// Method to roll die and get a random number between 1-6
	protected int rollDie() {
		int randomInt = rand.nextInt(6) + 1;
		return randomInt;
	}
	
//	// Method to reset the game 
//	protected void resetGame() {
//		// Reset Both Player's Scores
//		setPlayer1Score(0); 
//		setPlayer2Score(0); 
//	}
	
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
	
	protected void setCurrentPlayer(int player) {
		currentPlayer = player;
	}

	protected int getCurrentPlayer() {
		return currentPlayer;
	}
	
	
}