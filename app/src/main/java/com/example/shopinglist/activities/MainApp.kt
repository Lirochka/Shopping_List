package com.example.shopinglist.activities

import android.app.Application
import com.example.shopinglist.db.MainDataBase

class MainApp : Application() {

    val dataBase by lazy { MainDataBase.getDataBase(this) }
}