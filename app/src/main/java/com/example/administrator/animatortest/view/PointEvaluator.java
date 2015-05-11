package com.example.administrator.animatortest.view;

import android.animation.TypeEvaluator;

import com.example.administrator.animatortest.Point;

/**
 * Created by Administrator on 15-5-11.
 */
class PointEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        float x = startPoint.getX()+ fraction * (endPoint.getX()-startPoint.getX());
        float y = startPoint.getY()+ fraction * (endPoint.getY()-startPoint.getY());
        return new Point(x,y);
    }
}
