package com.example.slime.experiment1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Looper;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private int n = 0;
    private Canvas c;
    public Bitmap b;
    private Paint p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p.setColor(Color.BLACK);

        final MyTimer timer;
        timer = new MyTimer(new Stuff());
        timer.start();
        timer.stop();
        b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        c = new Canvas(b);

        new this.

        Button myBtn = (Button) findViewById(R.id.myBtn);
        myBtn.setWidth(2);
//        myBtn.

        class MyCanvas extends View{

            private Point co = new Point(1,1);

            public MyCanvas(Context context) {
                super(context);
            }

            public void update(){
                this.co.x++;
                this.co.y++;
            }

            @Override
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                invalidate();
                canvas.drawLine(this.co.x, this.co.y, this.co.x++, this.co.y++, new Paint());
                update();
            }
        }





    }
}
