package com.tunsorngkroem.itkh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DefinitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definition);



        String word=getIntent().getStringExtra("WORD");
        String defintion=getIntent().getStringExtra("DEFINITION");

        TextView wordText= (TextView) findViewById(R.id.wordtext);
        TextView definitionText= (TextView) findViewById(R.id.definitiontext);

        wordText.setText(word);
        definitionText.setText(defintion);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==android.R.id.home){
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onBack(View view) {
        Intent intent = new Intent(this, LessonActivity.class);
        startActivity(intent);
    }
}