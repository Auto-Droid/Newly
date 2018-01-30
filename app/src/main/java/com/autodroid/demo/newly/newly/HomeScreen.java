package com.autodroid.demo.newly.newly;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.autodroid.newly.dialog.Newly;

import com.autodroid.demo.newly.newly.R;

/**
 * Created by sourabhkarkal on 30/01/18.
 */

public class HomeScreen extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Activity activity = this;
        Newly newly = new Newly.Build(activity)
                .setBackgroundDrawable(R.drawable.rectangle)
                .setText("  ↑ New Tweets  ")
                .setTextColor("#FFFFFF")
                .setHeightOffset(250)
                .build();
        newly.show();
    }
}
