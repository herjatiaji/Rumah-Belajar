package com.example.rumahbelajar.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.rumahbelajar.MathQuizActivity;
import com.example.rumahbelajar.QuestionActivity;
import com.example.rumahbelajar.R;

public class QuizLocalActivity extends AppCompatActivity {

    CardView cvMath, cvGeography;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_local);

        cvMath = findViewById(R.id.cvMath);
        cvGeography = findViewById(R.id.cvGeography);

        cvMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizLocalActivity.this, MathQuizActivity.class);
                startActivity(intent);
            }
        });

        cvGeography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizLocalActivity.this, QuestionActivity.class);
                startActivity(intent);
            }
        });



    }
}