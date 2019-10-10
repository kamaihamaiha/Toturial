package com.kk.ui.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kk.ui.R;
import com.kk.ui.bean.Fruit;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;

    public FruitAdapter(@NonNull Context context, int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        //todo convertView 用于缓存之前加载好的布局
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImg = view.findViewById(R.id.iv_fruit);
            viewHolder.fruitName = view.findViewById(R.id.tv_fruit_name);

            view.setTag(viewHolder);
        } else {
            view = convertView;
            //todo 从新获取 viewHolder
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.fruitImg.setImageResource(fruit.getImgId());
        viewHolder.fruitName.setText(fruit.getName());

        return view;
    }

    class ViewHolder {
        ImageView fruitImg;
        TextView fruitName;
    }
}
