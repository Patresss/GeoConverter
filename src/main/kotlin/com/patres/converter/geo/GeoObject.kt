package com.patres.converter.geo


abstract class GeoObject(line: String) {

    var lineIterator: Iterator<String>

    init {
        val splitLine = line.split("\t")
        lineIterator = splitLine.iterator()
        if (splitLine.size < getNumberOfFields()) {
            throw Exception("Wrong number of fields. Should be ${getNumberOfFields()}, found: ${splitLine.size}")
        }
    }

    abstract fun loadFields(lineIterator: Iterator<String>)
    abstract fun getNumberOfFields(): Int

}