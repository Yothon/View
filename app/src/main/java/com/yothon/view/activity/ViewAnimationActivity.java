package com.yothon.view.activity;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.yothon.view.BaseActivity;
import com.yothon.view.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：Yoshon
 * on 2016/11/28 14:26
 * 邮箱：wanyouxin@parim.net
 */
public class ViewAnimationActivity extends BaseActivity {
    @BindView(R.id.image1)
    ImageView image1;
    @BindView(R.id.image2)
    ImageView image2;
    @BindView(R.id.image3)
    ImageView image3;
    @BindView(R.id.image4)
    ImageView image4;
    @BindView(R.id.image5)
    ImageView image5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_layout);
        ButterKnife.bind(this);
        //透明度动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(2000);
        image1.setAnimation(alphaAnimation);
        //旋转动画
        RotateAnimation rotateAnimation = new RotateAnimation(0, 90, RotateAnimation.RELATIVE_TO_SELF, 0.5F, RotateAnimation.RELATIVE_TO_SELF, 0.5F);
        rotateAnimation.setDuration(2000);
        image2.setAnimation(rotateAnimation);
        //位移动画
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 100, 0, 200);
        translateAnimation.setDuration(2000);
        image3.setAnimation(translateAnimation);
        //位移
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        scaleAnimation.setDuration(2000);
        image4.setAnimation(scaleAnimation);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(2000);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        image5.setAnimation(animationSet);

    }
}
