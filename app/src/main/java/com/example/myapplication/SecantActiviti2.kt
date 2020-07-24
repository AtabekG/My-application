package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_secant_activiti2.*

class SecantActiviti2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secant_activiti2)
        val result = intent.getStringExtra("res")
        val result1 = intent.getStringExtra("res1")
        textView.text = result
        textView2.text = result1
        button1.setOnClickListener {
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            finish()
        }
    }
}