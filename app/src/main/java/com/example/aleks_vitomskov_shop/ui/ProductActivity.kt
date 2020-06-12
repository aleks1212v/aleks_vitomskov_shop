package com.example.aleks_vitomskov_shop.ui
import android.os.Bundle
import android.util.Log
import com.example.aleks_vitomskov_shop.R
import com.example.aleks_vitomskov_shop.data.ViewedProductDaoImpl
import com.example.aleks_vitomskov_shop.domain.model.Product
import com.example.aleks_vitomskov_shop.presenter.ProductPresenter
import com.example.aleks_vitomskov_shop.presenter.ProductView
import com.example.myapplication.ui.BaseActivity
import kotlinx.android.synthetic.main.product_layout.*
import moxy.ktx.moxyPresenter


class ProductActivity: BaseActivity(), ProductView {
    private val presenter by moxyPresenter {
        ProductPresenter(
            ViewedProductDaoImpl(sharedPreferences)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_layout)
        val product = intent?.getParcelableExtra<Product>(PRODUCT_TAG) ?: return

        productBackBtn.setOnClickListener(){
            finish()
        }
        Log.d("productName", product.productName.toString())
        productNameTv.text = product.productName
        presenter.onProductShow(product)
    }

    companion object {
        const val PRODUCT_TAG = "PRODUCT_TAG"
    }

}