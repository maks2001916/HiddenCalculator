package com.example.hiddencalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculatorActivity: AppCompatActivity() {

    private lateinit var firstOperand: EditText
    private lateinit var lastOperand: EditText

    private lateinit var sumBTN: Button
    private lateinit var subBTN: Button
    private lateinit var mulBTN: Button
    private lateinit var divBTN: Button

    private lateinit var transferBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var result: Int = 0

        firstOperand = findViewById(R.id.firstOperandET)
        lastOperand = findViewById(R.id.lastOperandET)

        sumBTN = findViewById(R.id.buttonSumBTN)
        subBTN = findViewById(R.id.buttonSubBTN)
        mulBTN = findViewById(R.id.buttonMulBTN)
        divBTN = findViewById(R.id.buttonDivBTN)

        transferBTN = findViewById(R.id.buttonTransferDataBTN)

        sumBTN.setOnClickListener {
            if (firstOperand.text.matches(Regex("^[0-9]+$")) &&
                lastOperand.text.matches(Regex("^[0-9]+$"))) {

                result = firstOperand.text.toString().toInt() +
                lastOperand.text.toString().toInt()
                Toast.makeText(this, "Просмотрите результат на домашнем экране", Toast.LENGTH_LONG).show()
            }
        }

        subBTN.setOnClickListener {
            if (firstOperand.text.matches(Regex("^[0-9]+$")) &&
                lastOperand.text.matches(Regex("^[0-9]+$"))) {

                result = firstOperand.text.toString().toInt() -
                        lastOperand.text.toString().toInt()
                Toast.makeText(this, "Просмотрите результат на домашнем экране", Toast.LENGTH_LONG).show()
            }
        }

        mulBTN.setOnClickListener {
            if (firstOperand.text.matches(Regex("^[0-9]+$")) &&
                lastOperand.text.matches(Regex("^[0-9]+$"))) {

                result = firstOperand.text.toString().toInt() *
                        lastOperand.text.toString().toInt()
                Toast.makeText(this, "Просмотрите результат на домашнем экране", Toast.LENGTH_LONG).show()
            }
        }

        divBTN.setOnClickListener {
            if (firstOperand.text.matches(Regex("^[0-9]+$")) &&
                lastOperand.text.matches(Regex("^[0-9]+$"))) {

                result = firstOperand.text.toString().toInt() /
                        lastOperand.text.toString().toInt()
                Toast.makeText(this, "Просмотрите результат на домашнем экране", Toast.LENGTH_LONG).show()
            }
        }

        transferBTN.setOnClickListener {
            intent = Intent()
            intent.putExtra("res", result)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}