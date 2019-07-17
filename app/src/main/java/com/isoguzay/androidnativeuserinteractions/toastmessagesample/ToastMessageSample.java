package com.isoguzay.androidnativeuserinteractions.toastmessagesample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.isoguzay.androidnativeuserinteractions.R;
import com.isoguzay.androidnativeuserinteractions.mainactivity.MainActivity;

public class ToastMessageSample extends AppCompatActivity {

    private Button buttonDefaultToast, buttonSpecificToast, buttonBackMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_message_sample);
        initiliazeComponents();

        buttonDefaultClick();
        buttonSpecificClick();
        buttonBackMenu();

    }

    public void buttonBackMenu(){
        buttonBackMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backMenu = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backMenu);
            }
        });
    }

    public void buttonDefaultClick(){
        buttonDefaultToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Hello World", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void buttonSpecificClick(){
        buttonSpecificToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View toastDesign = getLayoutInflater().inflate(R.layout.toast_specific_message_design, null);

                TextView textViewSpecificMessage = toastDesign.findViewById(R.id.textView_toastMessage);

                textViewSpecificMessage.setText(R.string.specificToastMessage);

                Toast specificToast = new Toast(getApplicationContext());

                specificToast.setView(toastDesign);

                specificToast.setDuration(Toast.LENGTH_LONG);

                specificToast.show();

            }
        });
    }

    public void initiliazeComponents(){
        buttonDefaultToast = findViewById(R.id.button_showDefaultToast);
        buttonSpecificToast = findViewById(R.id.button_showSpecificToast);
        buttonBackMenu = findViewById(R.id.button_backToast);
    }
}
