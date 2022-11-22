package com.netimur.effectivemobiletesttask.ui.productdetails;

import com.netimur.effectivemobiletesttask.data.model.DetailsResponseBody;
import com.netimur.effectivemobiletesttask.data.network.ApplicationResponseCallback;
import com.netimur.effectivemobiletesttask.utils.AbstractPresenter;

final public class ProductDetailsPresenterImplementation extends AbstractPresenter implements ProductDetailsPresenter, ApplicationResponseCallback {
    private final ProductDetailsView view;

    public ProductDetailsPresenterImplementation(ProductDetailsView view) {
        this.view = view;
    }

    @Override
    public void requestProductDetails() {
        apiService.requestDetails(this);
    }

    @Override
    public <T> void onSuccess(T body) {
        DetailsResponseBody detailsResponseBody = (DetailsResponseBody) body;
        view.showProductDetails(detailsResponseBody);
    }

    @Override
    public void onError() {

    }
}
