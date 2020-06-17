package com.example.vadsofttest.views.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vadsofttest.R
import com.example.vadsofttest.adapter.ArticleAdapter
import com.example.vadsofttest.model.APIResponce
import com.example.vadsofttest.model.ArticleInfo
import com.example.vadsofttest.model.ArticleList
import com.example.vadsofttest.model.User


import com.example.vadsofttest.viewmodels.ArticlesViewModel



class ArticlesFragment : Fragment() {


    private lateinit var  articlesViewModel: ArticlesViewModel
    var recylerview: RecyclerView? = null
    var articleArrayList: List<APIResponce?> = ArrayList()
    var articleAdapter: ArticleAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        articlesViewModel =
            ViewModelProviders.of(this).get(ArticlesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_article, container, false)
        recylerview = root.findViewById(R.id.recyclerview)
        recylerview!!.layoutManager = LinearLayoutManager(activity)


        articlesViewModel.data!!.observe(viewLifecycleOwner, Observer {items->
            val articles:List<APIResponce?> = items
            if (items != null) {

                val listdata:ArrayList<ArticleInfo>?= ArrayList()
                for (current in articles) {

                    val id= current!!.id

                    val content=current.content
                    val comments =current.comments
                    val likes=current.likes
                    val media:List<ArticleList> =current.media
                    var img:String?= String()
                    var title :String?= String()
                    var url:String?= String()
                    for(cMedia in media) {
                         img = cMedia.image
                        println("we are here$img")
                         title =cMedia.title
                         url=cMedia.url
                    }
                    val users:List<User> = current.user
                    var username:String?= String()
                    var designation :String?= String()
                    var avatar:String?= String()
                    for (user in users)
                    {
                        username=user.name
                        println("we are here$username")
                        designation =user.designation
                        avatar=user.avatar
                    }
                    listdata!!.add(ArticleInfo(
                        id,
                        content,
                        likes.toString(),
                        comments.toString(),
                        username!!,
                        title!!,
                        avatar!!,
                        img!!,
                        designation!!,
                        url!!
                    ))
              }

                //articleArrayList=articles
                articleAdapter = ArticleAdapter(listdata!!)
                articleAdapter!!.notifyDataSetChanged()
            }
            recylerview!!.adapter=articleAdapter

        })

           return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(activity)
        recylerview!!.layoutManager = layoutManager
        recylerview!!.adapter=articleAdapter

    }
   /*
    articlesViewModel.allArticles.observe(viewLifecycleOwner, Observer { items ->
        if (items.isEmpty()) {
            articlesViewModel.insert(ArticleEntity("Article 1", "2001","","","",""))
        }

        Log.d(TAG, "ITEMS: $items")
    })
    */
}