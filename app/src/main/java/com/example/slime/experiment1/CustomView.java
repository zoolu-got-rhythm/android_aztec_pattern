package com.example.slime.experiment1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Slime on 16/03/2017.
 */
class CustomView extends View {

    Paint p;
    private Boolean toggle = false;
    private float i = 0;

    public CustomView(Context context) {
        super(context);
        this.p = new Paint();
        p.setColor(Color.BLACK);
        Toast.makeText(context, "asdf", Toast.LENGTH_LONG).show();
    }

    private void doToggle(){
        this.toggle = !this.toggle;

    }

    public void update(){
        if(this.toggle == false){
            this.i+=5;
            if(this.i == 200)
                doToggle();
        }else{
            this.i-=5;
            if(this.i == 0)
                doToggle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        invalidate();

        canvas.drawRect(50, 100, this.i, 200, this.p);
        //canvas.drawColor(Color.BLACK);
        update();
    }

    private class mySquare{
        public int l;
        public int t;
        public int r;
        public int b;

        public mySquare(int l, int t, int r, int b){
            this.l = l;
            this.t = t;
            this.r = r;
            this.b = b;
        }
    }
}