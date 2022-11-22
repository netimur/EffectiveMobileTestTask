package com.netimur.effectivemobiletesttask.ui.mainpage.bestseller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.netimur.effectivemobiletesttask.R;
import com.netimur.effectivemobiletesttask.data.model.BestSeller;
import com.netimur.effectivemobiletesttask.databinding.BestSellerCardBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BestSellerRecyclerviewAdapter extends RecyclerView.Adapter<BestSellerRecyclerviewAdapter.BestSellerViewHolder> {
    private final Context context;
    private List<BestSeller> bestSellers = new ArrayList<>();

    public BestSellerRecyclerviewAdapter(Context context) {
        this.context = context;
    }

    public void setBestSellers(List<BestSeller> bestSellers) {
        this.bestSellers = bestSellers;
    }

    @NonNull
    @Override
    public BestSellerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        return new BestSellerViewHolder(BestSellerCardBinding.inflate(layoutInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BestSellerViewHolder holder, int position) {
        BestSeller currentBestSeller = bestSellers.get(position);
        holder.bindData(currentBestSeller);
    }

    @Override
    public int getItemCount() {
        return bestSellers.size();
    }

    class BestSellerViewHolder extends RecyclerView.ViewHolder {
        private BestSellerCardBinding binding;

        public BestSellerViewHolder(BestSellerCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(BestSeller bestSeller) {
            ImageView imageView = binding.cardImage;
            Picasso.get().load(bestSeller.getPictureUrl()).into(imageView);
            binding.currentPrice.setText(context.getString(R.string.dollar) + String.valueOf(bestSeller.getDiscountPrice()));
            binding.oldPrice.setText(String.valueOf(bestSeller.getPriceWithoutDiscount()));
            binding.productName.setText(bestSeller.getTitle());
            if (bestSeller.isFavorites()) {
                binding.isFavoriteTag.setImageResource(R.drawable.ic_heart_filled);
            }
        }
    }
}
