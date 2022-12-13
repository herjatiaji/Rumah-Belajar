package com.example.rumahbelajar.api;

import okhttp3.ResponseBody;
import retrofit2.Call;

import com.example.rumahbelajar.kelas.KelasResponse;
import com.example.rumahbelajar.quiz.QuestionResponse;
import com.example.rumahbelajar.quiz.QuizData;
import com.example.rumahbelajar.quiz.QuizResponse;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BaseApiService {

    @GET("guru/quiz/getquiz")
    Call<QuizResponse> quizRequest();

    @GET("guru/question/getquestion/wdu8Ohc8")
    Call<QuestionResponse> questionRequest();

    @GET("guru/kelas/getall")
    Call<KelasResponse> KelasRequest();

    @POST("guru/quiz/addquiz")
    Call<QuizResponse> createLabelQuiz(@Body QuizResponse quizResponse);

    @FormUrlEncoded
    @POST("guru/quiz/addquiz")
    Call<ResponseBody> createQuiz(@Field("mata_pelajaran") String mataPelajaran,
                                  @Field("nama_quiz") String namaQuiz);


}
