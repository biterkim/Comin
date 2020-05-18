package com.example.comin.ShoppingCart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comin.R
import com.example.comin.ShoppingCart.KakaoPayActivity
import com.example.comin.Utils.FirebaseUtils
import kotlinx.android.synthetic.main.activity_shopping_cart.*

class ShoppingCartActivity : AppCompatActivity() {

    val array_list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)

        FirebaseUtils.db
            .collection("carts")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener { documentSnapshot ->

                if(documentSnapshot.get("Lang1") != ""){
                    array_list.add("Lang1")
                }
                if(documentSnapshot.get("Lang2") != ""){
                    array_list.add("Lang2")
                }
                if(documentSnapshot.get("Lang3") != ""){
                    array_list.add("Lang3")
                }
                if(documentSnapshot.get("Lang4") != ""){
                    array_list.add("Lang4")
                }
                if(documentSnapshot.get("Lang5") != ""){
                    array_list.add("Lang5")
                }
                if(documentSnapshot.get("Lang6") != ""){
                    array_list.add("Lang6")
                }
                if(documentSnapshot.get("Lang7") != ""){
                    array_list.add("Lang7")
                }
                if(documentSnapshot.get("Lang8") != ""){
                    array_list.add("Lang8")
                }
                if(documentSnapshot.get("Lang9") != ""){
                    array_list.add("Lang9")
                }

                val ShoppingcartAdapter = ShoppingCartAdapter(this,array_list)
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