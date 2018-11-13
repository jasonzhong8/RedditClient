package com.jasonzhong.redditclient.item_detail_activity

import com.jasonzhong.redditclient.model.ItemResponse
import com.jasonzhong.redditclient.network.RetrofitInstance
import com.jasonzhong.redditclient.reddit_interface.GetDataService

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemDetailInteractorImpl : ItemDetailContract.ItemDetailInteractor {

    override fun getItemDetail(url: String, listener: ItemDetailContract.ItemDetailInteractor.OnItemsLoadingFinishedListener) {

        /** Create handle for the RetrofitInstance interface */
        val service = RetrofitInstance.retrofitInstance!!.create(GetDataService::class.java)

        /** Call the method with parameter in the interface to get the notice data */
        val call = service.getItemDetail(url)

        call.enqueue(object : Callback<List<ItemResponse>> {
            override fun onResponse(call: Call<List<ItemResponse>>, response: Response<List<ItemResponse>>) {
                if (response.body() != null) {
                    listener.onFinished(response.body()[0].data!!)
                } else {
                    listener.onFailure(Throwable())
                }
            }

            override fun onFailure(call: Call<List<ItemResponse>>, t: Throwable) {
                listener.onFailure(t)
            }
        })

    }
}
