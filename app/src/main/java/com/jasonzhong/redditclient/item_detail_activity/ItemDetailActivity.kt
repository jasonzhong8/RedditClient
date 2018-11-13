package com.jasonzhong.redditclient.item_detail_activity

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.jasonzhong.redditclient.R
import com.jasonzhong.redditclient.model.Data
import com.jasonzhong.redditclient.model.GlideApp
import com.jasonzhong.redditclient.util.Util
import kotlinx.android.synthetic.main.content_item_detail.*


class ItemDetailActivity : AppCompatActivity(), ItemDetailContract.ItemDetailView {

    private var progressBar: ProgressBar? = null
    private var itemDetailPresenter: ItemDetailContract.ItemDetailPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        supportActionBar!!.title = getString(R.string.app_name)

        val permalink = intent.getStringExtra("Permalink")
        progressBar = findViewById(R.id.progressBar)
        itemDetailPresenter = ItemDetailPresenterImpl(this, ItemDetailInteractorImpl())
        itemDetailPresenter!!.requestDataFromServer(permalink)
    }

    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
    }

    override fun onResponseFailure(throwable: Throwable) {
        Util.showErrorDialog(this@ItemDetailActivity, throwable.message)
    }

    override fun setDataToView(data: Data) {
        updateViews(data)
    }

    override fun onDestroy() {
        itemDetailPresenter!!.onDestroy()
        super.onDestroy()
    }

    private fun updateViews(data: Data) {
        val child = data.children!![0]

        title_textView!!.text = child.data!!.title
        author_textView!!.text = child.data!!.author
        body_textView!!.text = child.data!!.body

        val image_width = Util.getScreenWidthPixels(this@ItemDetailActivity)
        image!!.layoutParams = LinearLayout.LayoutParams(image_width, image_width)
        image!!.scaleType = ImageView.ScaleType.CENTER

        if (child.data!!.preview != null) {

            GlideApp.with(this)
                    .load(child.data!!.preview!!.images!![0].source!!.url)
                    .centerInside()
                    .transition(DrawableTransitionOptions.withCrossFade()) //Optional
                    .skipMemoryCache(true)  //No memory cache
                    .diskCacheStrategy(DiskCacheStrategy.NONE)   //No disk cache
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(@Nullable e: GlideException?, model: Any, target: Target<Drawable>, isFirstResource: Boolean): Boolean {
                            image!!.setImageResource(R.drawable.no_image_icon);
                            return true
                        }

                        override fun onResourceReady(resource: Drawable, model: Any, target: Target<Drawable>, dataSource: DataSource, isFirstResource: Boolean): Boolean {
                            return false
                        }
                    })
                    .into(image)
        } else {
            image!!.setImageResource(R.drawable.no_image_icon);
        }

    }
}
