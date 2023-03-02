package com.example.yiapp.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yiapp.MainActivity;
import com.example.yiapp.R;
import com.example.yiapp.YtubeVideo.YouTubeActivity;
import com.example.yiapp.courses.CourseActivity;
import com.example.yiapp.databinding.ActivityLoginBinding;
import com.example.yiapp.ui.home.network.ApiInterface;
import com.example.yiapp.ui.home.network.RetrofitInstance;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    //edited
    TextInputLayout emaillayout;
    TextInputLayout passwordlayout;
    Button button;
    float v = 0;

    public static String token;
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //login progress bar
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
        Sprite doubleBounce = new WanderingCubes();
        progressBar.setIndeterminateDrawable(doubleBounce);


        //Animation Start
        emaillayout = (TextInputLayout) findViewById(R.id.email_InputLayout);
        passwordlayout = (TextInputLayout) findViewById(R.id.Password_InputLayout);
        button = (Button) findViewById(R.id.login_button);

        emaillayout.setTranslationX(800);
        passwordlayout.setTranslationX(800);
        button.setTranslationX(800);

        emaillayout.setAlpha(v);
        passwordlayout.setAlpha(v);
        button.setAlpha(v);

        emaillayout.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        passwordlayout.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        button.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();

        //Animation End

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                Toast.makeText(LoginActivity.this,"just clicked",Toast.LENGTH_SHORT).show();
                String email=binding.usernameLogin.getText().toString();
                String password=binding.passwordLogin.getText().toString();
                Call<LoginResponse> call= RetrofitInstance.getRetroClient().create(ApiInterface.class).login(new LoginSend(email,password));
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        LoginResponse loginResponse = response.body();
                        token=loginResponse.getToken();
                        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
                        SharedPreferences.Editor  editor=sp.edit();
                        editor.putString("token",token);
                        editor.apply();
                        if (response.isSuccessful()) {
                            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                            intent.putExtra("username",email);
                            intent.putExtra("password",password);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                         Toast.makeText(LoginActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}