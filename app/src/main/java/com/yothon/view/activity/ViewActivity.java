package com.yothon.view.activity;

import android.os.Bundle;
import android.widget.Toast;

import com.yothon.view.BaseActivity;
import com.yothon.view.R;
import com.yothon.view.widget.CircleImage;
import com.yothon.view.widget.RectMultGraphView;
import com.yothon.view.widget.TopBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：Yoshon
 * on 2016/11/17 14:47
 * 邮箱：wanyouxin@parim.net
 */
public class ViewActivity extends BaseActivity {
    @BindView(R.id.topbar)
    TopBar topbar;
    @BindView(R.id.circle)
    CircleImage circle;
    @BindView(R.id.rect)
    RectMultGraphView rect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        ButterKnife.bind(this);
        topbar.setOnTopbarClickListener(new TopBar.topbarOnClickListener() {
            @Override
            public void leftOnClick() {
                Toast.makeText(ViewActivity.this,"back",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightOnClick() {
                Toast.makeText(ViewActivity.this,"more",Toast.LENGTH_SHORT).show();
            }
        });
        circle.setText("你好哈哈");
        circle.setTextSize(24);
        circle.setSweepValue(200);
    }
}
