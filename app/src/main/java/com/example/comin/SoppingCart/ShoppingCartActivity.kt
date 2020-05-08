package com.example.comin.SoppingCart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comin.R
import kotlinx.android.synthetic.main.activity_shopping_cart.*

class ShoppingCartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)

        //결제하기 버튼 클릭
        pay_button.setOnClickListener {

        }
    }
}
