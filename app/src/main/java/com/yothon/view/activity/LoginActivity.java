package com.yothon.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yothon.view.BaseActivity;
import com.yothon.view.R;
import com.yothon.view.adapter.LoginRecyclerAdapter;
import com.yothon.view.model.Data;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：Yoshon
 * on 2016/11/18 15:14
 * 邮箱：wanyouxin@parim.net
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private List<Data> datas;
    private LoginRecyclerAdapter adapter;
    private LinearLayoutManager layoutManager;
    private Handler mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 0:
                        overridePendingTransition(R.anim.to_alpha, R.anim.from_alpha);// 淡出淡入动画效果
                        break;
                }
            }
        };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_layout);
        ButterKnife.bind(this);
        datas = new ArrayList<>();
        datas.add(new Data("View"));
        datas.add(new Data("ViewGroup"));
        initView();
    }

    private void initView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter =  new LoginRecyclerAdapter(this,datas);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new LoginRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(LoginActivity.this,ViewActivity.class);
                        startActivity(intent);
                        mHandler.sendEmptyMessage(0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(LoginActivity.this,ViewGroupActivity.class);
                        startActivity(intent1);
                        mHandler.sendEmptyMessage(0);
                        break;
                }
            }

        });
    }
}
