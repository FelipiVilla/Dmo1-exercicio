package com.example.myapplication

enum class Moeda(val nome: String, val valor: Double, val imagem: Int) {
    REAL("R$",1.0,R.drawable.bandeira_brasil),
    DOLAR("U$",5.14,R.drawable.bandeira_eua),
    EURO("€",5.89,R.drawable.bandeira_eu),
}