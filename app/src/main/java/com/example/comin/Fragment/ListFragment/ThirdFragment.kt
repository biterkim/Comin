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
import kotlinx.android.synthetic.main.fragment_third.view.*

/**
 * A simple [Fragment] subclass.
 */
class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view :View =inflater.inflate(R.layout.fragment_third, container, false);

        val list_array = arrayListOf<ContentsListModel>(
//
//            ContentsListModel(R.drawable.list3_1,"메가불닭치킨 고로케",1,""),
//            ContentsListModel(R.drawable.list3_2,"메가불닭참치 고로케",1,"d"),
//            ContentsListModel(R.drawable.list3_3,"메가불닭치킨 케이준",1,"d"),
//            ContentsListModel(R.drawable.list3_4,"메가불닭참치 케이준",1,"d"),
//            ContentsListModel(R.drawable.list3_5,"메가불닭치킨마요",1,"d"),
//            ContentsListModel(R.drawable.list3_6,"메가불닭참치마요",1,"d"),
//            ContentsListModel(R.drawable.list3_7,"피자불고기마요",1,"d"),
//            ContentsListModel(R.drawable.list3_8,"피자치킨마요",1,"d"),
//            ContentsListModel(R.drawable.list3_9,"갈비치킨마요",1,"d")
        )

        val list_adapter =
            ThirdFragAdapter(
                requireContext(),
                list_array
            )
        view.listview_third_fragment.adapter = list_adapter

        FirebaseUtils.db
            .collection("zzim")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists() == true){

                }else{
                    val lecture = hashMapOf(
                        "메가불닭치킨 고로케" to "",
                        "메가불닭참치 고로케" to "",
                        "메가불닭치킨 케이준" to "",
                        "메가불닭참치 케이준" to "",
                        "메가불닭치킨마요" to "",
                        "메가불닭참치마요" to "",
                        "피자불고기마요" to "",
                        "피자치킨마요" to "",
                        "갈비치킨마요" to ""
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

        view.listview_third_fragment.setOnItemClickListener { adapterView, view,i, l ->

            val intent = Intent(requireContext(), MarketInfoActivity::class.java)
            intent.putExtra("title",list_array.get(i).title)
            startActivity(intent)

        }

        return view
    }

}
