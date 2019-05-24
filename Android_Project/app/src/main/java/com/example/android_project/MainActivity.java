package com.example.android_project;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    Button connect;
    ProgressBar progressBar;
    EditText editIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connect=(Button)findViewById(R.id.connect);
        progressBar= (ProgressBar)findViewById(R.id.process_bar);
        editIP=(EditText)findViewById(R.id.editIP);

        editIP.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length()==0){
                    connect.setEnabled(false);
                    connect.setTextColor(Color.parseColor("#71a0b3"));
                    connect.setBackgroundResource(R.drawable.background_button_continue_disable);
                } else {
                    connect.setEnabled(true);
                    connect.setTextColor(Color.parseColor("#FFFFFF"));
                    connect.setBackgroundResource(R.drawable.background_button_done);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                connect.setEnabled(false);
                String ip= editIP.getText().toString();
                //gui ip len server

                CountDownTimer countDownTimer = new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        progressBar.setProgress(progressBar.getProgress()+10);
                    }

                    @Override
                    public void onFinish() {
                        progressBar.setProgress(0);
                        //kiem tra xem co du lieu gui ve
                        Intent intent = new Intent(MainActivity.this, Menu.class);
                        startActivity(intent);
                    }
                };
                countDownTimer.start();

            }
        });
    }

}
