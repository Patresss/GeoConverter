package com.patres.converter

class DecimalDegreesConverter {

    companion object {

        fun toDegree(decimal: String): String {
            val deg = decimal.toDouble()
            var degree = Math.floor(deg)
            val minfloat = (deg - degree) * 60
            var minute = Math.floor(minfloat)
            var second = (minfloat - minute) * 60.0

            if (second == 60.0) {
                minute++
                second = 0.0
            }
            if (minute == 60.0) {
                degree++
                minute = 0.0
            }
            return ("${degree.format(0)} ${minute.format(0)} ${second.format(4)}")
        }
    }
}