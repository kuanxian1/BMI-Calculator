package com.example.bmicalculator

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

var bmiIndex = 0.0

class BMI : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_m_i)

        val personName = intent?.getStringExtra("personName")

        val tv = findViewById<TextView>(R.id.nameText)
        tv.setText(personName)

        if(savedInstanceState!=null){
            bmiIndex = savedInstanceState.getDouble("bmiIndex")

            val status = findViewById<TextView>(R.id.resultText)
            status.setText(getStatus())
        }

        val button = findViewById<Button>(R.id.calculate_button)
        button.setOnClickListener{calcBMI()}
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("bmiIndex", bmiIndex)
    }

    fun calcBMI(){
        val height = findViewById<TextView>(R.id.editHeight).text.toString()
        val weight = findViewById<TextView>(R.id.editWeight).text.toString()
        val status = findViewById<TextView>(R.id.resultText)

        bmiIndex = weight.toDouble() / (height.toDouble() * height.toDouble())

        status.setText(getStatus())
    }

    fun getStatus():String{
        if(bmiIndex < 18.5)
            return "Underweight"
        else if(bmiIndex < 24.9)
            return "Normal Weight"
        else if(bmiIndex < 29.9)
            return "Overweight"
        else if(bmiIndex < 34.9)
            return "Obesity Class I"
        else if(bmiIndex < 39.9)
            return "Obesity Class II"
        else
            return "Obesity Class III"
    }
}