package com.example.comin.BuyHistory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comin.R
import com.example.comin.Utils.FirebaseUtils
import kotlinx.android.synthetic.main.activity_buy_history.*


class BuyHistoryActivity : AppCompatActivity() {

    val array_list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_history)

        FirebaseUtils.db
            .collection("buy_history")
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

                val buyhistoryAdapter = BuyHistoryAdapter(this,array_list)
                buy_history_listview.adapter = buyhistoryAdapter

            }
            .addOnFailureListener {  }
    }
}
