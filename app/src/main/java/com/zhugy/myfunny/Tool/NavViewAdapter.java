package com.zhugy.myfunny.Tool;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhugy.myfunny.R;

public class NavViewAdapter extends RecyclerView.Adapter<NavViewAdapter.NavViewHolder> {




    @NonNull
    @Override
    public NavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_item_layout, parent, false);
        NavViewHolder viewHolder = new NavViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NavViewHolder holder, int position) {

        holder.getTitleView().setText();

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class NavViewHolder extends RecyclerView.ViewHolder {
        private TextView titleView;

        public NavViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.textView);
        }

        public TextView getTitleView() {
            return titleView;
        }

    }
}
