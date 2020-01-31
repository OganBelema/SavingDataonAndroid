package com.raywenderlich.android.datadrop.viewmodel

import com.raywenderlich.android.datadrop.model.Drop

/**
 * Created by Belema Ogan on 2020-01-18.
 */
interface DropInsertListener {
    fun dropInserted(drop: Drop)
}