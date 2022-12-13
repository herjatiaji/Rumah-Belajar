package com.example.rumahbelajar.kelas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.rumahbelajar.R;

public class KelasActivity extends AppCompatActivity {

    TextView tv1;
    String namaKelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelas);

        Bundle bundle = getIntent().getExtras();
        namaKelas = bundle.getString("namaKelas");

        tv1 = findViewById(R.id.tv1);

        tv1.setText(namaKelas);


    }
}