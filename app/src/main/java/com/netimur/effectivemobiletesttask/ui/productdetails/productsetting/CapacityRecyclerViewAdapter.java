package com.netimur.effectivemobiletesttask.ui.productdetails.productsetting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.netimur.effectivemobiletesttask.databinding.CapacityItemBinding;

import java.util.ArrayList;
import java.util.List;

final public class CapacityRecyclerViewAdapter extends RecyclerView.Adapter<CapacityRecyclerViewAdapter.CapacityViewHolder> {
    private final Context context;
    private List<String> capacities = new ArrayList<>();
    public CapacityRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setCapacities(List<String> capacities) {
        this.capacities = capacities;
    }

    @NonNull
    @Override
    public CapacityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new CapacityViewHolder(CapacityItemBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CapacityViewHolder holder, int position) {
        String capacity = capacities.get(position);
        holder.bindData(capacity);
    }

    @Override
    public int getItemCount() {
        return capacities.size();
    }

    class CapacityViewHolder extends RecyclerView.ViewHolder {
        private final CapacityItemBinding binding;

        public CapacityViewHolder(CapacityItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(String capacity) {
            binding.capacityButton.setText(capacity);
        }
    }
}
