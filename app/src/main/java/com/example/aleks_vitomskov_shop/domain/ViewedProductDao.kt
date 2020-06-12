package com.example.aleks_vitomskov_shop.domain

import com.example.aleks_vitomskov_shop.domain.model.Product

interface ViewedProductDao {
    /*
    * save this product id as viewed
    */
    fun addProduct(productID: Long)

    /*
    * get all viewed products ids
    * might be empty
    */
    fun getAllProducts():List<Long>

    fun getProductById(productId: Long): Product
}