package com.example.yiapp.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.yiapp.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class QuizResult extends AppCompatActivity {
    PieChart pieChart;
    LottieAnimationView lottieAnimationView;
    TextView result;
    TextView score;
    TextView correctTxt;
    TextView wrongTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);


        Intent intent=getIntent();
        lottieAnimationView =findViewById(R.id.animationView);
        result=findViewById(R.id.result);
        score=findViewById(R.id.score);
        correctTxt=findViewById(R.id.correctText);
        wrongTxt=findViewById(R.id.wrongText);

        int correct=intent.getExtras().getInt("correct");
        int total=intent.getExtras().getInt("total");
        float percent=(correct*100)/total;
        score.setText(String.valueOf(percent));
        correctTxt.setText(String.valueOf(correct));
        wrongTxt.setText(String.valueOf(total-correct));

        if(correct>=total-correct){
            lottieAnimationView.setAnimation("Comp.json");
            result.setText("Passed!");
        }

        Log.i("INFOO", "onCreate: correct "+correct+" total "+total);
        pieChart  = findViewById(R.id.pieChart);
        ArrayList<PieEntry> visitors = new ArrayList<>();
        visitors.add(new PieEntry(correct,"Correct"));
        //visitors.add(new PieEntry(1,"Partially Correct"));
        visitors.add(new PieEntry(total-correct,"Wrong"));


        PieDataSet pieDataSet = new PieDataSet(visitors,"");
        pieDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData= new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Score");
        pieChart.setCenterTextSize(20);


        pieChart.animateXY(2000,2000);
    }
}