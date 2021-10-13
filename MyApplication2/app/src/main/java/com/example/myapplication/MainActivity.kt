package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast





class MainActivity : AppCompatActivity() {
    lateinit var etNomeUsuario:EditText
    lateinit var etValorCarteira:EditText
    var valor:Double = 0.0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNomeUsuario =findViewById(R.id.input_informar_nome)
        etValorCarteira= findViewById(R.id.input_informe_valor_carteira)
       }


    fun confirmar(view: android.view.View) {

        val nome = etNomeUsuario.text.toString()
        valor = "0${etValorCarteira.text}".toDouble()


        if (nome.equals("") || valor.equals(0.0)){
            Toast.makeText(this, "Favor informar nome e valor na carteira", Toast.LENGTH_SHORT).show()
        }
        else {
            val tela2 = Intent(this, Tela2::class.java)
            //val tela3 = Intent(this, Tela3::class.java)


            tela2.putExtra("nome_usuario", nome)
            tela2.putExtra("valor_carteira", valor)

           // tela3.putExtra("valor_carteira", valor)

            startActivity(tela2)
        }
    }
}

