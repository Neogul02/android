package com.example.chapter10_activityintentclass;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 투표");

        final int voteCount[] = new int[9]; // 9개의 이미지 버튼에 대한 투표수를 저장하는 정수형 배열
        for (int i = 0; i < 9; i++)
            voteCount[i] = 0; // 배열의 모든 요소를 0으로 초기화

        ImageView image[] = new ImageView[9]; // 9개의 이미지 버튼에 대한 객체배열
        Integer imageId[] = {R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5,
                R.id.img6, R.id.img7, R.id.img8, R.id.img9};

        final String imgName[] = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들", "해변에서"};

        for (int i = 0; i < imageId.length; i++) {
            final int index = i; // 이너 클래스에서 사용하기 위한 변수
            image[index] = (ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),imgName[index]+ ": 총"+ voteCount[index] + "표", Toast.LENGTH_SHORT).show();
                }
            });
        }
        Button btnFinish = (Button) findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class); // ResultActivity로 전환하기 위한 인텐트 객체 생성
                intent.putExtra("VoteCount", voteCount); // 투표수를 인텐트 객체에 저장
                intent.putExtra("ImageName", imgName); // 이미지 이름을 인텐트 객체에 저장
                startActivity(intent); // ResultActivity로 전환
            }
        });
    }
}