package com.akber.heightwrapingpager.ui

import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.akber.heightwrapingpager.R
import kotlinx.android.synthetic.main.child_fragment.*

class ChildFragment : Fragment() {


    private lateinit var adapter: ChildFragmentAdapter
    private var currentType: String? = ""

    companion object {

        private val TYPE: String = "TYPE"

        fun newInstance(type: String): ChildFragment {
            val promoterDashboardStatsChildFragment = ChildFragment()
            val bundle = Bundle()
            bundle.putString(TYPE, type)
            promoterDashboardStatsChildFragment.arguments = bundle
            return promoterDashboardStatsChildFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            currentType = arguments?.getString(TYPE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.child_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ChildFragmentAdapter(activity, ArrayList())
        val layoutManager = LinearLayoutManager(activity)
        recycler.layoutManager = layoutManager
        recycler.addItemDecoration(DividerItemDecoration(activity, LinearLayoutManager.VERTICAL))
        recycler.adapter = adapter
        mockData()
    }

    private fun mockData() {
        val list: ArrayList<String> = ArrayList()

        for (i in 1 until 10) {
            list.add("Row $i")
        }
        adapter.update(list)
    }
}
