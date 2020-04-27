package com.example.comin.Fragment.ListFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.comin.Fragment.MarketInfo.MarketInfoActivity

import com.example.comin.R
import com.example.comin.Utils.FirebaseUtils
import kotlinx.android.synthetic.main.fragment_premium.view.*

/**
 * A simple [Fragment] subclass.
 */
class PremiumFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view :View = inflater.inflate(R.layout.fragment_premium, container, false)
        val category = "프리미엄도시락"
        val list_array = arrayListOf<ContentsListModel>(

            ContentsListModel(R.drawable.premium_1,"매화(치킨, 연어구이)",1,"10,000원", category),
            ContentsListModel(R.drawable.premium_2,"매화(순살 고등어데리야끼)",1,"10,000원", category),
            ContentsListModel(R.drawable.premium_3,"진달래",1,"7,000원", category),
            ContentsListModel(R.drawable.premium_4,"개나리(순살 고등어 간장구이)",1,"8,000원",category)

        )

        val list_adapter =
            PremiumFragAdapter(
                requireContext(),
                list_array
            )
        view.listview_premium_fragment.adapter = list_adapter

        FirebaseUtils.db
            .collection("zzim")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists() == true){

                }else{
                    val lecture = hashMapOf(
                        "매화(치킨, 연어구이)" to "",
                        "매화(순살 고등어데리야끼)" to "",
                        "진달래" to "",
                        "개나리(순살 고등어 간장구이)" to ""
                    )

                    FirebaseUtils.db
                        .collection("zzim")
                        .document(FirebaseUtils.getUid())
                        .set(lecture)
                        .addOnSuccessListener {  }
                        .addOnFailureListener {  }

                }
            }
            .addOnFailureListener {  }

        view.listview_premium_fragment.setOnItemClickListener { adapterView, view,i, l ->

            val intent = Intent(requireContext(), MarketInfoActivity::class.java)
            intent.putExtra("title",list_array.get(i).title)
            intent.putExtra("category",list_array.get(i).category)
            intent.putExtra("price",list_array.get(i).price)//제품도 가격마다 바꾸기 위함
            startActivity(intent)

        }


        return view
    }

}
