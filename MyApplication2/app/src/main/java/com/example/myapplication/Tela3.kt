package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Tela3 : AppCompatActivity() {

    var valorAtualCarteira:Double = 0.0
    var valorCalculadoCompra:Double = 0.0
    var valorSoma:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela3)

        val tvValorAtualCarteira = intent.getDoubleExtra("valor_carteira", 0.0)
        val tvValorCalculado = intent.getDoubleExtra("valor_calculado", 0.0)

        valorAtualCarteira= "0${tvValorAtualCarteira}".toDouble()
        valorCalculadoCompra = "0${tvValorCalculado}".toDouble()

        val txtValorCarteira = getString(R.string.str_valor_atual, valorAtualCarteira)
        val txtValorCalculado= getString(R.string.str_txt_valor_calculado, valorCalculadoCompra)

        val tvTxtvalorCarteira:TextView = findViewById(R.id.id_txt_valor_atual_carteira)
        val tvTxtValorCalculado:TextView = findViewById(R.id.id_txt_valor_compra)

        tvTxtvalorCarteira.text = txtValorCarteira
        tvTxtValorCalculado.text = txtValorCalculado

        valorSoma = valorAtualCarteira - valorCalculadoCompra

    }



    fun realizar_pagamento(view: android.view.View) {
        val tvImagem:ImageView = findViewById(R.id.img)
        val tvTxtConfirmacao:TextView = findViewById(R.id.id_txt_valor_carteira5)



        if (valorSoma < 0){
            tvImagem.setImageDrawable(getDrawable(R.mipmap.warning))
            tvTxtConfirmacao.text = getString(R.string.str_confirmacao_negativa_pagamento)
        }

        else{
            tvImagem.setImageDrawable(getDrawable(R.mipmap.thumb))
            tvTxtConfirmacao.text = getString(R.string.str_confirmacao_positiva_pagamento)
        }

    }
}