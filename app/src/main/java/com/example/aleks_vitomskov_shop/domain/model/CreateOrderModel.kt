package com.example.aleks_vitomskov_shop.domain.model

/*
*  Модель для создания заказа.
*/
data class CreateOrderModel(
    var firstName:String = "",
    var secondName: String = "",
    var middleName: String = "",
    var phone: String = ""
)