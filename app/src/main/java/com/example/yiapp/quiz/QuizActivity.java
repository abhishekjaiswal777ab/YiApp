package com.example.yiapp.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.yiapp.R;
import com.example.yiapp.courses.modals.ModelOptions;
import com.example.yiapp.courses.modals.ModelQuestions;
import com.example.yiapp.databinding.ActivityQuizBinding;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private ActivityQuizBinding binding;
    List<Questions> questions=new ArrayList<Questions>(5);
    String TAG ="MainActivity";

    int count=0;
    ArrayList<String> selectedAnswers;
    int progressStatus=0;
    ArrayList<Character> flags;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        //TODO fetch questions from Source and put them in List<Questions>
        ArrayList<ModelQuestions> temp =(ArrayList<ModelQuestions>)getIntent().getSerializableExtra("Quiz");
        for(int i=0;i<temp.size();i++){
            Questions q =new Questions();
            q.setQuestion(temp.get(i).getQuestion());
            q.setOption1(temp.get(i).getOptions().get(0).getText());
            q.setOption2(temp.get(i).getOptions().get(1).getText());
            q.setOption3(temp.get(i).getOptions().get(2).getText());
            q.setOption4(temp.get(i).getOptions().get(3).getText());
            ArrayList<ModelOptions>t=temp.get(i).getOptions();
            for(int j=0;j<t.size();j++){
                if(t.get(j).getChecked()==true){
                    q.setAns(t.get(j).getText());
                    Log.i("QUIZ", "onCreate:  ->"+t.get(j).getText());
                    break;
                }
            }
            questions.add(q);
        }


        flags=new ArrayList<>(questions.size());
        Log.i(TAG, "onCreate: Arraylist");
        for(int i=0;i<questions.size();i++){
            flags.add('Z');
        }
        Log.i(TAG, "onCreate: before INIT");
        init(count);
        Log.i(TAG, "onCreate: INIT");

        // aage peeche jaane ke liye
        binding.previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.next.setVisibility(View.VISIBLE);
                binding.result.setVisibility(View.GONE);
                if(count == 0){
                    Toast.makeText(getApplicationContext(), "First Question", Toast.LENGTH_SHORT).show();
                }
                else{
                    // random comment
                    count --;
                    init(count);
                }
            }
        });
        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: next count :"+count);
                if(count == questions.size()-1){
                    binding.result.setVisibility(View.VISIBLE);
                    binding.next.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), " last question", Toast.LENGTH_SHORT).show();
                }
                else{
                    count++;
                    init(count);
                }
            }
        });


        // ans array

        selectedAnswers=new ArrayList<>(questions.size());
        for(int i=0;i<questions.size();i++)
            selectedAnswers.add("");

        binding.optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedAnswers.set(count,binding.optionA.getText().toString());
                binding.optionA.setBackgroundColor(getColor(R.color.green));
                binding.optionB.setBackgroundColor(getColor(R.color.blue));
                binding.optionC.setBackgroundColor(getColor(R.color.blue));
                binding.optionD.setBackgroundColor(getColor(R.color.blue));
                flags.set(count,'A');
            }
        });
        binding.optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswers.set(count,binding.optionB.getText().toString());
                binding.optionA.setBackgroundColor(getColor(R.color.blue));
                binding.optionB.setBackgroundColor(getColor(R.color.green));
                binding.optionC.setBackgroundColor(getColor(R.color.blue));
                binding.optionD.setBackgroundColor(getColor(R.color.blue));
                flags.set(count,'B');
            }
        });
        binding.optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswers.set(count,binding.optionC.getText().toString());
                binding.optionA.setBackgroundColor(getColor(R.color.blue));
                binding.optionB.setBackgroundColor(getColor(R.color.blue));
                binding.optionC.setBackgroundColor(getColor(R.color.green));
                binding.optionD.setBackgroundColor(getColor(R.color.blue));
                flags.set(count,'C');
            }
        });
        binding.optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswers.set(count,binding.optionD.getText().toString());
                binding.optionA.setBackgroundColor(getColor(R.color.blue));
                binding.optionB.setBackgroundColor(getColor(R.color.blue));
                binding.optionC.setBackgroundColor(getColor(R.color.blue));
                binding.optionD.setBackgroundColor(getColor(R.color.green));
                flags.set(count,'D');
            }
        });



        binding.result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showResults();
            }
        });



    }
    private void showResults() {
        int ans=0;
        for(int i=0;i<questions.size();i++){
            Log.i("INFOO", "onCreate:  ->"+questions.get(i).getAns()+"<- total ->"+selectedAnswers.get(i)+"<-");


        }

        for(int i=0;i<questions.size();i++){
            Log.i("INFOO", "onCreate:  ->"+questions.get(i).getAns()+"<- total ->"+selectedAnswers.get(i)+"<-");
            if(questions.get(i).getAns().equals(selectedAnswers.get(i)))
                ans++;

        }
        Log.i("INFOO", "onCreate: correct "+ans+" total "+questions.size());
        Intent intent =new Intent(this,QuizResult.class);
        intent.putExtra("correct",ans);
        intent.putExtra("total",questions.size());
        startActivity(intent);

    }
    private void init(int count){
        binding.question.setText(questions.get(count).getQuestion());
        binding.optionA.setText(questions.get(count).getOption1());
        binding.optionB.setText(questions.get(count).getOption2());
        binding.optionC.setText(questions.get(count).getOption3());
        binding.optionD.setText(questions.get(count).getOption4());
        binding.QuestionNumber.setText(count+1 +"/"+questions.size()+"Question");
        binding.optionA.setBackgroundColor(getColor(R.color.blue));
        binding.optionB.setBackgroundColor(getColor(R.color.blue));
        binding.optionC.setBackgroundColor(getColor(R.color.blue));
        binding.optionD.setBackgroundColor(getColor(R.color.blue));
        if(flags.get(count)=='A'){
            binding.optionA.setBackgroundColor(getColor(R.color.green));

        }else if(flags.get(count)=='B'){
            binding.optionB.setBackgroundColor(getColor(R.color.green));

        }
        else if(flags.get(count)=='C'){
            binding.optionC.setBackgroundColor(getColor(R.color.green));

        }
        else if(flags.get(count)=='D'){
            binding.optionD.setBackgroundColor(getColor(R.color.green));

        }

        try {
            progressStatus =(100/questions.size())*( count+1 / questions.size())+(100/questions.size());
            // Update the progress bar and display the
            //current value in the text view
            binding.progressBar.setProgress(progressStatus);
        }
        catch (ArithmeticException e){

        }
    }
}