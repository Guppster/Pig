package com.rawrlikeme.pig;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Piggy mPiggy = new Piggy();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Declare our View variables
		final TextView PlayerOneScoreLabel = (TextView) findViewById(R.id.txtPlayerOneScore);
		final TextView PlayerTwoScoreLabel = (TextView) findViewById(R.id.txtPlayerTwoScore);
		final Button HoldButton = (Button) findViewById(R.id.btnHold);
		final Button RollButton = (Button) findViewById(R.id.btnRoll);
		
		RollButton.setOnClickListener(new View.OnClickListener() {
			// What to do when the user clicks 'Roll'
			public void onClick(View arg0) {
				String answer = "Yes";
				PlayerOneScoreLabel.setText(answer);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
