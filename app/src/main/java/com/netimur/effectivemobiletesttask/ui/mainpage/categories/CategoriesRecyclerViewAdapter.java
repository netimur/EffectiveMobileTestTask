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

final public class CategoriesRecyclerViewAdapter extends RecyclerView.Adapter<CategoriesRecyclerViewAdapter.CategoryViewHolder> implements CategoryPublisher {
    private List<Category> categories;
    private final Context context;
    private final ArrayList<CategoryViewHolder> holders = new ArrayList<>();
    private CategoryStateObserver currentObserver = null;

    @Override
    public void subscribe(CategoryStateObserver observer) {
        subscribeFirstItem(observer);
        if (currentObserver != observer) {
            currentObserver.updateState();
            observer.updateState();
            currentObserver = observer;
        }
    }

    private void subscribeFirstItem(CategoryStateObserver observer) {
        if (currentObserver == null) {
            currentObserver = observer;
            currentObserver.updateState();
        }
    }

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
        subscribeFirstItem(holder);
        View.OnClickListener listener = v -> subscribe(holder);
        holder.bindData(category, listener);
        holders.add(holder);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    protected final static class CategoryViewHolder extends RecyclerView.ViewHolder implements CategoryStateObserver {
        private final CategoryItemBinding binding;
        private boolean isSelected = false;

        public CategoryViewHolder(CategoryItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(Category category, View.OnClickListener onClickListener) {
            binding.categoryName.setText(category.getCategoryName());
            binding.categoryIcon.setImageResource(category.getImageResourceId());
            binding.getRoot().setOnClickListener(onClickListener);
        }

        @Override
        public void updateState() {
            if (isSelected) {
                unselectHolder();
            } else {
                selectHolder();
            }
        }

        private void selectHolder() {
            binding.categoryIcon.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(255, 110, 78)));
            binding.categoryName.setTextColor(Color.rgb(255, 110, 78));
            binding.categoryIcon.setImageTintList(ColorStateList.valueOf(Color.WHITE));
            isSelected = true;
        }

        private void unselectHolder() {
            binding.categoryIcon.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
            binding.categoryName.setTextColor(Color.rgb(1, 0, 53));
            binding.categoryIcon.setImageTintList(ColorStateList.valueOf(Color.rgb(179, 179, 195)));
            isSelected = false;
        }
    }
}
