package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val conversor: String = " ois"


        val botaoCalcular = findViewById<Button>(R.id.btn_calcular)

        botaoCalcular.setOnClickListener {
            val campoValor = findViewById<EditText>(R.id.entrada_valor)
            val valorDigitado: Double = campoValor.text.toString().toDoubleOrNull() ?: 0.0

            mudarValor(valorDigitado);
        }

    }


    fun mudarValor(valorDigitado: Double){


        val txt_resultado = findViewById<TextView>(R.id.txt_resultado);
        val resultadotxt: String = ("Resultado = U$" + valorDigitado)
        txt_resultado.setText(resultadotxt);

    }
}