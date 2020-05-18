package com.example.comin.ShoppingCart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.comin.R
import kotlinx.android.synthetic.main.shopping_cart_item.view.*

//img:음식 사진 name:음식 이름, price:음식 가격, total_price:음식 별 총금액, delete_button: 삭제버튼,
class ShoppingCartAdapter(val context : Context, val list_array : ArrayList<String>):BaseAdapter() {

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view : View = LayoutInflater.from(context).inflate(R.layout.shopping_cart_item,null)
        view.shopping_cart_text.text = list_array.get(p0)
        return view
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return list_array.size
    }
}