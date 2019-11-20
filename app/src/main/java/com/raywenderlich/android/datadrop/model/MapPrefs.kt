package com.raywenderlich.android.datadrop.model

import android.preference.PreferenceManager
import com.raywenderlich.android.datadrop.app.DataDropApplication

/**
 * Created by Belema Ogan on 2019-11-20.
 */
object MapPrefs {

    private const val KEY_MARKER_COLOR = "KEY_MARKER_COLOR"

    private const val KEY_MAP_TYPE = "KEY_MAP_TYPE"

    fun sharedPrefs() = PreferenceManager.getDefaultSharedPreferences(DataDropApplication.getAppContext())

    fun saveMarkerColor(markerColor: String){
        val editor = sharedPrefs().edit()
        editor.putString(KEY_MARKER_COLOR, markerColor).apply()
    }

    fun saveMapType(mapType: String){
        val editor = sharedPrefs().edit()
        editor.putString(KEY_MAP_TYPE, mapType).apply()
    }

    fun getMarkerColor(): String = sharedPrefs().getString(KEY_MARKER_COLOR, "Red")

    fun getMapType(): String = sharedPrefs().getString(KEY_MAP_TYPE, "Normal")
}