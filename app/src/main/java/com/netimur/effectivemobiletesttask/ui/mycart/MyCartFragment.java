package com.netimur.effectivemobiletesttask.ui.mycart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.netimur.effectivemobiletesttask.R;
import com.netimur.effectivemobiletesttask.data.model.MyCart;
import com.netimur.effectivemobiletesttask.databinding.FragmentMyCartBinding;
import com.netimur.effectivemobiletesttask.ui.mycart.cartitems.CartItemsRecyclerViewAdapter;

final public class MyCartFragment extends Fragment implements MyCartView {
    private FragmentMyCartBinding binding;
    private MyCartPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMyCartBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        hideBottomNavigationBar();
        presenter = new MyCartPresenterImplementation(this);
        presenter.requestMyCart();
        binding.backButton.setOnClickListener(v -> Navigation.findNavController(binding.getRoot()).navigateUp());
        return view;
    }

    @Override
    public void showMyCart(MyCart myCart) {
        binding.deliveryCost.setText(myCart.getDelivery());
        binding.totalCost.setText("$" + String.valueOf(myCart.getTotal()));
        CartItemsRecyclerViewAdapter adapter = new CartItemsRecyclerViewAdapter(this.getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        adapter.setCartItems(myCart.getCartItems());
        binding.myCartRecyclerview.setLayoutManager(linearLayoutManager);
        binding.myCartRecyclerview.setAdapter(adapter);
        setBottomNavigationBadge(myCart.getCartItems().size());
    }

    private void hideBottomNavigationBar() {
        BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_navigation);
        navBar.setVisibility(View.INVISIBLE);
    }

    private void setBottomNavigationBadge(int badgeCount) {
        BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation);
        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.myCartFragment);
        badgeDrawable.setNumber(badgeCount);
    }
}