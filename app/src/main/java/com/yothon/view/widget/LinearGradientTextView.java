package com.yothon.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 作者：Yoshon
 * on 2016/11/15 15:01
 * 邮箱：wanyouxin@parim.net
 */
public class LinearGradientTextView extends TextView {
    private Paint mPaint;
    private int mViewWidth;
    private LinearGradient linearGradient;
    private Matrix matrix;
    private int mTranslate;

    public LinearGradientTextView(Context context) {
        super(context);
    }

    public LinearGradientTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                mPaint = getPaint();
                //参数一为渐变起初点坐标x位置，参数二为y轴位置，参数三和四分辨对应渐变终点，最后参数为平铺方式
                // CLAMP重复最后一个颜色至最后
                // MIRROR重复着色的图像水平或垂直方向已镜像方式填充会有翻转效果
                // REPEAT重复着色的图像水平或垂直方向
                linearGradient = new LinearGradient(0,
                        0,
                        mViewWidth,
                        0,
                        new int[]{
                                Color.BLUE,0xffffffff,
                                Color.BLUE
                        },
                        null,
                        Shader.TileMode.CLAMP);
                mPaint.setShader(linearGradient);
                matrix = new Matrix();
            }

        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (matrix!=null){
            mTranslate +=mViewWidth/5;
            if (mTranslate>2*mViewWidth){
                mTranslate = -mViewWidth;
            }
            matrix.setTranslate(mTranslate,0);
            linearGradient.setLocalMatrix(matrix);
            postInvalidateDelayed(200);
        }
    }
}
