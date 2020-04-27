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
import kotlinx.android.synthetic.main.fragment_treasure.view.*

/**
 * A simple [Fragment] subclass.
 */
class TreasureFragment : Fragment() { //

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view :View =inflater.inflate(R.layout.fragment_treasure, container, false);
        val category = "보물도시락"
        val list_array = arrayListOf<ContentsListModel>(

            ContentsListModel(R.drawable.list3_1,"메가불닭치킨 고로케",1,"한솥 시그니처 메뉴인 '마요'시리즈와 삼양 불닭소스의 콜라보 (+감자고로케+ 피크닉)세트","8200원",category),
            ContentsListModel(R.drawable.list3_2,"메가불닭참치 고로케",1,"한솥 시그니처 메뉴인 '마요'시리즈와 삼양 불닭소스의 콜라보 (+감자고로케+ 피크닉)세트","8200원",category),
            ContentsListModel(R.drawable.list3_3,"메가불닭치킨 케이준",1,"한솥 시그니처 메뉴인 '마요'시리즈와 삼양 불닭소스의 콜라보 (+케이준 후라이+ 피크닉)세트","7700원",category),
            ContentsListModel(R.drawable.list3_4,"메가불닭참치 케이준",1,"한솥 시그니처 메뉴인 '마요'시리즈와 삼양 불닭소스의 콜라보 (+케이준 후라이+ 피크닉)세트","7700원",category),
            ContentsListModel(R.drawable.list3_5,"메가불닭치킨마요",1,"한솥 시그니처 메뉴인 '마요'시리즈와 삼양 불닭소스의 콜라보","6400원",category),
            ContentsListModel(R.drawable.list3_6,"메가불닭참치마요",1,"한솥 시그니처 메뉴인 '마요'시리즈와 삼양 불닭소스의 콜라보","6400원",category),
            ContentsListModel(R.drawable.list3_7,"피자불고기마요",1,"한솥 베스트셀러인 마요가 소불고기피자로 변신! 부드러운 3종 믹스치즈, 소불고기, 피자소스의 조화","4700원",category),
            ContentsListModel(R.drawable.list3_8,"피자치킨마요",1,"한솥 베스트셀러인 치킨마요가 피자로 변신! 부드러운 3종믹스 치즈, 치킨, 피자소스의 조화","4500원",category),
            ContentsListModel(R.drawable.list3_9,"갈비치킨마요",1,"10여가지 국산 과일과 채소를 넣어 만든 특제 '한솥갈비소스'로 감칠맛이 가득한 정통갈비구이 맛을 구현했습니다.","3200원",category)
        )

        val list_adapter =
            TreasureFragAdapter(
                requireContext(),
                list_array
            )
        view.listview_treasure_fragment.adapter = list_adapter

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

        view.listview_treasure_fragment.setOnItemClickListener { adapterView, view,i, l ->

            val intent = Intent(requireContext(), MarketInfoActivity::class.java)
            intent.putExtra("title",list_array.get(i).title)
            intent.putExtra("category",list_array.get(i).category)
            intent.putExtra("price",list_array.get(i).price)//제품도 가격마다 바꾸기 위함
            startActivity(intent)

        }

        return view
    }

}
