package com.example.rumahbelajar.kelas;

import com.example.rumahbelajar.quiz.QuizData;

import java.util.ArrayList;

public class KelasResponse {

    private String status;
    private ArrayList<KelasData> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<KelasData> getData() {
        return data;
    }

    public void setData(ArrayList<KelasData> data) {
        this.data = data;
    }
}
