package com.netimur.effectivemobiletesttask.ui.productdetails;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netimur.effectivemobiletesttask.data.model.DetailsResponseBody;
import com.netimur.effectivemobiletesttask.databinding.FragmentProductDetailsBinding;
import com.netimur.effectivemobiletesttask.ui.productdetails.productphoto.ProductPhotoViewPagerAdapter;
import com.netimur.effectivemobiletesttask.ui.productdetails.productsetting.CapacityRecyclerViewAdapter;
import com.netimur.effectivemobiletesttask.ui.productdetails.productsetting.ColorRecyclerViewAdapter;

import java.util.List;

final public class ProductDetailsFragment extends Fragment implements ProductDetailsView {
    private FragmentProductDetailsBinding binding;
    private ProductDetailsPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProductDetailsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        presenter = new ProductDetailsPresenterImplementation(this);
        presenter.requestProductDetails();
        return view;
    }

    @Override
    public void showProductDetails(DetailsResponseBody detailsResponseBody) {
        List<String> urls = detailsResponseBody.getPictureUrls();
        ProductPhotoViewPagerAdapter viewPagerAdapter = new ProductPhotoViewPagerAdapter(this.getActivity(), urls);
        binding.photoViewpager.setAdapter(viewPagerAdapter);
        binding.cameraDescription.setText(detailsResponseBody.getCamera());
        binding.ramDescription.setText(detailsResponseBody.getSsd());
        binding.romDescription.setText(detailsResponseBody.getSd());
        binding.processorDescription.setText(detailsResponseBody.getCpu());
        ColorRecyclerViewAdapter colorRecyclerViewAdapter = new ColorRecyclerViewAdapter(this.getContext());
        Log.d("DEBUG", detailsResponseBody.getColors().toString());
        colorRecyclerViewAdapter.setColors(detailsResponseBody.getColors());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.colorRecyclerview.setLayoutManager(linearLayoutManager);
        binding.colorRecyclerview.setAdapter(colorRecyclerViewAdapter);
        CapacityRecyclerViewAdapter capacityRecyclerViewAdapter = new CapacityRecyclerViewAdapter(this.getContext());
        capacityRecyclerViewAdapter.setCapacities(detailsResponseBody.getCapacity());
        linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.capacityRecyclerview.setLayoutManager(linearLayoutManager);
        binding.capacityRecyclerview.setAdapter(capacityRecyclerViewAdapter);
    }
}