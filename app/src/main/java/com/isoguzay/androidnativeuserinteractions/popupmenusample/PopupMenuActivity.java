package com.isoguzay.androidnativeuserinteractions.popupmenusample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.isoguzay.androidnativeuserinteractions.R;
import com.isoguzay.androidnativeuserinteractions.mainactivity.MainActivity;

public class PopupMenuActivity extends AppCompatActivity {

    private Button buttonBack, buttonPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);

        initializeComponents();
        buttonPopupClick();
        buttonBackClick();

    }

    public void buttonPopupClick() {
        buttonPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(PopupMenuActivity.this, buttonPopup);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu_design, popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_add:
                                Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_LONG).show();
                                return true;
                            case R.id.action_delete:
                                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
            }
        });
    }

    public void buttonBackClick() {
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToMain = new Intent(PopupMenuActivity.this, MainActivity.class);
                startActivity(backToMain);
            }
        });
    }

    public void initializeComponents() {
        buttonBack = findViewById(R.id.button_backFromPopup);
        buttonPopup = findViewById(R.id.button_popup);
    }
}
