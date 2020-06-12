package com.example.aleks_vitomskov_shop

import org.junit.Assert.assertEquals
import org.junit.Test

/*Написать функцию форматирования цены, которая принимает:
- цену в виде дробного числа
- единицу измерения (по-умолчанию "шт.")
- скидку в процентах как целое число
Если есть скидка, то программа должна вывести данные в формате <ЦЕНА СО СКИДКОЙ>/<ЕДИНИЦА ИЗМЕРЕНИЯ> (скидка <СКИДКА>%). Например, 113/кг (скидка 5%)
Если скидки нет, то формат следующий: <ЦЕНА>/<ЕДИНИЦА ИЗМЕРЕНИЯ>
На максимальный балл:
Если цена целая - вывести только целую часть
Если цена дробная - вывести её с точностью до 2 символа
*/

class PricePrinter {
    fun PriceFormat(price : Double, measure: String, discount: Int = 0) : String{
        val finalPrice : String
        if((discount > 0) and (discount <= 100)){
            //вычисляем цену по скидке
            val discountPrice : Double = ((100 - discount)*price)/100;
            //определяем, целое число или дробное
            if (Math.floor(discountPrice) == (discountPrice)) {
                //число целое - цена без дробной части
                finalPrice  = Math.floor(discountPrice).toInt().toString()
            } else {
                //число дробное - цена с дробной частью
                finalPrice = String.format("%.2f", discountPrice);
            }
            return "$finalPrice/$measure (скидка $discount%)"
        }
        else if (discount == 0){
            //определяем, целое число или дробное
            if (Math.floor(price) == (price)) {
                //число целое - цена без дробной части
                finalPrice  = Math.floor(price).toInt().toString()
            } else {
                //число дробное - цена с дробной частью
                finalPrice = String.format("%.2f", price);
            }
            //выводим цену без скидки
            return "$finalPrice/$measure"
        }
        else{
            return "Скидка не может принимать значение меньше 0 или больше 100"
        }
    }

    @Test
    fun test() {
        assertEquals("7,50/kg (скидка 25%)", PriceFormat(10.0, "kg", 25));

    }

}