package com.codetobe.naibeck.stanfordcs193alesson1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button mLeftButton, mRightButton;
    private TextView mScoreTextView;
    private int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLeftButton = (Button)findViewById(R.id.btn_left_number);
        mRightButton = (Button)findViewById(R.id.btn_right_number);
        mScoreTextView = (TextView)findViewById(R.id.tv_main_score);

        pickRandomNumber();
    }

    public void leftButtonNumber(View view) {
        Toast.makeText(this, "You clicked L Button", Toast.LENGTH_SHORT).show();
        correctIncorrectAnswer(Integer.valueOf(mLeftButton.getText().toString()), Integer.valueOf(mRightButton.getText().toString()));
    }

    public void rightButtonNumber(View view) {
        Toast.makeText(this, "You clicked R  Button", Toast.LENGTH_SHORT).show();
        correctIncorrectAnswer(Integer.valueOf(mRightButton.getText().toString()), Integer.valueOf(mLeftButton.getText().toString()));
    }

    private void correctIncorrectAnswer(int firstNumber, int secondNumber) {
        if (firstNumber > secondNumber) {
            Toast.makeText(this, "Correct!!", Toast.LENGTH_SHORT).show();
            score++;
        } else {
            Toast.makeText(this, "You really are stupid", Toast.LENGTH_SHORT).show();
            score--;
        }
        mScoreTextView.setText(getString(R.string.label_main_score, score));
        pickRandomNumber();
    }

    private void pickRandomNumber() {

        Random random = new Random();
        int randomLeftNumber = 0;
        int randomRightNumber = 0;
        while (randomLeftNumber == randomRightNumber) {
            randomLeftNumber = random.nextInt(10);
            randomRightNumber = random.nextInt(10);
        }
        mScoreTextView.setText(getString(R.string.label_main_score, score));
        mLeftButton.setText(String.valueOf(randomLeftNumber));
        mRightButton.setText(String.valueOf(randomRightNumber));
    }
}
