package br.com.caelum.twittelum

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.caelum.twittelum.bancoDeDados.TweetDao
import br.com.caelum.twittelum.bancoDeDados.TwittelumDatabase
import br.com.caelum.twittelum.modelo.Tweet
import br.com.caelum.twittelum.viewmodel.TweetViewModel
import br.com.caelum.twittelum.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_lista.*

class

ListaTweetsActivity : AppCompatActivity() {

    private val viewModel: TweetViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)


        viewModel.getLista().observe(this, Observer { tweets ->
            lista.adapter = ArrayAdapter<Tweet>(this, android.R.layout.simple_list_item_1, tweets)

        })


        fab.setOnClickListener {

            val intencao = Intent(this, FormularioActivity::class.java)

            startActivity(intencao)

        }

    }

}













