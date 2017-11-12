package com.patres.converter

enum class GeoType(var typeName:String) {

    WPT("Obwód"),
    TRKPT("Powierzchnia");

    override fun toString():String {
        return typeName
    }

}