package com.example.tanmay.vitbot.Entity.IntroActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.tanmay.vitbot.Entity.ChatHome.Activity.ChatActivity;
import com.example.tanmay.vitbot.R;

public class IntroActivity extends AppCompatActivity {
    Button askButton;
    private PrefManager prefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            startActivity(new Intent(getApplicationContext(),ChatActivity.class));
            prefManager.setFirstTimeLaunch(false);
            finish();
        }
        askButton=(Button)findViewById(R.id.ask_button);
        askButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ChatActivity.class));
            }
        });

    }

}
