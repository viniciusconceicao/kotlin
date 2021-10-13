package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class Tela2 : AppCompatActivity() {

    var valorBanana:Double = 0.0
    var valorMamao:Double = 0.0
    var valorGoiaba:Double = 0.0
    var valorCalculado:Double = 0.0
    var varValorCarteira:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela2)





        val nome = intent.getStringExtra("nome_usuario")
        val valor = intent.getDoubleExtra("valor_carteira", 0.0)


        val valorCarteita = getString(R.string.str_valor_atual, valor)

        val tvValorCarteita:TextView = findViewById(R.id.id_txt_valor_carteira)
        tvValorCarteita.text = valorCarteita

        val tvNomeUsuario:TextView = findViewById(R.id.id_txt_nome_usuario)
        tvNomeUsuario.text = nome

        varValorCarteira = valor
    }

    fun calcular_valor(view: android.view.View) {


        val tvValorBanana:TextView = findViewById(R.id.id_input_kg_banana)
        val tvValorMamao:TextView = findViewById(R.id.id_input_kg_mamao)
        val tvValorGoiaba:TextView = findViewById(R.id.id_input_kg_goiaba)

        valorMamao = "0${tvValorMamao.text}".toDouble()
        valorBanana = "0${tvValorBanana.text}".toDouble()
        valorGoiaba = "0${tvValorGoiaba.text}".toDouble()

        valorCalculado = (valorBanana * 3) + (valorGoiaba * 4) + (valorMamao * 6)

        val tvValorCalculado:TextView = findViewById(R.id.id_txt_valor_calculado)
        tvValorCalculado.text = valorCalculado.toString()

        Toast.makeText(this, "$valorCalculado", Toast.LENGTH_SHORT).show()




    }

    fun iniciar_pagamento(view: android.view.View) {
        val tela3 = Intent(this, Tela3::class.java)

        tela3.putExtra("valor_calculado", valorCalculado)

        tela3.putExtra("valor_carteira", varValorCarteira)

        startActivity(tela3)
    }
}