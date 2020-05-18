package com.example.comin.ShoppingCart

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

//img:음식 사진 name:음식 이름, price:음식 가격, total_price:음식 별 총금액, delete_button: 삭제버튼,
class ShoppingCartAdapter(val img: String, val name: String, val price: String, total_price:String, val delete_button: String  ):BaseAdapter() {
    var cartList = arrayListOf<ShoppingCartAdapter>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        if(convertView == null){

        }
    }

    override fun getItem(position: Int): Any {
        return cartList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return cartList.size
    }
}