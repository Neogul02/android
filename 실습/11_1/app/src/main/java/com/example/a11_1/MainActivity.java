package com.example.a11_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv = findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;
        Integer[] posterID = {R.drawable.mov01, R.drawable.mov02,
                R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
                R.drawable.mov09, R.drawable.mov10, R.drawable.mov01,
                R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
                R.drawable.mov05, R.drawable.mov06, R.drawable.mov07,
                R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
                R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
                R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
                R.drawable.mov10};

        public MyGridAdapter(Context c) {
            context = c;
        }

        public int getCount() {
            return posterID.length;
        } // 그리드뷰의 전체 갯수

        public Object getItem(int position) {
            return null;
        } // 그리드뷰의 특정 항목

        public long getItemId(int position) {
            return 0;
        }

        String[] posterTitle = {"토이스토리", "호빗", "제이슨 본", "반지의제왕",
                "정직한 후보", "나쁜녀석들", "겨울왕국II", "알라딘", "극한직업", "스파이더맨",
                "토이스토리", "호빗", "제이슨 본", "반지의제왕",
                "정직한 후보", "나쁜녀석들", "겨울왕국II", "알라딘", "극한직업", "스파이더맨",
                "토이스토리", "호빗", "제이슨 본", "반지의제왕",
                "정직한 후보", "나쁜녀석들", "겨울왕국II", "알라딘", "극한직업", "스파이더맨"};

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new GridView.LayoutParams(200, 300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5, 5, 5);
            imageview.setImageResource(posterID[position]);

            final int pos = position;
            imageview.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    View dialogView = View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle(posterTitle[pos]);
                    dlg.setIcon(R.drawable.movie_icon);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });
            return imageview;
        }
    }
}