package com.example.homework_03;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText hour, minute;
    Button btnOk;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("homework #3");

        hour = findViewById(R.id.hour);
        minute = findViewById(R.id.minute);
        btnOk = findViewById(R.id.btnOk);
        timePicker = findViewById(R.id.timepicker1);

        btnOk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String strHour = hour.getText().toString();
                String strMinute = minute.getText().toString();

                timePicker.setHour(parseInt(strHour));
                timePicker.setMinute(parseInt(strMinute));
                Toast.makeText(getApplicationContext(), "입력한 시간: " + strHour + ":" + strMinute, Toast.LENGTH_SHORT).show();

            }
        });
    }
}