package com.example.rumahbelajar.login;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.rumahbelajar.R;

public class SplashActivity extends AppCompatActivity {

    int waktu = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try{
                    Intent home = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(home);
                    finish();
                } catch (Exception err){
                    Log.e(TAG, "The exception caught while executing the process. (error1)");
                    err.printStackTrace();
                }

            }
        },waktu);
    }
}