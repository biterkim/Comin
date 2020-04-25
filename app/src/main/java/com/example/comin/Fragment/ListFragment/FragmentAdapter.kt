package com.example.comin.Fragment.ListFragment
//위에 탭 : 프리미엄, 사각, 보물, 사이드 네 개에 대한 프래그먼트 페이지
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        return  when(position) {
            0->{
                FirstFragment()
            }
            1->{
                SquareFragment()
            }
            2->{
                ThirdFragment()
            }
            else -> {
                SecondFragment()
            }
        }

    }

    override fun getCount(): Int {
        return 4

    }

}