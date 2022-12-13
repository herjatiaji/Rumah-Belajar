package com.example.rumahbelajar.api;

public class ApiClient {

    public static final String BASE_URL_API = "https://learnwithacruz.my.id/PAD1/public/api/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }

}
