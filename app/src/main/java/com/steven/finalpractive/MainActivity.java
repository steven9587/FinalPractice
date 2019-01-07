package com.steven.finalpractive;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int RC_LOGIN = 100;
    boolean login = false;
    private String saveNickname;
    private int saveAge;
    private String saveGender;
    private TextView showNickname;
    private TextView showAge;
    private TextView showGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showNickname = findViewById(R.id.showNickname);
        showAge = findViewById(R.id.showAge);
        showGender = findViewById(R.id.showGenger);
        if (!login) {
            Intent login = new Intent(this, LoginActivity.class);
            startActivityForResult(login, RC_LOGIN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_LOGIN) {
            if (resultCode == RESULT_OK) {
                saveNickname = getSharedPreferences("ATM", MODE_PRIVATE)
                        .getString("USERNICKNAME", null);
                saveAge = getSharedPreferences("ATM", MODE_PRIVATE)
                        .getInt("USERAGE", 0);
                saveGender = getSharedPreferences("ATM", MODE_PRIVATE)
                        .getString("USERGENDER", null);
                if (saveNickname == null || saveAge == 0 || saveGender == null) {
                    Intent nickname = new Intent(this, NicknameActivity.class);
                    startActivity(nickname);
                }
                showNickname.setText(saveNickname);
                showAge.setText(saveAge + " ");
                showGender.setText(saveGender);
            } else {
                finish();
            }
        }
    }
}
