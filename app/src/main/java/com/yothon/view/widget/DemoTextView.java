package com.yothon.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 作者：Yoshon
 * on 2016/11/15 14:44
 * 邮箱：wanyouxin@parim.net
 */
public class DemoTextView extends TextView {
    private Paint mPaint;
    private Paint mPaint2;
    public DemoTextView(Context context) {
        super(context);
    }

    public DemoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(getResources().getColor(android.R.color.holo_blue_bright));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //绘制外层矩形
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);
        //绘制内层矩形
        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,mPaint2);
        canvas.save();
        canvas.translate(0,0);//绘制文本前平移10个像素
        super.onDraw(canvas);
        canvas.restore();
    }
}
