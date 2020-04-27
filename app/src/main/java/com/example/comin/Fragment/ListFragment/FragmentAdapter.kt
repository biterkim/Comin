package com.example.comin.Fragment.ListFragment
//위에 탭 : 프리미엄, 사각, 보물, 사이드 네 개에 대한 프래그먼트 페이지
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        return  when(position) {
            0->{
                PremiumFragment() // 프리미엄도시락
            }
            1->{
                SquareFragment() // 사각도시락
            }
            2->{
                TreasureFragment() // 보물도시락
            }
            else -> {
                Side_Menu_Fragment() //사이드메뉴
            }
        }

    }

    override fun getCount(): Int {
        return 4

    }

}