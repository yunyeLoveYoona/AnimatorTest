package com.example.administrator.animatortest.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.animatortest.Point;

/**
 * Created by Administrator on 15-5-11.
 */
class AnimatorTestView extends View {
    public static final float RADIUS = 50f;
    private Point mPoint;
    private Paint paint;
    private Point currentPoint;

    public AnimatorTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(currentPoint == null){
            currentPoint=new Point(RADIUS,RADIUS);
            drawCircle(canvas);
            startAnimator();
        }else{
            drawCircle(canvas);
        }
    }
    private void drawCircle(Canvas canvas){
        canvas.drawCircle(currentPoint.getX(),currentPoint.getY(),RADIUS,paint);
    }
    private void startAnimator(){
        Point startPoint = new Point(RADIUS,RADIUS);
        Point endPoint = new Point(getWidth()-RADIUS,getHeight()-RADIUS);
        ValueAnimator animator =ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(5000);
        animator.start();
    }
}
