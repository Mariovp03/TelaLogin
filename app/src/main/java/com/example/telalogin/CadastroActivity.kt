package com.example.telalogin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CadastroActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        var buttonCadastrar : Button = findViewById<Button>(R.id.buttonCadastrar)
        buttonCadastrar.setOnClickListener {
            val nome = findViewById<EditText>(R.id.nomeCadastro).text.toString()
            val usuario = findViewById<EditText>(R.id.usuarioCadastro).text.toString()
            val senha = findViewById<EditText>(R.id.senhaCadastro).text.toString()
            val senhaConfirmada = findViewById<EditText>(R.id.senhaCadastroConfirmar).text.toString()

            if(nome != null && usuario != null && senha != null && senha == senhaConfirmada ) {
                var user = UserModel()
                user.nome = nome.toString()
                user.username = usuario.toString()
                user.senha = senha.toString()
                BD.users.add(user)
            }else{
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
        var buttonVolta : Button = findViewById<Button>(R.id.buttonVoltar)
        buttonVolta.setOnClickListener {
            val newIntent = Intent(this, MainActivity::class.java)
            startActivity(newIntent)
        }
    }
}