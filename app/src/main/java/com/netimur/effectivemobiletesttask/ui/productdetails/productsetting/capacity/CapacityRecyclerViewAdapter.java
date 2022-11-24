package com.netimur.effectivemobiletesttask.ui.productdetails.productsetting.capacity;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.netimur.effectivemobiletesttask.databinding.CapacityItemBinding;

import java.util.ArrayList;
import java.util.List;

final public class CapacityRecyclerViewAdapter extends RecyclerView.Adapter<CapacityRecyclerViewAdapter.CapacityViewHolder> implements CapacityPublisher {
    private final Context context;
    private List<String> capacities = new ArrayList<>();
    private CapacityStateObserver currentObserver = null;

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
        CapacityViewHolder holder = new CapacityViewHolder(CapacityItemBinding.inflate(inflater, parent, false));
        View.OnClickListener listener = v -> subscribe(holder);
        holder.setOnClickListener(listener);
        return holder;
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

    @Override
    public void subscribe(CapacityStateObserver observer) {
        if (currentObserver == null) {
            currentObserver = observer;
            currentObserver.updateState();
        } else if (currentObserver != observer) {
            currentObserver.updateState();
            observer.updateState();
            currentObserver = observer;
        }
    }

    static class CapacityViewHolder extends RecyclerView.ViewHolder implements CapacityStateObserver {
        private final CapacityItemBinding binding;
        private boolean isSelected = false;

        public CapacityViewHolder(CapacityItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            binding.capacityButton.setOnClickListener(onClickListener);
        }

        public void bindData(String capacity) {
            binding.capacityButton.setText(capacity);
        }

        @Override
        public void updateState() {
            if (isSelected) {
                deselect();
                isSelected = false;
            } else {
                select();
                isSelected = true;
            }
        }

        private void select() {
            binding.capacityButton.setBackgroundColor(Color.parseColor("#FF6E4E"));
            binding.capacityButton.setTextColor(Color.WHITE);
            binding.capacityButton.setElevation(0);
        }

        private void deselect() {
            binding.capacityButton.setBackgroundColor(Color.WHITE);
            binding.capacityButton.setTextColor(Color.parseColor("#8D8D8D"));
            binding.capacityButton.setElevation(0);
        }

        @Override
        public String getCapacity() {
            return (String) binding.capacityButton.getText();
        }
    }
}
