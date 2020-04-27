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
import kotlinx.android.synthetic.main.fragment_square.view.*

/**
 * A simple [Fragment] subclass.
 */
class SquareFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view :View = inflater.inflate(R.layout.fragment_square, container, false)
        val category = "사각도시락"
        val list_array = arrayListOf<ContentsListModel>(

            ContentsListModel(R.drawable.square1,"메가고기고기",1,"7,900원", category),
            ContentsListModel(R.drawable.square2,"생선까스도련님고기고기",1,"5,500원", category),
            ContentsListModel(R.drawable.square3,"돈까스도련님고기고기",1,"5,500원", category),
            ContentsListModel(R.drawable.square4,"탕수육도련님고기고기",1,"5,600원",category),
            ContentsListModel(R.drawable.square5,"새치 고기고기",1,"6,000원",category),
            ContentsListModel(R.drawable.square6,"돈치 고기고기",1,"5,200원",category),
            ContentsListModel(R.drawable.square7,"고기고기",1,"4,000원",category),
            ContentsListModel(R.drawable.square8,"제육 김치찌개 정식",1,"8,000원",category),
            ContentsListModel(R.drawable.square9,"고등어 불고기 정식",1,"7,000원",category),
            ContentsListModel(R.drawable.square10,"콤비네이션 정식",1,"6,000원",category),
            ContentsListModel(R.drawable.square11,"숯불직화구이",1,"6,500원",category),
            ContentsListModel(R.drawable.square12,"소불고기",1,"5,000원",category),
            ContentsListModel(R.drawable.square13,"메가치킨제육",1,"6,900원",category),
            ContentsListModel(R.drawable.square14,"생선까스도련님",1,"3,900원",category),
            ContentsListModel(R.drawable.square15,"칠리 찹쌀탕수육도련님",1,"4,000원",category),
            ContentsListModel(R.drawable.square16,"오리지널 찹쌀탕수육",1,"4,700원",category),
            ContentsListModel(R.drawable.square17,"동백",1,"5,000원",category),
            ContentsListModel(R.drawable.square18,"치킨제육",1,"4,400원",category),
            ContentsListModel(R.drawable.square19,"국화",1,"4,200원",category),
            ContentsListModel(R.drawable.square20,"돈까스도련님",1,"3,900원",category),
            ContentsListModel(R.drawable.square21,"제육볶음",1,"3,900원",category),
            ContentsListModel(R.drawable.square22,"한솥밥",1,"1,000원",category),
            ContentsListModel(R.drawable.square23,"현미밥",1,"1,700원",category)


        )

        val list_adapter =
            SquareFragAdapter(
                requireContext(),
                list_array
            )
        view.listview_square_fragment.adapter = list_adapter

        FirebaseUtils.db
            .collection("zzim")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists() == true){

                }else{
                    val lecture = hashMapOf(
                        "메가고기고기" to "",
                        "생선까스도련님고기고기" to "",
                        "돈까스도련님고기고기" to "",
                        "탕수육도련님고기고기" to "",
                        "새치 고기고기" to "",
                        "돈치 고기고기" to "",
                        "고기고기" to "",
                        "제육 김치찌개 정식" to "",
                        "고등어 불고기 정식" to "",
                        "콤비네이션 정식" to "",
                        "숯불직화구이" to "",
                        "소불고기" to "",
                        "메가치킨제육" to "",
                        "생선까스도련님" to "",
                        "칠리 찹쌀탕수육도련님" to "",
                        "오리지널 찹쌀탕수육" to "",
                        "동백" to "",
                        "치킨제육" to "",
                        "국화" to "",
                        "돈까스도련님" to "",
                        "제육볶음" to "",
                        "한솥밥" to "",
                        "현미밥" to ""
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

        view.listview_square_fragment.setOnItemClickListener { adapterView, view,i, l ->

            val intent = Intent(requireContext(), MarketInfoActivity::class.java)
            intent.putExtra("title",list_array.get(i).title)
            intent.putExtra("category",list_array.get(i).category)
            intent.putExtra("price",list_array.get(i).price)//제품도 가격마다 바꾸기 위함
            startActivity(intent)

        }


        return view
    }
}
