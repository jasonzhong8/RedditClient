package com.jasonzhong.redditclient.items_activity

import com.jasonzhong.redditclient.model.Child
import com.jasonzhong.redditclient.model.ItemResponse
import com.jasonzhong.redditclient.network.RetrofitInstance
import com.jasonzhong.redditclient.reddit_interface.GetDataService

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemsInteractorImpl : ItemsContract.ItemsInteractor {


    override fun geAllItems(onFinishedListener: ItemsContract.ItemsInteractor.OnItemsLoadingFinishedListener) {


        /** Create handle for the RetrofitInstance interface */
        val service = RetrofitInstance.retrofitInstance!!.create(GetDataService::class.java)

        /** Call the method with parameter in the interface to get the notice data */
        val call = service.allItems

        call.enqueue(object : Callback<ItemResponse> {
            override fun onResponse(call: Call<ItemResponse>, response: Response<ItemResponse>) {
                onFinishedListener.onFinished(response.body().data!!)
            }

            override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                onFinishedListener.onFailure(t)
            }
        })

    }

}
