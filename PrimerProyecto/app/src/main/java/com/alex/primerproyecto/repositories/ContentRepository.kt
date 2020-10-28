package com.alex.primerproyecto.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.alex.primerproyecto.entities.Content
import com.alex.primerproyecto.roomDB.ContentDB


class ContentRepository(context: Context) {
    private val registrosDB = ContentDB.getInstance(context)
    private val registrosDAO = registrosDB.contentDAO()

    suspend fun insertContent(content: Content) {
        registrosDAO.insertContent(content)
    }

    suspend fun getAllContents(): List<Content> {
        return registrosDAO.getAllContentSync()
    }

    fun getAllContentLiveData(): LiveData<List<Content>>{
        return registrosDAO.getAllContent()
    }
}