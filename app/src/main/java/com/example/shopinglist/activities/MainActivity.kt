package com.example.shopinglist.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.shopinglist.fragments.FragmentManager
import com.example.shopinglist.R
import com.example.shopinglist.databinding.ActivityMainBinding
import com.example.shopinglist.dialogs.NewListDialog
import com.example.shopinglist.fragments.NoteFragment
import com.example.shopinglist.fragments.ShopListNamesFragment

class MainActivity : AppCompatActivity(), NewListDialog.Listener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FragmentManager.setFragment(ShopListNamesFragment.newInstance(), this)
        setButtonNavListener()
    }

    private fun setButtonNavListener() {
        binding.bNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.settings -> {
                    Log.d("MyLog", "Settings")
                }
                R.id.notes -> {
                    FragmentManager.setFragment(NoteFragment.newInstance(), this)
                }
                R.id.shop_list -> {
                    FragmentManager.setFragment(ShopListNamesFragment.newInstance(), this)

                }
                R.id.new_item -> {
                    FragmentManager.currentFrag?.onClickNew()

                }
            }
            true
        }
    }

    override fun onClick(name: String) {
        Log.d("MyLog", "Name: $name")
    }
}