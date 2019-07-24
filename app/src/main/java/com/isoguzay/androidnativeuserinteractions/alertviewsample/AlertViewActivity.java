package com.isoguzay.androidnativeuserinteractions.alertviewsample;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.isoguzay.androidnativeuserinteractions.R;
import com.isoguzay.androidnativeuserinteractions.mainactivity.MainActivity;

public class AlertViewActivity extends AppCompatActivity {

    private Button buttonAlertNormal, buttonAlertSpecial, buttonBack;
    private EditText editTextAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_view);

        initializeComponents();
        buttonAlertNormalClick();
        buttonAlertSpecialClick();
        buttonBackClick();
    }


    public void buttonAlertNormalClick(){
        buttonAlertNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertViewActivity.this);
                builder.setIcon(R.drawable.ic_desktop_windows_black_24dp);
                builder.setTitle("Open Your Computer");
                builder.setMessage("Do you want to open your computer?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Computer is opening..", Toast.LENGTH_LONG).show();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Computer is off.", Toast.LENGTH_LONG).show();
                    }
                });

                builder.show();
            }
        });
    }

    public void buttonAlertSpecialClick(){
        buttonAlertSpecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View alertDesign = getLayoutInflater().inflate(R.layout.alert_special_design,null);

                editTextAlert = alertDesign.findViewById(R.id.editText_alert);

                AlertDialog.Builder builder = new AlertDialog.Builder(AlertViewActivity.this);
                builder.setMessage("What is your computer brand?");
                builder.setView(alertDesign);

                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Your computer brand is " + editTextAlert.getText(), Toast.LENGTH_LONG).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "No information about your computer brand..", Toast.LENGTH_LONG).show();
                    }
                });

                builder.show();
            }
        });
    }

    public void buttonBackClick(){
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backToMain);
            }
        });
    }

    public void initializeComponents(){
        buttonAlertNormal = findViewById(R.id.button_alertNormal);
        buttonAlertSpecial = findViewById(R.id.button_alertSpecial);
        buttonBack = findViewById(R.id.button_backFromAlert);
    }
}
