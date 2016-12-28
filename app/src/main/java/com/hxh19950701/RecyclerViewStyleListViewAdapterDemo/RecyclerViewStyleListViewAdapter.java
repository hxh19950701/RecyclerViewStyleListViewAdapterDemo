package com.hxh19950701.RecyclerViewStyleListViewAdapterDemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class RecyclerViewStyleListViewAdapter<ViewHolder extends RecyclerView.ViewHolder> extends BaseAdapter {

    public abstract ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    public abstract void onBindViewHolder(ViewHolder holder, int position);

    public abstract int getItemCount();

    @Override
    public final int getCount() {
        return getItemCount();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public final View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            int itemViewType = getItemViewType(position);
            ViewHolder holder = onCreateViewHolder(parent, itemViewType);
            convertView = holder.itemView;
            convertView.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        onBindViewHolder(holder, position);
        return convertView;
    }
}