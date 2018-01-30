package com.autodroid.demo.newly.newly

import android.app.Activity
import android.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.autodroid.newly.dialog.Newly
import android.view.WindowManager
import android.view.Gravity
import android.view.animation.AnimationUtils
import android.view.ViewGroup
import android.widget.Toast
import com.autodroid.newly.NewlyOnTouchListener

class MainActivity : AppCompatActivity() , NewlyOnTouchListener {

    var activity : Activity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activity = this;

        var btnClick = findViewById<View>(R.id.btnClick) as Button;
        btnClick.setOnClickListener {
            var newly = Newly.Build(activity as MainActivity)
                    .setText("  ↑ New Tweets  ")
                    .setBackgroundDrawable(R.drawable.rectangle)
                    .setTextColor("#FFFFFF")
                    .setHeightOffset(250)
                    .build();
            newly.show()
        }
    }

    override fun onNewlyTouchListener() {
        Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show();
    }


}
