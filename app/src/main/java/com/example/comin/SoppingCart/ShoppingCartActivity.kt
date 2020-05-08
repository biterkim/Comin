package com.example.comin.SoppingCart

import android.content.Intent
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
            //카카오페이 결제버튼 눌렀을 때
            var intent= Intent(this,KakaoPayActivity::class.java)
            //장바구니 메뉴들
            intent.putExtra("menu","치킨마요")
            intent.putExtra("price",5000)
            startActivity(intent)
        }
    }
}
