package com.rivkaer.example;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * <p>@ProjectName:     WeedNet</p>
 * <p>@ClassName:       ExampleActivity</p>
 * <p>@PackageName:     com.rivkaer.example</p>
 * <b>
 * <p>@Description:     测试用例活动</p>
 * </b>
 * <p>@author:          Rivkaer Jia</p>
 * <p>@date:            2019/10/15 20:21</p>
 * <p>@email:           cnrivkaer@outlook.com</p>
 */
public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
    }
}