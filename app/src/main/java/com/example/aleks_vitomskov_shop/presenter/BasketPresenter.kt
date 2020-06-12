package com.example.aleks_vitomskov_shop.presenter

import com.example.aleks_vitomskov_shop.domain.model.Basket
import com.example.aleks_vitomskov_shop.domain.model.Product
import moxy.MvpPresenter

class BasketPresenter: MvpPresenter<BasketView>() {
    private val basket = Basket(
        mutableListOf(
            Product(
                1,
                "Планшет Samsung1",
                12000.0,
                30
            ),
            Product(2,
                "Планшет Huawei1",
                15000.0,
                10
            ),
            Product(3,
                "Планшет Iphone1",
                25000.0,
                15
            ),
            Product(4,
                "Планшет Samsung2",
                12500.0,
                12
            ),
            Product(5,
                "Планшет Huawei2",
                15500.0,
                17
            ),
            Product(6,
                "Планшет Iphone2",
                25500.0,
                13
            ),
            Product(7,
                "Планшет Samsung3",
                13000.0,
                23
            ),
            Product(8,
                "Планшет Huawei3",
                16000.0,
                25
            ),
            Product(9,
                "Планшет Iphone3",
                26000.0,
                19
            ),
            Product(10,
                "Планшет Samsung4",
                11000.0,
                21

            ),
            Product(11,
                "Планшет Huawei4",
                14000.0,
                33

            ),
            Product(12,
                "Планшет Iphone4",
                24000.0,
                31
            )
        )
    )

    fun setData(){
        viewState.setProducts(basket.products)
    }

    fun removeItem(productName: String){
        val position = basket.products.indexOf(
            basket.products.find { product -> product.productName == productName }
        )
        basket.products.removeAt(position)
        viewState.removeItem(position)
    }

    fun showProductDetails(product: Product) {
        viewState.showProductDetails(product)
    }

}