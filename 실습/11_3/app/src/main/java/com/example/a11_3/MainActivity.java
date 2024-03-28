package com.example.a11_3;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("스피너 테스트");

        final String[] movie = {"아바타", "힘을내요미스터리", "포트v페라리", "쥬만지", "대부", "국가대",
                "토이스토", "마당을나온암", "죽은 시인의 사회", "서유기"};

        final Integer[] posterID = {R.drawable.mov21, R.drawable.mov22,
                R.drawable.mov23, R.drawable.mov24, R.drawable.mov25,
                R.drawable.mov26, R.drawable.mov27, R.drawable.mov28,
                R.drawable.mov29, R.drawable.mov30};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, movie);

        Spinner spinner = findViewById(R.id.spinner1);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int position, long id) {
                ImageView ivPoster = findViewById(R.id.ivPoster);
                ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ivPoster.setPadding(5, 5, 5, 5);
                ivPoster.setImageResource(posterID[position]);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
}