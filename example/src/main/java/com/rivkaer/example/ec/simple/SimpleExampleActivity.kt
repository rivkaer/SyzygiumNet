package com.rivkaer.example.ec.simple

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import com.rivkaer.example.R
import com.rivkaer.example.base.bean.Welfare
import com.rivkaer.example.ec.simple.adapter.StaggerGirlsAdapter
import com.rivkaer.example.ec.simple.impl.SimplePresenter
import kotlinx.android.synthetic.main.activity_simple.*

class SimpleExampleActivity : AppCompatActivity(), ISimpleContract.ISimpleView {

    private val simplePresenter: ISimpleContract.ISimplePresenter = SimplePresenter()
    private var adapter: StaggerGirlsAdapter? = null
    private val data: MutableList<Welfare> = ArrayList<Welfare>()
    private var pager = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
        simplePresenter.attachView(this)

        adapter = StaggerGirlsAdapter(R.layout.adapter_simple_girls, data)
        adapter!!.setEnableLoadMore(true)
        adapter!!.setHasStableIds(true)

        val manager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        manager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        rv_content.layoutManager = manager
        rv_content.adapter = adapter

        simplePresenter.rquestGrils(true,10,pager)

        refresh.setOnRefreshListener {
            simplePresenter.rquestGrils(false, data.size, 1)
        }

        adapter!!.bindToRecyclerView(rv_content)

        adapter!!.setOnLoadMoreListener {
            simplePresenter.rquestGrils(true, 6, pager)
        }

    }

    override fun load(type: Boolean, list: List<Welfare>) {
        if (type) {
            val empty = data.isEmpty()
            data.addAll(list)
            if (empty) {
                adapter!!.notifyDataSetChanged()
            } else {
                val newSize = data.size - list.size
                adapter!!.notifyItemRangeInserted(newSize, list.size)
                adapter!!.loadMoreComplete()
                if (list.isEmpty()) adapter!!.loadMoreEnd()
            }
            pager++
        } else {
            data.clear()
            data.addAll(list)
            adapter!!.notifyDataSetChanged()
            refresh.isRefreshing = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        simplePresenter.detachView()
    }
}
