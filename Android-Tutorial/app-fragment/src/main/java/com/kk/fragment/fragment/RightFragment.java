package com.kk.fragment.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kk.fragment.R;

/**
*
* @Author: kk
* @Create Date: 18-9-26 下午7:30
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is RightFragment 右边的碎片
*/
public class RightFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //todo fragment 和 activity 建立关联的时候调用
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //todo fragment 加载布局的时候调用
        return  inflater.inflate(R.layout.fragment_right,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //todo 与 fragment 关联的 activity 已经创建完毕了
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
