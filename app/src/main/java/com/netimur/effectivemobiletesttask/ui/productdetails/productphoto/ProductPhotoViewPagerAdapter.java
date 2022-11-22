package com.netimur.effectivemobiletesttask.ui.productdetails.productphoto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

final public class ProductPhotoViewPagerAdapter extends FragmentStateAdapter {
    private List<String> urls = new ArrayList<>();

    public ProductPhotoViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<String> urls) {
        super(fragmentActivity);
        this.urls = urls;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new ProductPhotoFragment();
        Bundle args = new Bundle();
        args.putString(ProductPhotoFragment.ARG_OBJECT, urls.get(position));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }
}
