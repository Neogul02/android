package com.example.a11_class;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 엑티비티");

        final EditText edtNum1 = findViewById(R.id.edtNum1);
        final EditText edtNum2 = findViewById(R.id.edtNum2);
        final RadioGroup rdoGroup = findViewById(R.id.rdoGroup);
        Button btnNewActivity = findViewById(R.id.btnNewActivity);

        final RadioButton radioPlus = findViewById(R.id.rdoAdd);
        final RadioButton radioMinus = findViewById(R.id.rdoSub);
        final RadioButton radioMultiply = findViewById(R.id.rdoMul);
        final RadioButton radioDivide = findViewById(R.id.rdoDiv);


        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                if (radioPlus.isChecked()) {
                    intent.putExtra("Calc", "+");
                    // intent 로 secondActivity 로 넘어갈때, Calc 라는 이름으로 + 를 넘겨준다.
                }
                if (radioMinus.isChecked()) {
                    intent.putExtra("Calc", "-");
                }
                if (radioMultiply.isChecked()) {
                    intent.putExtra("Calc", "*");
                }
                if (radioDivide.isChecked()) {
                    intent.putExtra("Calc", "/");
                }

                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                // intent 로 secondActivity 로 넘어갈때, Num1, Num2 라는 이름으로 각각의 값을 넘겨준다.

                startActivityForResult(intent, 0);
                // startActivityForResult 를 통해, secondActivity 에서 값을 받아온다.
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "결과 :" + hap,
                    Toast.LENGTH_SHORT).show();
        }
    }


}