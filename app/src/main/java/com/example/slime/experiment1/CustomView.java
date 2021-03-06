package com.example.slime.experiment1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Slime on 16/03/2017.
 */
class CustomView extends View {

    Paint p;
    private Boolean toggle = false;
    private float i = 0;
    private MySquare square;
    private Aztec aztec;
    ArrayList<Integer> colors;

    public CustomView(Context context) {
        super(context);
        this.p = new Paint();
        // p.setColor(Color.BLACK);
        this.colors = new ArrayList<>();
        this.colors.add(Color.CYAN);
        this.colors.add(Color.BLACK);
        this.colors.add(Color.MAGENTA);
        this.colors.add(Color.RED);

        // super.getMeasuredWidth()
        this.aztec = new Aztec(new Coordinates(300, 400));
        this.square = new MySquare(50, 100, 150, 200);
        Toast.makeText(context, "HELLO, EARTHLING", Toast.LENGTH_LONG).show();
    }

    private void doToggle(){
        this.toggle = !this.toggle;
    }

    public void update(){
       this.aztec.move();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        invalidate();
        setBackgroundColor(Color.BLACK);
        for(Coordinates co : this.aztec.getCurrentPattern()){
            this.p.setColor(this.colors.get((int) Math.floor(Math.random() * colors.size())));
            canvas.drawRect(co.getY() + 20, co.getX() + 20, co.getY() + 40, co.getX() + 40, this.p);
        }
        //canvas.drawColor(Color.BLACK);
        update();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        Toast.makeText(getContext(), "you touched the screen", Toast.LENGTH_SHORT).show();
       return true;
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