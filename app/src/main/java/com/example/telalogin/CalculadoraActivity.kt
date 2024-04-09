package com.example.telalogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        var primeiroNumero = findViewById<EditText>(R.id.primeiroNumero)

        var segundoNumero = findViewById<EditText>(R.id.segundoNumero)

        var btSomar : Button = findViewById<Button>(R.id.btSomar)

        var btSubtrair : Button = findViewById<Button>(R.id.btSubtrair)

        var btMultiplicar : Button = findViewById<Button>(R.id.btMultiplicar)

        var btDividir : Button = findViewById<Button>(R.id.btDividir)

        var resultEditText = findViewById<TextView>(R.id.resultadoEdit)

        var btCalcular = findViewById<Button>(R.id.btCalcular)

        var operacao = ""

        var result = 0F

        btSomar.setOnClickListener {
            operacao = "+"
        }

        btSubtrair.setOnClickListener {
            operacao = "-"
        }

        btMultiplicar.setOnClickListener {
            operacao = "*"
        }

        btDividir.setOnClickListener {
            operacao = "/"
        }

        btCalcular.setOnClickListener {
            if(operacao == "+") {
                result = primeiroNumero.text.toString().toFloat() + segundoNumero.text.toString().toFloat()
            }else if(operacao == "-"){
                result = primeiroNumero.text.toString().toFloat() - segundoNumero.text.toString().toFloat()
            }else if(operacao == "/"){
                result = primeiroNumero.text.toString().toFloat() / segundoNumero.text.toString().toFloat()
            }else{
                result = primeiroNumero.text.toString().toFloat() * segundoNumero.text.toString().toFloat()
            }

            resultEditText.text = result.toString()
        }
    }

}