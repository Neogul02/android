package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final Button[] btns = new Button[6];
    private int btnCount = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btns[0] = (Button) findViewById(R.id.btn1);
        btns[1] = (Button) findViewById(R.id.btn2);
        btns[2] = (Button) findViewById(R.id.btn3);
        btns[3] = (Button) findViewById(R.id.btn4);
        btns[4] = (Button) findViewById(R.id.btn5);
        btns[5] = (Button) findViewById(R.id.btn6);


        for(int i=0; i<6; i++){
            btns[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

        if (v.getVisibility() == View.VISIBLE) {
            v.setVisibility(View.GONE);
            btnCount = btnCount-1;

            if (btnCount == 0) {
                Toast.makeText(getApplicationContext(), "버튼이 모두 사라졌습니다", Toast.LENGTH_SHORT).show();
            }

    }
}
}