package com.chimemoo.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {

    @GET("v2/top-headlines?country=us&apiKey=6f711c0871524df9bd47c6333402abca")
    Call<NewsResponseModel> newsHeadline();

}
