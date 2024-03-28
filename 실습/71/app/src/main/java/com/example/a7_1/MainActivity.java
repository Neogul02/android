package com.example.a7_1;

import static java.lang.Float.parseFloat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    EditText edtAngle;
    TextView textView1;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("제주도 풍경");
        setSupportActionBar(toolbar);

        imageView = findViewById(R.id.imageView1);
        edtAngle =findViewById(R.id.edtAngle);
        textView1 = findViewById(R.id.textView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.imgRotate){
            imageView.setRotation((parseFloat(edtAngle.getText().toString())));
            return true;
        }else if(item.getItemId()==R.id.item1){
            imageView.setImageResource(R.drawable.jeju2);
            return true;
        }else if(item.getItemId()==R.id.item2){
            imageView.setImageResource(R.drawable.jeju7);
            return true;
        }else if(item.getItemId()==R.id.item3){
            imageView.setImageResource(R.drawable.jeju14);
            return true;
        }
        return false;
    }
}