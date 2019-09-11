package br.com.caelum.twittelum.bancoDeDados

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.caelum.twittelum.modelo.Tweet

@Database(entities = [Tweet::class], version = 1)
abstract class TwittelumDatabase : RoomDatabase() {

    abstract fun getTweetDao(): TweetDao


    companion object {

        private var database: TwittelumDatabase? = null

        fun create(contexto: Context): TwittelumDatabase {

            return database ?: createDatabase(contexto).also {  database = it }
        }

        private fun createDatabase(contexto: Context): TwittelumDatabase {
            return Room.databaseBuilder(contexto, TwittelumDatabase::class.java, "twittelum")
                .allowMainThreadQueries()
                .build()
        }


    }

}