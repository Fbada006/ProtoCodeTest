package com.droidafricana.protocodetest.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Order(
    val smallOutright: Int?,
    val bigOutright: Int?,
    val smallRefill: Int?,
    val bigRefill: Int?,
    val smallMeko: Int?,
    val bigMeko: Int?,
    val cooker: Int?,
    val regulator: Int?
) : Parcelable
