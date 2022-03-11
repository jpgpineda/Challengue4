package com.example.challengue4.core.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.Gravity
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

fun Activity.checkForinternet(): Boolean {
    val connectivitymanager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    // Si la version de android es mayor a M se usa networkCapabilities para verificar
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        // Devuelve un objeto de tipo network correspondiente a la conectividad del disposito
        val network = connectivitymanager.activeNetwork ?: return false
        val activeNetwork = connectivitymanager.getNetworkCapabilities(network) ?: return false

        return when {
            // Indica si la red usa transporte Wifi o tiene conectividad Wifi
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            // Indica si la red tiene conectividad por datos moviles
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    } else {
        // Si la version de android en menor a M
        @Suppress("DEPRECATION") val networkInfo = connectivitymanager.activeNetworkInfo ?: return false
        @Suppress("DEPRECATION") return networkInfo.isConnected
    }
}

fun AppCompatActivity.showMessage(
    activity: Activity,
    mensaje: String
){
    val snackBar = Snackbar.make(activity.findViewById(android.R.id.content),mensaje, Snackbar.LENGTH_LONG)
    val view = snackBar.view
    val params = snackBar.view.layoutParams as FrameLayout.LayoutParams
    params.gravity = Gravity.TOP
    view.layoutParams = params
    snackBar.show()
}