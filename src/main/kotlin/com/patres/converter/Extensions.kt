package com.patres.converter

fun Double.format(digits: Int) = String.format("%.${digits}f", this).replace(",", ".")