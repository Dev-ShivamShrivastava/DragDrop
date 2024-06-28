package com.dragdrop

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class AppController:Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("TAG", "onCreate: ")
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }


}