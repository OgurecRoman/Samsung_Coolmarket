package com.example.save_information;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.save_information.databinding.Activity2Binding;
import com.example.save_information.databinding.ActivityMainBinding;

public class Activity2 extends AppCompatActivity {
    static final String LOGINSTRING = "login";
    static final String PASSWORDSTRING = "password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Activity2Binding binding = Activity2Binding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        SharedPreferences pref = MainActivity.pref;
        SharedPreferences.Editor edit = pref.edit();

        binding.login.setText(pref.getString(LOGINSTRING, "no value"));
        binding.password.setText(pref.getString(PASSWORDSTRING, "no value"));

        binding.Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.TRUELOGIN = binding.login.getText().toString();
                MainActivity.TRUEPASSWORD = binding.password.getText().toString();
                finish();
            }
        });

        binding.Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.putString(LOGINSTRING, "-");
                edit.putString(PASSWORDSTRING, "-");
                edit.commit();
                finish();
            }
        });

        binding.ACT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this, Activity3.class);
                startActivity(intent);
            }
        });
    }
}
