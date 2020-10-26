package com.alex.primerproyecto.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.alex.primerproyecto.entities.Content
import com.alex.primerproyecto.repositories.ContentRepository


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val contentRepository = ContentRepository(application)

    fun getContents() : LiveData<List<Content>> = liveData {
        emitSource(contentRepository.getAllContentLiveData())
    }
}