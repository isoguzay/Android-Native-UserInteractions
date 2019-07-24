package com.isoguzay.androidnativeuserinteractions.mainactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.isoguzay.androidnativeuserinteractions.R;
import com.isoguzay.androidnativeuserinteractions.alertviewsample.AlertViewActivity;
import com.isoguzay.androidnativeuserinteractions.popupmenusample.PopupMenuActivity;
import com.isoguzay.androidnativeuserinteractions.toastmessagesample.ToastMessageSample;

public class MainActivity extends AppCompatActivity {

    private Button buttonToast, buttonSnackbar, buttonPopup, buttonAlertView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();

        buttonToastClick();
        buttonPopupClick();
        buttonAlertViewClick();
    }

    public void buttonPopupClick() {
        buttonPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent popupActivity = new Intent(getApplicationContext(), PopupMenuActivity.class);
                startActivity(popupActivity);
            }
        });
    }

    public void buttonToastClick() {
        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toastActivity = new Intent(getApplicationContext(), ToastMessageSample.class);
                startActivity(toastActivity);
            }
        });
    }

    public void buttonAlertViewClick() {
        buttonAlertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alertActivity = new Intent(getApplicationContext(), AlertViewActivity.class);
                startActivity(alertActivity);
            }
        });
    }

    public void initializeComponents() {
        buttonToast = findViewById(R.id.button_toastSample);
        buttonSnackbar = findViewById(R.id.button_snackbarSample);
        buttonPopup = findViewById(R.id.button_popupSample);
        buttonAlertView = findViewById(R.id.button_alertviewSample);
    }
}
