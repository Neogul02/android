package com.example.project4_1_class;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project4_1_class.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edit1, edit2;
    private Button btnAdd, btnSub, btnMul, btnDiv, btnNa;
    private TextView textResult;
    private String num1, num2;
    private int result;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnNa = (Button) findViewById(R.id.BtnNa);

        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

        btnNa.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        num1 = edit1.getText().toString();
        num2 = edit2.getText().toString();

        if(edit1.length()==0 || edit2.length()==0){
            Toast.makeText(getApplicationContext(),"숫자를 입력해 주세요",Toast.LENGTH_SHORT).show();
        }else if (view.getId() == R.id.BtnAdd) {
            result = Integer.parseInt (num1) + Integer.parseInt (num2);
        }

        if(edit1.length()==0 || edit2.length()==0) {
            Toast.makeText(getApplicationContext(), "숫자를 입력해 주세요", Toast.LENGTH_SHORT).show();
        }else if(view.getId()==R.id.BtnSub){
            result = Integer.parseInt (num1) - Integer.parseInt (num2);
        }

        if(edit1.length()==0 || edit2.length()==0){
            Toast.makeText(getApplicationContext(),"숫자를 입력해 주세요",Toast.LENGTH_SHORT).show();
        }else if(view.getId()==R.id.BtnMul){
            result = Integer.parseInt (num1) * Integer.parseInt (num2);
        }

        if(edit1.length()==0 || edit2.length()==0) {
            Toast.makeText(getApplicationContext(), "숫자를 입력해 주세요", Toast.LENGTH_SHORT).show();
        }else if(view.getId()==R.id.BtnDiv){
            result = Integer.parseInt (num1) / Integer.parseInt (num2);
        }

        if(edit1.length()==0 || edit2.length()==0){
            Toast.makeText(getApplicationContext(),"숫자를 입력해 주세요",Toast.LENGTH_SHORT).show();
        }else if(view.getId()==R.id.BtnNa){
            result= Integer.parseInt (num1) % Integer.parseInt (num2);
        }

            textResult.setText("계산 결과 : " + result);
        }
}
