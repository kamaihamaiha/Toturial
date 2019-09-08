package com.kk.content_provider.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.kk.content_provider.R;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<String[]> {
    private int resourceId;

    public ContactAdapter(@NonNull Context context, int resource, @NonNull List<String[]> contactsList) {
        super(context,resource,contactsList);
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String[] info = getItem(position);
        View view;
        ViewHolder viewHolder;
        //todo convertView 用于缓存之前加载好的布局
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();


            viewHolder.name = view.findViewById(R.id.tv_contact_name);
            viewHolder.phoneNo = view.findViewById(R.id.tv_contact_phone);


            view.setTag(viewHolder);
        } else {
            view = convertView;
            //todo 从新获取 viewHolder
            viewHolder = (ViewHolder) view.getTag();
        }


        viewHolder.name.setText(info[0]);
        viewHolder.phoneNo.setText(info[1]);
        return view;
    }

    class ViewHolder {
        TextView name;
        TextView phoneNo;
    }
}
