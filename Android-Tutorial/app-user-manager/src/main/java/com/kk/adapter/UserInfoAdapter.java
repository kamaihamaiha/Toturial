package com.kk.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.kk.fragment.BaseFragment;
import com.kk.fragment.UserDetailFragment;
import com.kk.manager.R;
import com.kk.modle.UserInfo;
import com.kk.modle.UserInfoPager;

import java.util.List;
import java.util.zip.Inflater;

/**
 * @Author: kk
 * @Create Date: 19-3-19 下午8:39
 * @E-mail: kamaihamaiha@gmail.com
 * @Motto: 人生苦短，就是干！
 * @Des: this is UserInfoAdapter
 * 用户信息的适配器
 */
public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.UserInfoViewHolder> {
    private static final String TAG = UserInfoAdapter.class.getSimpleName();

    private Context context;
    private List<UserInfo> userInfoList;
    private View inflate;
    public UserInfoAdapter(Context context, List<UserInfo> userInfoList, View inflate) {
        this.context = context;
        this.userInfoList = userInfoList;
        this.inflate = inflate;
    }

    @NonNull
    @Override
    public UserInfoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_item, viewGroup, false);
        final UserInfoViewHolder viewHolder = new UserInfoViewHolder(inflate);
        final ViewFlipper viewFlipper = this.inflate.findViewById(R.id.viewFlipperUser);
        final TextView tvUserDetailName = this.inflate.findViewById(R.id.tv_user_detail_name);
        final TextView tvUserDetailJobNum = this.inflate.findViewById(R.id.tv_user_detail_job_num);
        final ImageView ivUserDetailImage = this.inflate.findViewById(R.id.iv_user_detail_img);

        viewHolder.userInfoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo 点击弹窗，显示详细信息
                int position = viewHolder.getAdapterPosition();
                UserInfo userInfo = userInfoList.get(position);

                viewFlipper.showNext();

                tvUserDetailName.setText(userInfo.getName());
                tvUserDetailJobNum.setText(userInfo.getJobNum());
                ivUserDetailImage.setBackground(context.getDrawable(R.drawable.avatar_96));

            }
        });

        this.inflate.findViewById(R.id.btn_back_detail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showPrevious();
                tvUserDetailName.setText("");
                tvUserDetailJobNum.setText("");
                ivUserDetailImage.setBackground(null);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserInfoViewHolder userInfoViewHolder, int position) {
        UserInfo userInfo = userInfoList.get(position);
        userInfoViewHolder.id.setText(userInfo.getId() + "");
        userInfoViewHolder.name.setText(userInfo.getName());
        userInfoViewHolder.jobNum.setText(userInfo.getJobNum());
        userInfoViewHolder.headImg.setImageResource(R.drawable.avatar_72);
    }


    @Override
    public int getItemCount() {
        return userInfoList.size();
    }

    class UserInfoViewHolder extends RecyclerView.ViewHolder {
        private View userInfoView;
        private TextView id;
        private TextView name;
        private TextView jobNum;
        private ImageView headImg;

        public UserInfoViewHolder(@NonNull View itemView) {
            super(itemView);
            userInfoView = itemView;
            id = itemView.findViewById(R.id.tv_user_item_id);
            name = itemView.findViewById(R.id.tv_user_item_name);
            jobNum = itemView.findViewById(R.id.tv_user_item_jobNum);
            headImg = itemView.findViewById(R.id.iv_user_item_headImg);
        }
    }
}
