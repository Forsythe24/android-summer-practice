package com.itis.androidsummerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var nameInput: EditText
    private lateinit var weightInput: EditText
    private lateinit var heightInput: EditText
    private lateinit var ageInput: EditText
    // Formula: numberOfCals = 66.5 + 13.8 * weight+ 5 * (height / 6.8) * age + name.length / 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameInput = findViewById(R.id.inputName)
        weightInput = findViewById(R.id.inputWeight)
        heightInput = findViewById(R.id.inputHeight)
        ageInput = findViewById(R.id.inputAge)
        val button: Button = findViewById(R.id.submitBtn)
        val output: TextView = findViewById(R.id.outputTextView)
        button.setOnClickListener {
            val calories = calcCals()
            if (calories == null) {
                output.text = "Invalid data. Please, try again."
            } else {
                output.text = "RESULT: " + String.format("%.3f", calories) + " calories"
            }
        }
    }

    private fun calcCals(): Double? {
        val nameLen = nameInput.text.toString().length
        val height = heightInput.text.toString().toIntOrNull()
        val weight = weightInput.text.toString().toDoubleOrNull()
        val age = ageInput.text.toString().toIntOrNull()
        if (nameLen in 1..50 &&
            height != null && height in 1..249 &&
            weight != null && weight in 1.0 .. 249.0 &&
            age != null && age in  1 .. 149) {
            return 66.5 + 13.8 * weight + 5 * (height / 6.8) * age + nameLen / 2
        }
        return null
    }

}