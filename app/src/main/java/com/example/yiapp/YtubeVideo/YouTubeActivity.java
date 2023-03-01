package com.example.yiapp.YtubeVideo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.yiapp.R;

public class YouTubeActivity extends AppCompatActivity {

    TextView VideoDescTxt;
    Button ActivityButton;

    Dialog dialog;

    String VideoSrc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube);

        VideoDescTxt = (TextView) findViewById(R.id.Video_description);
        ActivityButton = (Button) findViewById(R.id.Activity_Button);

       VideoDescTxt.setText(getIntent().getStringExtra("Description"));
       VideoSrc = getIntent().getStringExtra("VideoSource");

        dialog = new Dialog(YouTubeActivity.this);
        dialog.setContentView(R.layout.activity_dialog);

//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
//        {
//            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.activity_dialog_box_shape));
//        }
//
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
//        dialog.setCancelable(false);
//        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        ActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }
}