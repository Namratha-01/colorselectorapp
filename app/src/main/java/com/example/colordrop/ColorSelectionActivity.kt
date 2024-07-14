package com.example.colordrop
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ColorSelectionActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var spinner: Spinner
    private lateinit var buttonApply: Button
    private lateinit var layout: RelativeLayout
    private var selectedColor: String = "White"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_selection)

        spinner = findViewById(R.id.spinner)
        buttonApply = findViewById(R.id.buttonApply)
        layout = findViewById(R.id.layout)

        //Get selected color from the intent
        val colorFromPreviousScreen = intent.getStringExtra("selectedColor") ?: "White"

        //Create ArrayAdapter using the color array and a default spinner layout
        val colors = arrayOf("Red", "Green", "Blue")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        //Set spinner listener
        spinner.onItemSelectedListener = this

        //Set button click listener
        buttonApply.setOnClickListener {
            when (selectedColor) {
                "Red" -> layout.setBackgroundColor(Color.RED)
                "Green" -> layout.setBackgroundColor(Color.GREEN)
                "Blue" -> layout.setBackgroundColor(Color.BLUE)
                else -> layout.setBackgroundColor(Color.WHITE)
            }
            Toast.makeText(this, "Background color set to $selectedColor", Toast.LENGTH_SHORT).show()
        }

        //Set initial background color
        when (colorFromPreviousScreen) {
            "Red" -> layout.setBackgroundColor(Color.RED)
            "Green" -> layout.setBackgroundColor(Color.GREEN)
            "Blue" -> layout.setBackgroundColor(Color.BLUE)
            else -> layout.setBackgroundColor(Color.WHITE)
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        selectedColor = parent?.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        //Do nothing
    }
}