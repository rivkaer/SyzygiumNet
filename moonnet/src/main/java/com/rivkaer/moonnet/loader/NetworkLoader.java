package com.rivkaer.moonnet.loader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatDialog;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.rivkaer.moonnet.R;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * @author: Jia Junjian
 * @date: 2019/5/10
 * @email: cnrivkaer@outlook.com
 * @describe: 网络框架加载框
 **/
public class NetworkLoader {

    private static final int LOADER_SIZE_SCALE = 8;

    private static final int LOADER_OFFSET_SCALE = 10;

    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();

    private static final String DEFAULT_LOADER = LoaderStyle.BallClipRotatePulseIndicator.name();

    public static void showLoading(Context context, Enum<LoaderStyle> styleEnum) {
        showLoading(context, styleEnum.name());
    }

    public static void showLoading(Context context, String type) {
        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.network_dialog);

        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(type, context);
        dialog.setContentView(avLoadingIndicatorView);
        avLoadingIndicatorView.setIndicatorColor(Color.parseColor("#FF3D45"));

        int deviceWidth = getScreenWidth(context);
        int deviceHeight = getScreenHeight(context);

        final Window dialogWindow = dialog.getWindow();

        if (dialogWindow != null) {
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = deviceWidth / LOADER_SIZE_SCALE;
            lp.height = deviceHeight / LOADER_SIZE_SCALE;
            lp.height = lp.height + deviceHeight / LOADER_OFFSET_SCALE;
            lp.gravity = Gravity.CENTER;
        }
        LOADERS.add(dialog);
        dialog.show();
    }

    public static void showLoading(Context context) {
        showLoading(context, DEFAULT_LOADER);
    }

    public static void stopLoading() {
        for (AppCompatDialog dialog : LOADERS) {
            if (dialog != null) {
                if (dialog != null) {
                    dialog.cancel();
                }
            }
        }
    }

    public static int getScreenWidth(Context context) {
        final Resources resources = context.getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        final Resources resources = context.getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
