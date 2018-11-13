package com.jasonzhong.redditclient.util

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.util.DisplayMetrics

import com.jasonzhong.redditclient.R

object Util {

    fun getScreenWidthPixels(context: Activity): Int {
        val display = context.windowManager.defaultDisplay
        val outMetrics = DisplayMetrics()
        display.getMetrics(outMetrics)
        return outMetrics.widthPixels
    }

    fun showErrorDialog(context: Context, errorMessage: String?) {
        var errorMessage = errorMessage

        if (errorMessage != null || errorMessage!!.isEmpty()) {
            errorMessage = context.getString(R.string.no_data_error)
        }
        val alertDialogBuilder = AlertDialog.Builder(
                context)

        // set title
        alertDialogBuilder.setTitle(context.getString(R.string.error))

        // set dialog message
        alertDialogBuilder
                .setMessage(errorMessage)
                .setCancelable(false)
                .setPositiveButton(context.getString(R.string.exit)) { dialog, id -> dialog.dismiss() }
        // create alert dialog
        val alertDialog = alertDialogBuilder.create()

        // show it
        alertDialog.show()
    }

    fun removeLastChar(str: String): String {
        return str.substring(0, str.length - 1)
    }

    fun removeFirstChar(s: String): String {
        return s.substring(1)
    }
}
