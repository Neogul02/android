package com.example.a7animal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button1 = findViewById(R.id.button1);
        final ImageView imgView = findViewById(R.id.imgView);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] versionArray = new String[] {"강아지","고양이","말","토끼"};
                AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);
                dig.setTitle("좋아하는 동물은?");
                dig.setItems(versionArray,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(which==0){imgView.setImageResource(R.drawable.dog);}
                                if(which==1){imgView.setImageResource(R.drawable.cat);}
                                if(which==2){imgView.setImageResource(R.drawable.horse);}
                                if(which==3){imgView.setImageResource(R.drawable.rabbit);}
                            }
                        });
                dig.setPositiveButton("닫기",null);
                dig.show();

            }
        });
    }
}