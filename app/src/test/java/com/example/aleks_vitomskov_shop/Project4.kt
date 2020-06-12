package com.example.aleks_vitomskov_shop

import org.junit.Assert.assertEquals
import org.junit.Test

/**Реализовать интерфейс PricePrinter на классе
 * и использовать этот класс внутри теста в качестве реализации PricePrinter.
 * Можно сделать несколько реализаций PricePrinter и использовать их
 * в разных частях программы.
 * Оценка будет выставляться в зависимости от простоты и читаемости решения:
 */
class Project4 {

    @Test
    fun example() {

        val iphoneCase = Product(price = 100.0, salePercent = 10)

        val pricePrinter1: PricePrinter = CleanKotlinPriceFormatter()
        val pricePrinter2: PricePrinter = NonCleanKotlinPriceFormatter()
        val pricePrinter3: PricePrinter = NoPriceFormatter()

        val discountIphoneCasePrice = iphoneCase.calcDiscountPrice()

        pricePrinter1.printPrice(discountIphoneCasePrice)
        pricePrinter2.printPrice(discountIphoneCasePrice)
        pricePrinter3.printPrice(discountIphoneCasePrice)

        assertEquals(0, 0)
    }


    class Product(
        /**
         * Must be positive
         */
        private val price: Double,
        private val salePercent: Int = 0
    ) {
        /**
         * @return price with applied discount determined by [salePercent]
         *
         * If [salePercent] is more than 100 than product will have negative price
         * If [salePercent] less than 0 product price will be increased
         */
        fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)
    }

    interface PricePrinter {

        /**
         * Outputs price in <PRICE>P format.
         * If price have not fractional part than it will be printed as integer
         * If price have fractional part than it will be rounded for 2 symbols after "."
         */
        fun printPrice(price: Double)
    }

    class CleanKotlinPriceFormatter : PricePrinter { //реализация интерфейса

        override fun printPrice(price: Double) {
            if (price == kotlin.math.floor(price)) {
                println(price.toInt())
            } else {
                println(price)
            }
        }
    }

    class NonCleanKotlinPriceFormatter : PricePrinter { //реализация интерфейса

        override fun printPrice(price: Double) {
            if (price == java.lang.Math.floor(price)) {
                println(price.toInt())
            } else {
                println(price)
            }
        }
    }

    class NoPriceFormatter : PricePrinter { //реализация интерфейса

        override fun printPrice(price: Double) {
            println(price)
        }
    }
}

