package com.raywenderlich.android.datadrop.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.raywenderlich.android.datadrop.app.Injection
import com.raywenderlich.android.datadrop.model.Drop

/**
 * Created by Belema Ogan on 2020-01-18.
 */
class DropsViewModel(application: Application): AndroidViewModel(application) {

    private val repository = Injection.provideDropRepository()

    private val allDrops = repository.getDrops()

    fun getDrops() = allDrops

    fun insert(drop: Drop, listener: DropInsertListener) = repository.addDrop(drop, listener)

    fun clearAllDrops(listener: ClearAllDropsListener) = repository.clearAllDrops(listener)

    fun clearDrop(drop: Drop, listener: ClearDropListener) = repository.clearDrop(drop, listener)
}