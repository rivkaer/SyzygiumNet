package com.rivkaer.example;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.widget.ImageView;

import com.rivkaer.example.app.MoonNet;
import com.rivkaer.example.net.ExampleNET;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    AppCompatImageView simpleImageView;
    AppCompatButton simpleBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleImageView = findViewById(R.id.iv_simple);
        simpleBtn = findViewById(R.id.btn_simple);

        simpleBtn.setOnClickListener(v -> {
        });
    }

    private boolean saveFileToDisc(ResponseBody body) {

        try {
            InputStream in = null;
            FileOutputStream out = null;

            try {
                in = body.byteStream();
                out = new FileOutputStream(getExternalFilesDir(null) + File.separator + "AndroidTutorialPoint.jpg");
                int c;

                while ((c = in.read()) != -1) {
                    out.write(c);
                }
            } catch (IOException e) {
                Log.d("DownloadImage", e.toString());
                return false;
            } finally {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }

            int width, height;
            Bitmap bMap = BitmapFactory.decodeFile(getExternalFilesDir(null) + File.separator + "AndroidTutorialPoint.jpg");
            width = 2 * bMap.getWidth();
            height = 6 * bMap.getHeight();
            Bitmap bMap2 = Bitmap.createScaledBitmap(bMap, width, height, false);
            simpleImageView.setImageBitmap(bMap2);

            return true;
        } catch (IOException e) {
            Log.d("DownloadImage", e.toString());
            return false;
        }
    }
}
