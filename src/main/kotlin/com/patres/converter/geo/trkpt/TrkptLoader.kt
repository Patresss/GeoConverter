package com.patres.converter.geo.trkpt

import com.patres.converter.geo.Loader

class TrkptLoader(filePath: String) : Loader<Trkpt>(filePath) {

    override fun getContent(): String {
        val content = StringBuilder()
        lines.forEach {
            content.append("${it.id}\t${it.lat}\t${it.lon}\t${it.ele}\n")
            content.append(System.getProperty("line.separator"))
        }
        return content.toString()
    }

    override fun newGeoObject(line: String): Trkpt {
        return Trkpt(line)
    }

    override fun getStartHeader(): String {
        return "trkpt"
    }

}