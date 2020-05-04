package com.example.comin.BuyHistory

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.comin.R
import kotlinx.android.synthetic.main.buy_history_item.view.*

class BuyHistoryAdapter(val context : Context, val list_array : ArrayList<String>) : BaseAdapter(){
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view : View = LayoutInflater.from(context).inflate(R.layout.buy_history_item,null)
        view.buy_history_text.text = list_array.get(p0)
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