package com.example.quiz_app;


import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    private static List<QuestionList> AndroidQuestions(){
        final List<QuestionList> questionList = new ArrayList<>();

        //write in the QuestionList and answers
        final QuestionList question1 = new QuestionList("Language", "What language are using in the Android Studio", "Java", "C","Python", "Java", "");

        final QuestionList question2 = new QuestionList("Layout", "To set image in layout we use follow element", "View", "ImageView","LinearLayout", "ImageView", "");
        final QuestionList question3 = new QuestionList("Layout", "To set gap between layout elements we use this attribute", "android:layout_margin", "android:layout_width","android:paddingLeft", "android:layout_margin", "");
        final QuestionList question4 = new QuestionList("File", "Which folder do you copy and paste an image into", "Java", "Resource","Drawable", "Drawable", "");
        final QuestionList question5 = new QuestionList("Layout", "A Layout where the positions of the children can be described in relation to each other or to the parent?", "Relative Layout", "Table Layout","Linear Layout", "Relative Layout", "");

        //add to the list
        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        questionList.add(question5);

        return questionList;
    }

    public static List<QuestionList> getQuestions(){
        return AndroidQuestions();
    }

}
