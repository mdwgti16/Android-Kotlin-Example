package com.ls.project.recyclerview.adapter;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ls.project.recyclerview.BR;
import com.ls.project.recyclerview.databinding.ItemListBinding;
import com.ls.project.recyclerview.model.ListItem;

import java.util.List;

public class ListRecyclerViewAdapter extends RecyclerView.Adapter<ListRecyclerViewAdapter.GenericViewHolder> {
    List<ListItem> items;

    public ListRecyclerViewAdapter(List<ListItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemListBinding binding = ItemListBinding.inflate(layoutInflater, parent,false);
        binding.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout = (LinearLayout)v;

                Toast.makeText(v.getContext(),((TextView)((LinearLayout) v).getChildAt(0)).getText().toString() +" "+
                                ((TextView)((LinearLayout) v).getChildAt(1)).getText().toString()+" "+
                                ((TextView)((LinearLayout) v).getChildAt(2)).getText().toString()+" "+
                                ((TextView)((LinearLayout) v).getChildAt(3)).getText().toString()
                        ,Toast.LENGTH_SHORT).show();
            }
        });
        return new GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int i) {
        holder.bind(items.get(i));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<ListItem> items) {
        this.items = items;
    }

    public class GenericViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;
        public GenericViewHolder(ItemListBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
        public void bind(ListItem item){
            binding.setVariable(BR.item,item);
            binding.executePendingBindings();
        }
    }
}
