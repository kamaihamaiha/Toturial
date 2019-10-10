package com.kk.ui.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kk.ui.R;
import com.kk.ui.bean.Fruit;

import java.util.List;

public class RecyclerViewFruitAdapter extends RecyclerView.Adapter<RecyclerViewFruitAdapter.ViewHolder> {

    private List<Fruit> fruitList;
    private Type type;

    public RecyclerViewFruitAdapter(List<Fruit> fruitList, Type type) {
        this.fruitList = fruitList;
        this.type = type;
    }

    public static enum Type {
        Vertical, Horizontal,Grip, Fall
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;
        switch (type) {
            case Vertical:
                view = LayoutInflater
                        .from(viewGroup.getContext())
                        .inflate(R.layout.fruit_item, viewGroup, false);
                break;
            case Horizontal:
                view = LayoutInflater
                        .from(viewGroup.getContext())
                        .inflate(R.layout.fruit_item_horizontal, viewGroup, false);
                break;
            case Grip:
                break;
            case Fall:
                view = LayoutInflater
                        .from(viewGroup.getContext())
                        .inflate(R.layout.fruit_item_fall, viewGroup, false);
                break;
            default:
                view = LayoutInflater
                        .from(viewGroup.getContext())
                        .inflate(R.layout.fruit_item, viewGroup, false);
                break;
        }
        final ViewHolder viewHolder = new ViewHolder(view);
        //todo 给 itemView 注册点击事件
        viewHolder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = fruitList.get(position);
                Toast.makeText(v.getContext(),fruit.getName(),Toast.LENGTH_LONG).show();
            }
        });

        //todo 给 itemView 中的 imageview 注册点击事件
        viewHolder.fruitImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = fruitList.get(position);
                Toast.makeText(v.getContext(),"图标："+fruit.getName(),Toast.LENGTH_LONG).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Fruit fruit = fruitList.get(position);
        viewHolder.fruitName.setText(fruit.getName());
        viewHolder.fruitImg.setImageResource(fruit.getImgId());
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        View fruitView;
        ImageView fruitImg;
        TextView fruitName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitView = itemView;
            fruitImg = itemView.findViewById(R.id.iv_fruit);
            fruitName = itemView.findViewById(R.id.tv_fruit_name);
        }
    }
}
