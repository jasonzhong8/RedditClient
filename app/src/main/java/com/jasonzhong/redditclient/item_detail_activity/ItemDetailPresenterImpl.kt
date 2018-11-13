package com.jasonzhong.redditclient.item_detail_activity

import com.jasonzhong.redditclient.items_activity.ItemsContract
import com.jasonzhong.redditclient.model.Data

class ItemDetailPresenterImpl(private var itemDetailView: ItemDetailContract.ItemDetailView?, private val itemDetailIntractor: ItemDetailContract.ItemDetailInteractor) : ItemDetailContract.ItemDetailPresenter, ItemDetailContract.ItemDetailInteractor.OnItemsLoadingFinishedListener {


    override fun onDestroy() {
        itemDetailView = null
    }

    override fun requestDataFromServer(permalink: String) {
        itemDetailView!!.showProgress()
        itemDetailIntractor.getItemDetail(permalink, this)

    }

    override fun onFailure(throwable: Throwable) {
        if (itemDetailView != null) {
            itemDetailView!!.onResponseFailure(throwable)
            itemDetailView!!.hideProgress()
        }
    }

    override fun onFinished(data: Data) {
        if (itemDetailView != null) {
            itemDetailView!!.setDataToView(data)
            itemDetailView!!.hideProgress()
        }
    }
}
