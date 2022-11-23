package com.netimur.effectivemobiletesttask.ui.mainpage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.netimur.effectivemobiletesttask.R;
import com.netimur.effectivemobiletesttask.data.CategoryRepository;
import com.netimur.effectivemobiletesttask.databinding.FragmentMainPageBinding;
import com.netimur.effectivemobiletesttask.ui.mainpage.bestseller.BestSellerRecyclerviewAdapter;
import com.netimur.effectivemobiletesttask.ui.mainpage.categories.CategoriesRecyclerViewAdapter;
import com.netimur.effectivemobiletesttask.ui.mainpage.categories.Category;
import com.netimur.effectivemobiletesttask.ui.mainpage.filter.FilterBottomSheetDialog;
import com.netimur.effectivemobiletesttask.ui.mainpage.hotsales.HotSalesAdapter;
import com.netimur.effectivemobiletesttask.data.model.BestSeller;
import com.netimur.effectivemobiletesttask.data.model.HotSales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final public class MainPageFragment extends Fragment implements MainPageView {
    private FragmentMainPageBinding binding;
    private MainPagePresenter mainPagePresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainPageBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        mainPagePresenter = new MainPagePresenterImplementation(this);
        mainPagePresenter.requestMainPageData();
        configBestSellerRecyclerView();
        configCategoriesRecyclerView();
        showCategories(null);
        binding.filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FilterBottomSheetDialog filter = new FilterBottomSheetDialog();
                filter.show(getParentFragmentManager(), "TAG");
            }
        });
        return view;
    }

    @Override
    public void showCategories(List<Category> categories) {

        //TODO this is mock method. Have to replace then
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.categoryRecyclerview.setLayoutManager(linearLayoutManager);
        List<Category> categoryList = CategoryRepository.getCategories();
        CategoriesRecyclerViewAdapter adapter = new CategoriesRecyclerViewAdapter(this.getContext());
        adapter.setCategories(categoryList);
        binding.categoryRecyclerview.setAdapter(adapter);
    }

    @Override
    public void showHotSales(List<HotSales> hotSales) {
        FragmentStateAdapter adapter = new HotSalesAdapter(this, hotSales);
        binding.hotSalesViewpager.setAdapter(adapter);
    }

    @Override
    public void showBestSellers(List<BestSeller> bestSellers) {
        BestSellerRecyclerviewAdapter adapter = new BestSellerRecyclerviewAdapter(this.getContext());
        adapter.setBestSellers(bestSellers);
        binding.bestSellersRecyclerview.setAdapter(adapter);
    }

    private void configBestSellerRecyclerView() {
        GridLayoutManager manager = new GridLayoutManager(this.getContext(), 2, LinearLayoutManager.VERTICAL, false);
        binding.bestSellersRecyclerview.setLayoutManager(manager);
    }

    private void configCategoriesRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.categoryRecyclerview.setLayoutManager(manager);
    }

}