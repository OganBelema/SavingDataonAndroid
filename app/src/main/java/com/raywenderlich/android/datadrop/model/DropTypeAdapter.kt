package com.raywenderlich.android.datadrop.model

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.io.IOException

/**
 * Created by Belema Ogan on 2019-11-21.
 */
class DropTypeAdapter : TypeAdapter<Drop>() {

    @Throws(IOException::class)
    override fun write(out: JsonWriter, value: Drop) {
        out.beginObject()
        out.name("latitude").value(value.latLng.latitude)
        out.name("longitude").value(value.latLng.longitude)
        out.name("dropMessage").value(value.dropMessage)
        out.name("id").value(value.id)
        out.endObject()
    }

    override fun read(`in`: JsonReader?): Drop? {
        return null
    }

}