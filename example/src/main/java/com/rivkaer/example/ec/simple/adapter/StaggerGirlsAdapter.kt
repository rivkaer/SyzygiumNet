package com.rivkaer.example.ec.simple.adapter

import android.support.v7.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.rivkaer.example.R
import com.rivkaer.example.base.bean.Welfare

class StaggerGirlsAdapter(layoutResId: Int, data: List<Welfare>) :
        BaseQuickAdapter<Welfare, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder?, item: Welfare?) {
        val img = helper!!.getView<AppCompatImageView>(R.id.appIv)

        val options = RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .skipMemoryCache(true)
                .error(R.drawable.ic_error)
                .placeholder(R.drawable.ic_load)

        Glide.with(mContext).load(item!!.url).apply(options).into(img)
    }
}