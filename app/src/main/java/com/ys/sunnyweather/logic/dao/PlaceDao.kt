package com.ys.sunnyweather.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.ys.sunnyweather.base.MyApplication
import com.ys.sunnyweather.logic.model.Place

object PlaceDao {
    fun savePlace(place: Place) {
        sharePreferences().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavePlace(): Place {
        val placejson = sharePreferences().getString("place", "")
        return Gson().fromJson(placejson, Place::class.java)
    }

    fun isPlaceSaved() = sharePreferences().contains("place")
    private fun sharePreferences() =
        MyApplication.context.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)
}