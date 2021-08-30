package com.ui.espresso_kotlin.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ui.espresso_kotlin.R

class Dashboard : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        var dash: EditText = findViewById(R.id.dash)
        var msg: EditText = findViewById(R.id.msg)
        var name: EditText= findViewById(R.id.name)
        var btn: Button = findViewById(R.id.btn)
        var txView: TextView = findViewById(R.id.tv)

        btn.setOnClickListener {
            txView.text = dash.text.toString() + " " + msg.text + " " + name.text
        }
    }
}