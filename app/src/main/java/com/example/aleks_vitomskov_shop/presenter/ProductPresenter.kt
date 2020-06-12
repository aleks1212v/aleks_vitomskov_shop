package com.example.aleks_vitomskov_shop.presenter

import com.example.aleks_vitomskov_shop.domain.ViewedProductDao
import com.example.aleks_vitomskov_shop.domain.model.Product
import moxy.MvpPresenter

class ProductPresenter(private val viewedProductDao: ViewedProductDao):
    MvpPresenter<ProductView>()  {
    fun onProductShow(product: Product) {
        viewedProductDao.addProduct(product.id)
    }
}