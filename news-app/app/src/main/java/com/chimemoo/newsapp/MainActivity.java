package com.chimemoo.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    NewsService newsService;
    List<NewsModel> listNews;
    RecyclerView rvNews;
    NewsAdapter newsAdapter;
    ShimmerFrameLayout shimmerNews;
    SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsService = API.getHeadlineNews().create(NewsService.class);

        swipeRefreshLayout = findViewById(R.id.swipeRefresh);
        shimmerNews = findViewById(R.id.shimmer_news);
        rvNews = findViewById(R.id.rv_news);
        rvNews.setLayoutManager(new LinearLayoutManager(this));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                shimmerNews.setVisibility(View.VISIBLE);
                shimmerNews.startShimmer();
                listNews.clear();
                rvNews.removeAllViewsInLayout();
                refresh();
            }
        });

        refresh();

    }

    public void refresh() {
        Call<NewsResponseModel> newsCall = newsService.newsHeadline();
        newsCall.enqueue(new Callback<NewsResponseModel>() {
            @Override
            public void onResponse(Call<NewsResponseModel> call, Response<NewsResponseModel> response) {
                shimmerNews.stopShimmer();
                shimmerNews.setVisibility(View.GONE);
                NewsResponseModel newsResponse = response.body();
                listNews = newsResponse.getArticles();
                newsAdapter = new NewsAdapter(listNews);
                rvNews.setAdapter(newsAdapter);
                newsAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<NewsResponseModel> call, Throwable t) {
                Log.d("RESPONSE", "GAGAL");
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        shimmerNews.startShimmer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        shimmerNews.stopShimmer();
    }
}