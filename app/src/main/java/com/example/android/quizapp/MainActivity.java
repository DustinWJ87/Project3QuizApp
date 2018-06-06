package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * This app gives you a quiz and then displays your score via a Toast Message when done button is clicked.
 * Score is calculated off of correct answers given.
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int score = 0;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.question10Spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.question_10_choices, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    /**
     * Calculates the score for the Quiz based on the answers input by the user
     * Uses if statements tc check for the true state of all the different input types
     * Adds 1 Point to the running score total and then returns the score to the toast
     *
     * @param q1A Question 1 Answer A CheckBox
     * @param q1D Question 1 Answer D CheckBox
     * @param q2B Question 2 Answer B CheckBox
     * @param q2D Question 2 Answer C CheckBox
     * @param q3A Question 3 Answer A CheckBox
     * @param q3B Question 3 Answer B CheckBox
     * @param q3C Question 3 Answer C CheckBox
     * @param q3D Question 3 Answer D CheckBox
     * @param q4  Question 4 Radio Button
     * @param q5  Question 5 Radio Button
     * @param q6  Question 6 Radio Button
     * @param q7  Question 7 EditText Input
     * @param q8  Question 8 EditText Input
     * @param q9  Question 9 EditText Input
     * @return total score tallied from answers
     */
    private int calculateScore(boolean q1A, boolean q1B, boolean q1C, boolean q1D, boolean q2A, boolean q2B, boolean q2C, boolean q2D, boolean q3A, boolean q3B, boolean q3C, boolean q3D, boolean q4, boolean q5, boolean q6, String q7, String q8, String q9) {
        if (q1B || q1C) {
        } else if (q1A && q1D) {
            score++;
        }
        if (q2A || q2C) {
        } else if (q2B && q2D) {
            score++;
        }
        if (q3A && q3B && q3C && q3D) {
            score++;
        }
        if (q4) {
            score++;
        }
        if (q5) {
            score++;
        }
        if (q6) {
            score++;
        }
        switch (q7) {
            case "Bruce":
                score++;
        }
        switch (q8) {
            case "Tony Stark":
                score++;
        }
        switch (q9) {
            case "Hela":
                score++;
        }
        if (spinner.getSelectedItem().toString().trim().equals("Apocalypse")) {
            score++;
        }
        return score;
    }

    /**
     * On Click from the Button that runs a true/false check for all correct answers.
     * Resets Score back to 0 after score check.
     *
     * @param view Final Toast message output based on total score.
     */
    public void checkScore(View view) {
        CheckBox question1CheckBoxA = findViewById(R.id.question1A);
        boolean question1AnswerA = question1CheckBoxA.isChecked();

        CheckBox question1CheckBoxB = findViewById(R.id.question1B);
        boolean question1AnswerB = question1CheckBoxB.isChecked();

        CheckBox question1CheckBoxC = findViewById(R.id.question1C);
        boolean question1AnswerC = question1CheckBoxC.isChecked();

        CheckBox question1CheckBoxD = findViewById(R.id.question1D);
        boolean question1AnswerD = question1CheckBoxD.isChecked();

        CheckBox question2CheckBoxA = findViewById(R.id.question2A);
        boolean question2AnswerA = question2CheckBoxA.isChecked();

        CheckBox question2CheckBoxB = findViewById(R.id.question2B);
        boolean question2AnswerB = question2CheckBoxB.isChecked();

        CheckBox question2CheckBoxC = findViewById(R.id.question2C);
        boolean question2AnswerC = question2CheckBoxC.isChecked();

        CheckBox question2CheckBoxD = findViewById(R.id.question2D);
        boolean question2AnswerD = question2CheckBoxD.isChecked();

        CheckBox question3CheckBoxA = findViewById(R.id.question3A);
        boolean question3AnswerA = question3CheckBoxA.isChecked();

        CheckBox question3CheckBoxB = findViewById(R.id.question3B);
        boolean question3AnswerB = question3CheckBoxB.isChecked();

        CheckBox question3CheckBoxC = findViewById(R.id.question3C);
        boolean question3AnswerC = question3CheckBoxC.isChecked();

        CheckBox question3CheckBoxD = findViewById(R.id.question3D);
        boolean question3AnswerD = question3CheckBoxD.isChecked();

        boolean question4Radio = ((RadioButton) findViewById(R.id.question4B)).isChecked();

        boolean question5Radio = ((RadioButton) findViewById(R.id.question5C)).isChecked();

        boolean question6Radio = ((RadioButton) findViewById(R.id.question6D)).isChecked();

        EditText editText7 = findViewById(R.id.question7Answer);
        String question7 = editText7.getText().toString();

        EditText editText8 = findViewById(R.id.question8Answer);
        String question8 = editText8.getText().toString();

        EditText editText9 = findViewById(R.id.question9Answer);
        String question9 = editText9.getText().toString();

        score = calculateScore(question1AnswerA, question1AnswerB, question1AnswerC, question1AnswerD, question2AnswerA, question2AnswerB, question2AnswerC, question2AnswerD, question3AnswerA, question3AnswerB, question3AnswerC, question3AnswerD, question4Radio, question5Radio, question6Radio, question7, question8, question9);

        if (score < 4) {
            Toast.makeText(this, "Better Luck Next Time, You Scored " + score + " out of 10 Points", Toast.LENGTH_LONG).show();
        } else if (score >= 4 && score <= 7) {
            Toast.makeText(this, "Not too bad, You Scored " + score + " out of 10 Points", Toast.LENGTH_LONG).show();
        } else if (score > 7 && score < 10) {
            Toast.makeText(this, "Nicely Done!, You Scored " + score + " out of 10 Points", Toast.LENGTH_LONG).show();
        } else if (score == 10) {
            Toast.makeText(this, "Amazing, You Scored a Perfect " + score + " out of 10 Points", Toast.LENGTH_LONG).show();
        }

        score = 0;

    }

    /**
     * Controls the spinners behavior to it being selected.
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
    }

    /**
     * Controls the spinners behavior with nothing selected.
     */
    public void onNothingSelected(AdapterView<?> parent) {
    }

}