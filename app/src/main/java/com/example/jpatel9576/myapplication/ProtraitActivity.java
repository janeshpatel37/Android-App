package com.example.jpatel9576.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Jpatel9576 on 11/19/2018.
 */

public class ProtraitActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portrait);

        Intent i = getIntent();
        String title = i.getStringExtra("TITLE");
        String artist = i.getStringExtra("PRICE");
        String description = i.getStringExtra("DESCRIPT");
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.displayHolder);
        if (frag == null) {
            frag = DisplayFragment.newInstance(title, artist, description);
            fm.beginTransaction().add(R.id.displayHolder, frag).commit();
        }
    }
}
