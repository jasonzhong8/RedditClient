package com.jasonzhong.redditclient.items_activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ProgressBar

import com.jasonzhong.redditclient.R
import com.jasonzhong.redditclient.adapter.ItemsAdapter
import com.jasonzhong.redditclient.item_detail_activity.ItemDetailActivity
import com.jasonzhong.redditclient.model.Child
import com.jasonzhong.redditclient.model.Data
import com.jasonzhong.redditclient.util.Constant
import com.jasonzhong.redditclient.util.Util

import java.util.ArrayList

class ItemsActivity : AppCompatActivity(), ItemsContract.ItemsView {

    private var progressBar: ProgressBar? = null
    private var items_gridview: GridView? = null
    private var customAdapter: ItemsAdapter? = null
    private var itemlist: MutableList<Child>? = null
    private var presenter: ItemsContract.ItemsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        supportActionBar!!.title = getString(R.string.app_name)
        val userName = intent.getStringExtra("Username")
        supportActionBar!!.subtitle = userName

        progressBar = findViewById(R.id.progressBar)
        itemlist = ArrayList()
        items_gridview = findViewById(R.id.items_gridview)
        customAdapter = ItemsAdapter(this@ItemsActivity, itemlist!!)
        items_gridview!!.adapter = customAdapter

        items_gridview!!.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id -> navigateToDetail(position) }
        presenter = ItemsPresenterImpl(this, ItemsInteractorImpl())
        presenter!!.requestDataFromServer()
    }

    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
    }

    override fun onResponseFailure(throwable: Throwable) {
        Util.showErrorDialog(this@ItemsActivity, throwable.message)
    }

    override fun setDataToGridlayout(data: Data) {
        itemlist!!.addAll(data.children!!)
        customAdapter!!.notifyDataSetChanged()
    }

    override fun onDestroy() {
        presenter!!.onDestroy()
        super.onDestroy()
    }

    fun navigateToDetail(position: Int) {
        val permalink = Util.removeLastChar(Constant.BASE_URL) + Util.removeLastChar(itemlist!![position].data!!.permalink!!) + ".json"
        val intent = Intent(this@ItemsActivity, ItemDetailActivity::class.java)
        intent.putExtra("Permalink", permalink)
        startActivity(intent)
    }

}
