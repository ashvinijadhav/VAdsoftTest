package com.example.vadsofttest.model

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ArticleRepository () {


    private var articleRepository: ArticleRepository? = null

    fun getInstance(): ArticleRepository? {
        if (articleRepository == null) {
            articleRepository = ArticleRepository()
        }
        return articleRepository
    }

    fun getArticle(): MutableLiveData<List<APIResponce?>> {
        val articleData: MutableLiveData<List<APIResponce?>> = MutableLiveData<List<APIResponce?>>()
        RetrofitClient.instance.getArticles().enqueue(object : Callback<List<APIResponce>>{
            fun onResponse(
                call: Callback<List<APIResponce?>>,
                response: Response<APIResponce?>
            ) {

            }

            override fun onResponse(
                call: Call<List<APIResponce>>,
                response: Response<List<APIResponce>>
            ) {
                println("response${response.body()}")
                if (response.isSuccessful) {
                   articleData.setValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<APIResponce>>, t: Throwable) {
                println("response${t!!.message}")
            }
        })
        return articleData
    }

   /* val allArticles: LiveData<List<ArticleEntity>> = articleDao.getAll()

    fun insert(article: ArticleEntity) {
        articleDao.insert(article)
    }*/
}
