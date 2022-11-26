package com.netimur.effectivemobiletesttask.ui.mainpage.bestseller;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
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

final public class BestSellerRecyclerviewAdapter extends RecyclerView.Adapter<BestSellerRecyclerviewAdapter.BestSellerViewHolder> {
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
        private boolean isFavoriteButtonSelected;

        public BestSellerViewHolder(BestSellerCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(BestSeller bestSeller) {
            ImageView imageView = binding.cardImage;
            Picasso.get().load(bestSeller.getPictureUrl()).into(imageView);
            binding.currentPrice.setText("$" + String.valueOf(bestSeller.getDiscountPrice()));
            CharSequence oldPrice = Html.fromHtml("<s>" + "$" + String.valueOf(bestSeller.getPriceWithoutDiscount()) + "</s>");
            binding.oldPrice.setText(oldPrice);
            binding.productName.setText(bestSeller.getTitle());
            if (bestSeller.isFavorites()) {
                binding.isFavoriteTag.setImageResource(R.drawable.ic_baseline_favorite_24);
            }
            isFavoriteButtonSelected = bestSeller.isFavorites();
            binding.isFavoriteTag.setOnClickListener(v -> updateState());
        }

        private void updateState() {
            if (isFavoriteButtonSelected) {
                deselectFavourite();
            } else {
                selectFavourite();
            }
        }

        private void selectFavourite() {
            isFavoriteButtonSelected = true;
            binding.isFavoriteTag.setImageResource(R.drawable.ic_baseline_favorite_24);
        }

        private void deselectFavourite() {
            isFavoriteButtonSelected = false;
            binding.isFavoriteTag.setImageResource(R.drawable.ic_outline_favorite_border_24);
        }

    }
}
