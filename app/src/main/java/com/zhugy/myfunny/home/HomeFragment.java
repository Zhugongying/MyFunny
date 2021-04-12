package com.zhugy.myfunny.home;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zhugy.myfunny.R;
import com.zhugy.myfunny.Tool.NavView;
import com.zhugy.myfunny.Tool.NavViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private NavView navView;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        navView = view.findViewById(R.id.nav_view);
        navView.setClickItemCallBack(new NavViewAdapter.ClickItemCallBack() {
            @Override
            public void clickBlock(int index) {
                Toast.makeText(getContext(),"用户点击了第"+String.valueOf(index) +"个", Toast.LENGTH_SHORT).show();
            }
        });
        navView.showUI(getNavModel());


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }

    private NavViewAdapter.NavViewModel getNavModel() {
        NavViewAdapter.NavViewModel navModel = new NavViewAdapter.NavViewModel();
        List<NavViewAdapter.NavViewModel.NavViewItemModel> itemModelList = new ArrayList<>();
        for (int i=0; i<10; i++) {
            String title = "沙雕" + String.valueOf(i);
            NavViewAdapter.NavViewModel.NavViewItemModel itemModel = new NavViewAdapter.NavViewModel.NavViewItemModel();
            itemModel.setTitleStr(title);
            itemModel.setSelect(false);

            itemModelList.add(itemModel);
        }
        itemModelList.get(0).setSelect(true);

        navModel.setNavList(itemModelList);

        return navModel;
    }

}