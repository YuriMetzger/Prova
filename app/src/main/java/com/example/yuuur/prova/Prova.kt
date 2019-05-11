package com.example.yuuur.prova

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast

class Prova : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prova)

        val btConfirmar = findViewById<Button>(R.id.btConfirmar)
        val rbDoria = findViewById<RadioButton>(R.id.rbDoria)
        val rbLula = findViewById<RadioButton>(R.id.rbLula)
        val rbMarina = findViewById<RadioButton>(R.id.rbMarina)
        val rbBolsonaro = findViewById<RadioButton>(R.id.rbBolsonaro)
        val rbBranco = findViewById<RadioButton>(R.id.rbBranco)
        val rbNulo = findViewById<RadioButton>(R.id.rbNulo)


        btConfirmar.setOnClickListener{
            var candidato = ""
            var ehSelecionado = false
            if(rbDoria.isChecked) {
                candidato = "Doria"
                ehSelecionado = true
            }
            if(rbLula.isChecked) {
                candidato = "Lula"
                ehSelecionado = true
            }
            if(rbMarina.isChecked) {
                candidato = "Marina"
                ehSelecionado = true
            }
            if(rbBolsonaro.isChecked) {
                candidato = "Bolsonaro"
                ehSelecionado = true
            }
            if(rbNulo.isChecked) {
                candidato = "Nulo"
                ehSelecionado = true
            }
            if(rbBranco.isChecked) {
                candidato = "Branco"
                ehSelecionado = true
            }
            if(!ehSelecionado){
                Toast.makeText(this, "Necessário selecionar um candidato!", Toast.LENGTH_LONG).show()
            }else {
                val intent = Intent(this, Dados::class.java)
                intent.putExtra("candidato", candidato)
                //Toast.makeText(this, "" + candidato, Toast.LENGTH_LONG).show()
                startActivity(intent)
            }
        }
    }
}
