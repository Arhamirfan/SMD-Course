package com.example.smd_aftermid.GestureExamples.MultiTouchExample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MultiTouchView extends View {

    public static final int SIZE = 70;
    public SparseArray<PointF> myActivePointer;
    public Paint paint,myPaint;
    public int[] color= {Color.GREEN,Color.RED,Color.YELLOW,Color.BLUE,Color.BLACK,Color.MAGENTA,Color.CYAN};
    public MultiTouchView(Context context)
    {
        super(context);
    }

    public MultiTouchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        myPointers();
    }

    public  void myPointers()
    {
        myActivePointer=new SparseArray<PointF>();
        myPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        myPaint.setColor(Color.GREEN);
        myPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int PointIndex = event.getActionIndex();
        int pointID = event.getPointerId(PointIndex);
        int actionMasked = event.getActionMasked();
        switch (actionMasked)
        {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                PointF f = new PointF();
                f.x = event.getX(PointIndex);
                f.y = event.getY(PointIndex);
                myActivePointer.put(pointID,f);
                break;
            case MotionEvent.ACTION_MOVE:
                for(int size = event.getPointerCount(),i=0;i<size;i++) {
                    PointF point = myActivePointer.get(event.getPointerId(i));
                    if (point != null) {
                        point.x = event.getX();
                        point.y = event.getY();
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
                myActivePointer.remove(pointID);
                break;
            default: return false;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int size = myActivePointer.size(),i=0;i<size;i++)
        {
            PointF  f = myActivePointer.valueAt(i);
            if(f != null)
            {
                myPaint.setColor(color[i]);
            }
            canvas.drawCircle(f.x,f.y,SIZE,myPaint);
        }
    }
}
