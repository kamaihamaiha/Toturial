package com.kk.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kk.fragment.fragment.NewsFragment;

public class NewsContentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);

        getSupportActionBar().hide();

        Intent intent = getIntent();
        String newsTitle = intent.getStringExtra("news_title");
        String newsContent = intent.getStringExtra("news_content");

        NewsFragment newsFragment
                = (NewsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_news);
        newsFragment.refreshNews(newsTitle,newsContent);
    }

    public static void start(Context context, String title, String content){
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("news_title",title);
        intent.putExtra("news_content",content);
        context.startActivity(intent);
    }
}
