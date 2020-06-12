package com.example.aleks_vitomskov_shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity(), BasketView {
    private val presenter = BasketPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.totalPricePrint()
    }

    override fun print(prices: String) {
        Toast.makeText(this, "$prices", Toast.LENGTH_LONG).show()

    }
}
