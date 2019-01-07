package com.steven.finalpractive;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView edId;
    private TextView edPassword;
    private String id;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edId = findViewById(R.id.ed_id);
        edPassword = findViewById(R.id.ed_password);
        String saveId = getSharedPreferences("ATM",MODE_PRIVATE)
                .getString("USERID",password);
        edId.setText(saveId);
    }

    public void login(View view) {
        id = edId.getText().toString();
        password = edPassword.getText().toString();
        if ("steven".equals(id) && "1234".equals(password)) {
            getSharedPreferences("ATM",MODE_PRIVATE)
                    .edit()
                    .putString("USERID",id)
                    .apply();
            setResult(RESULT_OK);
            finish();
        } else {
            setResult(RESULT_CANCELED);
            finish();
        }
    }
}
