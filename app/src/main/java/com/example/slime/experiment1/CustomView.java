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
    private Aztec aztec;

    public CustomView(Context context) {
        super(context);
        this.p = new Paint();
        p.setColor(Color.BLACK);
        this.aztec = new Aztec(new Coordinates(100, 100));
        this.square = new MySquare(50, 100, 150, 200);
        Toast.makeText(context, "asdf", Toast.LENGTH_LONG).show();
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
        for(Coordinates co : this.aztec.getCurrentPattern()){
            canvas.drawRect(co.getY() + 20, co.getX() + 20, co.getY() + 40, co.getX() + 40, this.p);
        }
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