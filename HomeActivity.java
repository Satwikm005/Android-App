package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class HomeActivity extends AppCompatActivity {
    private TextView resultTextView;
    private EditText guessEditText;
    private Button submitButton;
    private int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        resultTextView = findViewById(R.id.result_textview);
        guessEditText = findViewById(R.id.guess_edittext);
        submitButton = findViewById(R.id.submit_button);

        // Generate a random number between 1 and 100 (inclusive)
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the user's guess from the EditText
                String guessString = guessEditText.getText().toString();

                if (guessString.isEmpty()) {
                    resultTextView.setText("Please enter a number.");
                } else {
                    // Convert the guess to an int
                    int guess = Integer.parseInt(guessString);

                    if (guess < 1 || guess > 100) {
                        // The user's guess is outside the valid range
                        resultTextView.setText("Please enter a number between 1 and 100.");
                    } else if (guess < randomNumber) {
                        // The user's guess is too low
                        resultTextView.setText("Your guess is too low. Try again.");
                    } else if (guess > randomNumber) {
                        // The user's guess is too high
                        resultTextView.setText("Your guess is too high. Try again.");
                    } else {
                        // The user has guessed the correct number
                        resultTextView.setText("Congratulations! You guessed the number.");
                        guessEditText.setEnabled(false);
                        submitButton.setEnabled(false);
                    }
                }
            }
        });
    }
}