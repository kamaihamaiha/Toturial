package com.kk.animation;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * @Author: kk
 * @Create Date: 18-9-26 下午7:30
 * @E-mail: kamaihamaiha@gmail.com
 * @Motto: 人生苦短，就是干！
 * @Des: this is RightFragment 右边的碎片
 */
public class DemoFragment extends Fragment {


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //todo fragment 和 activity 建立关联的时候调用
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //todo fragment 加载布局的时候调用
        View inflateView = inflater.inflate(R.layout.fragment_demo, container, false);
        TextView tvInfo = inflateView.findViewById(R.id.tv_demo_fragment_info);
        Random random = new Random();
        int i = random.nextInt(100);
        tvInfo.setText("demo fragment: " + i);
        return inflateView;
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
