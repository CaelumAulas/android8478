package br.com.caelum.twittelum.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.caelum.twittelum.application.TwittelumApplication
import br.com.caelum.twittelum.bancoDeDados.TweetDao
import br.com.caelum.twittelum.bancoDeDados.TwittelumDatabase
import br.com.caelum.twittelum.repository.TweetRepository

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private val contexto = TwittelumApplication.getInstance()
    private val database = TwittelumDatabase.create(contexto)
    private val tweetDao: TweetDao = database.getTweetDao()
    private val repository : TweetRepository = TweetRepository(tweetDao)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TweetViewModel(repository) as T
    }
}