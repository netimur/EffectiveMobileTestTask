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

    @Override
    public void subscribe(CapacityStateObserver observer) {
        subscribeFirstItem(observer);
        if (currentObserver != observer) {
            currentObserver.updateState();
            observer.updateState();
            currentObserver = observer;
        }
    }

    @NonNull
    @Override
    public CapacityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        CapacityViewHolder holder = new CapacityViewHolder(CapacityItemBinding.inflate(inflater, parent, false));
        subscribeFirstItem(holder);
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

    private void subscribeFirstItem(CapacityStateObserver observer) {
        if (currentObserver == null) {
            currentObserver = observer;
            currentObserver.updateState();
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
            } else {
                select();
            }
        }

        private void select() {
            binding.capacityButton.setBackgroundColor(Color.parseColor("#FF6E4E"));
            binding.capacityButton.setTextColor(Color.WHITE);
            binding.capacityButton.setElevation(0);
            isSelected = true;
        }

        private void deselect() {
            binding.capacityButton.setBackgroundColor(Color.WHITE);
            binding.capacityButton.setTextColor(Color.parseColor("#8D8D8D"));
            binding.capacityButton.setElevation(0);
            isSelected = false;
        }

        @Override
        public String getCapacity() {
            return (String) binding.capacityButton.getText();
        }
    }
}
