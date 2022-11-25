package com.netimur.effectivemobiletesttask.ui.productdetails.productsetting.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.netimur.effectivemobiletesttask.R;
import com.netimur.effectivemobiletesttask.databinding.ColorItemBinding;

import java.util.ArrayList;
import java.util.List;

final public class ColorRecyclerViewAdapter extends RecyclerView.Adapter<ColorRecyclerViewAdapter.ColorViewHolder> implements ColorPublisher {
    private List<String> colors = new ArrayList<>();
    private final Context context;
    private ColorStateObserver currentColorStateObserver = null;

    public ColorRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public void subscribe(ColorStateObserver observer) {
        if (currentColorStateObserver == null) {
            currentColorStateObserver = observer;
            currentColorStateObserver.updateState();
        } else if (observer != currentColorStateObserver) {
            observer.updateState();
            currentColorStateObserver.updateState();
            currentColorStateObserver = observer;
        }
    }

    @Override
    public void unsubscribe() {
        this.currentColorStateObserver = null;
    }

    public String getSelectedHexColor() {
        return currentColorStateObserver.getColor();
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ColorViewHolder viewHolder = new ColorViewHolder(ColorItemBinding.inflate(inflater, parent, false));
        View.OnClickListener listener = v -> subscribe(viewHolder);
        viewHolder.setOnClickListener(listener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        String color = colors.get(position);
        holder.bindData(color);
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

    static class ColorViewHolder extends RecyclerView.ViewHolder implements ColorStateObserver {
        private final ColorItemBinding binding;
        private boolean isSelected = false;

        public ColorViewHolder(ColorItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setOnClickListener(View.OnClickListener listener) {
            binding.colorItem.setOnClickListener(listener);
        }

        public void bindData(String hexColor) {
            binding.colorItem.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(hexColor)));
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

        public void select() {
            binding.colorItem.setImageResource(R.drawable.ic_baseline_check_24);
        }

        public void deselect() {
            binding.colorItem.setImageDrawable(null);
        }

        @Override
        public String getColor() {
            return String.valueOf(binding.colorItem.getBackgroundTintList());
        }
    }
}
