package com.alex.primerproyecto.roomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alex.primerproyecto.DAO.ContentDAO
import com.alex.primerproyecto.entities.Content
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [Content::class],
    version = 6,
    exportSchema = true
)
abstract class ContentDB : RoomDatabase() {
    abstract fun contentDAO(): ContentDAO

    companion object {
        @JvmStatic
        @Volatile
        private var instance: ContentDB? = null

        @Synchronized
        fun getInstance(context: Context): ContentDB {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    ContentDB::class.java,
                    "content.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                CoroutineScope(Dispatchers.IO).launch {
                    instance?.initDB()
                }
            }

            return instance as ContentDB
        }
    }

    suspend fun initDB() {
        val contentDAO = contentDAO()
        if (contentDAO.getAllContentSync().isEmpty()) {
            contentDAO.insertContent(
                Content(
                    nombre = "Alejandro Félix",
                    correo = "alexfelix2399@gmail.com",
                    telefono = 6673445439,
                    genero = "Terror",
                    peliculas="Masacre en Texas\nActividad Paranormal\nSaw"
                )
            )

        }
    }
}