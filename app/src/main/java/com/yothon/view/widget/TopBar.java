package com.yothon.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yothon.view.R;

/**
 * 作者：Yoshon
 * on 2016/11/15 15:32
 * 邮箱：wanyouxin@parim.net
 */
public class TopBar extends RelativeLayout {


    private int leftTextColor;
    private int rightTextColor;
    private Drawable leftdrawable;
    private Drawable rightdrawable;
    private int titleColor;
    private String leftText;
    private String rightText;
    private String title;
    private float titleSize;
    private Context context;
    private Button leftButton;
    private Button rightButton;
    private TextView textView;
    private LayoutParams leftParams;
    private LayoutParams rightParams;
    private LayoutParams titleParams;

    private topbarOnClickListener mlistener;

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        leftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);
        rightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, 0);
        leftdrawable = ta.getDrawable(R.styleable.TopBar_leftBackgroundColor);
        rightdrawable = ta.getDrawable(R.styleable.TopBar_rightBackgroundColor);
        titleColor = ta.getColor(R.styleable.TopBar_titleTextColor, 0);
        leftText = ta.getString(R.styleable.TopBar_leftText);
        rightText = ta.getString(R.styleable.TopBar_rightText);
        title = ta.getString(R.styleable.TopBar_title);
        titleSize = ta.getDimension(R.styleable.TopBar_titleTextSize, 10);
        //recycle 方法来避免重新创建的时候的错误
        ta.recycle();
        addView();
    }

    public void addView() {
        leftButton = new Button(context);
        rightButton = new Button(context);
        textView = new TextView(context);
        leftButton.setTextColor(leftTextColor);
        rightButton.setTextColor(rightTextColor);
        textView.setTextColor(titleColor);

        leftButton.setText(leftText);
        rightButton.setText(rightText);
        textView.setText(title);

        leftButton.setBackground(leftdrawable);
        rightButton.setBackground(rightdrawable);

        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mlistener.leftOnClick();
            }
        });

        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mlistener.rightOnClick();
            }
        });

        textView.setTextSize(titleSize);
        textView.setGravity(Gravity.CENTER);

        leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        addView(leftButton,leftParams);

        rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        addView(rightButton,rightParams);

        titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        addView(textView,titleParams);

    }


    public void setOnTopbarClickListener(topbarOnClickListener listener){
        this.mlistener = listener;
    }

    public interface topbarOnClickListener{
        void leftOnClick();

        void rightOnClick();
    }

}
