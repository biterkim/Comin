package com.example.comin.ShoppingCart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comin.R
import com.example.comin.ShoppingCart.KakaoPayActivity
import com.example.comin.Utils.FirebaseUtils
import kotlinx.android.synthetic.main.activity_shopping_cart.*
import java.util.*
import kotlin.collections.ArrayList

class ShoppingCartActivity : AppCompatActivity() {

    var menu_list = ArrayList<String>()
    var count_list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)

        FirebaseUtils.db
            .collection("carts")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener { documentSnapshot ->
                var map : Map<String,String> = documentSnapshot.getData() as Map<String, String>

                menu_list.addAll(map.keys)
                count_list.addAll(map.values)
                val ShoppingcartAdapter = ShoppingCartAdapter(this,menu_list,count_list)
                select_food_list.adapter = ShoppingcartAdapter

            }
            .addOnFailureListener {  }

        //결제하기 버튼 클릭
        pay_button.setOnClickListener {
            //카카오페이 결제버튼 눌렀을 때
            var intent = Intent(this, KakaoPayActivity::class.java)
            //장바구니 메뉴들
            intent.putExtra("menu","치킨마요")
            intent.putExtra("price",5000)
            startActivity(intent)
        }
    }
}