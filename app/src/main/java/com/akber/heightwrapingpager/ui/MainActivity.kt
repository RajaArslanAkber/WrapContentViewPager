package com.akber.heightwrapingpager.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.akber.heightwrapingpager.R
import com.akber.heightwrapingviewpagerlibrary.HeightWrapViewPagerBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        HeightWrapViewPagerBuilder.create {
            this.mViewPager = pager
            this.pageTitles = getTitlesList()
            this.fragmentsList = getFragmentsList()
            this.fragmentManager = supportFragmentManager
        }
        tabs.setupWithViewPager(pager)

    }

    private fun getTitlesList(): List<String> {
        val titles = ArrayList<String>()
        titles.add(getString(R.string.page_1))
        titles.add(getString(R.string.page_2))
        titles.add(getString(R.string.page_3))
        titles.add(getString(R.string.page_4))
        titles.add(getString(R.string.page_5))
        titles.add(getString(R.string.page_6))
        return titles
    }

    private fun getFragmentsList(): List<Fragment> {
        val fragments = ArrayList<Fragment>()
        fragments.add(ChildFragment.newInstance(getString(R.string.page_1)))
        fragments.add(ChildFragment.newInstance(getString(R.string.page_2)))
        fragments.add(ChildFragment.newInstance(getString(R.string.page_3)))
        fragments.add(ChildFragment.newInstance(getString(R.string.page_4)))
        fragments.add(ChildFragment.newInstance(getString(R.string.page_5)))
        fragments.add(ChildFragment.newInstance(getString(R.string.page_6)))
        return fragments
    }

}
