package com.patres.converter.geo.wpt

import com.patres.converter.DecimalDegreesConverter
import com.patres.converter.format
import com.patres.converter.geo.GeoObject

class Wpt(line: String) : GeoObject(line) {

    var id: String = ""
    var lat: String = ""
    var lon: String = ""
    var ele: String = ""
    var time: String = ""
    var magvar: String = ""
    var geoidheight: String = ""
    var name: String = ""
    var cmt: String = ""
    var desc: String = ""
    var src: String = ""
    var sym: String = ""
    var type: String = ""
    var fix: String = ""
    var sat: String = ""
    var hdop: String = ""
    var vdop: String = ""
    var pdop: String = ""
    var ageofdgpsdata: String = ""
    var dgpsid: String = ""
    var proximity: String = ""
    var temperature: String = ""
    var depth: String = ""
    var displayMode: String = ""
    var samples: String = ""
    var expiration: String = ""
    var creationTime: String = ""

    init {
        loadFields(lineIterator)
    }

    override fun loadFields(lineIterator: Iterator<String>) {
        id = lineIterator.next()
        lat = DecimalDegreesConverter.toDegree(lineIterator.next())
        lon = DecimalDegreesConverter.toDegree(lineIterator.next())
        ele = lineIterator.next().toDouble().format(2)
        time = lineIterator.next()
        magvar = lineIterator.next()
        geoidheight = lineIterator.next()
        name = lineIterator.next().replace("\"", "")
        cmt = lineIterator.next()
        desc = lineIterator.next()
        src = lineIterator.next()
        sym = lineIterator.next()
        type = lineIterator.next()
        fix = lineIterator.next()
        sat = lineIterator.next()
        hdop = lineIterator.next()
        vdop = lineIterator.next()
        pdop = lineIterator.next()
        ageofdgpsdata = lineIterator.next()
        dgpsid = lineIterator.next()
        proximity = lineIterator.next()
        temperature = lineIterator.next()
        depth = lineIterator.next()
        displayMode = lineIterator.next()
        samples = lineIterator.next()
        expiration = lineIterator.next()
        creationTime = lineIterator.next()
    }

    override fun getNumberOfFields(): Int {
        return 26
    }

}