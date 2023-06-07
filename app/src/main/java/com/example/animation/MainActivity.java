package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private ImageView imageV;

    private TextView text;
    private Animation top,bottom;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //is used to set the window flags for an activity to achieve a fullscreen display.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        imageV =  findViewById(R.id.imageV);
        text = findViewById(R.id.txtBurger);

        //method is used to load an animation from an XML resource file and create
        //an instance of the animation object
        top = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //is used in Android to apply an animation to a TextView or any other view.
        text.setAnimation(bottom);
        imageV.setAnimation(top);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,new_activity.class);
                startActivity(intent);
                finish();
            }
        },5000);

    }
}