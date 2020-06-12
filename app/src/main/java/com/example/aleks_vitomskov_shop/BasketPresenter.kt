package com.example.aleks_vitomskov_shop

import com.example.aleks_vitomskov_shop.ui.BasketView
import moxy.MvpPresenter

class BasketPresenter: MvpPresenter<BasketView>() {
    private val basket = Basket(mutableListOf(
        Product(12000.0, 30, "Планшет Samsung"),
        Product(15000.0, 10, "Планшет Huawei"),
        Product(25000.0, 15, "Планшет Iphone"),
        Product(12500.0, 12, "Планшет Samsung"),
        Product(15500.0, 17, "Планшет Huawei"),
        Product(25500.0, 13, "Планшет Iphone"),
        Product(13000.0, 23, "Планшет Explay"),
        Product(16000.0, 25, "Планшет Huawei"),
        Product(26000.0, 19, "Планшет Iphone"),
        Product(11000.0, 21, "Планшет Samsung"),
        Product(14000.0, 33, "Планшет Huawei"),
        Product(24000.0, 31, "Планшет Iphone")
    ))

    fun setData(){
        viewState.setProducts(basket.products)
    }

    fun removeItem(productName: String){
        val position = basket.products.indexOf(
            basket.products.find { product -> product.getProductName() == productName }
        )
        basket.products.removeAt(position)
        viewState.removeItem(position)
    }
}