package com.patres.converter.geo.wpt

import com.patres.converter.geo.Loader

class WptLoader(filePath: String) : Loader<Wpt>(filePath) {

    override fun getContent(): String {
        val content = StringBuilder()
        lines.forEach {
            content.append("${it.name}\t${it.lat}\t${it.lon}\t${it.ele}\n")
            content.append(System.getProperty("line.separator"))
        }
        return content.toString()
    }

    override fun newGeoObject(line: String): Wpt {
        return Wpt(line)
    }

    override fun getStartHeader(): String {
        return "wpt"
    }

}