package com.example.aleks_vitomskov_shop.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aleks_vitomskov_shop.presenter.BasketPresenter
import com.example.aleks_vitomskov_shop.domain.model.Product
import com.example.aleks_vitomskov_shop.R
import com.example.aleks_vitomskov_shop.presenter.BasketView
import com.example.aleks_vitomskov_shop.ui.ProductActivity.Companion.PRODUCT_TAG
import com.example.myapplication.ui.BaseActivity
import kotlinx.android.synthetic.main.basket_layout.*

class BasketActivity: BaseActivity(),
    BasketView {
    private val presenter = BasketPresenter()
    private val adapter = BasketAdapter(
        {product -> presenter.removeItem(product)},
        {product -> presenter.showProductDetails(product)}
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.basket_layout)
        basketBackBtn.setOnClickListener{
            startActivity(Intent(this, CatalogActivity::class.java))
        }

        basketRv.layoutManager = LinearLayoutManager(this)
        basketRv.adapter = adapter
        presenter.attachView(this)
        presenter.setData()
    }

    override fun setProducts(list: List<Product>) {
        adapter.setData(list)
    }

    override fun removeItem(position: Int) {
        adapter.notifyItemRemoved(position)
    }

    override fun showProductDetails(product: Product) {
        Log.d("productIds", product.id.toString())
        startActivity(Intent(this, ProductActivity::class.java).apply {
            putExtra(PRODUCT_TAG, product)
        })
    }
}
