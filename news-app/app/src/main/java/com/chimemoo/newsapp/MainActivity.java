package com.chimemoo.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    NewsService newsService;
    List<NewsModel> listNews;
    RecyclerView rvNews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsService = API.getHeadlineNews().create(NewsService.class);

        rvNews = findViewById(R.id.rv_news);
        rvNews.setLayoutManager(new LinearLayoutManager(this));

        refresh();

    }

    public void refresh() {
        Call<NewsResponseModel> newsCall = newsService.newsHeadline();
        newsCall.enqueue(new Callback<NewsResponseModel>() {
            @Override
            public void onResponse(Call<NewsResponseModel> call, Response<NewsResponseModel> response) {
                NewsResponseModel newsResponse = response.body();
                listNews = newsResponse.getArticles();
                NewsAdapter newsAdapter = new NewsAdapter(listNews);
                rvNews.setAdapter(newsAdapter);
                Log.d("RESPONSE", "data : " + response.body().toString());
            }

            @Override
            public void onFailure(Call<NewsResponseModel> call, Throwable t) {
                Log.d("RESPONSE", "GAGAL");
            }
        });
    }
}