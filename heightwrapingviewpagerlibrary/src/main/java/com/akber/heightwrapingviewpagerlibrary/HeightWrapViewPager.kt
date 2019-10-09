package com.akber.heightwrapingviewpagerlibrary

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.viewpager.widget.ViewPager


class HeightWrapViewPager : ViewPager {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val a = context.theme.obtainStyledAttributes(
            attrs, R.styleable.HeightWrapViewPager, 0, 0
        )
        try {
            mMinHeight =
                a.getDimensionPixelSize(R.styleable.HeightWrapViewPager_minViewPagerHeight, 0)
        } finally {
        }
    }

    private var mMinHeight: Int = 0
    private var mCurrentView: View? = null

    fun measureCurrentView(currentView: View?) {
        mCurrentView = currentView
        requestLayout()
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        @Suppress("NAME_SHADOWING") var heightMeasureSpec = heightMeasureSpec
        if (mCurrentView == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            return
        }
        var height = 0
        mCurrentView?.measure(
            widthMeasureSpec,
            MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
        )
        val h = mCurrentView?.measuredHeight
        if (h != null) {
            if (h > height) height = h
        }
        if (height == 0) {
            height = this.mMinHeight
        }
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY)

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}
