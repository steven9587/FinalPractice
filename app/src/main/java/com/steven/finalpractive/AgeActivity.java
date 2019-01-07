package com.steven.finalpractive;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class AgeActivity extends AppCompatActivity {

    private TextView edAge;
    private int age;
    int[] chooseAge = {15, 16, 17, 18, 19, 20, 21, 22, 23};
    //List chooseAge2 = Arrays.asList(15,16,17,18,19,20,21,22,23);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        edAge = findViewById(R.id.ed_age);
        RecyclerView ageRecyclerView = findViewById(R.id.ageRecycler);
        ageRecyclerView.setHasFixedSize(true);
        ageRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ageRecyclerView.setAdapter(new AgeAdapter());
    }

    class AgeAdapter extends RecyclerView.Adapter<AgeAdapter.AgeViewHolder>{
        @NonNull
        @Override
        public AgeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = getLayoutInflater().inflate(R.layout.age_row,viewGroup,false);
            return new AgeViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AgeViewHolder ageViewHolder, final int i) {
            ageViewHolder.ageText.setText(chooseAge[i]+" ");
            ageViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    edAge.setText(chooseAge[i]+"");
                }
            });
        }

        @Override
        public int getItemCount() {
            return chooseAge.length;
        }

        class AgeViewHolder extends RecyclerView.ViewHolder {
            TextView ageText;
            public AgeViewHolder(@NonNull View itemView) {
                super(itemView);
                ageText = itemView.findViewById(R.id.tv_age);
            }
        }
    }

    public void next(View view) {
        age = Integer.parseInt(edAge.getText().toString());
        getSharedPreferences("ATM", MODE_PRIVATE)
                .edit()
                .putInt("USERAGE", age)
                .apply();
        Intent gender = new Intent(this, GenderActivity.class);
        startActivity(gender);
    }

    public void back(View view) {
        finish();
    }
}
