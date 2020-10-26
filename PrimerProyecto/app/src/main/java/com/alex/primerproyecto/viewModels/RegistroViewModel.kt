package com.alex.primerproyecto.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.alex.primerproyecto.entities.Content
import com.alex.primerproyecto.repositories.ContentRepository
import kotlinx.coroutines.launch

class RegistroViewModel(application: Application) : AndroidViewModel(application) {
    private val contentRepository = ContentRepository(application)
    private val TAG = RegistroViewModel::class.java.name
    private val insertLiveData = MutableLiveData<Boolean>()

    fun insertContent(content: Content) = viewModelScope.launch{
        try {
            contentRepository.insertContent(content)
            insertLiveData.postValue(true)
        }catch(ex: Exception){
            Log.e(TAG,ex.message,ex)
            insertLiveData.postValue(false)
        }
    }
    fun notifyInsertContent() : LiveData<Boolean> = insertLiveData

    fun getAllContent() : LiveData<List<Content>> = liveData {
        emit(contentRepository.getAllContents())
    }
}