package com.yothon.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.yothon.view.utils.ScreenUtils;

import java.util.Random;

/**
 * 作者：Yoshon
 * on 2016/11/17 16:39
 * 邮箱：wanyouxin@parim.net
 */
public class RectMultGraphView extends View {
    private Paint mPaint;
    private int mWidth;
    private Random random;
    private float currentHeight;
    private int width;
    private int height;
    private int mRectWidth;
    private LinearGradient linearGradient;


    public RectMultGraphView(Context context){
        super(context);
    }

    public RectMultGraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mWidth = ScreenUtils.getScreenWidth(context);
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(3);

    }





    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < 5; i++) {
            random = new Random();
            currentHeight = random.nextInt(100);
            canvas.drawRect(
                    (float)(mWidth*0.2+mRectWidth*i+5),
                    currentHeight,
                    (float)(mWidth*0.2+mRectWidth*(i+1)),
                    height,
                    mPaint
            );
//            postInvalidateDelayed(500);
        }
//        postInvalidateDelayed(300);
//        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getWidth();
        height = getHeight();
        mRectWidth = (int) (mWidth * 0.4 / 5);
        linearGradient = new LinearGradient(
                0,
                0,
                mRectWidth,
                height,
                Color.BLUE,
                Color.GREEN,
                Shader.TileMode.CLAMP
        );
        mPaint.setShader(linearGradient);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
