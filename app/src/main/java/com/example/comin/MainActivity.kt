package com.example.comin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.comin.Auth.LoginActivity
import com.example.comin.Auth.MyCominActivity
import com.example.comin.Zzim.ZzimActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom.*

class MainActivity : AppCompatActivity(){

    internal lateinit var viewpager : ViewPager

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        val img = arrayOf(
            R.drawable.premium,
            R.drawable.square,
            R.drawable.treasure,
            R.drawable.sidedish
        )

        val text = arrayOf(
            "프리미엄 도시락",
            "사각 도시락",
            "보물 도시락",
            "반찬 및 음료"
        )

        val gridviewAdapter = GridviewAdapter(this, img,text)
        gridview.adapter = gridviewAdapter

        gridview.setOnItemClickListener { adapterView, view, i, l ->


            val intent = Intent(this, LectureActivity::class.java)
            intent.putExtra("grid_p",i);
            startActivity(intent)

        }

        viewpager = findViewById(R.id.viewpager) as ViewPager

        val adapter = ViewpagerAdapter(this)
        viewpager.adapter = adapter

        zzim_icon.setOnClickListener {
            val intent = Intent(this, ZzimActivity::class.java)
            startActivity(intent)
        }

        my_page.setOnClickListener {
            if(auth.currentUser ==null){
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, MyCominActivity::class.java)
                startActivity(intent)
            }

        }


    }
}
