package com.example.bottomnavview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ViewFlipper;

public class AViewFlipper extends ViewFlipper
{

    Paint paint = new Paint();

    public AViewFlipper(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        int width = getWidth();
        float margin = 10;
        float radius = 20;
        float cx = width / 2 - ((radius + margin) * 2 * getChildCount() / 2);
        float cy = getHeight() - 25;

        canvas.save();

        for (int i = 0; i < getChildCount(); i++)
        {
            if (i == getDisplayedChild())
            {
                paint.setColor(Color.RED);
                canvas.drawCircle(cx + 5, cy, radius, paint);

            } else
            {
                paint.setColor(Color.argb(200,0,255,0));
                canvas.drawCircle(cx, cy, radius, paint);
            }
            cx += 2 * (radius + margin);
        }
        canvas.restore();
    }

}
