package com.example.slime.experiment1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Slime on 16/03/2017.
 */
class CustomView extends View {

    Paint p;
    private Boolean toggle = false;
    private float i = 0;
    private MySquare square;

    public CustomView(Context context) {
        super(context);
        this.p = new Paint();
        p.setColor(Color.BLACK);
        this.square = new MySquare(50, 100, 150, 200);
        Toast.makeText(context, "asdf", Toast.LENGTH_LONG).show();
    }

    private void doToggle(){
        this.toggle = !this.toggle;
    }

    public void update(){
       this.square.b = (int) Math.round((Math.random() * 200));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        invalidate();

        canvas.drawRect(square.l, square.t, square.r, square.b, this.p);
        //canvas.drawColor(Color.BLACK);
        update();
    }

    private class MySquare{
        public int l;
        public int t;
        public int r;
        public int b;

        public MySquare(int l, int t, int r, int b){
            this.l = l;
            this.t = t;
            this.r = r;
            this.b = b;
        }
    }
}