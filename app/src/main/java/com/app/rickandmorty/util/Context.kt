package com.app.rickandmorty.util

import android.content.Context
import android.net.ConnectivityManager

/**
 * Extension function to check if the device is currently connected to a network.
 *
 * This function utilizes the Android `ConnectivityManager` to determine the network connectivity status.
 *
 * @return `true` if the device is connected to a network, `false` otherwise.
 */
fun Context.isConnected(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo?.isConnected ?: false
}
