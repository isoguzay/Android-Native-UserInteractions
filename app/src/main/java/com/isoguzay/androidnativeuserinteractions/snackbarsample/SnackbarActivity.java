package com.isoguzay.androidnativeuserinteractions.snackbarsample;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.isoguzay.androidnativeuserinteractions.R;
import com.isoguzay.androidnativeuserinteractions.mainactivity.MainActivity;

public class SnackbarActivity extends AppCompatActivity {

    private Button buttonBack, buttonSnackBar, buttonSnackBarFeedBack, buttonSnackBarSpecific;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

        initializeComponents();
        buttonBackClick();
        buttonSnackBarClick();
        buttonSnackBarFeedBackClick();
        buttonSnackBarSpecificClick();
    }

    public void buttonSnackBarSpecificClick() {
        buttonSnackBarSpecific.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v, "Internet Connection Error !", Snackbar.LENGTH_SHORT)
                        .setAction("Try Again", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                snackbar.setActionTextColor(Color.YELLOW);

                View view = snackbar.getView();
                TextView textView = view.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.RED);
                snackbar.show();
            }
        });

    }

    public void buttonSnackBarFeedBackClick() {
        buttonSnackBarFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Do you delete that message ?", Snackbar.LENGTH_LONG)
                        .setAction("Yes", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar.make(v, "Message deleted.", Snackbar.LENGTH_LONG).show();
                            }
                        }).show();
            }
        });
    }

    public void buttonSnackBarClick() {
        buttonSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Are you sure ? ", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    public void buttonBackClick() {
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backMain);
            }
        });
    }

    public void initializeComponents() {
        buttonBack = findViewById(R.id.button_backFromSnackbar);
        buttonSnackBar = findViewById(R.id.button_snackbar);
        buttonSnackBarFeedBack = findViewById(R.id.button_snackbar_feedback);
        buttonSnackBarSpecific = findViewById(R.id.button_snackbar_specific);
    }
}
