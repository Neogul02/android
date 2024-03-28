package com.example.a7_toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("My Toolbar");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menuSearch){
            Toast.makeText(this, "You Clicked Search",Toast.LENGTH_SHORT).show();
            return true;
        }if(item.getItemId()==R.id.menuAbout){
            Toast.makeText(this, "You Clicked About",Toast.LENGTH_SHORT).show();
            return true;
        }if(item.getItemId()==R.id.menuLogout){
            Toast.makeText(this, "You Clicked Logout",Toast.LENGTH_SHORT).show();
            return true;

        }if(item.getItemId()==R.id.menuSettings){
            Toast.makeText(this, "You Clicked Setting",Toast.LENGTH_SHORT).show();
            return true;

        }
        return false;
    }
}