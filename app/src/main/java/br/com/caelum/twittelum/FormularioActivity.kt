package br.com.caelum.twittelum

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class FormularioActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        salvar.setOnClickListener {

            publicaTweet()

            finish()

        }
    }

    private fun publicaTweet() {
        val texto = campoDeMensagem.text.toString()

        Toast.makeText(this, texto, Toast.LENGTH_LONG).show()
    }
}
