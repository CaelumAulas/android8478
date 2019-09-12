package br.com.caelum.twittelum

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.com.caelum.twittelum.bancoDeDados.TweetDao
import br.com.caelum.twittelum.bancoDeDados.TwittelumDatabase
import br.com.caelum.twittelum.modelo.Tweet
import kotlinx.android.synthetic.main.activity_lista.*

class ListaTweetsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val database = TwittelumDatabase.create(this)
        val dao = database.getTweetDao()
        val tweets = dao.lista()


        lista.adapter = ArrayAdapter<Tweet>(this, android.R.layout.simple_list_item_1, tweets)


        fab.setOnClickListener {

            val intencao = Intent(this, FormularioActivity::class.java)

            startActivity(intencao)

        }

    }
}