package com.kk.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kk.adapter.UserInfoAdapter;
import com.kk.manager.R;
import com.kk.modle.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class UserFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //todo fragment 和 activity 建立关联的时候调用
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //todo fragment 加载布局的时候调用

        View inflate = inflater.inflate(R.layout.fragment_user, container, false);
        recyclerView = inflate.findViewById(R.id.user_recyclerView);

        List<UserInfo> userInfoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            userInfoList.add(new UserInfo(i, "name-" + i, "jobNum-" + i, "/sdcard/img/" + i + ".jpg"));
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new UserInfoAdapter(getActivity(), userInfoList,inflate));

        return inflate;
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
