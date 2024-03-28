package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] titles = {
            "토이스토리4 (2019)",
            "호빗 (2012)",
            "제이슨 본 (2016)",
            "반지의 제왕(2001)",
            "정직한 후보 (2020)",
            "나쁜 녀석들: 포에버,",
            "겨울왕국 2 (2019)",
            "알라딘 (2019)",
            "극한직업 (2019)",
            "스파이더맨 (2019)"
    };
    private Integer[] images = {
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("커스텀 리스트뷰");

        ListView list = findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(this);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), titles[position], Toast.LENGTH_SHORT).show();
            }
        });
    }


    private class CustomAdapter extends BaseAdapter {
        Context context;

        public CustomAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //Log.i("TEST", "getView() 호출", position= "+ position);
            View itemView = View.inflate(context, R.layout.item, null);
            ImageView imageView = itemView.findViewById(R.id.image);
            TextView title = itemView.findViewById(R.id.title);
            TextView genre = itemView.findViewById(R.id.genre);
            TextView year = itemView.findViewById(R.id.year);

            title.setText(titles[position].substring(0, titles[position].indexOf('(')));
            imageView.setImageResource(images[position]);
            genre.setText("DRAMA");
            year.setText(titles[position].substring(titles[position].indexOf('(') + 1, titles[position].indexOf(')')));

            return itemView;
        }
    }

}
