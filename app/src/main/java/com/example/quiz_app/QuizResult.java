package com.example.quiz_app;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizResult extends AppCompatActivity {

    private Button again, finish;
    private TextView congratulation, score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        again = findViewById(R.id.Take_new_Quiz);
        finish = findViewById(R.id.Finish);
        congratulation = findViewById(R.id.Congratulation);
        score = findViewById(R.id.Score);

        String Username = getIntent().getStringExtra("Username");
        congratulation.setText("Congratulations: " + Username);

        int correct = getIntent().getIntExtra("correct", 0);
        int total = getIntent().getIntExtra("total", 0);
        score.setText(correct + "/" + total);


        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name1 = getIntent().getStringExtra("Username");
                Intent intent = new Intent(QuizResult.this, MainActivity.class);
                intent.putExtra("Username", Name1);

                setResult(RESULT_OK, intent);

                finish();


            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });


    }
    }
