package com.yothon.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者：Yoshon
 * on 2016/11/23 09:50
 * 邮箱：wanyouxin@parim.net
 */
public class DrawView extends View {
    private Paint paint1;
    private Paint paint2;
    private Paint paint3;
    private Paint paint4;
    private Paint paint5;
    private Paint paint6;
    private String str = "hello world";

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint1 = new Paint();
        paint1.setColor(Color.BLUE);
        paint1.setAntiAlias(true);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(6);
        paint2 = new Paint();
        paint2.setColor(Color.BLUE);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(false);
        paint2.setStrokeWidth(6);
        paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setColor(Color.BLUE);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(6);
        paint3.setAntiAlias(false);
        paint4 = new Paint(Color.BLUE);
        paint4.setColor(Color.BLUE);
        paint4.setAntiAlias(true);
        paint4.setStrokeWidth(6);
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setAntiAlias(true);
        paint5 = new Paint(Color.BLUE);
        paint5.setColor(Color.BLUE);
        paint5.setAntiAlias(true);
        paint5.setStrokeWidth(6);
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setAntiAlias(true);
        paint6 = new Paint();
        paint6.setColor(Color.BLUE);
        paint6.setStyle(Paint.Style.FILL);
        paint6.setAntiAlias(true);
        paint6.setTextSize(100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(100,500,500,900,-90,270,false,paint1);
        canvas.drawLine(10,10,60,60,paint2);
        canvas.drawRect(10,100,120,220,paint3);
        canvas.drawCircle(330,330,50,paint4);
        canvas.drawOval(200,300,700,400,paint5);
        canvas.drawText(str,100,800,paint6);

    }
}
