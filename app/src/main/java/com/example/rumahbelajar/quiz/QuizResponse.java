package com.example.rumahbelajar.quiz;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class QuizResponse {

    private String status;
    private ArrayList<QuizData> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<QuizData> getData() {
        return data;
    }

    public void setData(ArrayList<QuizData> data) {
        this.data = data;
    }
}
