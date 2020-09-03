package com.droidafricana.protocodetest.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LPGOrder(
    val smallOutright: Int? = 0,
    val bigOutright: Int? = 0,
    val smallRefill: Int? = 0,
    val bigRefill: Int? = 0
) : Parcelable