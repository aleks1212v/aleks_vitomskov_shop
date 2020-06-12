package com.example.aleks_vitomskov_shop.domain.model

class Basket (var products: MutableList<Product> = mutableListOf()) {
    val discountSum get() = products.map {product -> product.salePercent}.sum()
    val fullSum get() = products.map {product -> product.price}.sum()
}