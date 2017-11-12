package com.patres.converter.geo.trkpt

import com.patres.converter.DecimalDegreesConverter
import com.patres.converter.format
import com.patres.converter.geo.GeoObject

class Trkpt(line: String) : GeoObject(line) {

    var id: String = ""
    var trksegID: String = ""
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
    var Temperature: String = ""
    var Depth: String = ""
    var wtemp: String = ""
    var hr: String = ""
    var cad: String = ""

    init {
        loadFields(lineIterator)
    }

    override fun loadFields(lineIterator: Iterator<String>) {
        id = lineIterator.next()
        trksegID = lineIterator.next()
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
        Temperature = lineIterator.next()
        Depth = lineIterator.next()
        wtemp = lineIterator.next()
        hr = lineIterator.next()
        cad = lineIterator.next()
    }

    override fun getNumberOfFields(): Int {
        return 25
    }

}