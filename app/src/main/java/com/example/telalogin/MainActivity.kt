package com.example.telalogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Busca o objeto da tela e atribui na variável kotlin
        val btEntrar: Button = findViewById<Button>(R.id.btEntrar)

        // Seta o evento de listener do click do objeto
        btEntrar.setOnClickListener {
            // Busca os objetos da tela e atribui em suas respectivas variáveis
            val etUsuario = findViewById<EditText>(R.id.etUsuario)
            val etSenha = findViewById<EditText>(R.id.etSenha)

            // Valida se o campo usuário e senha estão preenchidos
            if (etUsuario.text.toString() != "" && etSenha.text.toString() != "") {

                var user = BD.users.firstOrNull() { it -> it.username == etUsuario.text.toString() }


                if (user != null) {
                    var sysUser = user.nome
                    var sysSenha = user.senha

                    // Converte o valor para inteiro e verifica se é igual ao valor da variável sysSenha
                    if (etSenha.text.toString() == sysSenha) {
                        //Exibe a mensagem de bem vindo
                        val newIntent = Intent(this, CalculadoraActivity::class.java)
                        startActivity(newIntent)
                    } else {
                        //Exibe a mensagem de usuário ou senha inválidos
                        Toast.makeText(this, "Usuario ou senha inválidos!", Toast.LENGTH_SHORT)
                            .show()
                    }
                } else {
                    Toast.makeText(this, "Usuário não encontrado!", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "Digite o usuário e senha", Toast.LENGTH_SHORT).show()
            }

        }

        // Busca o objeto da tela e atribui na variável kotlin
        val btCadastrar: Button = findViewById<Button>(R.id.btCadastrar)

        // Seta o evento de listener do click do objeto
        btCadastrar.setOnClickListener {
            val newIntent = Intent(this, CadastroActivity::class.java)
            startActivity(newIntent)
        }
    }


}