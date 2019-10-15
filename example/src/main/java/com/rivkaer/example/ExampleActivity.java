package com.rivkaer.example;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.rivkaer.example.bean.BaseRespBean;
import com.rivkaer.example.constant.AppConstant;
import com.rivkaer.example.local.ExampleService;

import java.util.HashMap;
import java.util.Map;

import okio.Okio;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
public class ExampleActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatButton btnReqGet, btnReqPost;
    private TextView tvBodyContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        btnReqGet = findViewById(R.id.btnReqGet);
        btnReqPost = findViewById(R.id.btnReqPost);
        tvBodyContent = findViewById(R.id.tvBodyContent);

        btnReqGet.setOnClickListener(this);
        btnReqPost.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == null) {
            return;
        }
        switch (v.getId()) {
            case R.id.btnReqGet: {
                Call<BaseRespBean<String>> wReqGetCall = ExampleService.apis().reqGet("Hello Retrofit!!!");
                wReqGetCall.enqueue(new Callback<BaseRespBean<String>>() {
                    @Override
                    public void onResponse(Call<BaseRespBean<String>> call, Response<BaseRespBean<String>> response) {
                        String thisBody = response.body().getData();
                        if (tvBodyContent != null && !isFinishing()) {
                            tvBodyContent.setText(thisBody);
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseRespBean<String>> call, Throwable t) {
                        System.out.println("error message => " + t.getMessage());
                    }
                });
                break;
            }
            case R.id.btnReqPost: {
                Map<String, String> dMap = new HashMap<>();
                dMap.put(AppConstant.FUNC_HOST_REQ_KEY, AppConstant.FUNC_HOST_REQ_VALUE);
                Call<BaseRespBean<String>> wReqPostCall = ExampleService.apis().reqPost(dMap);
                wReqPostCall.enqueue(new Callback<BaseRespBean<String>>() {
                    @Override
                    public void onResponse(Call<BaseRespBean<String>> call, Response<BaseRespBean<String>> response) {
                        String thisBody = response.body().getData();
                        if (tvBodyContent != null && !isFinishing()) {
                            tvBodyContent.setText(thisBody);
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseRespBean<String>> call, Throwable t) {
                        System.out.println("error message => " + t.getMessage());
                    }
                });
                break;
            }
            default:

                break;
        }
    }
}