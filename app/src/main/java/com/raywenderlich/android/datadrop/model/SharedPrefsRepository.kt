package com.raywenderlich.android.datadrop.model

import android.content.Context
import com.raywenderlich.android.datadrop.app.DataDropApplication

/**
 * Created by Belema Ogan on 2019-11-20.
 */
object SharedPrefsRepository: DropRepository {

    private const val SHARED_PREFS_REPOSITORY = "SHARED_PREFS_REPOSITORY"

    fun sharedPrefs() = DataDropApplication.getAppContext().getSharedPreferences(SHARED_PREFS_REPOSITORY,
            Context.MODE_PRIVATE)

    override fun addDrop(drop: Drop) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDrops(): List<Drop> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearDrop(drop: Drop) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearAllDrops() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}