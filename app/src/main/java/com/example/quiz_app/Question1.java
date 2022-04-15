package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Question1 extends AppCompatActivity {

    TextView name;
    private TextView title;
    private TextView question, page;

    private AppCompatButton option1, option2, option3;

    private AppCompatButton next;

    private List<QuestionList> questionList;

    private int currentQuestionPosition = 0;

    private String selectedOptionByUser = "";

    private ProgressBar progressBar;

    private int CurrentProgress = 0;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        name = findViewById(R.id.Name);

        String Username = getIntent().getStringExtra("Keyname");
        name.setText(Username);

        title = findViewById(R.id.Title1);
        question = findViewById(R.id.Content1);
        option1 = findViewById(R.id.Answer1);
        option2 = findViewById(R.id.Answer2);
        option3 = findViewById(R.id.Answer3);
        next = findViewById(R.id.Submit1);
        page = findViewById(R.id.page);
        progressBar = findViewById(R.id.progressBar1);

        questionList = QuestionsBank.getQuestions();

        page.setText((currentQuestionPosition + 1) + "/" + questionList.size());
        title.setText(questionList.get(0).getTitle());
        question.setText(questionList.get(0).getQuestion());
        option1.setText(questionList.get(0).getOption1());
        option2.setText(questionList.get(0).getOption2());
        option3.setText(questionList.get(0).getOption3());

        CurrentProgress = CurrentProgress + 1;
        progressBar.setProgress(CurrentProgress);
        progressBar.setMax(questionList.size());


        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = option1.getText().toString();

                    option1.setBackgroundResource(R.drawable.incorrect_red);
                    option1.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }


            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = option2.getText().toString();

                    option2.setBackgroundResource(R.drawable.incorrect_red);
                    option2.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }

            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = option3.getText().toString();

                    option3.setBackgroundResource(R.drawable.incorrect_red);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOptionByUser.isEmpty()) {
                    Toast.makeText(Question1.this, "Please Select an option", Toast.LENGTH_SHORT).show();
                } else {
                    changenextQuestion();
                }

            }
        });


    }


    private void changenextQuestion() {
        currentQuestionPosition++;


        if ((currentQuestionPosition + 1) == questionList.size()) {
            next.setText("Finish");
        }

        if (currentQuestionPosition < questionList.size()) {

            CurrentProgress = CurrentProgress + 1;
            progressBar.setProgress(CurrentProgress);
            progressBar.setMax(questionList.size());
            selectedOptionByUser = "";
            option1.setBackgroundResource(R.drawable.back_to_no_color);
            option1.setTextColor(Color.parseColor("#1F6BB8"));

            option2.setBackgroundResource(R.drawable.back_to_no_color);
            option2.setTextColor(Color.parseColor("#1F6BB8"));

            option3.setBackgroundResource(R.drawable.back_to_no_color);
            option3.setTextColor(Color.parseColor("#1F6BB8"));

            page.setText((currentQuestionPosition + 1) + "/" + questionList.size());
            title.setText(questionList.get(currentQuestionPosition).getTitle());
            question.setText(questionList.get(currentQuestionPosition).getQuestion());
            option1.setText(questionList.get(currentQuestionPosition).getOption1());
            option2.setText(questionList.get(currentQuestionPosition).getOption2());
            option3.setText(questionList.get(currentQuestionPosition).getOption3());


        } else {
            String Name1 = name.getText().toString();
            Intent intent = new Intent(Question1.this, QuizResult.class);
            intent.putExtra("correct", getCorrectAnswer());
            intent.putExtra("total", questionList.size());
            intent.putExtra("Username", Name1);

            intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);

            startActivity(intent);
            finish();
        }


    }

    private void revealAnswer() {
        final String getAnswer = questionList.get(currentQuestionPosition).getAnswer();
        if (option1.getText().toString().equals(getAnswer)) {
            option1.setBackgroundResource(R.drawable.correct_answer_green);
            option1.setTextColor(Color.WHITE);
        } else if (option2.getText().toString().equals(getAnswer)) {
            option2.setBackgroundResource(R.drawable.correct_answer_green);
            option2.setTextColor(Color.WHITE);
        } else if (option3.getText().toString().equals(getAnswer)) {
            option3.setBackgroundResource(R.drawable.correct_answer_green);
            option3.setTextColor(Color.WHITE);
        }
    }

    private int getCorrectAnswer() {
        int correct = 0;
        for (int i = 0; i < questionList.size(); i++) {
            final String getUserSelectedAnswer = questionList.get(i).getUserSelectedAnswer();
            final String getAnswer = questionList.get(i).getAnswer();

            if (getUserSelectedAnswer.equals(getAnswer)) {
                correct++;
            }
        }
        return correct;
    }

    private int getInCorrectAnswer() {
        int Incorrect = 0;
        for (int i = 0; i < questionList.size(); i++) {
            final String getUserSelectedAnswer = questionList.get(i).getUserSelectedAnswer();
            final String getAnswer = questionList.get(i).getAnswer();

            if (!getUserSelectedAnswer.equals(getAnswer)) {
                Incorrect++;
            }
        }
        return Incorrect;
    }
}