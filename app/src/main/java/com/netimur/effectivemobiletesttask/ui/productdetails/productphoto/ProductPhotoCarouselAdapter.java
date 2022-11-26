package com.netimur.effectivemobiletesttask.ui.productdetails.productphoto;


import android.view.View;
import android.widget.ImageView;

import androidx.constraintlayout.helper.widget.Carousel;

import com.squareup.picasso.Picasso;

import java.util.List;

final public class ProductPhotoCarouselAdapter implements Carousel.Adapter {
    private final List<String> urls;

    public ProductPhotoCarouselAdapter(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public int count() {
        return urls.size();
    }

    @Override
    public void populate(View view, int index) {
        ImageView imageView = (ImageView) view;
        Picasso.get().load(urls.get(index)).fit().centerCrop().into(imageView);
    }

    @Override
    public void onNewItem(int index) {
      
    }
}
