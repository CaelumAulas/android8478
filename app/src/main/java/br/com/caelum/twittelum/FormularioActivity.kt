package br.com.caelum.twittelum

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import br.com.caelum.twittelum.bancoDeDados.TwittelumDatabase
import br.com.caelum.twittelum.modelo.Tweet
import br.com.caelum.twittelum.viewmodel.TweetViewModel
import br.com.caelum.twittelum.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class FormularioActivity : AppCompatActivity() {

    private val viewModel: TweetViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(TweetViewModel::class.java)
    }


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

        when (item.itemId) {

            R.id.menuSalvar -> {
                publicaTweet()
                finish()
            }

            R.id.menuFoto -> {

                val vaiParaCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(vaiParaCamera)
            }

            android.R.id.home -> finish()
        }

        return true

    }

    private fun publicaTweet() {
        val texto = campoDeMensagem.text.toString()

        val tweet = Tweet(texto)

        viewModel.publicaTweet(tweet)

        Toast.makeText(this, "$tweet", Toast.LENGTH_LONG).show()
    }
}
