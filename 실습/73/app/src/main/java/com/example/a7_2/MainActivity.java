package com.example.a7_2;

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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText editName, editEmail;
    Button button1;
    EditText digEdtName, digEdtEmail;
    TextView toastText;
    View dialogView, toastView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.tvName);
        editEmail = findViewById(R.id.tvEmail);
        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = View.inflate(MainActivity.this,R.layout.dialog1,null);
                AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);
                dig.setTitle("사용자 정보 입력");
                dig.setIcon(R.drawable.ic_menu_allfriends);
                dig.setView(dialogView);

                digEdtName = dialogView.findViewById(R.id.digEdt1);
                digEdtEmail = dialogView.findViewById(R.id.digEdt2);

                digEdtName.setText(editName.getText());
                digEdtEmail.setText(editEmail.getText());

                dig.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                editName.setText(digEdtName.getText().toString());
                                editEmail.setText(digEdtEmail.getText().toString());
                            }
                        });
                dig.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = new Toast(MainActivity.this);
                        toastView = View.inflate(MainActivity.this,R.layout.toast1,null);
                        toastText = toastView.findViewById(R.id.toastText1);
                        toastText.setText("취소했습니다");
                        toast.setView(toastView);
                        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        int xOffset = (int) (Math.random()*display.getWidth());
                        int yOffset = (int) (Math.random()*display.getHeight());
                        toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset,yOffset);
                        toast.show();
                    }
                });
                dig.show();


            }
        });

    }
}