package com.example.a10_intenturl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.util.Log.i("액티비티 테스트", "onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        android.util.Log.i("액티비티 테스트", "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        android.util.Log.i("액티비티 테스트", "onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        android.util.Log.i("액티비티 테스트", "onStart()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        android.util.Log.i("액티비티 테스트", "onStop()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.util.Log.i("액티비티 테스트", "onCreate()");


        Button btnCall = findViewById(R.id.btnCall);
        Button btnWeb = findViewById(R.id.btnWeb);
        Button btnGoogle = findViewById(R.id.btnGoogle);
        Button btnSearch = findViewById(R.id.btnSearch);
        Button btnSms = findViewById(R.id.btnSms);
        Button btnPhoto = findViewById(R.id.btnPhoto);

        Button btnFinish = findViewById(R.id.btnFinish);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:010-1234-5678");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.naver.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:37.275, 127.132?z=17");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "안드로이드");
                startActivity(intent);
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "안녕하세요");
                intent.setData(Uri.parse("smsto:" + Uri.encode("010-1234-5678")));
                startActivity(intent);
            }
        });

    }
}