package com.example.comin
//test 중 중dd
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.comin.Fragment.ListFragment.FragmentAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_lecture.*
import kotlinx.android.synthetic.main.custom_tab.view.*

class LectureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecture)

        val fragmentAdapter =
            FragmentAdapter(
                supportFragmentManager
            )
        list_viewpager.adapter = fragmentAdapter

        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("프리미엄")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("사각")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("보물")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("사이드")))
//        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("JPG")))
//        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("JS")))

        list_viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                if (p0 != null) {
                    list_viewpager.currentItem = p0.position
                }

            }

        })

    }

    private  fun createTabView(tabName:String) : View {

        val tabView = LayoutInflater.from(baseContext).inflate(R.layout.custom_tab, null)
        tabView.txt_name.text = tabName

        return tabView

    }
}
