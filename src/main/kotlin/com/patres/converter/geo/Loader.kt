package com.patres.converter.geo

import java.io.FileReader
import java.util.*

abstract class Loader<T : GeoObject>(filePath: String) {

    val lines = ArrayList<T>()

    init {
        loadLines(filePath)
    }

    private fun loadLines(filePath: String) {
        val sc = Scanner(FileReader(filePath))
        var save = false
        while (sc.hasNextLine()) {
            val line = sc.nextLine()
            if (line.startsWith(getStartHeader())) {
                sc.nextLine()
                save = true
                continue
            }
            if (save) {
                if (line.matches(Regex("[0-9].*"))) {
                    lines.add(newGeoObject(line))
                } else {
                    break
                }
            }
        }
        if (!save) {
            throw Exception("Zły plik - nie zawiera ${getStartHeader()}")
        }
    }


    abstract fun getStartHeader(): String
    abstract fun newGeoObject(line: String): T
    abstract fun getContent(): String
}