package br.com.caelum.twittelum.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.com.caelum.twittelum.DecodificadorDeBase64
import br.com.caelum.twittelum.R
import br.com.caelum.twittelum.modelo.Tweet
import kotlinx.android.synthetic.main.item_tweet.view.*

class TweetAdapter(private val tweets: List<Tweet>) : BaseAdapter() {

    override fun getCount(): Int = tweets.size

    override fun getItem(position: Int): Any = tweets[position]

    override fun getItemId(position: Int): Long = tweets[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val tweet = tweets[position]

        val inflater = LayoutInflater.from(parent.context)
        val view = convertView ?: inflater.inflate(R.layout.item_tweet, parent, false)


        view.item_conteudo.text = tweet.conteudo

        view.item_foto.visibility = View.GONE

        tweet.foto?.let {

            view.item_foto.visibility = View.VISIBLE

            view.item_foto.setImageBitmap(DecodificadorDeBase64.decodifica(it))

        }

        return view

    }
}