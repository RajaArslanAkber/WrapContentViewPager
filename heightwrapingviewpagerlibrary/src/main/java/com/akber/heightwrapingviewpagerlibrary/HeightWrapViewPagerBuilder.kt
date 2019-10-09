package com.akber.heightwrapingviewpagerlibrary

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

open class HeightWrapViewPagerBuilder private constructor(
    private val mViewPager: HeightWrapViewPager,
    private val pageTitles: List<String>,
    private val fragmentsList: List<Fragment>,
    private val fragmentManager: FragmentManager
) {
    private constructor(builder: Builder) : this(
        builder.mViewPager,
        builder.pageTitles,
        builder.fragmentsList,
        builder.fragmentManager
    ) {
        initViewPager()
    }

    companion object {
        fun create(init: Builder.() -> Unit) = Builder(init).build()
    }

    class Builder private constructor() {
        constructor(init: Builder.() -> Unit) : this() {
            init()
        }

        lateinit var mViewPager: HeightWrapViewPager
        lateinit var pageTitles: List<String>
        lateinit var fragmentsList: List<Fragment>
        lateinit var fragmentManager: FragmentManager


        fun mViewPager(init: Builder.() -> HeightWrapViewPager) = apply { mViewPager = init() }

        fun pageTitles(init: Builder.() -> List<String>) = apply { pageTitles = init() }

        fun fragmentsList(init: Builder.() -> List<Fragment>) = apply { fragmentsList = init() }

        fun fragmentManager(init: Builder.() -> FragmentManager) =
            apply { fragmentManager = init() }

        fun build() = HeightWrapViewPagerBuilder(this)


    }

    private fun initViewPager() {
        val viewPagerAdapter = HeightWrapViewPagerAdapter(fragmentManager)
        viewPagerAdapter.setFragments(fragmentsList)
        viewPagerAdapter.setPageTitles(pageTitles)
        mViewPager.adapter = viewPagerAdapter
    }
}