package com.zhugy.myfunny.Tool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.zhugy.myfunny.R;

import java.util.List;



public class NavViewAdapter extends RecyclerView.Adapter<NavViewAdapter.NavViewHolder> {

    private NavViewModel viewModel;
    private Context context;

    public interface ClickItemCallBack {
        void clickBlock(int index);
    }

    private ClickItemCallBack callBack;

    public NavViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public NavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_item_layout, parent, false);
        NavViewHolder viewHolder = new NavViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NavViewHolder holder, int position) {

        NavViewModel.NavViewItemModel itemModel = viewModel.getItemModel(position);
        holder.getTitleView().setText(itemModel.getTitleStr());
        if (itemModel.isSelect()) {
            holder.getTitleView().setTextColor(0xFF782365);
        } else {
            holder.getTitleView().setTextColor(0xFF000000);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick(itemModel, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return viewModel.getNavList().size();
    }


    // item 点击

    private void itemClick(NavViewModel.NavViewItemModel itemModel, int position) {
        viewModel.selectItem(itemModel);
        notifyDataSetChanged();
        if (callBack != null) {
            callBack.clickBlock(position);
        }
    }

    public void setCallBack(ClickItemCallBack callBack) {
        this.callBack = callBack;
    }

    // 更新数据
    public void update(NavViewModel viewModel) {
        this.viewModel = viewModel;
        notifyDataSetChanged();
    }

    // NavViewHolder
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

    //NavViewModel
    public static class NavViewModel extends ViewModel {

        public static class NavViewItemModel {
            private String titleStr;
            private boolean select;

            public String getTitleStr() {
                return titleStr;
            }

            public void setTitleStr(String titleStr) {
                this.titleStr = titleStr;
            }

            public boolean isSelect() {
                return select;
            }

            public void setSelect(boolean select) {
                this.select = select;
            }
        }

        public NavViewModel() {
            super();
        }

        private List<NavViewItemModel> navList;

        public List<NavViewItemModel> getNavList() {
            return navList;
        }

        public void setNavList(List<NavViewItemModel> navList) {
            this.navList = navList;
        }

        public NavViewItemModel getItemModel(int index) {
            if (index<getNavList().size()) {
                return getNavList().get(index);
            }
            return getNavList().get(0);
        }

        public void selectItem(NavViewItemModel item) {
            for (NavViewItemModel itemModel1 : getNavList()) {
                boolean mark = item.titleStr.equals(itemModel1.titleStr);
                itemModel1.setSelect(mark);
            }
        }
    }
}
