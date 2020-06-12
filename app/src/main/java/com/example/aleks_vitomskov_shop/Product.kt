package com.example.aleks_vitomskov_shop

class Product(
    /**
     * Must be positive
     */
    private val price: Double,
    private val salePercent: Int = 0,
    private val productName: String
) {
    fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)
    fun getProductName(): String = productName
}
