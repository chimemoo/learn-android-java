package com.chimemoo.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ListViewHolder> {
    private List<NewsModel> listNews;

    public NewsAdapter(List<NewsModel> listNews) {
        this.listNews = listNews;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ListViewHolder holder, int position) {
        NewsModel news = listNews.get(position);

        Glide.with(holder.itemView.getContext())
                .load(news.getUrlToImage())
                .apply(new RequestOptions().override(800, 400))
                .fitCenter()
                .into(holder.ivNews);

        holder.tvTitle.setText(news.getTitle());
        holder.tvContent.setText(news.getDescription());
    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView ivNews;
        TextView tvTitle, tvContent;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            ivNews = itemView.findViewById(R.id.iv_news);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }
}
