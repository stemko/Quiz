package com.example.user11.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class StudyActivity extends AppCompatActivity {
    String htmlString =
            "<h1>BIBLE STUDY</h1>\n" +
                    "<h3>BIBLE QUIZ ONE:</h3>\n" +
                    "<p>He denied Jesus before His=Judas</p>\n" +
                    "<p>He denied Jesus before His=Judas</p>\n"+
                    "<p>What is the first book in the new=Mathews</p>\n"+
                    "<p>Who is regarded the most wise king in the bible=King Solomon</p>\n"+
                    "<p>who in the bible changed water into wine=Jesus</p>\n"+

                    "<h3>BIBLE QUIZ TWO: </h3>\n" +
                    "<p>How many desciples did Jesus have=12</p>\n" +
                    "<p>Who was Jesus' father=joseph</p>\n"+
                    "<p>The last book in the bible=Genesis</p>\n"+
                    "<p>The place where Jesus was crucified=Golgoltha</p>\n"+
                    "<p>She is the mother of Jesus=Mary</p>\n"+
                    "<h3>ASTRONO QUESTIONS : </h3>"
                    ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        TextView textView = (TextView) findViewById(R.id.display_html_string);
        textView.setText(Html.fromHtml(htmlString));
    }


}





