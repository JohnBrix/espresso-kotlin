package com.ui.espresso_kotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var editTxFName: EditText = findViewById(R.id.edFname)
        var editTxLName: EditText = findViewById(R.id.edLname)
        var editTxMName: EditText = findViewById(R.id.edMname)
        var btn: Button = findViewById(R.id.btn)
        var txView: TextView = findViewById(R.id.tv)

        btn.setOnClickListener(View.OnClickListener {
            txView.setText(editTxFName.getText().toString() + " " + editTxLName.getText() + " " + editTxMName.getText()) })
    }
}