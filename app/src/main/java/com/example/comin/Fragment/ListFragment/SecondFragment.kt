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
import kotlinx.android.synthetic.main.fragment_second.view.*

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view : View = inflater.inflate(R.layout.fragment_second,container,false)

        val list_array = arrayListOf<ContentsListModel>(

            ContentsListModel(R.drawable.second1,"치킨샐러드",1,""),
            ContentsListModel(R.drawable.second2,"계란말이",1,"d"),
            ContentsListModel(R.drawable.second3,"해물파전",1,"d"),
            ContentsListModel(R.drawable.second4,"군만두",1,"d"),
            ContentsListModel(R.drawable.second5,"핫도그",1,"d"),
            ContentsListModel(R.drawable.second6,"카레",1,"d"),
            ContentsListModel(R.drawable.second7,"김치찌개",1,"d"),
            ContentsListModel(R.drawable.second8,"녹두전",1,"d"),
            ContentsListModel(R.drawable.second9,"오징어젓갈",1,"d"),
            ContentsListModel(R.drawable.second10,"김치",1,"d"),
            ContentsListModel(R.drawable.second11,"콜라 및 사이다",1,"d")

        )

        val list_adapter =
            SecondFragAdapter(
                requireContext(),
                list_array
            )
        view.listview_second_fragment.adapter = list_adapter

        FirebaseUtils.db
            .collection("zzim")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener { documentSnapshot ->
                if(documentSnapshot.exists() == true){

                }else {
                    val lecture = hashMapOf(
                        "치킨샐러드" to "",
                        "계란말이" to "",
                        "해물파전" to "",
                        "군만두" to "",
                        "핫도그" to "",
                        "카레" to "",
                        "김치찌개" to "",
                        "녹두전" to "",
                        "오징어젓갈" to "",
                        "김치" to "",
                        "콜라 및 사이다" to ""
                    )

                    FirebaseUtils.db
                        .collection("zzim")
                        .document(FirebaseUtils.getUid())
                        .set(lecture)
                        .addOnSuccessListener { }
                        .addOnFailureListener { }
                }
            }
            .addOnFailureListener { }

        view.listview_second_fragment.setOnItemClickListener { adapterView, view,i, l ->

            val intent = Intent(requireContext(),MarketInfoActivity::class.java)
            intent.putExtra("title",list_array.get(i).title)
            startActivity(intent)
        }

        return view
    }

}
