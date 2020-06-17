package com.example.vadsofttest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vadsofttest.model.API
import com.example.vadsofttest.model.APIResponce
import com.example.vadsofttest.model.ArticleRepository
import com.example.vadsofttest.model.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ArticlesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is articles Fragment"
    }

    val text: LiveData<String> = _text



    private var mutableLiveData: MutableLiveData<List<APIResponce?>>? = null


    fun getArticleRepository(): LiveData <List<APIResponce?>>? {
        return mutableLiveData
    }

    private val _data = MutableLiveData<List<APIResponce?>>().apply {

        var mainRepository: ArticleRepository = ArticleRepository().getInstance()!!
        mutableLiveData = mainRepository.getArticle()

    }

    val data: LiveData<List<APIResponce?>>? = getArticleRepository()


    /* private val repository: ArticleRepository
    val allArticles: LiveData<List<ArticleEntity>>

    init {
        val movieDao = VadAppdatabase.getInstance(application).articleDao()
        repository = ArticleRepository(movieDao)
        allArticles = repository.allArticles
    }

    fun insert(movie: ArticleEntity) = viewModelScope.launch {
        repository.insert(movie)
    }*/

}