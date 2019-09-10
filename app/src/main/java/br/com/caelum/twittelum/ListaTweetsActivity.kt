package br.com.caelum.twittelum

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lista.*

class ListaTweetsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val tweets = arrayListOf("tweet 1 ", "tweet 2 ", "tweet 3", "tweet 4", "tweet 1 ", "tweet 2 ", "tweet 3", "tweet 4", "tweet 1 ", "tweet 2 ", "tweet 3", "tweet 4", "tweet 1 ", "tweet 2 ", "tweet 3", "tweet 4", "tweet 1 ", "tweet 2 ", "tweet 3", "tweet 4")


        lista.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , tweets)
    }
}