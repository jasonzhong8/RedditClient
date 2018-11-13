package com.jasonzhong.redditclient.items_activity

import com.jasonzhong.redditclient.model.Data

class ItemsPresenterImpl(private var itemsView: ItemsContract.ItemsView?, private val itemsIntractor: ItemsContract.ItemsInteractor) : ItemsContract.ItemsPresenter, ItemsContract.ItemsInteractor.OnItemsLoadingFinishedListener {

    override fun onDestroy() {
        itemsView = null
    }

    override fun requestDataFromServer() {
        itemsView!!.showProgress()
        itemsIntractor.geAllItems(this)
    }

    override fun onFailure(throwable: Throwable) {
        if (itemsView != null) {
            itemsView!!.onResponseFailure(throwable)
            itemsView!!.hideProgress()
        }
    }

    override fun onFinished(data: Data) {
        if (itemsView != null) {
            itemsView!!.setDataToGridlayout(data)
            itemsView!!.hideProgress()
        }
    }
}
