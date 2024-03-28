package com.example.a7_contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    LinearLayout baseLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("context Menu ");

        baseLayout = findViewById(R.id.baseLayout);
        btn1 = findViewById(R.id.btn1);
        registerForContextMenu(btn1);
        btn2 = findViewById(R.id.btn2);
        registerForContextMenu(btn2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();
        if(v==btn1){
            menu.setHeaderTitle("배경색 변경");

            mInflater.inflate(R.menu.menu1, menu);
        }if(v==btn2){
            menu.setHeaderTitle("버튼 변경");

            mInflater.inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if ()
    }
}