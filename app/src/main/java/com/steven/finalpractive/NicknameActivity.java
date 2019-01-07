package com.steven.finalpractive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NicknameActivity extends AppCompatActivity {

    private TextView edNickname;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        edNickname = findViewById(R.id.ed_nickname);
    }

    public void next(View view) {
        nickname = edNickname.getText().toString();
        getSharedPreferences("ATM",MODE_PRIVATE)
                .edit()
                .putString("USERNICKNAME",nickname)
                .apply();
        Intent age = new Intent(this,AgeActivity.class);
        startActivity(age);
    }
}
