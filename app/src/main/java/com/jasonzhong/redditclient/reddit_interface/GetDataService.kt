package com.jasonzhong.redditclient.reddit_interface

import com.jasonzhong.redditclient.model.Child
import com.jasonzhong.redditclient.model.Data
import com.jasonzhong.redditclient.model.ItemResponse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface GetDataService {

    @get:GET("r/all.json")
    val allItems: Call<ItemResponse>

    @GET
    fun getItemDetail(@Url url: String): Call<List<ItemResponse>>

}
