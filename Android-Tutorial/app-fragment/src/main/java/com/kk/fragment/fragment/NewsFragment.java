package com.kk.fragment.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kk.fragment.R;

/**
*
* @Author: kk
* @Create Date: 18-9-27 下午8:51
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is NewsFragment 存放新闻布局的碎片
*/
public class NewsFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_news,container,false);
        return view;
    }

    public void refreshNews(String title,String content){
        View containerView = view.findViewById(R.id.ll_news_container);
        containerView.setVisibility(View.VISIBLE);
        TextView tvNewsTitle = view.findViewById(R.id.tv_news_title);
        TextView tvNewsContent = view.findViewById(R.id.tv_news_content);

        tvNewsTitle.setText(title);
        tvNewsContent.setText(content);
    }
}
