package com.example.comin.Fragment.MarketInfo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
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

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_area, ContentFragment())
            .commit()

        figure_1.setOnClickListener {

            figure_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25f)
            figure_2.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15f)
            figure_3.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15f)

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_area, ContentFragment())
                .commit()
        }

        figure_2.setOnClickListener {

            figure_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15f)
            figure_2.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25f)
            figure_3.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15f)

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_area, InfoFragment())
                .commit()
        }

        figure_3.setOnClickListener {

            figure_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15f)
            figure_2.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15f)
            figure_3.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25f)

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_area, ReviewFragment())
                .commit()
        }

    }
}