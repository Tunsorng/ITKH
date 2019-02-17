package com.tunsorngkroem.itkh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView lesson,video,quiz,adLearn,aboutUs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lesson=findViewById(R.id.lesson);
        video=findViewById(R.id.video);
        quiz=findViewById(R.id.quiz);
        adLearn=findViewById(R.id.adLearn);
        aboutUs=findViewById(R.id.aboutUs);

        lesson.setOnClickListener(this);
        video.setOnClickListener(this);
        quiz.setOnClickListener(this);
        adLearn.setOnClickListener(this);
        aboutUs.setOnClickListener(this);

        


    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.lesson : intent=new Intent(this,LessonActivity.class);startActivity(intent); break;
            case R.id.video : intent=new Intent(this,VideoActivity.class);startActivity(intent); break;
            case R.id.quiz : intent=new Intent(this,QuizActivity.class);startActivity(intent); break;
            case R.id.adLearn: intent=new Intent(this,AdLearnActivity.class);startActivity(intent);break;
            case R.id.aboutUs : intent=new Intent(this,AboutUsActivity.class);startActivity(intent);break;
            default:break;
        }

    }
}

