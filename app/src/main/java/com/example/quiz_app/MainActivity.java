package com.example.quiz_app;

import static android.widget.Toast.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1;
    EditText Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button);
        Name = findViewById(R.id.Username);

        button1.setOnClickListener(new Button.OnClickListener() {

               @Override
               public void onClick(View view1) {
                   String UserName = Name.getText().toString();
                   if (UserName.isEmpty()) {
                       Toast.makeText(MainActivity.this,
                               "Please enter your name",
                               LENGTH_SHORT).show();
                   } else {
                       String Name1 = Name.getText().toString();

                       Intent intent = new Intent(MainActivity.this, Question1.class);
                       intent.putExtra("Keyname", Name1);

                       startActivityForResult(intent, 1);
                   }
               }
           }
        );
    }

    protected void onActivity(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("Username");
                Name.setText(name);

            }
        }
    }
}