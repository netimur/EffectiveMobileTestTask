package com.netimur.effectivemobiletesttask.ui.productdetails;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netimur.effectivemobiletesttask.R;
import com.netimur.effectivemobiletesttask.data.model.DetailsResponseBody;
import com.netimur.effectivemobiletesttask.databinding.FragmentProductDetailsBinding;
import com.netimur.effectivemobiletesttask.ui.productdetails.productphoto.ProductPhotoViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

final public class ProductDetailsFragment extends Fragment implements ProductDetailsView{
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
        ProductPhotoViewPagerAdapter adapter = new ProductPhotoViewPagerAdapter(this.getActivity(), urls);
        binding.photoViewpager.setAdapter(adapter);
        binding.cameraDescription.setText(detailsResponseBody.getCamera());
        binding.ramDescription.setText(detailsResponseBody.getSd());
        binding.romDescription.setText(detailsResponseBody.getSd());
        binding.processorDescription.setText(detailsResponseBody.getCpu());
    }
}