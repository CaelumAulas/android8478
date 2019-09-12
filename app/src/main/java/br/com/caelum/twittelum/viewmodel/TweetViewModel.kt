package br.com.caelum.twittelum.viewmodel

import androidx.lifecycle.ViewModel
import br.com.caelum.twittelum.modelo.Tweet
import br.com.caelum.twittelum.repository.TweetRepository

class TweetViewModel(private val repository: TweetRepository) : ViewModel() {

    fun publicaTweet(tweet: Tweet) = repository.salva(tweet)

    fun getLista() = repository.listaTweets()

    fun deleta(tweet: Tweet) = repository.deleta(tweet)
}