package br.com.caelum.twittelum

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.caelum.twittelum.adapter.TweetAdapter
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
            lista.adapter = TweetAdapter(tweets)

        })


        lista.setOnItemClickListener { _, _, posicao, _ ->
            val tweet = lista.getItemAtPosition(posicao) as Tweet

            perguntaSePrecisaDeletar(tweet)
        }

        fab.setOnClickListener {

            val intencao = Intent(this, FormularioActivity::class.java)

            startActivity(intencao)

        }

    }

    private fun perguntaSePrecisaDeletar(tweet: Tweet) {
        AlertDialog.Builder(this)
            .setIcon(R.drawable.ic_warning)
            .setTitle("Atenção")
            .setMessage("Você quer mesmo apagar esse tweet?")
            .setPositiveButton("Sim") { _, _ ->
                viewModel.deleta(tweet)
            }
            .setNegativeButton("Não", null)
            .setNeutralButton("Vish", null)
            .show()
    }

}













