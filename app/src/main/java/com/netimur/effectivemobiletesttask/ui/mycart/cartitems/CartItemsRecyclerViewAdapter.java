package com.netimur.effectivemobiletesttask.ui.mycart.cartitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.netimur.effectivemobiletesttask.data.model.CartItem;
import com.netimur.effectivemobiletesttask.databinding.MyCartCardBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

final public class CartItemsRecyclerViewAdapter extends RecyclerView.Adapter<CartItemsRecyclerViewAdapter.CartItemViewHolder> {
    private List<CartItem> cartItems;
    private final Context context;

    public CartItemsRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setCartItems(List<CartItem> cartItems) {

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
        return cartItems.size();
    }

    class CartItemViewHolder extends RecyclerView.ViewHolder {
        private final MyCartCardBinding binding;

        public CartItemViewHolder(MyCartCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(CartItem cartItem) {
            binding.itemName.setText(cartItem.getTitle());
            binding.price.setText(cartItem.getPrice());
            ImageView imageView = binding.itemPreview;
            Picasso.get().load(cartItem.getImages()).fit().centerCrop().into(imageView);
        }
    }
}
