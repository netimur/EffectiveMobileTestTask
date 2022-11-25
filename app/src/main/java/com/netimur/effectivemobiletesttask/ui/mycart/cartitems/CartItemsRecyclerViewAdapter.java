package com.netimur.effectivemobiletesttask.ui.mycart.cartitems;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.netimur.effectivemobiletesttask.data.model.CartItem;
import com.netimur.effectivemobiletesttask.databinding.MyCartCardBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

final public class CartItemsRecyclerViewAdapter extends RecyclerView.Adapter<CartItemsRecyclerViewAdapter.CartItemViewHolder> {
    private List<CartItem> cartItems = new ArrayList<>();
    private final Context context;

    public CartItemsRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        return new CartItemViewHolder(MyCartCardBinding.inflate(layoutInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemViewHolder holder, int position) {
        CartItem cartItem = cartItems.get(position);
        holder.bindData(cartItem);
    }

    @Override
    public int getItemCount() {
        Log.d("DEBUG", "getItemCount: " + cartItems);
        return cartItems.size();
    }

    static class CartItemViewHolder extends RecyclerView.ViewHolder {
        private final MyCartCardBinding binding;
        private int itemCount = 1;

        public CartItemViewHolder(MyCartCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(CartItem cartItem) {
            binding.itemName.setText(cartItem.getTitle());
            binding.price.setText("$" + String.valueOf(cartItem.getPrice()));
            binding.itemCount.setText(String.valueOf(itemCount));
            ImageView imageView = binding.itemPreview;
            Picasso.get().load(cartItem.getImages()).fit().centerCrop().into(imageView);
            binding.removeItemButton.setOnClickListener(v -> {
                if (Integer.parseInt(binding.itemCount.getText().toString()) > 1) {
                    itemCount--;
                    updateCount();
                }
            });
            binding.addItemButton.setOnClickListener(v -> {
                itemCount++;
                updateCount();
            });
        }

        private void updateCount() {
            binding.itemCount.setText(String.valueOf(itemCount));
        }
    }
}
