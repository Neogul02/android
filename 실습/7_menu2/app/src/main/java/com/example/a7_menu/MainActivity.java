package com.example.a7_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기");

        baseLayout =findViewById(R.id.baseLayout);
        btn1 = findViewById(R.id.btn1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0,1,0,"배경색(빨강)");
        menu.add(0,2,0,"배경색(파랑)");
        menu.add(0,3,0,"배경색(초록)");

        subMenu
        smenu.add(0,4,0,"배경색(빨강");
        smenu.add(0,5,0,"배경색(빨강");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       if(item.getItemId()==R.id.itemRed){
           baseLayout.setBackgroundColor(Color.RED);
           return true;
       }if(item.getItemId()==R.id.itemGreen){
            baseLayout.setBackgroundColor(Color.GREEN);
            return true;
       }if(item.getItemId()==R.id.itemBlue){
            baseLayout.setBackgroundColor(Color.BLUE);
            return true;
       }
       return false;
}}