package com.example.rumahbelajar.quiz;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.rumahbelajar.R;
import com.example.rumahbelajar.adapter.DetailQuizAdapter;
import com.example.rumahbelajar.adapter.LabelQuizAdapter;
import com.example.rumahbelajar.api.ApiClient;
import com.example.rumahbelajar.api.BaseApiService;
import com.example.rumahbelajar.api.RetrofitClient;
import com.example.rumahbelajar.data.User;
import com.example.rumahbelajar.other.Constants;
import com.example.rumahbelajar.other.SharedPref;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class LabelQuizActivity extends AppCompatActivity {

    private LabelQuizAdapter adapter;
    RecyclerView recyclerView;
    BaseApiService mApiService;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label_quiz);

        mApiService = ApiClient.getAPIService();
        recyclerView = findViewById(R.id.rv1);
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

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LabelQuizActivity.this, AddLabelActivity.class);
                intent.putExtra(Constants.SUBJECT, getString(R.string.geography));
                startActivity(intent);
            }
        });

        mApiService.quizRequest().enqueue(new Callback<QuizResponse>() {
            @Override
            public void onResponse(Call<QuizResponse> call, Response<QuizResponse> response) {
                if (response.isSuccessful()) {
                    QuizResponse quizResponse = response.body();
                    ArrayList<QuizData> quizData = quizResponse.getData();
                    Log.e("getSuccess", "onFailure: ERROR > " + quizResponse.getStatus().toString());
                    try {
                        adapter = new LabelQuizAdapter(LabelQuizActivity.this, quizData);
                        recyclerView.setAdapter(adapter);
                    } catch (Exception err) {
                        Log.e(TAG, "Error INIII");
                        err.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<QuizResponse> call, Throwable t) {
                Log.e("debug", "onFailure: ERROR > " + t.toString());
            }
        });
    }
}