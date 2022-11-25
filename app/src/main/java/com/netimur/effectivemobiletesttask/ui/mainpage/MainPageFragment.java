package com.netimur.effectivemobiletesttask.ui.mainpage;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.netimur.effectivemobiletesttask.R;
import com.netimur.effectivemobiletesttask.data.CategoryRepository;
import com.netimur.effectivemobiletesttask.databinding.FragmentMainPageBinding;
import com.netimur.effectivemobiletesttask.ui.MainActivity;
import com.netimur.effectivemobiletesttask.ui.mainpage.bestseller.BestSellerRecyclerviewAdapter;
import com.netimur.effectivemobiletesttask.ui.mainpage.categories.CategoriesRecyclerViewAdapter;
import com.netimur.effectivemobiletesttask.ui.mainpage.categories.Category;
import com.netimur.effectivemobiletesttask.ui.mainpage.filter.FilterBottomSheetDialog;
import com.netimur.effectivemobiletesttask.ui.mainpage.hotsales.HotSalesAdapter;
import com.netimur.effectivemobiletesttask.data.model.BestSeller;
import com.netimur.effectivemobiletesttask.data.model.HotSales;

import java.util.List;
import java.util.Objects;

final public class MainPageFragment extends Fragment implements MainPageView {
    private FragmentMainPageBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainPageBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        MainPagePresenter mainPagePresenter = new MainPagePresenterImplementation(this);
        mainPagePresenter.requestMainPageData();
        configBestSellerRecyclerView();
        configCategoriesRecyclerView();
        showCategories(null);
        binding.filterButton.setOnClickListener(v -> {
            FilterBottomSheetDialog filter = new FilterBottomSheetDialog();
            filter.show(getParentFragmentManager(), "TAG");
        });
        MainActivity activity = (MainActivity) this.getActivity();
        assert activity != null;
        if (activity.isBottomNavigationInitialized()) {
            showBottomNavigationBar();
        }
        return view;
    }

    @Override
    public void showCategories(List<Category> categories) {
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

    private void showBottomNavigationBar() {
        BottomNavigationView navBar = requireActivity().findViewById(R.id.bottom_navigation);
        navBar.setVisibility(View.VISIBLE);
    }
}