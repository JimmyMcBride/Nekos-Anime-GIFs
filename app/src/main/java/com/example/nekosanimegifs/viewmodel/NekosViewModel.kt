package com.example.nekosanimegifs.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nekosanimegifs.models.AnimeCategories
import com.example.nekosanimegifs.models.AnimeGIFList
import com.example.nekosanimegifs.models.Url
import com.example.nekosanimegifs.repo.NekosRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NekosViewModel : ViewModel() {
    private val _nekos = MutableLiveData<AnimeCategories>()
    val nekos: LiveData<AnimeCategories> get() = _nekos

    fun loadNekos() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = NekosRepo.getAnimeCategoryInfo()
            val categoryObject = if (response.isSuccessful)
                response.body()
            else null
            categoryObject?.let { categories -> _nekos.postValue(categories) }
        }
    }

    private val _categories = MutableLiveData<AnimeCategories>()
    val categories: LiveData<AnimeCategories> get() = _categories

    fun loadCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = NekosRepo.getAnimeCategoryInfo()
            val categoryObject = if (response.isSuccessful)
                response.body()
            else null
            categoryObject?.let { categories -> _categories.postValue(categories) }
        }
    }

    private val _gifs = MutableLiveData<List<Url>>()
    val gifs: LiveData<List<Url>> get() = _gifs

    fun loadGIFs(path: String, amount: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = NekosRepo.getAnimeGIFURLs(path, amount)
            val list = if (response.isSuccessful)
                response.body()
            else null
            list?.let { animeGIFs -> _gifs.postValue(animeGIFs.urls) }
        }
    }
}