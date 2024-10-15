package com.example.hiddencalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var resultTV: TextView
    private lateinit var calculatorBTN: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        resultTV = findViewById(R.id.resultTV)
        calculatorBTN = findViewById(R.id.buttonCalcBTN)
        calculatorBTN.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
            launchSomeActivity.launch(intent)
        }
    }

    private val launchSomeActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            resultTV.setText(data!!.getStringExtra("res").toString())
            Toast.makeText(this, "$data", Toast.LENGTH_LONG).show()

        } else {

        }
    }
}