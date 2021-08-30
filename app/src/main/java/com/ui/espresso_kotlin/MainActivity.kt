package com.ui.espresso_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ui.espresso_kotlin.view.Dashboard

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var editTxFName: EditText = findViewById(R.id.edfName)
        var editTxLName: EditText = findViewById(R.id.edlName)
        var editTxMName: EditText = findViewById(R.id.edMname)
        var btn: Button = findViewById(R.id.btn)
        var txView: TextView = findViewById(R.id.tv)

        btn.setOnClickListener{
            val fname = editTxFName.text.toString()
            val lname = editTxLName.text.toString()
            val mname = editTxMName.text.toString()

            if (fname.contains("open") && lname.contains("the") && mname.contains("intent")) {
                val i = Intent(applicationContext, Dashboard::class.java)
                startActivity(i)
            } else {
                txView.text =
                    editTxFName.text.toString() + " " + editTxLName.text + " " + editTxMName.text
            }
        }
    }
}