package com.rivkaer.example;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rivkaer.moonlib.base.BaseActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {

    private final static List<String> funcList = Arrays.asList(
            "Kotlin"
    );

    @BindView(R.id.view_content_list)
    RecyclerView vContentList;

    private BaseQuickAdapter adapter;

    @NonNull
    @Override
    protected Object setLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        adapter = new BaseQuickAdapter<String, BaseViewHolder>(android.R.layout.simple_list_item_1) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(android.R.id.text1, item)
                        .setBackgroundColor(android.R.id.text1, Color.DKGRAY)
                        .setTextColor(android.R.id.text1, Color.WHITE);
            }
        };
        vContentList.setLayoutManager(new LinearLayoutManager(mContext));
        vContentList.setAdapter(adapter);
        adapter.addData(funcList);
    }

    @Override
    protected void initView() {
        if (adapter != null) {
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    if (position == 0){
                        startActivity(new Intent(MainActivity.this, ExampleKotlinActivity.class));
                    }
                }
            });
        }
    }
}
