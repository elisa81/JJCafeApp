package com.jmk.edu.jjcafeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EditTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_table);
        getSupportActionBar().hide();
    }
}
