package com.example.rumahbelajar.quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rumahbelajar.R;
import com.example.rumahbelajar.adapter.LabelQuizAdapter;
import com.example.rumahbelajar.api.ApiClient;
import com.example.rumahbelajar.api.BaseApiService;
import com.example.rumahbelajar.other.SharedPref;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddLabelActivity extends AppCompatActivity {

    TextInputEditText tiet1,tiet2;
    private ProgressBar loadingPB;
    Button button;
    private TextView responseTV;
    BaseApiService mApiService;
    public static SharedPref sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_label);

        tiet1 = findViewById(R.id.tiet1);
        tiet2 = findViewById(R.id.tiet2);
        button = findViewById(R.id.button);
        mApiService = ApiClient.getAPIService();
        loadingPB = findViewById(R.id.idLoadingPB);
        responseTV = findViewById(R.id.idTVResponse);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addQuiz();
            }
        });

    }

    private void addQuiz() {
        mApiService.createQuiz(tiet1.getText().toString(), tiet2.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
//                        loading.dismiss();
                    }
                });

    }

}