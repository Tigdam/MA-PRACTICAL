package com.example.mapractical;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Practical11_MyView extends View {
    public Practical11_MyView(Context cont) {
        super(cont);
    }
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int x=getWidth();
        int y=getHeight();
        int rad=100;
        Paint p=new Paint();
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.WHITE);
        canvas.drawPaint(p);
        p.setColor(Color.parseColor("#da4747"));
        canvas.drawCircle(x/2,y/2,rad,p);
    }


}
