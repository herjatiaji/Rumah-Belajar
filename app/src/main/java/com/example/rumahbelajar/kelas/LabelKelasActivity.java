package com.example.rumahbelajar.kelas;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rumahbelajar.R;
import com.example.rumahbelajar.adapter.LabelKelasAdapter;
import com.example.rumahbelajar.api.ApiClient;
import com.example.rumahbelajar.api.BaseApiService;
import com.example.rumahbelajar.data.User;
import com.example.rumahbelajar.other.Constants;
import com.example.rumahbelajar.other.SharedPref;
import com.example.rumahbelajar.quiz.AddLabelActivity;
import com.example.rumahbelajar.quiz.LabelQuizActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LabelKelasActivity extends AppCompatActivity {

    private LabelKelasAdapter adapter;
    RecyclerView recyclerView;
    BaseApiService mApiService;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label_kelas);

        mApiService = ApiClient.getAPIService();
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        SharedPref sharedPref = SharedPref.getInstance();
        User user = sharedPref.getUser(this);
//        tv1.setText("Hello, " + user.getUsername());

        FloatingActionButton fab = findViewById(R.id.fab);

        findViewById(R.id.imageViewQuizOption).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(LabelQuizActivity.this, AddLabelActivity.class);
//                intent.putExtra(Constants.SUBJECT, getString(R.string.geography));
//                startActivity(intent);
//            }
//        });

        mApiService.KelasRequest().enqueue(new Callback<KelasResponse>() {
            @Override
            public void onResponse(Call<KelasResponse> call, Response<KelasResponse> response) {
                if(response.isSuccessful()){
                    KelasResponse kelasResponse = response.body();
                    ArrayList<KelasData> kelasData = kelasResponse.getData();
                    Log.e("getSuccess", "onFailure: ERROR > " + kelasResponse.getStatus().toString());
                    try{
                        adapter = new LabelKelasAdapter(LabelKelasActivity.this, kelasData);
                        recyclerView.setAdapter(adapter);
                    }catch (Exception err) {
                        Log.e(TAG, "Error INIII");
                        err.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<KelasResponse> call, Throwable t) {
                Log.e("debug", "onFailure: ERROR > " + t.toString());
            }
        });
    }
}