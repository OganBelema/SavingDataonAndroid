package com.raywenderlich.android.datadrop.model

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.raywenderlich.android.datadrop.app.DataDropApplication
import java.io.*
import java.lang.StringBuilder

/**
 * Created by Belema Ogan on 2019-11-21.
 */
object FileRepository: DropRepository {

    private val gson: Gson
        get() {
            val builder = GsonBuilder()
            builder.registerTypeAdapter(Drop::class.java, DropTypeAdapter())
            return builder.create()
        }

    private fun getContext() = DataDropApplication.getAppContext()

    override fun addDrop(drop: Drop) {
        val dropString = gson.toJson(drop)
        try {
            val dropStream = dropOutputStream(drop)
            dropStream.write(dropString.toByteArray())
            dropStream.close()
        } catch (exception: IOException){
            Log.e("FileRepository", "Error saving drop")
        }
    }

    override fun getDrops(): List<Drop> {
        val drops = mutableListOf<Drop>()

        try {
            val fileList = dropsDirectory().list()

            fileList.map { convertStreamToString(dropInputStream(it)) }.mapTo(drops) {
                gson.fromJson(it, Drop::class.java)
            }
        } catch (exception: IOException) {
            Log.e("FileRepository", "Error reading drops")
        }

        return drops
    }

    override fun clearDrop(drop: Drop) {

    }

    override fun clearAllDrops() {

    }

    /**
     * Creates the drop directory
     */
    private fun dropsDirectory() : File {
        val dropDirectory = File(getContext().getExternalFilesDir(null), "drops")
        if (!dropDirectory.exists()){
            dropDirectory.mkdirs()
        }
        return dropDirectory
    }

    /**
     * Creates a file in the drop directory
     * @param fileName is the name of the file to be created
     */
    private fun dropFile(fileName: String) = File(dropsDirectory(), fileName)

    /**
     * Creates file name for the received drop
     * @param drop the drop that the file name is created for
     */
    private fun dropFileName(drop: Drop) = drop.id + ".drop"

    private fun dropOutputStream(drop: Drop): FileOutputStream {
        return FileOutputStream(dropFile(dropFileName(drop)))
    }

    private fun dropInputStream(filename: String): FileInputStream {
        return FileInputStream(dropFile(filename))
    }

    @Throws(IOException::class)
    private fun convertStreamToString(inputStream: InputStream): String {
        val reader = BufferedReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()
        var line: String? = reader.readLine()
        while (line != null){
            stringBuilder.append(line).append("\n")
            line = reader.readLine()
        }
        reader.close()
        return stringBuilder.toString()
    }
}