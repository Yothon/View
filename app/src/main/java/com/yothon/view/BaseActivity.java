package com.yothon.view;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
                && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();

//      set transparent status and let main layout extend to status
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

//      set transparent navigation and let main layout extend to navigation
//      window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

            ViewGroup mContentView = (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
//      set contentView rootView padding in order to set aside the location of the power strip
            View rootView = mContentView.getChildAt(0);
            if (rootView != null){
          rootView.setFitsSystemWindows(true);
//                rootView.setPadding(0,getStatusBarHeight(this),0,0);
            }*/
//        }
    }


}
