package com.example.comin.Fragment.MarketInfo
//
import android.content.Intent
import android.graphics.Color
import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.TypedValue
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.comin.R
import com.example.comin.Utils.FirebaseUtils
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_market_info.*

class MarketInfoActivity : AppCompatActivity() {


    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market_info)


        lecture_text.text = intent.getStringExtra("title")
        lecture_review_count.text = intent.getStringExtra("category")//카테고리 변경을 위함
        food_information.text = intent.getStringExtra("information")
        price_real_text.text = intent.getStringExtra("price")//제품마다 가격도 변경해주기 위함

        FirebaseUtils.db
            .collection("zzim")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener {documentSnapshot ->

                if(documentSnapshot.get(intent.getStringExtra("title"))==true){

                    header_zzim.text = "하트뿅뿅 찜 되었습니다."
                    header_zzim.setTextColor(Color.BLUE)
                }

            }

       plus_button.setOnClickListener {
           var count =Integer.parseInt(count_text.text.toString())
            count++
            count_text.setText(count.toString())

        }

        minus_button.setOnClickListener {
            var count =Integer.parseInt(count_text.text.toString())
            if(count>1)
                count--
            count_text.setText(count.toString())
        }

        zzim.setOnClickListener {

            if (header_zzim.text.equals("하트뿅뿅 찜 되었습니다.")) {
                header_zzim.text = "하트뿅뿅 찜"
                header_zzim.setTextColor(Color.RED)

                FirebaseUtils.db
                    .collection("zzim")
                    .document(FirebaseUtils.getUid())
                    .update(intent.getStringExtra("title"), "")
                    .addOnSuccessListener {
                        Toast.makeText(this, "성공", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "실패", Toast.LENGTH_LONG).show()
                    }

            } else {

                header_zzim.text = "하트뿅뿅 찜 되었습니다."
                header_zzim.setTextColor(Color.BLUE)

                FirebaseUtils.db
                    .collection("zzim")
                    .document(FirebaseUtils.getUid())
                    .update(intent.getStringExtra("title"), true)
                    .addOnSuccessListener {
                        Toast.makeText(this, "성공", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "실패", Toast.LENGTH_LONG).show()
                    }
            }
        }

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_area, ContentFragment())
//            .commit()

//        selection_menu.setOnClickListener {
//
//            selection_menu.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25f)
//            information_menu.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15f)
//            review_menu.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15f)
//
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_area, ContentFragment())
//                .commit()
//        }
//
//        information_menu.setOnClickListener {
//
//            selection_menu.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15f)
//            information_menu.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25f)
//            review_menu.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15f)
//
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_area, InfoFragment())
//                .commit()
//        }
//
//        review_menu.setOnClickListener {
//
//            selection_menu.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15f)
//            information_menu.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15f)
//            review_menu.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25f)
//
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_area, ReviewFragment())
//                .commit()
//        }

    }

}






