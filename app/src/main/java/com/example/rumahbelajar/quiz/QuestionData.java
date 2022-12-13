package com.example.rumahbelajar.quiz;

import com.google.gson.annotations.SerializedName;

public class QuestionData {

    @SerializedName("question")
    private String question;

    @SerializedName("answer")
    private String answer;

    @SerializedName("jawaban")
    private String jawaban;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer(int i) {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }


}
