package com.nbali.alinadi.shahabmousaviapp.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.Toast

class ConnectivityBroadcastReceiver(var onClickNetworkState:(item:Boolean)->Unit) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var connected = isNetworkAvailable(context!!)
        if(!connected){
            Toast.makeText(context,"خطا در اتصال به اینترنت",Toast.LENGTH_SHORT).show()
            onClickNetworkState(connected)
        }else{
            onClickNetworkState(connected)
        }
    }

    private fun isNetworkAvailable(context: Context):Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            val network = connectivityManager.activeNetwork ?:return false
            val actNewtwork = connectivityManager.getNetworkCapabilities(network) ?: return false
            return when{
                actNewtwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNewtwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNewtwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else->false
            }
        }else{
            val networkInfo = connectivityManager.activeNetworkInfo ?:return false
            return networkInfo.isConnected
        }
    }
}