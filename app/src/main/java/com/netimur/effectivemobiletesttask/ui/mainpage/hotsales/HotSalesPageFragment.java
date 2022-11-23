package com.netimur.effectivemobiletesttask.ui.mainpage.hotsales;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.netimur.effectivemobiletesttask.R;
import com.netimur.effectivemobiletesttask.data.model.HotSales;
import com.netimur.effectivemobiletesttask.databinding.FragmentHotSalesPageBinding;
import com.squareup.picasso.Picasso;

final public class HotSalesPageFragment extends Fragment {
    private FragmentHotSalesPageBinding binding;
    private HotSales hotSales;
    public static final String ARG_OBJECT = "object";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHotSalesPageBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        Bundle args = getArguments();
        this.hotSales = args.getParcelable(ARG_OBJECT);
        binding.title.setText(hotSales.getTitle());
        binding.subtitle.setText(hotSales.getSubtitle());
        if (!hotSales.isNew()) {
            binding.newTag.setVisibility(View.INVISIBLE);
        }
        ImageView imageView = binding.imageview;
        Picasso.get().load(hotSales.getPictureUrl()).resize(1000, binding.hotSalesCard.getHeight()).into(imageView);
        Log.d(this.getClass().toString(), this.hotSales.toString());
        binding.getRoot().setOnClickListener(v -> Navigation.findNavController(binding.getRoot()).navigate(R.id.action_mainPageFragment_to_productDetailsFragment));
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