package com.rushal.interview.presentation

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import com.rushal.interview.R
import com.rushal.interview.databinding.ActivityMainBinding

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_ImageLoaderDagger2)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}