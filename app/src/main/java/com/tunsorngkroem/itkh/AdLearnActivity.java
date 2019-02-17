package com.tunsorngkroem.itkh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AdLearnActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView bgapp, clover;
    LinearLayout texthome, menus,facebook,youtube;
    Animation frombottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_learn);

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);


        facebook=(LinearLayout) findViewById(R.id.facebook);
        youtube=(LinearLayout) findViewById(R.id.youtube);
        bgapp = (ImageView) findViewById(R.id.bgapp);
        clover = (ImageView) findViewById(R.id.clover);

        texthome = (LinearLayout) findViewById(R.id.texthome);
        menus = (LinearLayout) findViewById(R.id.menus);

        bgapp.animate().translationY(-1900).setDuration(800).setStartDelay(300);
        clover.animate().alpha(0).setDuration(800).setStartDelay(600);


        texthome.startAnimation(frombottom);
        menus.startAnimation(frombottom);

        facebook.setOnClickListener(this);
        youtube.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.facebook : intent=new Intent(this,DefinitionActivity.class);startActivity(intent); break;
            case R.id.youtube : intent=new Intent(this,YoutubeActivity.class);startActivity(intent); break;

            default:break;
        }

    }
}
