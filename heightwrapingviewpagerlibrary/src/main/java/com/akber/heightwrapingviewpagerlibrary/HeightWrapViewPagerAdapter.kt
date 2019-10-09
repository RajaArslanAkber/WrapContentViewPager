package com.akber.heightwrapingviewpagerlibrary

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import android.view.ViewGroup

internal class HeightWrapViewPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var mCurrentPosition: Int? = -1
    private var mFragmentsList = ArrayList<Fragment>()
    private var mFragmentsTitle = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragmentsList[position]
    }

    override fun getCount(): Int {
        return mFragmentsList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentsTitle[position]
    }

    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
        super.setPrimaryItem(container, position, `object`)
        if (position != mCurrentPosition) {
            val fragment = `object` as Fragment
            val pager = container as HeightWrapViewPager
            if (fragment.view != null) {
                mCurrentPosition = position
                pager.measureCurrentView(fragment.view)
            }
        }
    }

    fun setFragments(fragments: List<Fragment>) {
        this.mFragmentsList.clear()
        this.mFragmentsList.addAll(fragments)
    }

    fun setPageTitles(titles: List<String>) {
        this.mFragmentsTitle.clear()
        this.mFragmentsTitle.addAll(titles)
    }

}
