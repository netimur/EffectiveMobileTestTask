package com.netimur.effectivemobiletesttask.ui.mainpage;

import com.netimur.effectivemobiletesttask.data.model.BestSeller;
import com.netimur.effectivemobiletesttask.data.model.HotSales;
import com.netimur.effectivemobiletesttask.ui.mainpage.categories.Category;

import java.util.List;

public interface MainPageView {
    void showCategories(List<Category> categories);
    void showHotSales(List<HotSales> hotSales);
    void showBestSellers(List<BestSeller> bestSellers);
}
