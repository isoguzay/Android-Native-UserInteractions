package com.isoguzay.androidnativeuserinteractions.mainactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.isoguzay.androidnativeuserinteractions.R;
import com.isoguzay.androidnativeuserinteractions.toastmessagesample.ToastMessageSample;

public class MainActivity extends AppCompatActivity {

    private Button buttonToast, buttonSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiliazeComponents();

        buttonToastClick();
    }

    public void buttonToastClick(){
        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toastActivity = new Intent(getApplicationContext(), ToastMessageSample.class);
                startActivity(toastActivity);
            }
        });
    }

    public void initiliazeComponents(){
        buttonToast = findViewById(R.id.button_toastSample);
        buttonSnackbar = findViewById(R.id.button_snackbarSample);
    }
}
