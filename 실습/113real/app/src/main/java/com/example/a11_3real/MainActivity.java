package com.example.a11_3real;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;



public class MainActivity extends AppCompatActivity {
    String[] movie = {"쿵푸팬더", "짱구는 못말려", "아저씨", "아바타", "대부",
            "국가대표", "토이스토리3", "마당을 나온 암탉", "죽은 시인의 사회", "서유기"};

    Integer[] posterID = {R.drawable.mov20, R.drawable.mov21, R.drawable.mov22, R.drawable.mov23, R.drawable.mov24, R.drawable.mov25,
            R.drawable.mov26, R.drawable.mov27, R.drawable.mov28, R.drawable.mov29, R.drawable.mov30};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("스피너 테스트");

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, movie);
        spinner.setAdapter(adapter);
    }
    public class
}