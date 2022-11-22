package com.netimur.effectivemobiletesttask.ui.productdetails.productphoto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.netimur.effectivemobiletesttask.R;
import com.netimur.effectivemobiletesttask.databinding.FragmentProductDetailsBinding;
import com.netimur.effectivemobiletesttask.databinding.FragmentProductPhotoBinding;
import com.squareup.picasso.Picasso;


final public class ProductPhotoFragment extends Fragment {
    private FragmentProductPhotoBinding binding;
    public static final String ARG_OBJECT = "object";
    private String photoUrl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProductPhotoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        photoUrl = getArguments().getString(ARG_OBJECT);
        ImageView imageView = binding.imageView;
        Picasso.get().load(photoUrl).fit().into(imageView);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}