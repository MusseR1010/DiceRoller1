package com.example.cs18rrm2.diceroller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

import static android.R.id.input;

public class MainActivity extends AppCompatActivity {

    TextView points;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        points = (TextView)findViewById(R.id.currentPoints);

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


    }



}
