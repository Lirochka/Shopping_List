package com.example.shopinglist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shopinglist.R
import com.example.shopinglist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setButtonNavListener()
    }

    private fun setButtonNavListener() {
        binding.bNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.settings -> {}
                R.id.notes -> {}
                R.id.shop_list -> {}
                R.id.new_item -> {}
            }
            true
        }
    }
}