package com.cuong.app.cnote.utils;

import android.view.Window;
import android.view.WindowManager;

public final class ScreenUtils {
    public static void setFullScreen(Window window) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
