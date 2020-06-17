package com.example.vadsofttest.model

data class APIResponce(
                 val id :String,
                 val comments:Int,
                  val likes:Int,
                  val content:String,
                  val media:List<ArticleList>,
                  val user:List<User>)

data class ArticleList(val url:String,val title:String, val image:String)

data class User(val name:String,val designation:String, val avatar:String,val lastname:String)