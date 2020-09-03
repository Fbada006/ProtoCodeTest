package com.droidafricana.protocodetest.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LPGOrder(
    val smallOutright: Int?,
    val bigOutright: Int?,
    val smallRefill: Int?,
    val bigRefill: Int?
) : Parcelable