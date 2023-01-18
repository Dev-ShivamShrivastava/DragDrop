package com.dragdrop.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.dragdrop.R
import com.dragdrop.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var binding : ActivityMainBinding
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}