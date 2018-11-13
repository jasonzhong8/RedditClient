package com.jasonzhong.redditclient.item_detail_activity

import com.jasonzhong.redditclient.model.Data

interface ItemDetailContract {

    interface ItemDetailPresenter {

        fun onDestroy()

        fun requestDataFromServer(permalink: String)

    }

    interface ItemDetailInteractor {

        interface OnItemsLoadingFinishedListener {

            fun onFailure(throwable: Throwable)

            fun onFinished(items: Data)
        }

        fun getItemDetail(permalink: String, listener: OnItemsLoadingFinishedListener)
    }

    interface ItemDetailView {

        fun showProgress()

        fun hideProgress()

        fun onResponseFailure(throwable: Throwable)

        fun setDataToView(data: Data)

    }
}
