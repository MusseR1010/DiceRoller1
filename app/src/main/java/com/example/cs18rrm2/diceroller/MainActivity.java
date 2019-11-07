package com.example.cs18rrm2.diceroller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button showSomething;
    TextView points;
    ArrayList<String> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        showSomething = (Button)findViewById(R.id.letsPlayButton);
        showSomething.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                roll_the_dice(v);
            }
        });

        points = (TextView)findViewById(R.id.currentPoints);

        questions = new ArrayList<>();
        questions.add("If you could go anywhere in the world, where would you go?");
        questions.add("If you were stranded on a desert island, what three things would you want to take with you?");
        questions.add("If you could eat only one food for the rest of your life, what would that be?");
        questions.add("If you won a million dollars, what is the first thing you would buy?");
        questions.add("If you could spaned the day with one fictional character, who would it be?");
        questions.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void generate (View view){
        Random rand = new Random();
        int number = rand.nextInt (6)+1;
        TextView myText = (TextView)findViewById(R.id.textView);
        String myString = String.valueOf(number);
        myText.setText(myString);

        EditText input;
        input = (EditText) findViewById(R.id.input);
        int inputnumber = Integer.parseInt(input.getText().toString());
        if (inputnumber < 1 || inputnumber > 6 ){
            Toast.makeText(this,"Invalid, try again!", Toast.LENGTH_SHORT).show();
        }
        else if (inputnumber == number){
            Toast.makeText(this,"congratulations", Toast.LENGTH_SHORT).show();
            int currentPoints = Integer.parseInt(points.getText().toString());
            currentPoints = currentPoints + 1;
            points.setText(String.valueOf(currentPoints));

        }

    }

    public void roll_the_dice(View view) {

        Random r = new Random ();
        int index = r.nextInt(6)+1;

        String question = questions.get(index - 1);
        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText(question);

    }

}
