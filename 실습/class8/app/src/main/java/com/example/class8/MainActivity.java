package com.example.class8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("SD 카드에서 파일 읽기");

        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        Button btnMakeDir = findViewById(R.id.btnMakeDir);
        Button btnRemoveDir = findViewById(R.id.btnRemoveDir);
        final String strSDpath = Environment.getExternalStorageDirectory().getAbsolutePath();
        final File myDir = new File(strSDpath + "/mydir");


        btnMakeDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDir.mkdir();
            }
        });
        btnRemoveDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDir.delete();
            }
        });
    }

}