package com.netimur.effectivemobiletesttask.ui.mainpage.categories;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.netimur.effectivemobiletesttask.databinding.CategoryItemBinding;

import java.util.ArrayList;
import java.util.List;

public class CategoriesRecyclerViewAdapter extends RecyclerView.Adapter<CategoriesRecyclerViewAdapter.CategoryViewHolder> {
    private List<Category> categories;
    private final Context context;
    private final ArrayList<CategoryViewHolder> holders = new ArrayList<>();
    private CategoryViewHolder currentHolder;

    public CategoriesRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        return new CategoryViewHolder(CategoryItemBinding.inflate(layoutInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categories.get(position);
        View.OnClickListener onClickListener = v -> {
            if (currentHolder != null && currentHolder != holder) {
                holder.selectHolder();
                currentHolder.unselectHolder();
                currentHolder = holder;
            } else {
                currentHolder = holder;
                currentHolder.selectHolder();
            }

        };
        holder.bindData(category, onClickListener);
        holders.add(holder);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    protected final static class CategoryViewHolder extends RecyclerView.ViewHolder {
        private CategoryItemBinding binding;
        private Category category;

        public CategoryViewHolder(CategoryItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(Category category, View.OnClickListener onClickListener) {
            this.category = category;
            binding.categoryName.setText(category.getCategoryName());
            binding.categoryIcon.setImageResource(category.getImageResourceId());
            binding.getRoot().setOnClickListener(onClickListener);
        }

        public void selectHolder() {
            binding.categoryIcon.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(255, 110, 78)));
            binding.categoryName.setTextColor(Color.rgb(255, 110, 78));
            binding.categoryIcon.setImageTintList(ColorStateList.valueOf(Color.WHITE));
        }

        public void unselectHolder() {
            binding.categoryIcon.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
            binding.categoryName.setTextColor(Color.rgb(1, 0, 53));
            binding.categoryIcon.setImageTintList(ColorStateList.valueOf(Color.rgb(179, 179, 195)));
        }
    }
}
