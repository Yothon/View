package com.yothon.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

import com.yothon.view.utils.ScreenUtils;

/**
 * 作者：Yoshon
 * on 2016/11/21 14:47
 * 邮箱：wanyouxin@parim.net
 */
public class ReboundViewGroup extends ViewGroup {
    private Context context;
    private int mlastY;
    private int mStartY;

    private Scroller mScroller;
    private int screenHeight;
    private int mEnd;

    public ReboundViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        mScroller = new Scroller(context);
        screenHeight = ScreenUtils.getScreenHeight(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View childAt = getChildAt(i);
            measureChild(childAt,widthMeasureSpec,heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        int childCount = getChildCount();
        MarginLayoutParams mlp = (MarginLayoutParams) getLayoutParams();
        mlp.height = screenHeight * childCount;
        setLayoutParams(mlp);
        for (int j = 0; j < childCount; j++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility()!=View.GONE){
                childAt.layout(i,i* screenHeight,i2,(i+1)* screenHeight);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mlastY = y;
                mStartY = getScrollY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (!mScroller.isFinished()){
                    mScroller.abortAnimation();
                }
                int dy = mlastY - y;
                if (getScrollY()<0){
                    dy = 0;
                }
                if (getScrollY()>getHeight()-screenHeight){
                    dy = 0;
                }
                scrollBy(0,dy);
                mlastY = y;
                break;
            case MotionEvent.ACTION_UP:
                mEnd = getScrollY();
                int dScrollY = mEnd - mStartY;
                if (dScrollY>0){
                    if (dScrollY < screenHeight/3){
                        mScroller.startScroll(0,getScrollY(),0,-dScrollY);
                    }else {
                        mScroller.startScroll(0,getScrollY(),0,screenHeight-dScrollY);
                    }
                }else {
                    if (-dScrollY<screenHeight/3){
                        mScroller.startScroll(0,getScrollY(),0,-dScrollY);
                    }else {
                        mScroller.startScroll(0,getScrollY(),0,-screenHeight-dScrollY);
                    }
                }
                break;
        }
        postInvalidate();
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()){
            scrollTo(0,mScroller.getCurrY());
            postInvalidate();
        }
    }
}
