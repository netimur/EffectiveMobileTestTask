package com.netimur.effectivemobiletesttask.ui.mycart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netimur.effectivemobiletesttask.data.model.MyCart;
import com.netimur.effectivemobiletesttask.databinding.FragmentMyCartBinding;

final public class MyCartFragment extends Fragment implements MyCartView {
    private FragmentMyCartBinding binding;
    private MyCartPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMyCartBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        presenter = new MyCartPresenterImplementation(this);
        presenter.requestMyCart();
        return view;
    }

    @Override
    public void showMyCart(MyCart myCart) {

    }
}