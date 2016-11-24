package com.yothon.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.yothon.view.utils.ScreenUtils;

/**
 * 作者：Yoshon
 * on 2016/11/23 14:31
 * 邮箱：wanyouxin@parim.net
 */
public class ClockView extends View {
    private Paint paint;
    private int mScreenWidth;
    private int mScreenHeight;
    private int radius;
    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        mScreenHeight = ScreenUtils.getScreenHeight(context);
        mScreenWidth = ScreenUtils.getScreenWidth(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        radius = mScreenWidth/2-40;
        canvas.drawCircle(mScreenWidth/2,mScreenHeight/2,radius,paint);
        Paint paint2 = new Paint();
        for (int i = 0; i < 12; i++) {
            if (i==0||i==3||i==6||i==9){
                paint2.setStrokeWidth(5);
                paint2.setTextSize(30);
                canvas.drawLine(mScreenWidth/2,mScreenHeight/2-radius,mScreenWidth/2,mScreenHeight/2-radius+30,paint2);
                String str =  String.valueOf(i);
                canvas.drawText(str,mScreenWidth/2-paint2.measureText(str)/2,mScreenHeight/2-radius+60,paint2);
            }else {
                paint2.setStrokeWidth(2);
                paint2.setTextSize(15);
                canvas.drawLine(mScreenWidth/2,mScreenHeight/2-radius,mScreenWidth/2,mScreenHeight/2-radius+15,paint2);
                String str = String.valueOf(i);
                canvas.drawText(str,mScreenWidth/2-paint2.measureText(str)/2,mScreenHeight/2-radius+40,paint2);
            }
            canvas.rotate(30,mScreenWidth/2,mScreenHeight/2);
        }
        Paint paint3 = new Paint();
        paint3.setStrokeWidth(40);
        paint3.setAntiAlias(true);
        paint3.setStyle(Paint.Style.FILL);
        Paint paint4 = new Paint();
        paint4.setStrokeWidth(20);
        paint4.setAntiAlias(true);
        paint4.setStyle(Paint.Style.FILL);
        canvas.save();
        canvas.translate(mScreenWidth/2,mScreenHeight/2);
        canvas.drawLine(0,0,100,100,paint3);
        canvas.drawLine(0,0,100,200,paint4);
        canvas.restore();
    }
}
