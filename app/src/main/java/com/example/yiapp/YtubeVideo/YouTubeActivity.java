package com.example.yiapp.YtubeVideo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yiapp.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTubeActivity extends YouTubeBaseActivity {

    TextView VideoDescTxt;
    Button ActivityButton;

    Dialog dialog;

    YouTubePlayerView youTubePlayerView;

    String VideoSrc;
    String VideoCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube);

        youTubePlayerView = findViewById(R.id.YoutubePlayer);


        YouTubePlayer.OnInitializedListener listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(VideoCode);
                youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(getApplicationContext(),
                        "Initialization Failed",
                        Toast.LENGTH_SHORT).show();
            }
        };

        youTubePlayerView.initialize("AIzaSyDsMJQ507XrkuqkTKP4Y-k7byFwp-OeMFs",listener);

        VideoDescTxt = (TextView) findViewById(R.id.Video_description);
        ActivityButton = (Button) findViewById(R.id.Activity_Button);

       VideoDescTxt.setText(getIntent().getStringExtra("Description"));
       VideoSrc = getIntent().getStringExtra("VideoSource");

       VideoCode = VideoSrc.substring(VideoSrc.indexOf("=")+1);

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