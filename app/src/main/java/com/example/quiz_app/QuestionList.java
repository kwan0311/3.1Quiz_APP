package com.example.quiz_app;

public class QuestionList {

    private String title, question, option1, option2, option3, answer;
    private  String userSelectedAnswer;

    public QuestionList(String title, String question, String option1, String option2, String option3, String answer, String userSelectedAnswer) {
        this.title = title;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answer = answer;
        this.userSelectedAnswer = userSelectedAnswer;
    }

    public String getTitle() {
        return title;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getAnswer() {
        return answer;
    }

    public String getUserSelectedAnswer() {
        return userSelectedAnswer;
    }

    public void setUserSelectedAnswer(String userSelectedAnswer) {
        this.userSelectedAnswer = userSelectedAnswer;
    }
}

