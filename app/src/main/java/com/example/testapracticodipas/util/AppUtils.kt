package com.example.testapracticodipas.util

import android.R
import android.content.Context
import android.graphics.Paint.Align
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.google.android.material.snackbar.Snackbar
import android.net.NetworkInfo;
import com.example.testapracticodipas.model.GamesList
import com.example.testapracticodipas.model.Test


object AppUtils {

    fun isOnline(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false

        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    }

}