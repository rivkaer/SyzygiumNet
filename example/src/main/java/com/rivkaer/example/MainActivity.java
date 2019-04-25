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
            ExampleNET
                    .exampleNet()
                    .urlImage("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556215538108&di=8330792ff9ccf2d9e06586b286acbb58&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F9%2F5450ae2fdef8a.jpg")
                    .subscribeOn(Schedulers.newThread())
                    .map(responseBody -> {
                        InputStream inputStream= responseBody.byteStream();
                        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                        byte[] buffer = new byte[1024];
                        byte[] bmp_buffer;
                        int len = 0;
                        while( (len=inputStream.read(buffer)) != -1){
                            outStream.write(buffer, 0, len);
                        }
                        outStream.close();
                        inputStream.close();
                        bmp_buffer=outStream.toByteArray();
                        return BitmapFactory.decodeByteArray(bmp_buffer, 0, bmp_buffer.length);
                    }).observeOn(AndroidSchedulers.mainThread())//在Android主线程中展示
                    .subscribe(new Observer<Bitmap>() {

                        ProgressDialog dialog = new ProgressDialog(getBaseContext());

                        @Override
                        public void onSubscribe(Disposable d) {
//                            dialog.show();
                        }

                        @Override
                        public void onNext(Bitmap bitmap) {
                            simpleImageView.setImageBitmap(bitmap);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d("tag", "onError ===== " + e.toString());
                        }

                        @Override
                        public void onComplete() {
//                            dialog.dismiss();
                        }
                    });
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
