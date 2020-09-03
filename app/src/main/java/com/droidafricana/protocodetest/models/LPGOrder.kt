package com.droidafricana.protocodetest.models

data class LPGOrder(
    val smallOutright: Int? = 0,
    val bigOutright: Int? = 0,
    val smallRefill: Int? = 0,
    val bigRefill: Int? = 0
)