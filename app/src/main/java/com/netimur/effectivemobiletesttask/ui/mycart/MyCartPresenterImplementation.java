package com.netimur.effectivemobiletesttask.ui.mycart;

import com.netimur.effectivemobiletesttask.data.model.MyCart;
import com.netimur.effectivemobiletesttask.data.network.ApplicationResponseCallback;
import com.netimur.effectivemobiletesttask.utils.AbstractPresenter;

final public class MyCartPresenterImplementation extends AbstractPresenter implements MyCartPresenter, ApplicationResponseCallback {
    private final MyCartView view;

    public MyCartPresenterImplementation(MyCartView view) {
        this.view = view;
    }

    @Override
    public void requestMyCart() {
        apiService.requestMyCart(this);
    }

    @Override
    public <T> void onSuccess(T body) {
        MyCart myCart = (MyCart) body;
        view.showMyCart(myCart);
    }

    @Override
    public void onError() {

    }
}
