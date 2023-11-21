package com.example.save_information;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.save_information.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    static String TRUELOGIN = "321";
    static String TRUEPASSWORD = "123";
    static SharedPreferences pref;

    static final String LOGINSTRING = "login";
    static final String PASSWORDSTRING = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        pref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();


        if (pref.getString(LOGINSTRING, "no value").equals(TRUELOGIN) && pref.getString(PASSWORDSTRING, "no value").equals(TRUEPASSWORD)) {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            startActivity(intent);
        }

        binding.Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strLogin = binding.Login.getText().toString();
                String strpassword = binding.Password.getText().toString();

                if (strLogin.equals(TRUELOGIN) && strpassword.equals(TRUEPASSWORD)) {
                    edit.putString(LOGINSTRING, strLogin);
                    edit.putString(PASSWORDSTRING, strpassword);
                    edit.commit();

                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    startActivity(intent);
                } else {
                    ////
                }
            }
        });

    }
}