package com.alex.primerproyecto.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.alex.primerproyecto.entities.Content
import com.alex.primerproyecto.roomDB.ContentDB


class ContentRepository(context: Context) {
    private val contactDB = ContentDB.getInstance(context)
    private val contactDAO = contactDB.contentDAO()

    suspend fun insertContent(content: Content) {
        contactDAO.insertContent(content)
    }

    suspend fun getAllContents(): List<Content> {
        return contactDAO.getAllContentSync()
    }

    fun getAllContentLiveData(): LiveData<List<Content>>{
        return contactDAO.getAllContent()
    }
}