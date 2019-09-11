package br.com.caelum.twittelum

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class FormularioActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.formulario_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {

            R.id.menuSalvar -> {
                publicaTweet()
                finish()
            }

            android.R.id.home -> finish()
        }

        return true

    }

    private fun publicaTweet() {
        val texto = campoDeMensagem.text.toString()

        Toast.makeText(this, texto, Toast.LENGTH_LONG).show()
    }
}
