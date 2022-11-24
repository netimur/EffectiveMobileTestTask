package com.netimur.effectivemobiletesttask.ui.productdetails.productsetting.color;

public interface ColorPublisher {
    void subscribe(ColorStateObserver observer);
    void unsubscribe();
}
