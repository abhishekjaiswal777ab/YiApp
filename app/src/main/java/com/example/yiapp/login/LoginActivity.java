package com.example.yiapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yiapp.MainActivity;
import com.example.yiapp.courses.CourseActivity;
import com.example.yiapp.databinding.ActivityLoginBinding;
import com.example.yiapp.ui.home.network.ApiInterface;
import com.example.yiapp.ui.home.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    public static String token;
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this,"just clicked",Toast.LENGTH_SHORT).show();
                String email=binding.usernameLogin.getText().toString();
                String password=binding.passwordLogin.getText().toString();
                Call<LoginResponse> call= RetrofitInstance.getRetroClient().create(ApiInterface.class).login(new LoginSend(email,password));
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        LoginResponse loginResponse = response.body();
                        token=loginResponse.getToken();
                        if (response.isSuccessful()) {
                            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                            intent.putExtra("token",token);
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