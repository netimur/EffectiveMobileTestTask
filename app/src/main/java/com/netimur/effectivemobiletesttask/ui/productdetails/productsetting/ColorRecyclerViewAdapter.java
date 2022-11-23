package com.netimur.effectivemobiletesttask.ui.productdetails.productsetting;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.netimur.effectivemobiletesttask.databinding.ColorItemBinding;

import java.util.ArrayList;
import java.util.List;

final public class ColorRecyclerViewAdapter extends RecyclerView.Adapter<ColorRecyclerViewAdapter.ColorViewHolder> {
    private List<String> colors = new ArrayList<>();
    private final Context context;

    public ColorRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
        Log.d("DEBUG", "colors set");
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new ColorViewHolder(ColorItemBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        String color = colors.get(position);
        holder.bindData(color);
        Log.d("DEBUG", "onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

    class ColorViewHolder extends RecyclerView.ViewHolder {
        private ColorItemBinding binding;

        public ColorViewHolder(ColorItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(String hexColor) {
            binding.colorItem.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(hexColor)));
            Log.d("DEBUG", hexColor);
        }
    }
}
