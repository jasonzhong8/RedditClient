package com.jasonzhong.redditclient

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.filters.MediumTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import com.jasonzhong.redditclient.items_activity.ItemsActivity

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.`is`
import org.junit.Assert.assertThat

@MediumTest
@RunWith(AndroidJUnit4::class)
class ItemsActivityTest {

    @get:Rule
    var rule: ActivityTestRule<ItemsActivity> = object : ActivityTestRule<ItemsActivity>(ItemsActivity::class.java) {
        override fun getActivityIntent(): Intent {
            InstrumentationRegistry.getTargetContext()
            val intent = Intent(Intent.ACTION_MAIN)
            intent.putExtra("Username", "Jason")
            return intent
        }
    }

    @Test
    @Throws(Exception::class)
    fun ensureIntentDataIsDisplayed() {
        val activity = rule.activity

        assertThat(activity.supportActionBar!!.subtitle!!.toString(), `is`("Jason"))
    }

}
