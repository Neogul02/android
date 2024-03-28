package com.example.drawpaint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Paint paint = new Paint();
    private Path path = new Path();
    private MyPaintView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 그림판");

        myView = new MyPaintView(this);
        LinearLayout baseLayout = findViewById(R.id.baseLayout);
        baseLayout.addView(myView);

        findViewById(R.id.btnClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                path.reset();
                myView.invalidate();
            }
        }); //

    }

    public class MyPaintView extends View {
        public MyPaintView(Context context) {
            super(context);

            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(10);
        }

        @Override
        protected void onDraw(@NonNull Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawPath(path, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(x, y);
                    break;
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    path.lineTo(x, y);
                    break;
                default:
                    return false;
            }
            this.invalidate();
            return true;
        }
    }

}

