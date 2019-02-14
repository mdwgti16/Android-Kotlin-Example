package com.ls.project.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListRecyclerViewAdapter extends RecyclerView.Adapter<ListRecyclerViewAdapter.GenericViewHolder> {
    List<ListItem> items;

    public ListRecyclerViewAdapter(List<ListItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        GenericViewHolder holder = new GenericViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int i) {
        holder.num.setText(items.get(i).num);
        holder.name.setText(items.get(i).name);
        holder.date.setText(items.get(i).date);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public List<ListItem> getItems() {
        return items;
    }

    public void setItems(List<ListItem> items) {
        this.items = items;
    }

    public ListItem getItemPos(int pos){
        return items.get(pos);
    }

    public class GenericViewHolder extends RecyclerView.ViewHolder {
        TextView num;
        TextView name;
        TextView date;

        public GenericViewHolder(View view) {
            super(view);
            num = view.findViewById(R.id.num);
            name = view.findViewById(R.id.name);
            date = view.findViewById(R.id.date);
        }
    }
}
