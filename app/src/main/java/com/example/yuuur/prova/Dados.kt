package com.example.yuuur.prova

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.R.array
import android.widget.*
import android.content.Intent




class Dados : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dados)

        val btConfirmar = findViewById<Button>(R.id.btConfirmar)
        val edIdade = findViewById<EditText>(R.id.edIdade)

        val spSpiner = findViewById<Spinner>(R.id.spinner)
        var list_of_items = arrayOf("Analfabeto", "Ensino Medio", "Graduação", "Pos Graduação")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,list_of_items)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spSpiner.adapter = adapter;

        btConfirmar.setOnClickListener{
            if(edIdade.text.toString().toInt() < 16) {
                Toast.makeText(this, "Idade deve ser maior que 16 anos", Toast.LENGTH_SHORT).show()
            }else {
                val candidato = intent.getStringExtra("candidato")
                Toast.makeText(
                    this,
                    "Obrigado por participar da entrevista. Seu voto foi no candidato: " + candidato,
                    Toast.LENGTH_SHORT
                ).show()

                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/html"
                intent.putExtra(Intent.EXTRA_EMAIL, "intensaovotos@teste.com.br" )
                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
                intent.putExtra(Intent.EXTRA_TEXT, "Obrigado por participar da entrevista. Seu voto foi no candidato: " + candidato)

                startActivity(Intent.createChooser(intent, "Send Email"));

                val intent2 = Intent(this@Dados, Prova::class.java)
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent2)

            }
        }
    }
}