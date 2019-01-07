package com.steven.finalpractive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GenderActivity extends AppCompatActivity {

    private TextView edGender;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        edGender = findViewById(R.id.ed_gender);
    }

    public void next(View view) {
        gender = edGender.getText().toString();
        getSharedPreferences("ATM",MODE_PRIVATE)
                .edit()
                .putString("USERGENDER",gender)
                .apply();
        Intent main = new Intent(this,MainActivity.class);
        main.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(main);
    }

    public void back(View view) {
        finish();
    }
}
