package com.rawrlikeme.pig;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Piggy mPiggy = new Piggy();
	
	private int tempScore = 0, tempRoll  = 0;
	private String labelRoll = "", labelScore = "", labelPlayer = "";
	final Context context = this;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Declare our View variables
		final TextView PlayerOneScoreLabel = (TextView) findViewById(R.id.txtPlayerOneScore); // TextView for Player1's score
		final TextView PlayerTwoScoreLabel = (TextView) findViewById(R.id.txtPlayerTwoScore); // TextView for Player2's score
		final TextView RolledLabel = (TextView) findViewById(R.id.txtRolled); // TextView for Player2's score
		final Button HoldButton = (Button) findViewById(R.id.btnHold); // Button for the Hold method
		final Button RollButton = (Button) findViewById(R.id.btnRoll); // Button for the Roll method
		final ImageView DiceImage = (ImageView) findViewById(R.id.imgDice); // ImageView to display the Dice
		
		// RollButton onClickListener to call the other Function
		RollButton.setOnClickListener(new View.OnClickListener() {
			// What to do when the user clicks 'Roll'
			public void onClick(View arg0) {
				tempRoll = mPiggy.rollDie();
				tempScore += tempRoll;
				labelRoll = String.valueOf(tempRoll);
				labelScore = String.valueOf(tempScore);
				labelPlayer = String.valueOf(mPiggy.getCurrentPlayer());
				
				RolledLabel.setText("Player " + labelPlayer + " rolled a " + labelRoll);
				
				switch(tempRoll) {
					case 1:
						DiceImage.setImageResource(R.drawable.dice1);
						
						if (mPiggy.getCurrentPlayer() == 1) {
							mPiggy.setCurrentPlayer(2);
						}
						else {
							mPiggy.setCurrentPlayer(1);
						}
						tempScore = 0;
				        break;
					case 2:
						DiceImage.setImageResource(R.drawable.dice2);
				        break;
					case 3:
						DiceImage.setImageResource(R.drawable.dice3);
				        break;
					case 4:
						DiceImage.setImageResource(R.drawable.dice4);
				        break;
					case 5:
						DiceImage.setImageResource(R.drawable.dice5);
				        break;
					case 6:
						DiceImage.setImageResource(R.drawable.dice6);
				        break;
				}
				HoldButton.setVisibility(View.VISIBLE);
			}
			
		});
		
		HoldButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				
				if(mPiggy.getCurrentPlayer() == 1) {
					mPiggy.setPlayer1Score(tempScore);
					PlayerOneScoreLabel.setText(labelScore);
					mPiggy.setCurrentPlayer(2);
				} 
				else {
					mPiggy.setPlayer2Score(tempScore);
					PlayerTwoScoreLabel.setText(labelScore);
					mPiggy.setCurrentPlayer(1);
				}
				
//				switch(mPiggy.getCurrentPlayer()) {
//					case 1:
//						mPiggy.setPlayer1Score(tempScore);
//						PlayerOneScoreLabel.setText(labelScore);
//						mPiggy.setCurrentPlayer(2);
//						break;
//					case 2: 
//						mPiggy.setPlayer2Score(tempScore);
//						PlayerTwoScoreLabel.setText(labelScore);
//						mPiggy.setCurrentPlayer(1);
//						break;
//				}
				//openAlert();
				HoldButton.setVisibility(View.INVISIBLE);
				tempScore = 0;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void openAlert() {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
 
			// set title
			alertDialogBuilder.setTitle("Your Title");
 
			// set dialog message
			alertDialogBuilder
				.setMessage("Click yes to exit!")
				.setCancelable(false)
				.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// current activity
						MainActivity.this.finish();
					}
				  })
				.setNegativeButton("No",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						dialog.cancel();
					}
				});
 
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();
 
				// show it
				alertDialog.show();
	}
}
