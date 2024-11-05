package com.pdfreadapp.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.pdfreadapp.R;

import java.util.List;

/**
 * Created by zlf on 2024/11/5.
 */

public class CustomAdapter extends ArrayAdapter<String> {
    private Context context;
    private List<String> titles;
    private List<String> contents;

    public CustomAdapter(@NonNull Context context, List<String> titles, List<String> contents) {
        super(context, R.layout.list_item);
        this.context = context;
        this.titles = titles;
        this.contents = contents;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return titles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.title = convertView.findViewById(R.id.title);
            holder.content = convertView.findViewById(R.id.content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // 设置标题和内容
        holder.title.setText(titles.get(position));
        holder.content.setText(contents.get(position));

        return convertView;
    }

    private static class ViewHolder {
        TextView title;
        TextView content;
    }
}
