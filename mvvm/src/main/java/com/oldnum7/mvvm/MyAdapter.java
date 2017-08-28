package com.oldnum7.mvvm;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.oldnum7.mvvm.databinding.UserItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *       author : denglin
 *       time   : 2017/08/28/10:25
 *       desc   :
 *       version: 1.0
 * </pre>
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHoler> {
    private List<User2> mData = new ArrayList<>();

    public MyAdapter(List<User2> data) {
        this.mData = data;
    }

    @Override
    public MyHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        return MyHoler.create(LayoutInflater.from(parent.getContext()),parent);
    }

    @Override
    public void onBindViewHolder(MyHoler holder, int position) {
            holder.bindTo(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mData == null)
            return 0;
        return mData.size();
    }

    static class MyHoler extends RecyclerView.ViewHolder {

        private final UserItemBinding mBinding;

        static MyHoler create(LayoutInflater inflater, ViewGroup parent) {
            UserItemBinding binding = UserItemBinding.inflate(inflater, parent, false);
            return new MyHoler(binding);
        }

        public MyHoler(UserItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bindTo(User2 user) {
            mBinding.setUser2(user);
            mBinding.executePendingBindings();
        }
    }
}
