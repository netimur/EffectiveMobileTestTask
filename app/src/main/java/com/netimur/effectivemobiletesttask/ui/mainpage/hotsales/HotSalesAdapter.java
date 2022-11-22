package com.netimur.effectivemobiletesttask.ui.mainpage.hotsales;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.netimur.effectivemobiletesttask.ui.mainpage.MainPageFragment;
import com.netimur.effectivemobiletesttask.data.model.HotSales;

import java.util.ArrayList;
import java.util.List;

final public class HotSalesAdapter extends FragmentStateAdapter {
    private List<HotSales> hotSales = new ArrayList<>();
    public HotSalesAdapter(@NonNull MainPageFragment fragmentActivity, List<HotSales> hotSales) {
        super(fragmentActivity);
        this.hotSales = hotSales;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new HotSalesPageFragment();
        Bundle args = new Bundle();
        args.putParcelable(HotSalesPageFragment.ARG_OBJECT, hotSales.get(position));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return hotSales.size();
    }
}
