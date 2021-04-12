package com.zhugy.myfunny.Tool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhugy.myfunny.R;

public class NavView extends RelativeLayout {

    private RecyclerView recyclerView;
    private NavViewAdapter adapter;

    private NavViewAdapter.ClickItemCallBack  clickItemCallBack;

    public NavView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.nav_layout, this);
        adapter = new NavViewAdapter(getContext());
        recyclerView = findViewById(R.id.nav_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    public void setClickItemCallBack(NavViewAdapter.ClickItemCallBack clickItemCallBack) {
        this.clickItemCallBack = clickItemCallBack;
    }

    public void showUI(NavViewAdapter.NavViewModel viewModel) {
        adapter.update(viewModel);
        adapter.setCallBack(clickItemCallBack);
        recyclerView.setAdapter(adapter);

    }
}
