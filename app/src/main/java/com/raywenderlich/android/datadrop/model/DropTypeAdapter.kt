package com.raywenderlich.android.datadrop.model

import com.google.android.gms.maps.model.LatLng
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

    override fun read(reader: JsonReader): Drop? {
        var longitude = 0.0
        var latitude = 0.0
        var dropMessage = ""
        var id = ""

        reader.beginObject()
        while (reader.hasNext()){
            when(reader.nextName()){
                "latitude" -> latitude = reader.nextDouble()
                "longitude" -> longitude = reader.nextDouble()
                "dropMessage" -> dropMessage = reader.nextString()
                "id" -> id = reader.nextString()
            }
        }
        reader.endObject()

        return Drop(LatLng(latitude, longitude), dropMessage, id)
    }

}