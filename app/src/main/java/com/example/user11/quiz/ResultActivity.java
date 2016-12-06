package com.example.user11.quiz;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //get rating bar object
        RatingBar bar = (RatingBar) findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        //get text view
        TextView t = (TextView) findViewById(R.id.textResult);
        //get score
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        //display score
        bar.setRating(score);
        switch (score) {
            case 0:
                t.setText("come on dude!!! study before attempting any quiz");
                Toast.makeText(this, "you got 0 out of 5 questions", Toast.LENGTH_LONG).show();
                break;
            case 1:
                Toast.makeText(this, "you got 1 out of 5 questions", Toast.LENGTH_LONG).show();
                break;
            case 2:
                t.setText("Oopsie! Better Luck Next Time!");
                Toast.makeText(this, "you got 2 out of 5 questions", Toast.LENGTH_LONG).show();
                break;
            case 3:
                Toast.makeText(this, "you got 3 out of 5 questions", Toast.LENGTH_LONG).show();
                break;
            case 4:
                t.setText("Hmmmm.. Someone's been reading a lot of trivia");
                Toast.makeText(this, "you got 4 out of 5 questions", Toast.LENGTH_LONG).show();
                break;
            case 5:
                t.setText("Who are you? A trivia wizard???");
                Toast.makeText(this, "you got 5 out of 5 questions", Toast.LENGTH_LONG).show();
                break;

        }
        Button btnDone = (Button) findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });5

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}