package com.chimemoo.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class ViewNewsActivity extends AppCompatActivity {

    public static String NEWS_URL = "NEWS_URL";

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_news);

        Intent intent = getIntent();
        String newsUrl = intent.getStringExtra(NEWS_URL);

        mWebView = findViewById(R.id.webView);

        mWebView.loadUrl(newsUrl);
    }
}