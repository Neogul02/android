package com.example.a7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText tvName, tvEmail;
    EditText dlgEdtName, dlgEdtEmail;
    TextView toastText;
    View dialogView, toastView;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력(수정)");

        tvName = (EditText) findViewById(R.id.tvName);
        tvEmail = (EditText) findViewById(R.id.tvEmail);

        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() { //btn1
            @Override
            public void onClick(View view) { // 여기를 클릭 버튼
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                dlg.setTitle("동물선택 대화상자");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dialogView);

                dlgEdtName = (EditText) dialogView.findViewById(R.id.edit1);
                dlgEdtEmail = (EditText) dialogView.findViewById(R.id.edit2);

                dlgEdtName.setText(tvName.getText());
                dlgEdtEmail.setText(tvEmail.getText());

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override // 확인 버튼
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvName.setText(dlgEdtName.getText()); // text 가져오기
                        tvEmail.setText(dlgEdtEmail.getText());
                    }
                });

                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override // 취소 버튼
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity.this);
                        toastView = (View) View.inflate(MainActivity.this, R.layout.toast1, null);
                        toastText = (TextView) toastView.findViewById(R.id.textView);
                        toastText.setText("취소했습니다");
                        toast.setView(toastView);

                        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        int x = (int) (Math.random() * display.getWidth());
                        int y = (int) (Math.random() * display.getHeight());

                        toast.setGravity(Gravity.TOP | Gravity.LEFT, x, y);
                        toast.show();
                    }
                });
                dlg.show();
            }
        });
    }
}

