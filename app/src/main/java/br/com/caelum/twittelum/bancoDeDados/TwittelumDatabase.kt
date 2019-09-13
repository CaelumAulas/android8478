package br.com.caelum.twittelum.bancoDeDados

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import br.com.caelum.twittelum.modelo.Tweet

@Database(entities = [Tweet::class], version = 2, exportSchema = false)
abstract class TwittelumDatabase : RoomDatabase() {

    abstract fun getTweetDao(): TweetDao


    companion object {

        private var database: TwittelumDatabase? = null

        fun create(contexto: Context): TwittelumDatabase {

            return database ?: createDatabase(contexto).also { database = it }
        }

        private fun createDatabase(contexto: Context): TwittelumDatabase {
            return Room.databaseBuilder(contexto, TwittelumDatabase::class.java, "twittelum")
                .allowMainThreadQueries()
                .addMigrations(migracao1para2())
                .build()
        }

        private fun migracao1para2(): Migration {
            return object : Migration(1, 2) {
                override fun migrate(database: SupportSQLiteDatabase) {

                    database.execSQL("alter table Tweet add column foto text ")

                }


            }
        }


    }

}