package com.yothon.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.yothon.view.utils.ScreenUtils;

/**
 * 作者：Yoshon
 * on 2016/11/17 15:21
 * 邮箱：wanyouxin@parim.net
 */
public class CircleImage extends View {

    private int mCircleXY = 0;
    private int screenWidth;
    private float mRadius;
    private RectF rectF;
    private Paint paint1;
    private Paint paint2;
    private Paint paint3;
    private float mSweepAngle = 0;
    private String mText = "你好";
    private float mTextSize;

    public CircleImage(Context context) {
        this(context, null);
    }

    public CircleImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        screenWidth = ScreenUtils.getScreenWidth(context);
        mCircleXY = screenWidth / 2;
        mRadius = (float) (screenWidth * 0.3 / 2);
        rectF = new RectF(
                (float) (screenWidth * 0.3),
                (float) (screenWidth * 0.3),
                (float) (screenWidth * 0.7),
                (float) (screenWidth * 0.7)
        );
        paint1 = new Paint();
        paint1.setColor(Color.RED);
        paint2 = new Paint();
        paint2.setColor(Color.BLUE);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(40);
        paint3 = new Paint();
        paint3.setColor(Color.BLACK);
        paint3.setTextSize(mTextSize);

    }

    public void setTextSize(float size) {
        this.mTextSize = size;
        this.invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //圆形
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, paint1);
        //弧形
        canvas.drawArc(rectF, 270, mSweepAngle, false, paint2);
        //文字
        // 测量字体宽度，根据字体的宽度设置在圆环中间
        float textWidth = paint3.measureText(mText);
        paint3.setTextSize(mTextSize);
        canvas.drawText(mText, 0, mText.length(), mCircleXY-(textWidth/2), mCircleXY + (mTextSize / 4), paint3);
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setSweepValue(float sweepvalue) {
        if (sweepvalue != 0) {
            mSweepAngle = sweepvalue;
        } else {
            mSweepAngle = 25;
        }
        this.invalidate();
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }
}
