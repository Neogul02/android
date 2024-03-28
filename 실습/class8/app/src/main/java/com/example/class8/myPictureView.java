package com.example.class8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class myPictureView extends View {

    String imagePath = null;
    public myPictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if (imagePath != null) { // null이 아니라면 인자로 사진파일이 넘어온것.
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            canvas.drawBitmap(bitmap, 0, 0, null);
            bitmap.recycle();
        }
    }
}
