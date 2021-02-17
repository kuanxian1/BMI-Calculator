package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.enter_button)
        button.setOnClickListener{
            val intent = Intent(this, BMI::class.java)
            val personName = findViewById<TextView>(R.id.editTextTextPersonName)
            intent.putExtra("personName", personName.text.toString())
            startActivity(intent)
        }
    }
}