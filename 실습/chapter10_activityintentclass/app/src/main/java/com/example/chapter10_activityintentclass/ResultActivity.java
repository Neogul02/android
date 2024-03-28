package com.example.chapter10_activityintentclass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        Intent intent =getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount"); // MainActivity에서 전달한 투표수를 받기 위한 정수형 배열
        String[] imageName = intent.getStringArrayExtra("ImageName"); // MainActivity에서 전달한 이미지 이름을 받기 위한 문자열 배열

        TextView tv[] = new TextView[imageName.length]; // 텍스트뷰 객체 배열
        RatingBar rbar[] = new RatingBar[imageName.length]; // 레이팅바 객체 배열

        Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
                R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9}; // 텍스트뷰의 id 배열

        Integer rbarID[] = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5,
                R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9}; // 레이팅바의 id 배열

        for (int i =0; i<voteResult.length; i++){
            tv[i] = (TextView) findViewById(tvID[i]);
            rbar[i] = (RatingBar) findViewById(rbarID[i]);
        }

        for (int i =0; i<voteResult.length; i++){
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }
        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 현재 액티비티를 종료하고 이전 액티비티로 돌아감
            }
        });

    }
}
