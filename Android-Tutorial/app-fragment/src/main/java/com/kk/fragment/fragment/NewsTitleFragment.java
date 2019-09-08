package com.kk.fragment.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kk.fragment.R;
import com.kk.fragment.SimpleNewsActivity;
import com.kk.fragment.adapter.NewsAdapter;
import com.kk.fragment.bean.News;

import java.util.ArrayList;
import java.util.List;

/**
*
* @Author: kk
* @Create Date: 18-9-27 下午9:10
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is NewsTitleFragment 存放新闻标题的碎片
*/
public class NewsTitleFragment extends Fragment {

    //是否时双页模式
    private boolean isTwoPane;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_title,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.fl_news_content_container) == null) {
            isTwoPane = false;
        } else {
            isTwoPane = true;
        }

        RecyclerView recyclerViewNewsTitle = view.findViewById(R.id.recyclerView_news_title);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewNewsTitle.setLayoutManager(linearLayoutManager);
        NewsAdapter newsAdapter = new NewsAdapter(initNews(), isTwoPane, (SimpleNewsActivity) getActivity());
        recyclerViewNewsTitle.setAdapter(newsAdapter);




    }

    private List<News> initNews(){
        List<News> newsList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            newsList.add(new News("标题-" + i,"发生大事了-" + i));
        }
        return newsList;
    }
}
