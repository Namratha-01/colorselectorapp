package com.example.colordrop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonNext: Button = findViewById(R.id.buttonNext)

        buttonNext.setOnClickListener {
            val selectedColor = when {
                findViewById<RadioButton>(R.id.radioButtonRed).isChecked -> "Red"
                findViewById<RadioButton>(R.id.radioButtonGreen).isChecked -> "Green"
                findViewById<RadioButton>(R.id.radioButtonBlue).isChecked -> "Blue"
                else -> "White"
            }
            val intent = Intent(this, ColorSelectionActivity::class.java)
            intent.putExtra("selectedColor", selectedColor)
            startActivity(intent)
        }
    }
}
