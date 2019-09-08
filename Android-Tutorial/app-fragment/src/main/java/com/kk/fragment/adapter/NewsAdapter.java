package com.kk.fragment.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kk.fragment.NewsContentActivity;
import com.kk.fragment.R;
import com.kk.fragment.SimpleNewsActivity;
import com.kk.fragment.bean.News;
import com.kk.fragment.fragment.NewsFragment;
import com.kk.fragment.fragment.NewsTitleFragment;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.TitleViewHolder> {

    private List<News> newsList;
    private boolean isTwoPane;
    private SimpleNewsActivity activity;

    public NewsAdapter(List<News> newsList, boolean isTwoPane, SimpleNewsActivity activity) {
        this.newsList = newsList;
        this.isTwoPane = isTwoPane;
        this.activity = activity;
    }

    @NonNull
    @Override
    public TitleViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        final View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.news_title_item, viewGroup, false);
        final TitleViewHolder titleViewHolder = new TitleViewHolder(view);

        //todo 这个时左边的新闻标题，需要有点击事件
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                News news = newsList.get(titleViewHolder.getAdapterPosition());
                if (isTwoPane) {
                    //todo 如果是双页模式，刷新 NewsFragment 内容

                    NewsFragment newsFragment = (NewsFragment) activity
                            .getSupportFragmentManager()
                            .findFragmentById(R.id.fragment_news_large);


                    newsFragment.refreshNews(news.getTitle(), news.getContent());

                } else {
                    //todo 如果是单页模式，直接启动 SimpleNewsActivity
                    NewsContentActivity.start(viewGroup.getContext(), news.getTitle(), news.getContent());
                }
            }
        });
        return titleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TitleViewHolder titleViewHolder, int i) {

        News news = newsList.get(i);
        titleViewHolder.tvNewsTitle.setText(news.getTitle());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class TitleViewHolder extends RecyclerView.ViewHolder {

        TextView tvNewsTitle;

        public TitleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNewsTitle = itemView.findViewById(R.id.tv_news_left_title);
        }
    }
}
