package com.zhugy.myfunny.Tool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.zhugy.myfunny.R;

public class NavView extends RelativeLayout {

    private RecyclerView recyclerView;

    public NavView(Context context,  AttributeSet attrs ) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.nav_layout, this);
        recyclerView = findViewById(R.id.nav_recyclerview);
        recyclerView.set

    }

}
