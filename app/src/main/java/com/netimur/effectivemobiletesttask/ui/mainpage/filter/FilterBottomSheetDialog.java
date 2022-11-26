package com.netimur.effectivemobiletesttask.ui.mainpage.filter;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.netimur.effectivemobiletesttask.R;
import com.netimur.effectivemobiletesttask.databinding.FilterBottomSheetDialogBinding;

final public class FilterBottomSheetDialog extends BottomSheetDialogFragment {
    private FilterBottomSheetDialogBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FilterBottomSheetDialogBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        specifySpinners();
        binding.closeDialogButton.setOnClickListener(v -> this.dismiss());
        return view;
    }

    private void specifySpinners() {
        Spinner brandSpinner = binding.brandSpinner;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.brands_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brandSpinner.setAdapter(adapter);
        Spinner priceSpinner = binding.priceSpinner;
        ArrayAdapter<CharSequence> priceAdapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.prices_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        priceSpinner.setAdapter(priceAdapter);
        Spinner sizeSpinner = binding.sizeSpinner;
        ArrayAdapter<CharSequence> sizeAdapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.sizes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sizeSpinner.setAdapter(sizeAdapter);
    }
}
