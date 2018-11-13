package com.jasonzhong.redditclient.items_activity

import com.jasonzhong.redditclient.model.Data

interface ItemsContract {

    interface ItemsPresenter {

        fun onDestroy()

        fun requestDataFromServer()

    }

    interface ItemsInteractor {

        interface OnItemsLoadingFinishedListener {

            fun onFailure(throwable: Throwable)

            fun onFinished(items: Data)
        }

        fun geAllItems(listener: OnItemsLoadingFinishedListener)
    }

    interface ItemsView {

        fun showProgress()

        fun hideProgress()

        fun onResponseFailure(throwable: Throwable)

        fun setDataToGridlayout(data: Data)

    }
}
