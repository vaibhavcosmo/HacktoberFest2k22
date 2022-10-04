package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.test.R.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        var btn:ImageButton = findViewById(id.btn);
        var status= 0;
        btn.setOnClickListener(){

            if(status==0) {
                btn.setImageResource(R.drawable.ic_med_difficulty)
                status = 1
            }
            else if(status==1) {
                btn.setImageResource(R.drawable.ic_hard_difficulty)
                status = 2
            }
            else {
                btn.setImageResource(R.drawable.ic_easy_difficulty)
                status = 0
            }
        }
        btnplay.setOnClickListener(){
            val intent = Intent(this,GameActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}