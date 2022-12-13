package com.example.rumahbelajar.materi;

import androidx.appcompat.app.AppCompatActivity;
import com.example.rumahbelajar.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MateriActivity extends AppCompatActivity {

    public static final String MESSAGE_EXTRA = "MESSAGE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);
    }

    public void readMateriB1(View view){
        Intent intent = new Intent(MateriActivity.this, DetailMateriActivity.class);
        String message = "b1";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB2(View view){
        Intent intent = new Intent(MateriActivity.this, DetailMateriActivity.class);
        String message = "b2";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB3(View view){
        Intent intent = new Intent(MateriActivity.this, DetailMateriActivity.class);
        String message = "b3";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB4(View view){
        Intent intent = new Intent(MateriActivity.this, DetailMateriActivity.class);
        String message = "b4";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB5(View view){
        Intent intent = new Intent(MateriActivity.this, DetailMateriActivity.class);
        String message = "b5";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB6(View view){
        Intent intent = new Intent(MateriActivity.this, DetailMateriActivity.class);
        String message = "b6";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }

    public void readMateriB7(View view){
        Intent intent = new Intent(MateriActivity.this, DetailMateriActivity.class);
        String message = "b7";
        intent.putExtra(MESSAGE_EXTRA, message);
        startActivityForResult(intent, 1);
    }


}