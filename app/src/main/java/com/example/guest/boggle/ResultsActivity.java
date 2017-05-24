package com.example.guest.boggle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultsActivity extends AppCompatActivity {

    @BindView(R.id.inputWordView) TextView mInputWordView;
    @BindView(R.id.resultView) TextView mResultView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String inputWord = intent.getStringExtra("word");
        String formattedString = String.format("This is the user's inputted word: %s", inputWord);
        mInputWordView.setText(formattedString);
        String[] inputLetters = inputWord.split("");

        String[] letterArray = intent.getStringArrayExtra("letters");
        if (containsSuppliedLetter(letterArray, inputWord) == true) {
            mResultView.setText("Yay, that's a valid word");
        } else if (containsSuppliedLetter(letterArray, inputWord) == false) {
            mResultView.setText("Nope, that's not a valid word. Try again");
        } else {
            mResultView.setText("Something went horribly wrong");
        }
    }



//    private boolean containsSuppliedLetter(String[] letterArray, String inputWord) {
//
////        for (int i=0; i<=letterArray.length; i++) {
////            if(inputWord.contains(letterArray[i]))
////        }
//        if (inputWord.contains())
//    }


}
