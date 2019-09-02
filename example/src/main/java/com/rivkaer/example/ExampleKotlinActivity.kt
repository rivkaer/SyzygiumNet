package com.rivkaer.example

import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.rivkaer.example.models.net.Movie
import com.rivkaer.example.net.ExampleNET
import com.rivkaer.example.base.BaseActivity
import com.rivkaer.moonnet.extend.defaultSetting
import com.rivkaer.moonnet.model.BaseResultBean
import io.reactivex.functions.Action
import io.reactivex.observers.DefaultObserver
import kotlinx.android.synthetic.main.activity_example_kotlin.*

/**
 * @author: Junjian Jia
 * @Date: 2019/7/12 22:26
 * @Email: cnrivkaer@outlook.com
 * @Description: 测试kotlin demo
 */
class ExampleKotlinActivity : BaseActivity() {

    lateinit var adapter: BaseQuickAdapter<Movie, BaseViewHolder>

    override fun setLayoutRes(): Any = R.layout.activity_example_kotlin

    override fun initData() {
        adapter = object : BaseQuickAdapter<Movie, BaseViewHolder>(R.layout.adapter_movie) {
            override fun convert(helper: BaseViewHolder?, item: Movie?) {
                if (helper != null && item != null) {
                    val itemView = helper.getView<AppCompatImageView>(R.id.view_item_image)
                    Glide.with(mContext).load(item.picture).into(itemView)
                    helper.setText(R.id.view_item_name, item.name)
                }
            }
        }
        val manager: GridLayoutManager = GridLayoutManager(mContext, 2)
        view_content_list.layoutManager = manager
        view_content_list.adapter = adapter
    }

    private var currentPage: Int = 0

    override fun initView() {
        view_content_refresh.setOnRefreshListener {
            currentPage = 0;
            requestMovie(true, currentPage)
        }
        view_content_refresh.setOnLoadMoreListener {
            currentPage++
            requestMovie(false, currentPage)
        }
        view_content_refresh.autoRefresh()
    }

    /**
     * 获取电影数据
     */
    private fun requestMovie(isRefresh: Boolean, page: Int) {
        ExampleNET.exampleNet().fetchMovie(page).defaultSetting()
            .doOnTerminate(object : Action {
                override fun run() {
                    if (view_content_refresh != null) {
                        view_content_refresh.finishLoadMore()
                        view_content_refresh.finishRefresh()
                    }
                }
            })
            .subscribe(object : DefaultObserver<BaseResultBean<List<Movie>>>(){
                override fun onComplete() {

                }

                override fun onNext(t: BaseResultBean<List<Movie>>) {
                    val data = t.data
                    if (adapter != null && data != null) {
                        if (isRefresh) {
                            adapter.setNewData(data)
                            return
                        }
                        adapter.addData(data)
                    }
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            })
    }
}