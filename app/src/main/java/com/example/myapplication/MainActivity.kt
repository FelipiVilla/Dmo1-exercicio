package com.example.myapplication

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    private var moedaOrigem: Moeda = Moeda.REAL;
    private var moedaDestino: Moeda = Moeda.DOLAR;
    private var moedaFora: Moeda = Moeda.EURO;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgFora: ImageView = ImageView(this);
        imgFora.setImageResource(R.drawable.bandeira_eu);
        val imgEntrada: ImageView = findViewById<ImageView>(R.id.img_entrada);
        val imgSaida: ImageView = findViewById<ImageView>(R.id.img_saida);
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado);
        val botaoTrocar = findViewById<Button>(R.id.btn_trocar);
        val botaoCalcular = findViewById<Button>(R.id.btn_calcular);
        val trocarDireita = findViewById<Button>(R.id.trocar_d);
        val trocarEsquerda = findViewById<Button>(R.id.esquerda);

        trocarEsquerda.setOnClickListener {
            val temp: Moeda = moedaOrigem;
            moedaOrigem = moedaFora;
            moedaFora = temp;

            val imgTemp: ImageView = ImageView(this);
            imgTemp.setImageDrawable(imgEntrada.drawable)
            imgEntrada.setImageDrawable(imgFora.drawable);
            imgFora.setImageDrawable(imgTemp.drawable);
        }

        trocarDireita.setOnClickListener {
            val temp: Moeda = moedaDestino;
            moedaDestino = moedaFora;
            moedaFora = temp;

            val imgTemp: ImageView = ImageView(this);
            imgTemp.setImageDrawable(imgSaida.drawable)
            imgSaida.setImageDrawable(imgFora.drawable);
            imgFora.setImageDrawable(imgTemp.drawable);
        }

        botaoTrocar.setOnClickListener {
            trocarImagem(imgEntrada,imgSaida)
        }

        botaoCalcular.setOnClickListener {
            val campoValor = findViewById<EditText>(R.id.entrada_valor)
            val valorDigitado: Double = campoValor.text.toString().toDoubleOrNull() ?: 0.0

            mudarValor(valorDigitado,moedaOrigem,moedaDestino,txt_resultado);
        }

    }

    fun trocarImagem(esquerda: ImageView, direita: ImageView){
        val temp= esquerda.drawable;
        esquerda.setImageDrawable(direita.drawable);
        direita.setImageDrawable(temp);

        val tempMoeda = moedaOrigem
        moedaOrigem = moedaDestino
        moedaDestino = tempMoeda
    }

    fun mudarValor(valorDigitado: Double,entrada: Moeda, saida: Moeda,txtResultado: TextView){

        val resultado: Double = (valorDigitado * entrada.valor) / saida.valor;
        val resultadotxt: String = ("Resultado = " + saida.nome + " " + String.format("%.2f", resultado));
        txtResultado.setText(resultadotxt);

    }
}