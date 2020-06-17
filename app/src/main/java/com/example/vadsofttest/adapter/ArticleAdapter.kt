package com.example.vadsofttest.adapter



import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.vadsofttest.R
import com.example.vadsofttest.model.APIResponce
import com.example.vadsofttest.model.ArticleInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.articlelist_item.view.*



class ArticleAdapter (var articleList:  ArrayList<ArticleInfo>):
    RecyclerView.Adapter<ArticleAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        println("iiiiiiiiiii ")
        val row = inflater.inflate(R.layout.articlelist_item, parent, false)
        return MyViewHolder(row)


    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemOfProduct = articleList?.get(position)
        var listItr=articleList.iterator()
        while(listItr.hasNext()) {


            val integer = listItr.next()

        }
        holder.bindView(itemOfProduct!!,position)
    }


    class MyViewHolder(val currentView: View) : RecyclerView.ViewHolder(currentView) {

        fun bindView(currentArticle: ArticleInfo, position: Int) {


           Picasso.with(currentView.context).load(currentArticle.avtar).into(currentView.profile_image)
            Picasso.with(currentView.context).load(currentArticle.articleImage).into(currentView.imageViewArticleImg)
            currentView.textViewArticleUserName.text = currentArticle.username
            currentView.textViewArticleUserDesignation.text = currentArticle.designation
            currentView.textViewArticleContent.text = currentArticle.content
            currentView.textViewArticleComments.text = currentArticle.comments.toString()+"Comments"
            currentView.textViewArticleLikes.text = currentArticle.likes.toString()+"Likes"
            currentView.textViewArticleName.text = currentArticle.title
            currentView.textViewArticleUrl.text = currentArticle.url



        }
    }
}






